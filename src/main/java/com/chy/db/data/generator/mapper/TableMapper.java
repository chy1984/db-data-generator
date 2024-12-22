package com.chy.db.data.generator.mapper;

import java.util.List;

/**
 * 数据表操作的 Mapper 接口，泛型指定数据表对应的实体类
 *
 * @author chy
 */
public interface TableMapper<T> {

    /**
     * 批量插入记录
     *
     * @param records 待插入记录列表
     * @return int
     */
    int batchInsert(List<T> records);

    /**
     * 清空表数据
     */
    void truncateTable();

}
