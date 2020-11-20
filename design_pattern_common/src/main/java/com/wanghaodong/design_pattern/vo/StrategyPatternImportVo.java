package com.wanghaodong.design_pattern.vo;

import com.wanghaodong.design_pattern.enums.StrategyPatternImportEnum;

import java.io.Serializable;

/**
 * 策略模式 - 导入实体类（仅作为类型区分）
 */

public class StrategyPatternImportVo implements Serializable {

    private static final long serialVersionUID = 7719113400606580201L;
    /**
     * 类型
     */
    private StrategyPatternImportEnum type;

    public StrategyPatternImportEnum getType() {
        return type;
    }

    public void setType(StrategyPatternImportEnum type) {
        this.type = type;
    }
}
