package com.nettytest;

import java.util.Set;

/**
 * Created by zhengchao on 2016/11/10.
 */
public class Demo {

    private static void startNormalServer() throws InterruptedException {
        AlexServer server = new AlexServer();
        server.start();
    }

    private static void startLocalServer() throws InterruptedException {
        AlexLocalServer server = new AlexLocalServer("hello");
        server.start();
    }

    private static void startLocalClient() {
        AlexLocalClient client = new AlexLocalClient("hello");
        client.start();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread serverThread = new Thread(new Runnable() {
            @Override public void run() {
                try {
                    startLocalServer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        serverThread.start();

        Thread.sleep(1000);

        Thread clientThread = new Thread(new Runnable() {
            @Override public void run() {
                startLocalClient();
            }
        });
        clientThread.start();
    }
}
