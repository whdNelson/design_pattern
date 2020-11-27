package com.wanghaodong.design_pattern.vo;

import java.io.Serializable;

public class AgeLogVo implements Serializable {

    private String age;

    private String memo;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
