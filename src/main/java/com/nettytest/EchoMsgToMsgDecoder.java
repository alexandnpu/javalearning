package com.nettytest;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * Created by zhengchao on 2017/1/23.
 */
public class EchoMsgToMsgDecoder extends MessageToMessageDecoder<String> {
    @Override protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        System.out.println("received:" + msg);
        ctx.channel().writeAndFlush(Unpooled.wrappedBuffer("msg received".getBytes()));
    }
}
