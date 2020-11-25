package com.wanghaodong.design_pattern.controller;

import com.wanghaodong.design_pattern.service.ChainOfResponsibilityDestinationHandle;
import com.wanghaodong.design_pattern.service.impl.chainofresponsibility.ChainOfResponsibilityDestinationOne;
import com.wanghaodong.design_pattern.service.impl.chainofresponsibility.ChainOfResponsibilityDestinationThree;
import com.wanghaodong.design_pattern.service.impl.chainofresponsibility.ChainOfResponsibilityDestinationTwo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/ChainOfResponsibility")
@Api(tags = "责任链模式")
public class ChainOfResponsibilityController {

    /**
     * 分层级数据目的地编码
     *
     */
    @GetMapping
    public String parseDestination(String code){

        if (code == null || "".equals(code.trim())){
            return "输入编码错误";
        }
        //定义链子节点实例
        ChainOfResponsibilityDestinationHandle one = new ChainOfResponsibilityDestinationOne();
        ChainOfResponsibilityDestinationHandle two = new ChainOfResponsibilityDestinationTwo();
        ChainOfResponsibilityDestinationHandle three = new ChainOfResponsibilityDestinationThree();

        //组装链子顺序
        one.setNext(two);
        two.setNext(three);

        //执行首节点的，作为入口
        return one.getDestination(code.trim(),new HashMap<>());
    }

}
