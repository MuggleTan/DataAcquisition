package com.hunau.datacquisition;

import com.hunau.datacquisition.socket.client.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataAcquisitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAcquisitionApplication.class, args);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new NettyClient("192.168.4.1",5000).startConn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
