package com.jit.emsystemapi.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TargetPoint {

    private Integer userId;

    private Integer uid;

    @TableId(type = IdType.AUTO)
    private Integer tpId;

    private String tpNo;

    private String content;
}
