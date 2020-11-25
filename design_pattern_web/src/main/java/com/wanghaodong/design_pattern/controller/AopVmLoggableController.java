package com.wanghaodong.design_pattern.controller;

import com.wanghaodong.design_pattern.service.AopVmLoggableService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/AopVmLoggable")
@Api(tags = "切面模板日志")
public class AopVmLoggableController {


    @Autowired
    private AopVmLoggableService aopVmLoggableService;


    /**
     * 通过切面记录年龄的日志，在vm模板中根据年龄不同区分年龄段
     * @param age 入参年龄
     */
    @GetMapping
    public Integer strategyPattern(Integer age){
        return aopVmLoggableService.getAge(age);
    }
}
