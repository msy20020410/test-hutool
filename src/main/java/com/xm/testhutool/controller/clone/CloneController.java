package com.xm.testhutool.controller.clone;

import cn.hutool.core.clone.CloneSupport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clone")
public class CloneController {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Dog extends CloneSupport<Dog> {
        String name;
        int age;
    }

    // 浅克隆
    @GetMapping("/test")
    public String test() {
        Dog dog = new Dog("张三", 18);
        Dog cloned = dog.clone();
        return dog == cloned ? "true" : "false";
    }
}
