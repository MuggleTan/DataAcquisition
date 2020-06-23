package com.hunau.datacquisition.mapper;

import com.hunau.datacquisition.domain.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author TanXY
 * @create 2020/6/23 - 8:32
 */

@Repository
@Mapper
public interface DataMapper {

    List<Data> selectDataList(int start, int pageSize);

    List<Data> getDataCount();

    void collData(Data data);
}