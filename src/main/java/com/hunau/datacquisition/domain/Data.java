package com.hunau.datacquisition.domain;

/**
 * @author TanXY
 * @create 2020/6/23 - 8:32
 */
@lombok.Data
public class Data {
    private int dataId;

    private String IP;

    private String temp;

    private String humi;

    private String collTime;

    public Data() {
    }

    public Data(String IP, String temp, String humi) {
        this.IP = IP;
        this.temp = temp;
        this.humi = humi;
    }


}
