package com.xm.testhutool.controller.date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/date")
public class DateController {

    // 获取当前时间
    @RequestMapping("/now")
    public String now() {
        return DateUtil.now();
    }

    // 计算两个日期的检差
    @GetMapping("/between")
    public Long between() {
        DateTime d1 = DateUtil.parse("2017-08-08 12:30:00");
        DateTime d2 = DateUtil.parse("2017-08-09 14:45:00");
        return DateUtil.between(d1, d2, DateUnit.DAY);
    }

    // 计时工具
    @GetMapping("/timer")
    public long timer() throws InterruptedException {
        // 开始计时
        TimeInterval timer = DateUtil.timer();

        for (int i = 0; i < 5; i++) {
            i++;
            Thread.sleep(1000);
        }
        return timer.intervalSecond();
    }
}
