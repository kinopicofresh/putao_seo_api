package com.putao_seo.api.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface PartitionOptMapper {

    Map<String, String> showCreateTable(@Param("tableName")String tableName);

    Map<String, String> showPartitionTable(@Param("tableName")String tableName);
}
