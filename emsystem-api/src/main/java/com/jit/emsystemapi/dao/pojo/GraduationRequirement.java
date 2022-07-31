package com.jit.emsystemapi.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class GraduationRequirement {
    private Integer userId;

    private Integer gradeId;

    private Integer majorId;

    @TableId(type = IdType.AUTO)
    private Integer uid;

    private String no;

    private String content;
}
