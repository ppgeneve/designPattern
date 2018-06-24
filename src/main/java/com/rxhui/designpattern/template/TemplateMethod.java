package com.rxhui.designpattern.template;

/**
 * @author ppgeneve
 * @Description:
 * @Date 2018/6/24 19:06
 */
abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("boil water!");
    }

    void pourInCup() {
        System.out.println("pour in cup!");
    }
}

class Coffee extends CaffeineBeverage {
    @Override
    void addCondiments() {
        System.out.println("add sugar!");
    }

    @Override
    void brew() {
        System.out.println("brew coffee grinds");
    }
}

class Tea extends CaffeineBeverage {
    @Override
    void addCondiments() {
        System.out.println("add lemon");
    }

    @Override
    void brew() {
        System.out.println("steep tea bag");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        CaffeineBeverage caffeineBeverage = new Coffee();
        caffeineBeverage.prepareRecipe();
        System.out.println("---------");
        caffeineBeverage = new Tea();
        caffeineBeverage.prepareRecipe();

    }
}
