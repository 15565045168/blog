package com.wubo.blog.controller;

import com.wubo.blog.pojo.user;
import com.wubo.blog.service.userService;
import com.wubo.blog.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "用户接口",tags = "用户接口")
public class userController {
    @Autowired
    private com.wubo.blog.util.redis redis;

    @Autowired
    private userService us;

    @Autowired
    private IdWorker idWork;

    @Autowired
    private md5 md5;

    @RequestMapping(value = "selectById",method = RequestMethod.GET)
    @ApiImplicitParam(type = "String",value = "用户ID查询",name = "id")
    @ApiOperation("用户ID查询")
    public Result selectAll(@RequestParam(value = "id") String id){
       user user =us.selectUsername(id);
       return Result.SUCCESS(user);
    }
    @ApiOperation("用户注册")
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public Result register(@RequestBody user user){
  if(!StringUtils.isBlank(user.getCode())){
      int i = us.selectUserName(user.getUsername());
      if(i>0){
         return new Result(ResultCode.ERROR,"用户已注册,请直接登录");
      }else{
          Object hget = redis.hget(codeText.CODE, user.getToken());
          if(user.getCode().equals(hget)){
              user.setId(idWork.nextId());
              user.setPassword(md5.getMD5(user.getPassword()));
              user.setCreateTime(new Date());
              user.setUpdateTime(new Date());
              Boolean ok=  us.register(user);
              if(ok){
                  return new Result(ResultCode.SUCCESS,"注册成功");
              }else{
                  return Result.ERROR(ResultCode.ERROR,"注册失败");
              }
          }else{
              return Result.ERROR(ResultCode.ERROR,"验证码错误");
          }
      }

  }
     return Result.ERROR(ResultCode.ERROR,"验证码不能为空");
    }
    @ApiOperation("用户更新")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result update(@RequestBody user user){

        boolean update = us.update(user);
        if(update){
            return Result.SUCCESS();
        }else{
            return Result.ERROR(ResultCode.ERROR,"更新失败");
        }
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    @ApiOperation("用户删除")
    @ApiImplicitParam(type = "String",value = "用户删除以Id形式进行删除",name = "id")
    public Result delete(@RequestParam(value = "String") String id){
        boolean  ok=us.deleteById(id);
        if(ok){
            return Result.SUCCESS();
        }else{
            return Result.ERROR(ResultCode.ERROR,"删除失败");
        }
    }


    @ApiOperation("用户登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "String",value = "用户账号",name="username"),
            @ApiImplicitParam(type = "String",value = "用户密码",name="password"),
            @ApiImplicitParam(type = "String",value = "验证码",name="code"),
            @ApiImplicitParam(type = "String",value = "token",name="token")
    })
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public Result login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "code") String code,
                        @RequestParam(value = "token")String token){
       if(!StringUtils.isBlank(token)){
           System.out.println(token);
           Object hget = redis.hget(codeText.CODE, token);
           System.out.println(hget);
          if(code.equals(hget.toString())){
              System.out.println(code);
              String md5 = this.md5.getMD5(password);
              user user=us.login(username,md5);
              System.out.println(user);
              if(user!=null){
                  Map<String,Object> map=new HashMap<>();
                  map.put("data",user);
                  map.put("token",null);
                  System.out.println(map.toString());
                  return new Result(ResultCode.SUCCESS,"登陆成功",map);
              }
              return new Result(ResultCode.ERROR,"您的账户名或者密码不正确");
          }else{
              return Result.ERROR(ResultCode.ERROR,"验证码不正确");
          }
       }
       return Result.ERROR(ResultCode.ERROR,"验证码不能为空");

    }
}
