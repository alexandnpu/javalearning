package com.alex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by zhengchao on 16/10/1.
 */
public class Main {
    public static long getHashCode(String id) {
        if (id == null)
            return -1;

        char[] value = id.toCharArray();
        long h = 0;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
        }
        h = Math.abs(h);
        h = h % 1024;
        return h;
    }

    public static void main(String[] args) {
        System.out.println(getHashCode("7950594"));

    }


}
