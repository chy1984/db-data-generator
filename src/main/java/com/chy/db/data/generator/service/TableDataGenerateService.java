package com.chy.db.data.generator.service;

/**
 * 表数据生成服务接口
 *
 * @author chy
 */
public interface TableDataGenerateService<T> {

    /**
     * 生成一条记录
     *
     * @return T
     */
    T generateRecord();

    /**
     * 批量插入记录
     *
     * @param inertRecordCount 要插入的记录总数
     */
    void batchInsertRecords(final int inertRecordCount);

    /**
     * 批量插入记录，可指定每批次生成、插入的记录数
     *
     * @param inertRecordCount 要插入的记录总数
     * @param batchSize        每批次插入的记录数
     */
    void batchInsertRecords(final int inertRecordCount, final int batchSize);

    /**
     * 清空表
     */
    void truncateTable();

}
