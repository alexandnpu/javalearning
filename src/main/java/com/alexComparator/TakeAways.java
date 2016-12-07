package com.alexComparator;


/**
 * Created by zhengchao on 16/10/3.
 */
public class TakeAways {

    int price;
    String name;

    public TakeAways(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return String.format("TakeAway[name=%s, price=%d]", this.name, this.price);
    }
}
