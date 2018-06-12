package com.rxhui.designpattern.prototype;

/**
 * @author ppgeneve
 * @Description:
 * @Date 2018/6/12 16:30
 */
public abstract class Prototype {
    abstract Prototype myClone();
}

class ConcreteProtoType1 extends Prototype {
    private String filed;

    public ConcreteProtoType1(String filed){
        this.filed = filed;
    }

    @Override
    Prototype myClone() {
        return new ConcreteProtoType1(filed);
    }

    @Override
    public String toString(){
        return filed;
    }
}



class Client {
    public static void main(String[] args) {
        Prototype prototype = new ConcreteProtoType1("abc");
        Prototype clone = prototype.myClone();
        System.out.println(clone.toString());
    }
}
