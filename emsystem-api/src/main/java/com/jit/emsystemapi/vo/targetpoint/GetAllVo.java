package com.jit.emsystemapi.vo.targetpoint;

import lombok.Data;

@Data
public class GetAllVo {
    private String userId;

    private String yearId;

    private String majorName;

    private String uid;

    private String graduationNo;

    private String pointNo;

    private String pointId;

    private String pointContent;

    public GetAllVo(String userId,Integer gradeId, String majorName, String uid, String graduationNo, String tpNo, Integer tpId, String content) {
        this.userId = userId;
        this.yearId = String.valueOf(gradeId);
        this.majorName = majorName;
        this.uid = uid;
        this.graduationNo = graduationNo;
        this.pointNo = tpNo;
        this.pointId = String.valueOf(tpId);
        this.pointContent = content;
    }
}
