package com.ssmstudy.dubbo.spi.jdkSpi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

import com.ssmstudy.dubbo.spi.MyProtocol;

public class SpiProtocolClient {
    private final static Map<String, MyProtocol> RPOTOCOL_LIST = new HashMap<>();

    static {
        // 使用ServiceLoader
        ServiceLoader<MyProtocol> serviceLoader = ServiceLoader.load (MyProtocol.class);
        Iterator<MyProtocol> iterator = serviceLoader.iterator ();
        while (iterator.hasNext ()) {
            MyProtocol itr = iterator.next ();
            RPOTOCOL_LIST.put (itr.getProtocolType (), itr);
        }
    }

    public void doInvoke(String protocolType) {
        MyProtocol protocol = SpiProtocolClient.RPOTOCOL_LIST.get (protocolType);
        if (protocol != null) {
            protocol.invoke ();
        }
    }

    public static void main(String[] args) {
        SpiProtocolClient spiProtocolClient = new SpiProtocolClient();
        spiProtocolClient.doInvoke("dubbo");
    }
}
