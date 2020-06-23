package com.hunau.datacquisition.service.Impl;

import com.hunau.datacquisition.domain.Data;
import com.hunau.datacquisition.mapper.DataMapper;
import com.hunau.datacquisition.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TanXY
 * @create 2020/6/23 - 8:33
 */

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataMapper dataMapper;

    @Override
    public List<Data> selectDataList(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        return dataMapper.selectDataList(start,pageSize);
    }

    @Override
    public List<Data> getDataCount() {
        return dataMapper.getDataCount();
    }

    @Override
    public void collData(Data data) {
        dataMapper.collData(data);
    }
}
