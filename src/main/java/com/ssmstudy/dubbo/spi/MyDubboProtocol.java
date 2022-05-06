package com.ssmstudy.dubbo.spi;

public class MyDubboProtocol implements MyProtocol {

    private static final String protocolType = "dubbo";

    @Override
    public String getProtocolType() {
        return protocolType;
    }

    @Override
    public void invoke() {
        System.out.println ("this is dubbo protocol ");
    }
}
