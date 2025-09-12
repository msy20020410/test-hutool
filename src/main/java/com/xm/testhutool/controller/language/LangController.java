package com.xm.testhutool.controller.language;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Dict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LangController {

    // Dict类
    @RequestMapping("/dict")
    public Person dict() {
        Dict dict = Dict.create();
        dict
                .set("name", "张三")
                .set("age", 18)
                .set("sex", "男");
        return new Person(dict.getStr("name"), dict.getInt("age"), dict.getStr("sex"));
    }

    // Assert类
    @RequestMapping("/assert")
    public String asserts() {
        String name = "张三";
        Assert.notBlank(name);
        return "success";
    }

    // Console 类
    @RequestMapping("/console")
    public String console() {
        Console.log("你好，{}！", "张三");
        return "success";
    }


}
