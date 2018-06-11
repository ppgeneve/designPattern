package com.rxhui.designpattern.simplefactory;

/**
 * @author ppgeneve
 * @Description: simple factory
 * @Date 2018/6/11 14:54
 */
public class SimpleFactory {
    public Product createProduct(int type){
        if(type == 1) {
            return new ConcreteProduct1();
        } else if(type == 2){
            return new ConcreteProduct2();
        }
        return new ConcreteProduct();
    }
}

interface Product {

}

class ConcreteProduct implements Product {

}

class ConcreteProduct1 implements Product {

}

class ConcreteProduct2 implements Product {

}

class Usage {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
    }
}
