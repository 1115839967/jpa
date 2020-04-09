package com.example.jpa.controller;

import com.example.jpa.entity.UserEntity;
import com.example.jpa.service.UserService;
import com.example.jpa.utils.JsonResult;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author xutiancheng
 * @since 2020年03月19日14:57:51
 */

@RestController
@RequestMapping("/user")
public class UserController implements InitializingBean {

    @Resource
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("++++++初始化成功！！！");
    }

    @GetMapping("/findOne")
    public JsonResult findOne(@RequestParam String id) {
        UserEntity user = userService.findById(id);
        Optional.ofNullable(user).ifPresent(u -> {
            System.out.println(u.getRealName());
        });
        return new JsonResult(true, "", user);
    }

    @GetMapping("/findAll")
    public JsonResult findAll(HttpServletRequest request) {
        System.out.println(request.getParameter("corpCode"));
        List<UserEntity> all = userService.findAll();
        if (CollectionUtils.isEmpty(all)) {
            return new JsonResult(true, "empty", null);
        }

        return new JsonResult(true, "", all);
    }

    @PostMapping("/save")
    public JsonResult save(@RequestBody UserEntity userEntity) {
        if (Stream.of(userEntity.getRealName(), userEntity.getPassword(), userEntity.getUserName())
                .anyMatch(Objects::isNull)) {
            return new JsonResult(false, "ILLEGAL_PARAM");
        }

        try {
            UserEntity user = new UserEntity();
            user.setPassword(userEntity.getPassword());
            user.setRealName(userEntity.getRealName());
            user.setUserName(userEntity.getUserName());
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "保存失败");
        }

        return new JsonResult(true, "保存成功");
    }


    @PostMapping("/list")
    public void list(@RequestParam List<String> userIdList) {

        for (String s : userIdList) {
            System.out.println(s);
        }
    }

}