package com.alex;

/**
 * Created by zhengchao on 2016/11/10.
 */
public class SubAlex extends OneAlex {
    @Override
    public int hashCode() {
        return 1234;
    }

    @Override public void sayHi() {
        System.out.println("sayHi" + super.hashCode());
    }
}
