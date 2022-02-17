package com.wubo.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分类")
@TableName("category")
public class category {
    @TableId(value = "id",type = IdType.INPUT)
    @ApiModelProperty(name = "id",dataType = "String",value = "文章id",required = true)
    private String id;
    @ApiModelProperty(name = "name",dataType = "String",value = "分类名称",required = true)
    private String name;
    @ApiModelProperty(name = "pic",dataType = "String",value = "分类图片",required = true)
    private String pic;
    @ApiModelProperty(value = "分类创建时间",dataType = "String",required = true)
    @TableField(value = "create_time")
    private Date createTime;
    @ApiModelProperty(value = "分类更新时间",dataType = "String",required = true)
    @TableField(value = "update_time")
    private Date updateTime;
}
