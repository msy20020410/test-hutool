package com.xm.testhutool.controller.util;

import cn.hutool.core.util.ReflectUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reflect")
public class ReflectController {

    @RequestMapping("/methods")
    public List<String> test() {
        List<String> list = new ArrayList<>();
        // 获取所有声明的方法
        Method[] methods = ReflectUtil.getMethods(String.class);
        for (Method method : methods) {
            list.add(method.getName());
        }
        return list;
    }
}
