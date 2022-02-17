package com.wubo.blog.util;

import com.wubo.blog.blogApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = blogApplication.class)
@RunWith(SpringRunner.class)
public class redisTest {

  @Test
    public void one(){
     // boolean hset = redis.hset("one", "sc", "code", 60);
     // System.out.println(hset);
  }
}