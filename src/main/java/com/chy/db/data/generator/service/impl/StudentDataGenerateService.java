package com.chy.db.data.generator.service.impl;

import com.apifan.common.random.source.AreaSource;
import com.apifan.common.random.source.DateTimeSource;
import com.apifan.common.random.source.PersonInfoSource;
import com.chy.db.data.generator.entity.Student;
import com.chy.db.data.generator.mapper.StudentMapper;
import com.chy.db.data.generator.mapper.TableMapper;
import com.chy.db.data.generator.service.AbstractTableDataGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * 学生表数据生成服务实现
 *
 * @author chy
 */
@Slf4j
@Service
public class StudentDataGenerateService extends AbstractTableDataGenerateService<Student> {

    @Resource
    private StudentMapper studentMapper;

    @Override
    protected TableMapper<Student> getMapper() {
        return studentMapper;
    }

    @Override
    public Student generateRecord() {
        return Student.builder()
                .name(PersonInfoSource.getInstance().randomChineseName())
                .tel(PersonInfoSource.getInstance().randomChineseMobile())
                .address(AreaSource.getInstance().randomAddress())
                .birthday(DateTimeSource.getInstance().randomPastDate(LocalDate.of(2020, 1, 1), 365 * 20L))
                .build();
    }

}
