package com.nettytest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created by zhengchao on 2016/12/7.
 */
public class AlexServer {

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group);
            b.channel(NioServerSocketChannel.class);
            b.localAddress(new InetSocketAddress(20000));
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new EchoHandler());
                }
            });

            ChannelFuture f = b.bind().sync();
            System.out.println("server has started");
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
