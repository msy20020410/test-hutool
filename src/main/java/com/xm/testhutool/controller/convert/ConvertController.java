package com.xm.testhutool.controller.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@RestController
@RequestMapping("/convert")
public class ConvertController {

    // 转换为字符串
    @GetMapping("/toStr")
    public String toStr() {
        return Convert.toStr(123, "default");
    }

    // 转换为指定数据类型
    @GetMapping("/to")
    public Integer[] to() {
        String[] arr = {"1", "2", "3"};
        return Convert.toIntArray(arr);
    }

    // 转换为日期
    @GetMapping("/toDate")
    public Date toDate() {
        return Convert.toDate("2088-08-08");
    }

    // 将字符串转换为16进制的字符串
    @GetMapping("/toHex")
    public String toHex() {
        String s = "你好,世界!";
        return Convert.toHex(s, StandardCharsets.UTF_8);
    }

    // 将16进制的字符串转换为字符串
    @GetMapping("/HexToStr")
    public String toStrHex() {
        String hex = "e4bda0e5a5bd2ce4b896e7958c21";
        return Convert.hexToStr(hex,StandardCharsets.UTF_8);
    }

    // 金额大小写转换
    @GetMapping("/toChinese")
    public String toChinese() {
        return Convert.digitToChinese(123456789.01);
    }
}
