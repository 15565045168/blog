package com.wubo.blog.controller;

import com.wubo.blog.pojo.article;
import com.wubo.blog.pojo.category;
import com.wubo.blog.service.categoryService;
import com.wubo.blog.util.IdWorker;
import com.wubo.blog.util.Result;
import com.wubo.blog.util.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/category")
@Api(tags="分类")
public class categoryController {
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private com.wubo.blog.service.categoryService categoryService;

    @ApiOperation("查询分类")
    @RequestMapping(value = "selectAll",method = RequestMethod.GET)
    public Result selectAll(){
        List<category> categorys=categoryService.selectAll();
        return Result.SUCCESS(categorys);
    }
    @ApiOperation("根据分类id查询文章")
    @ApiImplicitParam(name = "id",type = "String",value = "根据分类id查询文章")
    @RequestMapping(value = "selectByIdarticle",method = RequestMethod.GET)
    public Result selectByIdarticle(@RequestParam(value = "id") String id){
        List<article> articles= categoryService.selectByIdarticle(id);
        return Result.SUCCESS(articles);
    }
    @ApiOperation("添加分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",dataType = "String",value = "分类名称"),
            @ApiImplicitParam(name = "pic",dataType = "String",value = "分类图标")
    })
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Result addCategory(@RequestParam(value = "name")String name,@RequestParam(value = "pic") String pic){
        category category = new category();
        category.setId(idWorker.nextId());
        category.setName(name);
        category.setPic(pic);
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
      boolean ok=  categoryService.addCategory(category);
      if(ok){
          return Result.SUCCESS();
      }else{
          return Result.ERROR(ResultCode.ERROR,"添加失败");
      }
    }
}
