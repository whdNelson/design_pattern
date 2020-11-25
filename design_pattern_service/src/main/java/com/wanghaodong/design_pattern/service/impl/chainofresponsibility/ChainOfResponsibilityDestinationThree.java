package com.wanghaodong.design_pattern.service.impl.chainofresponsibility;

import com.wanghaodong.design_pattern.service.ChainOfResponsibilityDestinationHandle;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 责任链模式 - 目的地三段码解析
 */
@Service
public class ChainOfResponsibilityDestinationThree extends ChainOfResponsibilityDestinationHandle {


    @Override
    public String getDestination(String code, Map<String,String> result) {

        String[] codes = code.split(" ");
        if (codes.length == 3){
            //判断为三段码，执行解析逻辑
            result.put("三段码",code);
        }
        if (getNext() != null){
            //执行下一节点方法
            return getNext().getDestination(code,result);
        }else {
            //无下一节点
            return result.toString();
        }
    }
}
