package com.wubo.blog.controller;

import com.wubo.blog.pojo.article;
import com.wubo.blog.service.articleService;
import com.wubo.blog.util.IdWorker;
import com.wubo.blog.util.Result;
import com.wubo.blog.util.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/article")
@Api(tags = "文章接口")
public class articleController {
    @Autowired
    private articleService as;
    @Autowired
    private IdWorker id;
    
    @ApiOperation( "文章添加")
    @RequestMapping(value = "addArticle",method = RequestMethod.POST)
    public Result addArticle(@RequestBody article article){
        article.setId(id.nextId());
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        boolean b = as.addArticle(article);
        if(b){
            return new Result(ResultCode.SUCCESS,"文章添加成功");
        }else{
            return new Result(ResultCode.ERROR,"文章添加失败请重试");
        }
    }
    @ApiOperation("按照创建时间进行文章从新到旧查询")
    @RequestMapping(value = "selectArticleTime",method = RequestMethod.GET)
    public Result selectArticleTime(){
      List<article> li=  as.selectArticleTime();
      if(li!=null){
          return Result.SUCCESS(li);
      }
      return Result.ERROR(ResultCode.ERROR,"查询失败");
    }
    @ApiOperation("文章标题模糊查询,并按照创建时间的先后进行排序")
    @ApiImplicitParam(value = "模糊查询需要的内容",name="title",dataType = "String",required = true)
    @RequestMapping(value = "selectTitleVague",method = RequestMethod.GET)
    public Result selectTitleVague(@RequestParam(value = "title") String title){
      List<article> articles=  as.selectTitleVague(title);
      if(articles!=null){
          return Result.SUCCESS(articles);
      }
      return Result.ERROR(ResultCode.ERROR,"查询失败");
    }

    
}
