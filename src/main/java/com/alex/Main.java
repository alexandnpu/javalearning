package com.alex;

import java.util.List;

/**
 * Created by zhengchao on 16/10/1.
 */
public class Main {

    public static void main(String[] args) {
        AbstractAlex one = new OneAlex();
        AbstractAlex sub = new SubAlex();

        System.out.println(one.hashCode());
        System.out.println(sub.hashCode());
        sub.sayHi();

    }


}
