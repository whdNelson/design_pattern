package com.wanghaodong.design_pattern.service.impl.chainofresponsibility;

import com.wanghaodong.design_pattern.service.ChainOfResponsibilityDestinationHandle;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

/**
 * 责任链模式 - 目的地一段码解析
 */
@Service
public class ChainOfResponsibilityDestinationOne extends ChainOfResponsibilityDestinationHandle {


    @Override
    public String getDestination(String code, Map<String,String> result) {

        String[] codes = code.split(" ");
        if (codes.length >= 1){
            //判断为一段码，执行解析逻辑
            result.put("一段码",Arrays.toString(codes));
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
