package com.xm.testhutool.controller.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/str")
public class StringUtilController {
    @RequestMapping("/format")
    public String format() {
        String msg = "{},今年{}岁了";
        return StrUtil.format(msg, "小明", 18);
    }
}
