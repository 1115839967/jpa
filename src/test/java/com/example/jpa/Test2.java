package com.example.jpa;

import com.alibaba.fastjson.JSONObject;
import com.example.jpa.utils.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xutiancheng
 * @since 2020-03-30 11:24
 */
public class Test2 {

    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse("2020-03-31");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        list.add("abc");
        list.add("def");
        list.add("ghi");

        System.out.println("字符串：" + StringUtils.join(list.toArray(), ","));

        String jsonResult = JSONObject.toJSONString(list);
        System.out.println(jsonResult);
    }

    /**
     * 测试HTTPClient工具类的使用
     */
    @Test
    void testHttp() {
        Object code = 0;
        if (code.equals(0)) {
            System.out.println(1);
        }

//        List<String> userIds = new ArrayList<>();
//        userIds.add("123");
//        userIds.add("456");
//        userIds.add("abc");
//        Map<String, String> param = new HashMap<>();
//        param.put("userIdList", StringUtils.join(userIds.toArray(), ","));
//
//
//
//        String s = HttpClientUtils.doPost("http://localhost:8080/user/list", param);
//
//
//        StringBuilder stringBuilder = new StringBuilder();

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        String s = map.get("5");
        System.out.println(s);
    }

    @Test
    void testHtml() throws UnsupportedEncodingException {
        String content = "尊敬的徐天成：\n" +
                "<p style=\"text-indent:2em;\">您有新的考试需要参加，详情如下：</p>\n" +
                "<p style=\"text-indent:2em;\">考试编号：20200401173623370</p>\n" +
                "<p style=\"text-indent:2em;\">考试名称：<a href=\"https://huangjun.21tb.com/ems/html/myExam/examLinkFromIm.do?examId=17d3489ef62c4f199eb923135550e818&linkFrom=message\" target=\"_blank\">消息推送测试1 Copy Copy</a></p>\n" +
                "<p style=\"text-indent:2em;\">考试有效时间：2020-04-01 17:39:01~2020-04-01 18:38:07</p>\n" +
                "<p style=\"text-indent:2em;\">考试时长：60</p>\n" +
                "<p style=\"text-indent:2em;\">请在有效时间内及时参加考试！</p>";

        String  str  = content.replaceAll("</?[^>]+>", " "); //剔出<html>的标签
        if (str.length() > 30) {
            System.out.println(str.substring(0, 30) + "...");
        }

        System.out.println(str);
        try {
            str = URLEncoder.encode(str, "utf-8");
            String encode = URLEncoder.encode("啊", "utf-8");
            System.out.println(encode);
            System.out.println(URLDecoder.decode(encode, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(str.getBytes(StandardCharsets.UTF_8).length);

    }
}