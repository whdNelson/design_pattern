package com.wanghaodong.design_pattern.service;

import com.wanghaodong.design_pattern.enums.StrategyPatternImportEnum;

/**
 * 策略模式-导入案例接口
 */
public interface StrategyPatternImportService {

    /**
     * 抽象方法
     */
    void importFile();

    /**
     * 获取实现类的具体类型
     * @return 类型
     */
    StrategyPatternImportEnum getClassType();

}
