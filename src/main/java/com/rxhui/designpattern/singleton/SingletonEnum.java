package com.rxhui.designpattern.singleton;

/**
 * @author ppgeneve
 * @Description: singleton best practice
 * @Date 2018/6/11 14:29
 */
enum SingletonEnum {
    /**
     优势：
     (1)自由序列化。
     (2)保证只有一个实例。
     (3)线程安全。
     */
    INSTANCE;
    public void f(){
        //do something.
    }
}

class Usage {
    public static void main(String[] args) {
        SingletonEnum.INSTANCE.f();
    }
}
