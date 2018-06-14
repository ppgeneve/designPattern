package com.rxhui.designpattern.proxy;

/**
 * @author ppgeneve
 * @Description:
 * @Date 2018/6/12 22:31
 */

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 没有实现任何接口
 */
class CglibUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}

class CglibProxyFactory implements MethodInterceptor{
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        /*
        工具
         */
        Enhancer en = new Enhancer();

        /*
        设置父类
         */
        en.setSuperclass(target.getClass());

        /*
        设置回调
         */
        en.setCallback(this);

        return en.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务...");

        //执行目标对象的方法
        Object returnValue = method.invoke(target);

        System.out.println("提交事务...");

        return returnValue;
    }
}


/**
 * 测试类
 */

class App {
    public static void main(String[] args){
        //目标对象
        CglibUserDao target = new CglibUserDao();

        //代理对象
        CglibUserDao proxy = (CglibUserDao)new CglibProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}