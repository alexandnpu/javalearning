package com.nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by zhengchao on 2017/1/23.
 */
public class EchoByteToMsgDecoder extends ByteToMessageDecoder {
    @Override protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println(in);
        while (in.readableBytes() >= 4) {
            out.add(String.valueOf(in.readInt()));
        }
    }
}
