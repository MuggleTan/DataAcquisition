package com.hunau.datacquisition.domain;

import lombok.Data;

import java.util.List;

/**
 * @author TanXY
 * @create 2020/6/23 - 9:02
 */
@Data
public class TableInfo {
    //状态码
    private int code;

    //消息内容
    private String msg;

    //列表数据
    private List<?> data;

    //总记录条数
    private long count;

    public TableInfo getTableData(List<?> list, int size){
        TableInfo resData = new TableInfo();
        resData.setCode(0);
        resData.setData(list);
        resData.setCount(size);
        return resData;
    }
}
