package com.alan.dashboard.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void valueTest() {
        redisUtil.set("amount", new Integer(100));
        //redisUtil.incr("amount",1);
        redisUtil.set("student1", new Student("ming", 2019));
        redisUtil.set("student2", new Student("ming12", 2019));
        redisUtil.set("student3", new Student("ming123", 2019));
        Student student = (Student) redisUtil.get("student");
        System.out.println(student);
    }
}
