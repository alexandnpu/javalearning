package com.alexComparator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhengchao on 16/10/3.
 */
public class Main {

    static int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            nums[0] = nums[0] ^ nums[i];
            System.out.println(nums[0]);
        }

        return nums[0];
    }
    public static void main(String[] args) {
        List<TakeAways> shopingList = new LinkedList<>();
        shopingList.add(new TakeAways("hamburge", 123));
        shopingList.add(new TakeAways("youtiao", 150));
        shopingList.add(new TakeAways("doujiang", 100));

        Collections.sort(shopingList, (a, b) -> {
            return a.price - b.price;
        });

        for (TakeAways ta : shopingList) {
            System.out.println(ta);
        }

        System.out.printf("22 binary format(%1$x), after shifting right(%2$x) (%3$x)\n", 22, 22>>>1, 22>>1);
        System.out.printf("-22 binary format(%1$x), after shifting right(%2$x) (%3$x)\n", -22, -22>>>1, -22>>1);

        int[] test = {1, 2, 1};
        System.out.println(singleNumber(test));
    }
}
