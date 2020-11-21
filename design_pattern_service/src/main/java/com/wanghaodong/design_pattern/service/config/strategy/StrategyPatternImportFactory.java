package com.wanghaodong.design_pattern.service.config.strategy;


import com.wanghaodong.design_pattern.enums.StrategyPatternImportEnum;
import com.wanghaodong.design_pattern.service.StrategyPatternImportService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

/**
 * 策略模式-导入功能
 */
@Component
public class StrategyPatternImportFactory implements ApplicationContextAware {

    /**
     * 静态枚举map，存储枚举名称与对应的接口实现类
     * k:枚举名称
     * v:对应的实现类
     */
    private static EnumMap<StrategyPatternImportEnum, StrategyPatternImportService> strategyServiceMap = new EnumMap<>(StrategyPatternImportEnum.class);


    /**
     * 实现方法：程序启动，通过上下文获取实现类
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String,StrategyPatternImportService> serviceMap = applicationContext.getBeansOfType(StrategyPatternImportService.class);
        serviceMap.forEach((k,v) -> strategyServiceMap.put(v.getClassType(),v));
    }

    /**
     * 提供对外数据：
     * 根据具体类型，获取对应的实现类。
     * @param type 类型
     * @return
     */
    public StrategyPatternImportService getService(StrategyPatternImportEnum type){
        return strategyServiceMap.get(type);
    }
}
