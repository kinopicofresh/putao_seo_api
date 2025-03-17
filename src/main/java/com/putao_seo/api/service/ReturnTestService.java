package com.putao_seo.api.service;

import com.putao_seo.api.controller.TestQueryController;
import com.putao_seo.api.mapper.PartitionOptMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
@Service
public class ReturnTestService {

    private static final Logger logger = LoggerFactory.getLogger(ReturnTestService.class);

    @Resource
    PartitionOptMapper partitionOptMapper;

    public void showCreateTable() {

        String tableWithoutPartition = "yd_user";
        String tableHavePartition = "orders_par";
        Map<String, String> withOutParTable = partitionOptMapper.showCreateTable(tableWithoutPartition);
        Map<String, String> withParTable = partitionOptMapper.showCreateTable(tableHavePartition);

        logger.info("have partition table:");
        for (Map.Entry<String, String> entity: withParTable.entrySet()) {
            logger.info("key: {}, value: {} ", entity.getKey(), entity.getValue());
        }
        System.out.println("without partition table:");
        withOutParTable.forEach((key, value) -> System.out.println("key:  " + key + ", val: " + value));



    }

    public void showPartitionTable() {
        System.out.println("showPartitionTable:::::::::::::::::::::");

        String tableWithoutPartition = "yd_user";
        String tableHavePartition = "orders_par";
        //error sql statement
        Map<String, String> showWithOutTable = partitionOptMapper.showPartitionTable(tableWithoutPartition);
        Map<String, String> showPartitionTable = partitionOptMapper.showPartitionTable(tableHavePartition);

        logger.info("have partition table:");
        for (Map.Entry<String, String> entity: showPartitionTable.entrySet()) {
            logger.info("key: {}, value: {} ", entity.getKey(), entity.getValue());
        }
        System.out.println("without partition table:");
        for (Map.Entry<String, String> entity : showWithOutTable.entrySet()) {
            logger.info("key: {}, value: {} ", entity.getKey(), entity.getValue());
        }


    }
}
