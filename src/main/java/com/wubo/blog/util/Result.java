package com.wubo.blog.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    public static <T> Result<T> SUCCESS(T data) {
        return new Result<T>(data);
    }

      public Result (T data){
        this.code=ResultCode.SUCCESS;
        this.message="查询成功";
        this.data=data;
    }
    public  static <T> Result<T> SUCCESS(){
        return new Result();
    }
    public Result(){
        this.code=ResultCode.SUCCESS;
        this.message="查询成功";
    }
    public static <T> Result<T> ERROR(Integer code,String message){
        return new Result();
    }
    public Result(Integer code,String message){
        this.code=code;
        this.message=message;
    }

}
