package com.rxhui.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ppgeneve
 * @Description: visitor模式加入一些反射的应用会更为简单
 * @Date 2018/6/24 19:14
 */
interface Visitor {
    void visitor(Customer customer);
    void visit(Order order);
    void visit(Item  item);
}

class Item implements Element{
    private String name;

    Item(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Element {
    void accept(Visitor visitor);
}


class Order implements Element {
    private String name;
    private List<Item> items = new ArrayList<>();

    Order(String name) {
        this.name = name;
    }

    Order(String name, String itemName){
        this.name = name;
        this.addItem(new Item(itemName));
    }

    void addItem(Item item) {
        items.add(item);
    }

    String getName() {
        return  name;
    }

    @Override
    public void accept(Visitor visitor) {
        for (Item item : items) {
            item.accept(visitor);
        }
    }
}

class Customer implements Element{
    private String name;
    private List<Order> orderList = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void addOrder(Order order) {
        orderList.add(order);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
        for (Order order : orderList) {
            order.accept(visitor);
        }
    }
}

class GeneralReport implements Visitor {

    private int customersNo;
    private int ordersNo;
    private int itemsNo;

    @Override
    public void visitor(Customer customer) {
        System.out.println("customer怼");
        System.out.println(customer.getName());
        customersNo++;
    }

    @Override
    public void visit(Order order) {
        System.out.println("order怼");
        System.out.println(order.getName());
        ordersNo++;
    }

    @Override
    public void visit(Item item) {
        System.out.println("item怼");
        System.out.println(item.getName());
        itemsNo++;
    }

    public void displayResults() {
        System.out.println("Number of customers: " + customersNo);
        System.out.println("Number of orders:    " + ordersNo);
        System.out.println("Number of items:     " + itemsNo);
    }

}
class CustomerGroup {

    private List<Customer> customers = new ArrayList<>();

    void accept(Visitor visitor) {
        for (Customer customer : customers) {
            customer.accept(visitor);
        }
    }

    void addCustomer(Customer customer) {
        customers.add(customer);
    }
}


class Client {
    public static void main(String[] args) {
        Customer customer1 = new Customer("customer1");
        customer1.addOrder(new Order("order1", "item1"));
        customer1.addOrder(new Order("order2", "item1"));
        customer1.addOrder(new Order("order3", "item1"));

        Order order = new Order("order_a");
        order.addItem(new Item("item_a1"));
        order.addItem(new Item("item_a2"));
        order.addItem(new Item("item_a3"));
        Customer customer2 = new Customer("customer2");
        customer2.addOrder(order);

        CustomerGroup customers = new CustomerGroup();
        customers.addCustomer(customer1);
        customers.addCustomer(customer2);

        GeneralReport visitor = new GeneralReport();
        customers.accept(visitor);
        visitor.displayResults();
    }
}
