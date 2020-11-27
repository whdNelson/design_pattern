package com.wanghaodong.design_pattern.service;


import com.wanghaodong.design_pattern.model.AgeLog;
import com.wanghaodong.design_pattern.vo.AgeLogVo;

/**
 * 切面模板日志
 */
public interface AopVmLoggableService {

    void create(AgeLog ageLog);

    /**
     * 抽象方法
     */
    String getAge(AgeLogVo age);
}
