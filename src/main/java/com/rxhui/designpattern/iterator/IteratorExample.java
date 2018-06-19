package com.rxhui.designpattern.iterator;

/**
 * @author ppgeneve
 * @Description:
 * @Date 2018/6/19 08:45
 */
interface Iterator<Item> {
    Item next();
    boolean hasNext();
}

class ConcreteIterator<Item> implements Iterator {
    private Item[] items;
    private int position = 0;

    public ConcreteIterator(Item[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length;
    }

    @Override
    public Object next() {
        return items[position++];
    }
}

interface Aggregate {
    Iterator createIterator();
}

class ConcreteAggregate implements Aggregate{
    private Integer[] items;

    public ConcreteAggregate() {
        items = new Integer[10];
        for (int i = 0; i < items.length; i ++) {
            items[i] = i;
        }
    }

    @Override
    public Iterator createIterator() {
       return new ConcreteIterator<Integer>(items);
    }
}


public class IteratorExample {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        Iterator<Integer> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
