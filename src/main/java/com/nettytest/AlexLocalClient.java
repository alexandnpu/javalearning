package com.nettytest;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalEventLoopGroup;

/**
 * Created by zhengchao on 2017/1/25.
 */
public class AlexLocalClient {

    private String remoteAddress;
    public AlexLocalClient(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
    public void start() {
        EventLoopGroup eventLoopGroup = new LocalEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(eventLoopGroup);
            b.channel(LocalChannel.class);
            b.handler(new ChannelInitializer<LocalChannel>() {
                @Override protected void initChannel(LocalChannel ch) throws Exception {
                    ch.pipeline().addLast(new AlexLocalClientHandler());
                }
            });
            LocalAddress address = new LocalAddress(this.remoteAddress);
            ChannelFuture future = b.connect(address).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            System.out.println("error !" + e);
        }
    }
}
