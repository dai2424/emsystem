package com.jit.emsystemapi.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class GradeMajor {
    private Integer userId;

    @TableId(type = IdType.AUTO)
    private Integer majorId;

    private Integer gradeId;

    private String majorName;
}
