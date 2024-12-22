package com.chy.db.data.generator.service;

import com.chy.db.data.generator.mapper.TableMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.ArrayList;

/**
 * 表数据生成服务的抽象实现
 *
 * @author chy
 */
@Slf4j
public abstract class AbstractTableDataGenerateService<T> implements TableDataGenerateService<T> {

    /**
     * 默认的每批次插入记录数
     */
    private static final int DEFAULT_BATCH_SIZE = 1000;

    /**
     * 获取对应的 DAO 层实例
     *
     * @return TableMapper<T>
     */
    protected abstract TableMapper<T> getMapper();

    @Override
    public void batchInsertRecords(final int inertRecordCount) {
        batchInsertRecords(inertRecordCount, DEFAULT_BATCH_SIZE);
    }

    @Override
    public void batchInsertRecords(final int inertRecordCount, final int batchSize) {
        // 校验入参
        Assert.isTrue(inertRecordCount > 0, "待插入的记录总数量必须大于0");
        Assert.isTrue(batchSize > 0, "每批次插入的记录数必须大于0");

        // 已插入记录数
        int insertedRecordCount = 0;
        long startTime = System.currentTimeMillis();
        log.info("开始插入");

        while (insertedRecordCount < inertRecordCount) {
            try {
                // 计算当前批次要插入的记录数
                int curBatchSize = Math.min(batchSize, inertRecordCount - insertedRecordCount);

                // 生成待插入的数据列表
                ArrayList<T> records = new ArrayList<>(curBatchSize);
                for (int i = 0; i < curBatchSize; i++) {
                    records.add(this.generateRecord());
                }

                // 批量插入
                int curBatchInsertedCount = this.getMapper().batchInsert(records);
                insertedRecordCount += curBatchInsertedCount;
                log.info("当前批次预期插入 {} 条，实际插入 {} 条，总计插入 {} 条", curBatchSize, curBatchInsertedCount, insertedRecordCount);
            } catch (Exception e) {
                log.error("当前批次执行异常", e);
            }
        }

        long endTime = System.currentTimeMillis();
        log.info("插入完毕，共插入 {} 条记录，耗时 {} 秒", inertRecordCount, (endTime - startTime) / 1000);
    }

    @Override
    public void truncateTable() {
        this.getMapper().truncateTable();
        log.info("已清空表");
    }

}
