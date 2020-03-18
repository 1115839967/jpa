package com.example.jpa.service;

import com.example.jpa.entity.UserEntity;
import com.example.jpa.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2020-03-13 14:26
 *
 * @author xutiancheng
 * @since
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;

    @Override
    public UserEntity get(Integer id) {
        return userRepository.getOne(id);

    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> all = userRepository.findAll();
        if (CollectionUtils.isEmpty(all)) {
            return new ArrayList<>(0);
        }

        return all;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }


}