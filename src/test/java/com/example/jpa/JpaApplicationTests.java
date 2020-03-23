package com.example.jpa;

import com.example.jpa.controller.UserController;
import com.example.jpa.utils.JsonResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class JpaApplicationTests {

    @Resource
    private UserController userController;

    @Test
    void contextLoads() {
        JsonResult result = userController.findAll();
        System.out.println(result.getResult());

    }

}
