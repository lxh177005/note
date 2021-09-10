package com.xingxin.java8;

@FunctionalInterface
public interface Java8ParamInterface {
    void hello(int i, int j);
}
class Java8ParamInterfaceTest {
    public static void main(String[] args) {
         // java8之前
        Java8ParamInterface old = new Java8ParamInterface() {
            @Override
            public void hello(int i, int j) {
                System.out.println( i +"----"+ j);
            }
        };
        old.hello(1,2);
        // now
        Java8ParamInterface now = (i, j) -> System.out.println(i +"----"+ j);
        now.hello(3,4);
    }
}