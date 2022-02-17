package com.wubo.blog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class redis {
    @Autowired
    private  RedisTemplate<String,Object> redis;
    public  boolean hset(String key, String item, Object value, long time) {
        try {
            redis.opsForHash().put(key, item, value);

            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }
    public  boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redis.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /*查询key*/
    public Object hget(String key,String item){
        return redis.opsForHash().get(key, item);
    }
    /*删除*/
    public void hdel(String key, Object... item){
        redis.opsForHash().delete(key,item);
    }


}
