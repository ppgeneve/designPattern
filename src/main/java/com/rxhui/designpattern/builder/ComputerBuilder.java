package com.rxhui.designpattern.builder;

/**
 * @author ppgeneve
 * @Description: builder example
 * @Date 2018/6/12 16:18
 */
class Computer {
    public String master;
    public String screen;
    public String keyboard;
    public String mouse;
    public String audio;
    public void setMaster(String master) {
        this.master = master;
    }
    public void setScreen(String screen) {
        this.screen = screen;
    }
    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }
    public void setMouse(String mouse) {
        this.mouse = mouse;
    }
    public void setAudio(String audio) {
        this.audio = audio;
    }
}

public abstract class ComputerBuilder {
    protected Computer computer;
    public Computer getComputer() {
        return computer;
    }
    public void buildComputer(){
        computer = new Computer();
        System.out.println("生成了一个电脑");
    }

    public abstract void buildMaster();
    public abstract void buildScreen();
    public abstract void buildKeyboard();
    public abstract void buildMouse();
    public abstract void buildAudio();
}

class HpComputerBuilder extends ComputerBuilder {
    @Override
    public void buildAudio() {
        computer.setAudio("飞利浦 音响");
        System.out.println("(飞利浦 音响)的音响");
    }

    @Override
    public void buildMaster() {
        computer.setMaster("i7,16g,512SSD,1060");
        System.out.println("(i7,16g,512SSD,1060)的惠普主机");
    }

    @Override
    public void buildScreen() {
        computer.setScreen("1080p");
        System.out.println("(1080p)的惠普显示屏");
    }

    @Override
    public void buildKeyboard() {
        computer.setKeyboard("cherry 青轴机械键盘");
        System.out.println("(cherry 青轴机械键盘)的键盘");
    }

    @Override
    public void buildMouse() {
        computer.setMouse("MI 鼠标");
        System.out.println("(MI 鼠标)的鼠标");
    }
}

class DELLComputerBuilder extends ComputerBuilder {

    @Override
    public void buildMaster() {
        // TODO Auto-generated method stub
        computer.setMaster("i7,32g,1TSSD,1060");
        System.out.println("(i7,32g,1TSSD,1060)的戴尔主机");
    }

    @Override
    public void buildScreen() {
        // TODO Auto-generated method stub
        computer.setScreen("4k");
        System.out.println("(4k)的dell显示屏");
    }

    @Override
    public void buildKeyboard() {
        // TODO Auto-generated method stub
        computer.setKeyboard("cherry 黑轴机械键盘");
        System.out.println("(cherry 黑轴机械键盘)的键盘");
    }

    @Override
    public void buildMouse() {
        // TODO Auto-generated method stub
        computer.setMouse("MI 鼠标");
        System.out.println("(MI 鼠标)的鼠标");
    }

    @Override
    public void buildAudio() {
        // TODO Auto-generated method stub
        computer.setAudio("飞利浦 音响");
        System.out.println("(飞利浦 音响)的音响");
    }
}

class Director {

    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

    public void constructComputer() {
        computerBuilder.buildComputer();
        computerBuilder.buildMaster();
        computerBuilder.buildScreen();
        computerBuilder.buildKeyboard();
        computerBuilder.buildMouse();
        computerBuilder.buildAudio();
    }

}

 class ComputerCustomer {

    public static void main(String[] args) {
        Director director = new Director();

        ComputerBuilder hp = new HpComputerBuilder();

        director.setComputerBuilder(hp);

        director.constructComputer();

        //get the pc
        Computer pc = director.getComputer();
    }
}



