package com.wubo.blog.controller;

import com.google.code.kaptcha.Producer;
import com.wubo.blog.util.Result;
import com.wubo.blog.util.codeText;
import com.wubo.blog.util.redis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Api(tags = "验证码")
public class codeController {

    @Autowired
    private Producer producer;
    @Autowired
    private redis redis;
    @ApiOperation("验证码")
    @GetMapping("/code")
    public Result captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = producer.createText();
        String key = UUID.randomUUID().toString().replaceAll("_","");
        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray());
        redis.hset(codeText.CODE,key,code,60*5);
         Map<String,Object> map=new HashMap<>();
        map.put("token", key);
        map.put("base64Img", base64Img);
        return Result.SUCCESS(map);
    }
}
