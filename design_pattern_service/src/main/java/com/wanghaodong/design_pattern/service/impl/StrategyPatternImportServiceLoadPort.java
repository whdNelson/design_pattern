package com.wanghaodong.design_pattern.service.impl;

import com.wanghaodong.design_pattern.enums.StrategyPatternImportEnum;
import com.wanghaodong.design_pattern.service.StrategyPatternImportService;
import org.springframework.stereotype.Service;

/**
 * 策略模式-装车口导入实现
 */
@Service
public class StrategyPatternImportServiceLoadPort implements StrategyPatternImportService {

    @Override
    public void importFile() {
        System.out.println("导入装车口");
    }

    @Override
    public StrategyPatternImportEnum getClassType() {
        return StrategyPatternImportEnum.LOAD_PORT;
    }
}
