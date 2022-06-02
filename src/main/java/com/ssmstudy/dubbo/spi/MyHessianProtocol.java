package com.ssmstudy.dubbo.spi;

public class MyHessianProtocol implements MyProtocol {

    private static final String protocolType = "hessian";

    @Override
    public String getProtocolType() {
        return protocolType;
    }

    @Override
    public void invoke() {
        System.out.println ("this is hessian protocol ");
    }
}
