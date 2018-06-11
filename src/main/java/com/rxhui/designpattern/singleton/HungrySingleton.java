package com.rxhui.designpattern.singleton;

/**
 * @author ppgeneve
 * @Description: hungry, safe
 * @Date 2018/6/11 14:15
 */
class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
