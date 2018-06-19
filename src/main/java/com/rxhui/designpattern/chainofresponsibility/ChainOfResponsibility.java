package com.rxhui.designpattern.chainofresponsibility;


/**
 * @author ppgeneve
 * @Description: 责任链
 * @Date 2018/6/15 15:37
 */
enum RequestType {
    type1, type2
}

class Request {
    private RequestType type;
    private String name;

    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }

    public RequestType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}

abstract class BaseHandler {
    protected BaseHandler successor;

    public BaseHandler(BaseHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理请求的逻辑
     */
    protected abstract void handleRequest(Request request);

}

class ConcreteBaseHandler1 extends BaseHandler {
    public ConcreteBaseHandler1(BaseHandler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.getType() == RequestType.type1) {
            System.out.println(request.getName() + " is handled by ConcreteHandler1.");
        }
        if(successor != null) {
            successor.handleRequest(request);
            System.out.println(successor.getClass().getName());
        }
    }
}

class ConcreteBaseHandler2 extends BaseHandler {
    public ConcreteBaseHandler2(BaseHandler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.getType() == RequestType.type2) {
            System.out.println(request.getName() + " is handled by ConcreteHandler2.");
        }
        if(successor != null) {
            System.out.println(successor.getClass().getName());
            successor.handleRequest(request);
        }
    }
}

class Client {
    public static void main(String[] args) {
        BaseHandler handler1 = new ConcreteBaseHandler1(null);
        BaseHandler handler2 = new ConcreteBaseHandler2(handler1);
        Request request1 = new Request(RequestType.type1, "request1");
        handler2.handleRequest(request1);
        Request request2 = new Request(RequestType.type2, "request2");
        handler2.handleRequest(request2);
    }
}
