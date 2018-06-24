package com.rxhui.designpattern.strategy;

/**
 * @author ppgeneve
 * @Description:
 * @Date 2018/6/24 18:59
 */
interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}

class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}


class Duck {
    private QuackBehavior quackBehavior;

    public void performQuack() {
        if(quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}


public class Strategy {
   public static void main(String[] args) {
       Duck duck = new Duck();
       duck.setQuackBehavior(new Squeak());
       duck.performQuack();
       duck.setQuackBehavior(new Quack());
       duck.performQuack();
   }
}
