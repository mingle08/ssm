package com.ssmstudy.dubbo.spi.jdkSpi;

import java.util.HashMap;
import java.util.Map;

import com.ssmstudy.dubbo.spi.MyDubboProtocol;
import com.ssmstudy.dubbo.spi.MyHessianProtocol;
import com.ssmstudy.dubbo.spi.MyProtocol;

public class ProtocolClient {
    private final static Map<String, MyProtocol> RPOTOCOL_LIST = new HashMap<>();

    static {
        RPOTOCOL_LIST.put ("dubbo", new MyDubboProtocol());
        RPOTOCOL_LIST.put ("hessian", new MyHessianProtocol());
    }

    public void doInvoke(String protocolType) {
        MyProtocol protocol = ProtocolClient.RPOTOCOL_LIST.get (protocolType);
        if (protocol != null) {
            protocol.invoke ();
        }
    }
}
