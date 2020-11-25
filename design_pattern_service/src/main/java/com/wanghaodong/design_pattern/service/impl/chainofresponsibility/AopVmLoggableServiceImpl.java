package com.wanghaodong.design_pattern.service.impl.chainofresponsibility;

import com.wanghaodong.design_pattern.annotation.Loggable;
import com.wanghaodong.design_pattern.service.AopVmLoggableService;
import org.springframework.stereotype.Service;

/**
 * 切面模板日志
 */
@Service
public class AopVmLoggableServiceImpl implements AopVmLoggableService {


    @Override
    @Loggable
    public Integer getAge(Integer age) {
        return age;
    }
}
