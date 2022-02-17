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
@TableName("user")
@ApiModel( "用户")
public class user {
    @TableId(value = "id",type = IdType.INPUT)
    private String id;
    @ApiModelProperty(value = "用户昵称",dataType = "String",required = true)
    private String nickname;
    @ApiModelProperty(value = "用户账号",dataType = "String",required = true)
    private String username;
    @ApiModelProperty(value = "用户密码",dataType = "String",required = true)
    private String password;
    @ApiModelProperty(value = "用户头像",dataType = "String",required = true)
    @TableField(value = "user_pic")
    private String userPic;
    @ApiModelProperty(value = "用户性别",dataType = "String",required = true)
    private Integer sex;
    @ApiModelProperty(value = "用户简介",dataType = "String",required = true)
    private String body;
    @ApiModelProperty(value = "用户创建时间",dataType = "String",required = true)
    @TableField(value = "create_time")
    private Date createTime;
    @ApiModelProperty(value = "用户更新时间",dataType = "String",required = true)
    @TableField(value = "update_time")
    private Date updateTime;
    @ApiModelProperty(value = "token,进行验证code是否正确",dataType = "String",required = true)
    @TableField(exist = false)
    private String token;
    @ApiModelProperty(value = "验证码",dataType = "String",required = true)
    @TableField(exist = false)
    private String code;
}
