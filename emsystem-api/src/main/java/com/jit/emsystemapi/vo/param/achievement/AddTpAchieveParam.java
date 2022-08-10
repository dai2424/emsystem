package com.jit.emsystemapi.vo.param.achievement;

import lombok.Data;

import java.util.List;

@Data
public class AddTpAchieveParam {
    private String userId;

    private String classId;

    private String courseNo;

    private List<TpAchieve> tpAchieves;
}
