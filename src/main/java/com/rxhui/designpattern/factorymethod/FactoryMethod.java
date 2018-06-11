package com.rxhui.designpattern.factorymethod;

/**
 * @author ppgeneve
 * @Description: 定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化推迟到子类。
 * @Date 2018/6/11 15:16
 */
public class FactoryMethod {

}


interface Product {

}

class ConcreteProduct implements Product {

}

abstract class BaseFactory {
    abstract Product factoryMethod();

    void f(){}
}

class ConcreteBaseFactory extends BaseFactory {
    @Override
    Product factoryMethod() {
        return new ConcreteProduct();
    }

}