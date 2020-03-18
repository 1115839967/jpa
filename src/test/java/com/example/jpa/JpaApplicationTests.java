package com.example.jpa;

import com.example.jpa.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class JpaApplicationTests {

    @Resource
    private UserController userController;

    @Test
    void contextLoads() {
        String all = userController.findAll();
        System.out.println(all);

    }

}
