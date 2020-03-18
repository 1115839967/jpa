package com.example.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by on 2020-03-13 14:22
 *
 * @author xutiancheng
 * @since 用户对象
 */

@Entity
@Table(name = "t_user")
@Data
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String password;

    private String realName;

}