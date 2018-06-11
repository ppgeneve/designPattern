package com.rxhui.designpattern.singleton;

/**
 * @author ppgeneve
 * @Description: lazy, thread safe.
 * @Date 2018/6/11 14:12
 */
class LazySafeSingleton {
    private static LazySafeSingleton uniqueInstance;

    private LazySafeSingleton() {
    }

    public static synchronized LazySafeSingleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LazySafeSingleton();
        }
        return uniqueInstance;
    }
}
