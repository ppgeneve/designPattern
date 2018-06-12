package com.rxhui.designpattern.abstractfactory;

/**
 * @author ppgeneve
 * @Description: 抽象工厂方法，用于同时创建一系列相关的对象
 * @Date 2018/6/12 15:14
 */
public abstract class AbstractFactory {
    abstract ProductA createProductA();
    abstract ProductB createProductB();
}

class ProductA {

}

class ProductB {

}

class ProductA1 extends ProductA {

}

class ProductA2 extends ProductA {

}

class ProductB1 extends ProductB {

}

class ProductB2 extends ProductB {

}

class ConcreteFactory1 extends AbstractFactory {
    @Override
    ProductA createProductA() {
        return new ProductA1();
    }

    @Override
    ProductB createProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory2 extends AbstractFactory {
    @Override
    ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    ProductB createProductB() {
        return new ProductB2();
    }
}

class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        ProductA productA = abstractFactory.createProductA();
        ProductB productB = abstractFactory.createProductB();
        // do something with productA and productB
    }
}






