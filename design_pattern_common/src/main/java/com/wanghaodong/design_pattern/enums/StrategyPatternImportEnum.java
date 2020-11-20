package com.wanghaodong.design_pattern.enums;

/**
 * 策略模式 - 导入功能枚举类
 */
public enum StrategyPatternImportEnum {

    STATION("工位"),
    LOAD_PORT("zhuangchek "),
    UNLOAD_PORT("卸车口");

    private String name;

    StrategyPatternImportEnum(String name){this.name = name;}

    public String getName(){
        return name;
    }

}
