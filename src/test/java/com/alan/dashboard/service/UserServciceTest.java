package com.alan.dashboard.service;

import com.alan.dashboard.model.security.User;
import com.alan.dashboard.service.security.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServciceTest {
    @Autowired
    UserService userService;

    @Test
    public void test() {
        User user = new User("alanliu", "alanliu");
        userService.createUser(user);
        System.out.println("新用户的主键id：" + user.getId());
        System.out.println(userService.findByUsername("zhang"));
    }
}
