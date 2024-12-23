package com.chy.db.data.generator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生表对应的实体类
 *
 * @author chy
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = -6345368530170632920L;

    private Long id;

    private String name;

    private String tel;

    private String address;

    private Date birthday;

    private Date createTime;

    private Date updateTime;

}
