package com.rxhui.designpattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @author ppgeneve
 * @Description: 动态代理
 * @Date 2018/6/12 21:08
 */
interface IUserDao {
    /**
     * save
     */
    void save();
}

class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("-----已经保存数据------");
    }
}

class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开始事务2");
                    //执行目标对象方法
                    Object returnValue = method.invoke(target, args);
                    System.out.println("提交事务2");
                    return returnValue;
                }
        );
    }
}

public class DynamicProxy {
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }

}
