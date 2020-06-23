package com.hunau.datacquisition.socket.handler;

import com.hunau.datacquisition.domain.Data;
import com.hunau.datacquisition.service.Impl.DataServiceImpl;
import com.hunau.datacquisition.socket.client.NettyClient;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author TanXY
 * @create 2020/6/23 - 11:12
 */
@Component
public class DataHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    private DataServiceImpl dataService;
    private NettyClient nettyClient;
    private static DataHandler dataHandler;

    @PostConstruct
    private void init() {
        dataHandler = this;
        dataHandler.dataService = this.dataService;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        String str = (String) msg;

        System.err.println(str);

        if (!str.equals("error")) {
            String[] data = str.split(",");

            dataHandler.dataService.collData(new
                    Data("192.168.4.1",data[0], data[1]));
        }
    }
}
