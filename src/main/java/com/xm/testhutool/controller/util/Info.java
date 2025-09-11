package com.xm.testhutool.controller.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Info {
    // 是否有效
    private boolean valid;
    // 出生日期
    private String birth;
    // 省份
    private String province;
}
