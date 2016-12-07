package com.logbackLearning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhengchao on 2016/11/8.
 */
public class Demo {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Demo.class);
        for (int i = 0; i < 10000; ++i) {
            logger.info("Hello world");
            logger.info("Hello eleme");
        }
    }
}
