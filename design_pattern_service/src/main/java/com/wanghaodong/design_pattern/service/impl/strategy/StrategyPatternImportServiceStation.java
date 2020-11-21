package com.wanghaodong.design_pattern.service.impl.strategy;

import com.wanghaodong.design_pattern.enums.StrategyPatternImportEnum;
import com.wanghaodong.design_pattern.service.StrategyPatternImportService;
import org.springframework.stereotype.Service;

/**
 * 策略模式-工位导入实现
 */
@Service
public class StrategyPatternImportServiceStation implements StrategyPatternImportService {

    @Override
    public void importFile() {
        System.out.println("导入工位");
    }

    @Override
    public StrategyPatternImportEnum getClassType() {
        return StrategyPatternImportEnum.STATION;
    }
}
