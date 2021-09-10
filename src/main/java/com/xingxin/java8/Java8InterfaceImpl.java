package com.xingxin.java8;

import com.rabbitmq.client.UnblockedCallback;

/**
 * @author liuxh
 * @date 2021/9/10
 */
public class Java8InterfaceImpl implements Java8Interface{
    @Override
    public void hello() {
        System.out.println("JDK8InterfaceImpl");
    }

    public static void main(String[] args) {
        Java8InterfaceImpl impl = new Java8InterfaceImpl();
        impl.hello();
        impl.defaultHello();
        Java8Interface.staticHello();
        UnblockedCallback staticHello = Java8Interface::staticHello;
    }
}
