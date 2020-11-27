package com.wanghaodong.design_pattern.service.impl.chainofresponsibility;

import com.wanghaodong.design_pattern.annotation.Loggable;
import com.wanghaodong.design_pattern.mapper.AgeLogMapper;
import com.wanghaodong.design_pattern.model.AgeLog;
import com.wanghaodong.design_pattern.service.AopVmLoggableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 切面模板日志
 */
@Service
public class AopVmLoggableServiceImpl implements AopVmLoggableService {

    @Autowired
    private AgeLogMapper ageLogMapper;

    @Override
    public void create(AgeLog ageLog) {
        ageLogMapper.insertSelective(ageLog);
    }

    @Override
    @Loggable
    public Integer getAge(Integer age) {
        return age;
    }
}
