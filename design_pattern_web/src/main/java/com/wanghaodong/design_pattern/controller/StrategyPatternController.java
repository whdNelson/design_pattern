package com.wanghaodong.design_pattern.controller;

import com.wanghaodong.design_pattern.enums.StrategyPatternImportEnum;
import com.wanghaodong.design_pattern.service.StrategyPatternImportService;
import com.wanghaodong.design_pattern.service.config.StrategyPatternImportFactory;
import com.wanghaodong.design_pattern.vo.StrategyPatternImportVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/Strategy")
@Api(tags = "策略模式")
public class StrategyPatternController {

    @Autowired
    private List<StrategyPatternImportService> strategyPatternImportServices;

    @Autowired
    private StrategyPatternImportFactory strategyPatternImportFactory;


    /**
     * 简单策略模式：
     * 依赖注入抽象接口，作为list
     * 遍历调用每一个实现类
     *
     */
    @GetMapping("/simple")
    public void simpleStrategyPattern(){
        for (StrategyPatternImportService strategyPatternImportService: strategyPatternImportServices) {
            strategyPatternImportService.importFile();
        }
    }

    /**
     * 拓展模式（接口工厂模式与Aware接口）
     *
     */
    @GetMapping
    @ApiImplicitParams(
            @ApiImplicitParam(name = "type",value = "实现类型",required = true,paramType = "query",dataType = "StrategyPatternImportEnum")
    )
    public void strategyPattern(@ApiIgnore StrategyPatternImportVo vo){

        //设定枚举值，匹配具体实现类（可扩展成vo类属性，web端入参控制）
        StrategyPatternImportService strategyPatternImportService = strategyPatternImportFactory.getService(vo.getType());
        strategyPatternImportService.importFile();
    }

}
