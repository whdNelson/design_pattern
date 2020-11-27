package com.wanghaodong.design_pattern.service.impl.strategy;

import com.wanghaodong.design_pattern.enums.StrategyPatternImportEnum;
import com.wanghaodong.design_pattern.mapper.AgeLogMapper;
import com.wanghaodong.design_pattern.model.AgeLog;
import com.wanghaodong.design_pattern.service.StrategyPatternImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 策略模式-工位导入实现
 */
@Service
public class StrategyPatternImportServiceStation implements StrategyPatternImportService {

    @Autowired
    private AgeLogMapper ageLogMapper;
    @Override
    public void importFile() {
        List<AgeLog> ageLogs = ageLogMapper.selectAll();
        System.out.println("导入工位");
    }

    @Override
    public StrategyPatternImportEnum getClassType() {
        return StrategyPatternImportEnum.STATION;
    }
}
