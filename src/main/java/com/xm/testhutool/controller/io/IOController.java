package com.xm.testhutool.controller.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileAppender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/io")
public class IOController {

    // 文件拷贝
    @RequestMapping("/copy")
    public String copy() {
        BufferedInputStream is = FileUtil.getInputStream("xlsx/员工信息模拟表.xlsx");
        BufferedOutputStream os = FileUtil.getOutputStream(
                "D:\\resources\\end_projects\\test-hutool\\src\\main\\resources\\xlsx\\员工信息模拟表copy.xlsx");
        IoUtil.copy(is, os, IoUtil.DEFAULT_BUFFER_SIZE);
        IoUtil.close(os);
        IoUtil.close(is);
        return "success";
    }

    // 文件追加器
    @RequestMapping("/append")
    public String append() {
        FileAppender appender = new FileAppender(
                FileUtil.file("D:\\resources\\end_projects\\test-hutool\\src\\main\\resources\\application.properties"),
                StandardCharsets.UTF_8,
                16,
                true);
        appender.append("server.port=8080");
        appender.flush();
        return "success!";
    }
}
