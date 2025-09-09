package com.xm.testhutool.controller.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
