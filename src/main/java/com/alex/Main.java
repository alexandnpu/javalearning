package com.alex;

//import com.alex.AlexHello;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
//        AlexHello.sayHi("my god");
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(100);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1, 2, 3, TimeUnit.SECONDS, queue
        );

        pool.execute(new Runnable() {
            @Override public void run() {
                System.out.println("hello");
            }
        });

    }


}
