package com.chy.db.data.generator.service;

import com.chy.db.data.generator.ApplicationTests;
import com.chy.db.data.generator.service.impl.StudentDataGenerateService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * StudentDataGenerateService 单元测试
 *
 * @author chy
 */
public class StudentDataGenerateServiceTest extends ApplicationTests {

    @Resource
    private StudentDataGenerateService studentDataGenerateService;

    @Test
    public void testGenerateTableData() {
        // 清空表
        studentDataGenerateService.truncateTable();
        // 插入记录
        studentDataGenerateService.batchInsertRecords(1000000);
    }

}
