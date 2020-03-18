package com.example.jpa.controller;

import com.example.jpa.entity.UserEntity;
import com.example.jpa.service.UserService;
import com.example.jpa.utils.JsonResult;
import org.apache.catalina.User;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by on 2020-03-13 14:31
 *
 * @author xutiancheng
 * @since
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getById")
    public JsonResult getUserById(@RequestParam Integer id) {
        UserEntity user = userService.get(id);
        if (null == user) {
            return new JsonResult(true, "未查到数据", null);
        }

        return new JsonResult(true, null, user);
    }

    @GetMapping("/findAll")
    public String findAll() {
        List<UserEntity> all = userService.findAll();
        if (CollectionUtils.isEmpty(all)) {
            return "empty";
        }

        return "notEmpty";
    }

    @PostMapping("/save")
    public String save(@RequestBody UserEntity userEntity) {
        try {
            userService.save(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

        return "true";
    }

}