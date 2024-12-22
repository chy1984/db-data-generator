package com.chy.db.data.generator.service.impl;

import com.apifan.common.random.source.AreaSource;
import com.apifan.common.random.source.DateTimeSource;
import com.apifan.common.random.source.InternetSource;
import com.apifan.common.random.source.PersonInfoSource;
import com.chy.db.data.generator.entity.User;
import com.chy.db.data.generator.mapper.TableMapper;
import com.chy.db.data.generator.mapper.UserMapper;
import com.chy.db.data.generator.service.AbstractTableDataGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * 用户表数据生成服务实现
 *
 * @author chy
 */
@Slf4j
@Service
public class UserDataGenerateService extends AbstractTableDataGenerateService<User> {

    @Resource
    private UserMapper userMapper;

    @Override
    protected TableMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public User generateRecord() {
        return User.builder()
                .username(PersonInfoSource.getInstance().randomChineseNickName(15))
                .tel(PersonInfoSource.getInstance().randomChineseMobile())
                .email(InternetSource.getInstance().randomEmail(20))
                .address(AreaSource.getInstance().randomAddress())
                .birthday(DateTimeSource.getInstance().randomPastDate(LocalDate.of(2010, 1, 1), 365 * 30L))
                .build();
    }

}
