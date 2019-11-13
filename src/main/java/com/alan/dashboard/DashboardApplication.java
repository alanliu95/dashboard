package com.alan.dashboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.alan.dashboard.DAO.Mybatis")
//@ImportResource(locations={"classpath:shiro.xml"})
//@ImportResource(locations={"classpath:shiroTestBeans.xml"})
public class DashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }

}
