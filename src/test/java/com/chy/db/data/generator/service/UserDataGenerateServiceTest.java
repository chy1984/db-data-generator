package com.chy.db.data.generator.service;

import com.chy.db.data.generator.ApplicationTests;
import com.chy.db.data.generator.service.impl.UserDataGenerateService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * UserDataGenerateService 单元测试
 *
 * @author chy
 */
public class UserDataGenerateServiceTest extends ApplicationTests {

    @Resource
    private UserDataGenerateService userDataGenerateService;

    @Test
    public void testGenerateTableData() {
        // 清空表
        userDataGenerateService.truncateTable();
        // 插入记录
        userDataGenerateService.batchInsertRecords(1000000);
    }

}
