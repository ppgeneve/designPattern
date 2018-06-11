package com.rxhui.designpattern.singleton;

/**
 * @author ppgeneve
 * @Description: lazy, thread unsafe
 * @Date 2018/6/11 13:50
 */
class LazyUnsafeSingleton {
    private static LazyUnsafeSingleton uniqueInstance;

    private LazyUnsafeSingleton(){}

    public static LazyUnsafeSingleton getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new LazyUnsafeSingleton();
        }
        return uniqueInstance;
    }
}
