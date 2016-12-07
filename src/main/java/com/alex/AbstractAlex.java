package com.alex;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhengchao on 16/10/1.
 */
public abstract class AbstractAlex {

    static List<Integer> ENQUEUED = new LinkedList<Integer>();
    static {
        ENQUEUED.add(123);
    }

    public abstract void sayHi();
}
