package com.alan.dashboard;

import com.alan.dashboard.DAO.Mybatis.UserDao;
import com.alan.dashboard.model.security.User;
import com.alan.dashboard.service.security.UserService;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ImportResource(locations={"classpath:shiroTestBeans.xml"})
public class ShiroTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    DefaultWebSessionManager sessionManager;

    @Test
    public void testUserDao() {
//        User user=new User("wu","123");
//        userService.createUser(user);
        System.out.println(userDao.findOne(1L));
    }
}

