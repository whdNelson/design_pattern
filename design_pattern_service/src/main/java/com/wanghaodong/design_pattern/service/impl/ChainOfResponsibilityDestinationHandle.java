package com.wanghaodong.design_pattern.service.impl;


import java.util.Map;

/**
 * 责任链模式 - 根据目的地编码类型匹配目的地
 */
public abstract class ChainOfResponsibilityDestinationHandle {

    /**
     * 下一环节处理者
     */
    private ChainOfResponsibilityDestinationHandle next;

    public ChainOfResponsibilityDestinationHandle getNext() {
        return next;
    }

    public void setNext(ChainOfResponsibilityDestinationHandle next) {
        this.next = next;
    }

    /**
     * 根据对应的目的地编码执行逻辑
     * @param code 目的地编码
     * @return
     */
    public abstract String getDestination(String code, Map<String,String> result);
}
