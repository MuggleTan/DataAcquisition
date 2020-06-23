package com.hunau.datacquisition.controller;

import com.hunau.datacquisition.domain.Data;
import com.hunau.datacquisition.domain.TableInfo;
import com.hunau.datacquisition.service.Impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author TanXY
 * @create 2020/6/23 - 8:32
 */

@Controller
public class DataController {

    @Autowired
    DataServiceImpl dataService;

    private TableInfo tableInfo = new TableInfo();

    @ResponseBody
    @GetMapping("/list")
    public TableInfo dataList(int page,int limit){
        List<Data> list = dataService.selectDataList(page,limit);
        List<Data> data = dataService.getDataCount();
        return tableInfo.getTableData(list,data.size());
    }
}
