package com.rxhui.designpattern.adapter;

/**
 * @author ppgeneve
 * @Description:
 * @Date 2018/6/25 08:12
 */
interface Duck {
    void quack();
}

interface Turkey {
    void gobble();
}

class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("gobble");
    }
}

class TurkeyAdapter implements Duck {
    Turkey turkey;


    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}

public class Adapter {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quack();
    }
}
