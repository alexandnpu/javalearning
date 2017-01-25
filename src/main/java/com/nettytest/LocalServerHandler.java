package com.nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * Created by zhengchao on 2017/1/25.
 */
public class LocalServerHandler extends MessageToMessageDecoder<String> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channel active");
        super.channelActive(ctx);
    }
    @Override protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        System.out.println(msg);
        ctx.write(msg);
    }
}
