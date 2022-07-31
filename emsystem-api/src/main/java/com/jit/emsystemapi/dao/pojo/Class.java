package com.jit.emsystemapi.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Class {
    private Integer userId;

    @TableId(type = IdType.AUTO)
    private Integer classId;

    private Integer majorId;

    private String className;
}
