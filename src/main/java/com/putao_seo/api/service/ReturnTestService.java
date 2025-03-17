package com.putao_seo.api.service;

import com.putao_seo.api.mapper.PartitionOptMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
@Service
public class ReturnTestService {

    @Resource
    PartitionOptMapper partitionOptMapper;

    public void showCreateTable() {

        String tableNameWithoutPar = "yd_user";
        String tableNamePar = "orders_par";
        Map<String, String> withOutParTable = partitionOptMapper.showCreateTable(tableNameWithoutPar);
        Map<String, String> withParTable = partitionOptMapper.showCreateTable(tableNamePar);

        System.out.println("with partition table:");
        for (Map.Entry<String, String> entity: withParTable.entrySet()) {
            System.out.println("key:  " + entity.getKey());
            System.out.println("val: " + entity.getValue());
        }
        System.out.println("without partition table:");
        withOutParTable.entrySet().stream().
                forEach(entity -> System.out.println("key:  " + entity.getKey() + ", val: " + entity.getValue()));

        showPartitionTable();

    }

    public void showPartitionTable() {
        System.out.println("showPartitionTable:::::::::::::::::::::");

        String tableNameWithoutPar = "yd_user";
        String tableNamePar = "orders_par";
        Map<String, String> showWithOutTable = partitionOptMapper.showPartitionTable(tableNameWithoutPar);
        Map<String, String> showPartitionTable = partitionOptMapper.showPartitionTable(tableNamePar);

        System.out.println("with partition table:");
        for (Map.Entry<String, String> entity: showPartitionTable.entrySet()) {
            System.out.println("key:  " + entity.getKey());
            System.out.println("val: " + entity.getValue());
        }
        System.out.println("without partition table:");
        showWithOutTable.entrySet().stream().
                forEach(entity -> System.out.println("key:  " + entity.getKey() + ", val: " + entity.getValue()));



    }
}
