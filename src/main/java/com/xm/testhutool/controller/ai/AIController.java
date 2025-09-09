package com.xm.testhutool.controller.ai;

import cn.hutool.ai.AIUtil;
import cn.hutool.ai.ModelName;
import cn.hutool.ai.core.AIConfig;
import cn.hutool.ai.core.AIConfigBuilder;
import cn.hutool.ai.model.deepseek.DeepSeekService;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AIController {
    // 获取指定的ai服务
    DeepSeekService dss = AIUtil.getDeepSeekService(
            new AIConfigBuilder(ModelName.DEEPSEEK.getValue())
                    .setApiKey("sk-76779b2b7a2c44aa8d9a51bc83fdb3aa")
                    .build()
    );

    // 对话
    @GetMapping("/chat")
    public String chat() {
        String json = dss.chat("你是谁?");
        //只获取content字段
        JSONObject root = JSONUtil.parseObj(json);
        JSONArray choices = root.getJSONArray("choices");
        return choices.getJSONObject(0)
                .getJSONObject("message")
                .getStr("content");
    }


    // 查模型
    @GetMapping("/models")
    public String models() {
        // 获取模型列表
        return dss.models();
    }

    // 查余额
    @GetMapping("/balance")
    public String balance() {
        // 查余额
        return dss.balance();
    }

}
