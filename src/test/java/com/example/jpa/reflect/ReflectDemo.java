package com.example.jpa.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 *
 * @author xutiancheng
 * @since 2020-04-08 15:57
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.example.jpa.reflect.Person");
        Class<?> c = Person.class;
        Object obj = aClass.newInstance();

        Field[] fields = aClass.getFields();
        for (Field field : fields) {

            System.out.println(field);
        }

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

}