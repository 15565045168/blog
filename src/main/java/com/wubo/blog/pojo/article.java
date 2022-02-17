package com.wubo.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article")
@ApiModel("文章")
public class article {
    @ApiModelProperty(value = "文章id",name = "id",dataType = "String",required = false)
    @TableId(value = "id",type = IdType.INPUT)
    private String id;
    @ApiModelProperty(value = "文章标题",name = "title",dataType = "String",required = true)
    private String  title;
    @ApiModelProperty(value = "文章图片",name = "pic",dataType = "String",required = true)
    private String pic;
    @ApiModelProperty(value = "文章主体",name = "body",dataType = "String",required = true)
    private String body;
    @ApiModelProperty(value = "文章创建时间",name = "createTime",dataType = "date",required = true)
    @TableField(value = "create_time")
    private Date createTime;
    @ApiModelProperty(value = "文章更新时间",name = "updateTime",dataType = "date",required = true)
    @TableField(value = "update_time")
    private Date updateTime;
    @ApiModelProperty(value = "文章用户ID",name = "userId",dataType = "String",required = true)
    @TableField(value = "user_id")
    private String userId;
    @ApiModelProperty(value = "文章分类",name = "categoryId",dataType = "String",required = true)
    @TableField(value = "category_id")
    private String categoryId;


}
