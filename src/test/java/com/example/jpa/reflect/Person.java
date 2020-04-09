package com.example.jpa.reflect;

/**
 * @author xutiancheng
 * @since 2020-04-08 16:45
 */
public class Person {

    public String name;

    public String age;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person() {
        this.name = "张三";
        System.out.println("Person对象实例化了");
    }

    @Override
    public String toString() {
        return "我是一个好人";
    }
}