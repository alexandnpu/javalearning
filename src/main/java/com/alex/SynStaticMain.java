package com.alex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhengchao on 2017/1/9.
 */
public class SynStaticMain {

    public static void main(String[] args) throws InterruptedException {
        Map<String, Boolean> map = new HashMap<>();
        map.put("eleme", true);

        System.out.println(map.put("alex", true));
        System.out.println(map.put("eleme", false));
    }
}
