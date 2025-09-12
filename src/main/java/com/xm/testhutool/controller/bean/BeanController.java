package com.xm.testhutool.controller.bean;

import cn.hutool.core.bean.BeanUtil;
import com.xm.testhutool.controller.language.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BeanController {

    // bean工具类
    @GetMapping("/bean")
    public boolean bean() {
        return BeanUtil.isBean(Object.class);
    }

    // bean转map
    @GetMapping("/bean2map")
    public Map<String, Object> bean2map() {
        return BeanUtil.beanToMap(new Person("xm", 18, "男"));
    }
}
