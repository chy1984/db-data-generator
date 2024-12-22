package com.chy.db.data.generator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表对应的实体类
 *
 * @author chy
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 490327631370074387L;

    private Long id;

    private String username;

    private String tel;

    private String email;

    private String address;

    private Date birthday;

    private Date createTime;

    private Date updateTime;

}
