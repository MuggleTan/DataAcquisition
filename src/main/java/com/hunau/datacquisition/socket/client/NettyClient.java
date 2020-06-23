package com.hunau.datacquisition.socket.client;

import com.hunau.datacquisition.socket.handler.DataHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * @author TanXY
 * @create 2020/6/23 - 11:11
 */
public class NettyClient {

    private String IP;

    private int port;

    private static Channel channel = null;

    public NettyClient(String IP, int port) {
        this.IP = IP;
        this.port = port;
    }

    public NettyClient() {
    }

    public void startConn() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .remoteAddress(new InetSocketAddress(port))
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new StringEncoder());
                        socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new DataHandler());
                    }
                });
        ChannelFuture cf = bootstrap.connect(IP, port).sync();

        channel = cf.channel();

        cf.channel().closeFuture().sync();

        group.shutdownGracefully().sync();

    }

    public String getIP() {
        return IP;
    }
}
