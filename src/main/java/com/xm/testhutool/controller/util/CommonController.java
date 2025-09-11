package com.xm.testhutool.controller.util;

import cn.hutool.core.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/common")
public class CommonController {


    // 类工具的使用
    @RequestMapping("/class")
    public String classUtil() {
        // 获取该包下的所有类
        Set<Class<?>> classes =
                ClassUtil.scanPackage("com.xm.testhutool");
        // 打印所有类名
        classes.forEach(c -> System.out.println(c.getSimpleName()));
        return "success";
    }

    // 命令行工具
    @RequestMapping("/cmd")
    public String cmd() {
        // 执行命令
        return RuntimeUtil.execForStr("ipconfig");
    }

    // 数组工具
    @RequestMapping("/zip")
    public Map array() {
        // 将两个数组组合为一个map,一个数组的对应位为 key,一个数组的元素为 value
        Map<String, String> map = ArrayUtil.zip(new String[]{"1", "2"}, new String[]{"a", "b"});
        return map;
    }

    // 随机数工具
    @RequestMapping("/random")
    public List<Integer> random() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(RandomUtil.randomInt(10, 20));
        }
        return list;
    }

    // id 工具
    @RequestMapping("/id")
    public String id() {
        return IdUtil.randomUUID();
    }

    // 身份证工具类
    @RequestMapping("/idcard")
    public Info idcard() {
        String idcard = "341522200204108197";
        return Info.builder()
                .valid(IdcardUtil.isValidCard(idcard))
                .birth(IdcardUtil.getBirthByIdCard(idcard))
                .province(IdcardUtil.getProvinceByIdCard(idcard))
                .build();
    }

    // 信息脱敏工具
    @RequestMapping("/mask")
    public String mask() {
        return DesensitizedUtil.mobilePhone("13800000001");
    }
}
