package com.hunau.datacquisition.service;

import com.hunau.datacquisition.domain.Data;

import java.util.List;

/**
 * @author TanXY
 * @create 2020/6/23 - 8:32
 */
public interface DataService {
    List<Data> selectDataList(int start, int pageSize);

    List<Data> getDataCount();

    void collData(Data data);
}
