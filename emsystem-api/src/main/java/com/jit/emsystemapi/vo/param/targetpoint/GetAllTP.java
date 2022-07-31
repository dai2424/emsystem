package com.jit.emsystemapi.vo.param.targetpoint;

import lombok.Data;

@Data
public class GetAllTP {
    private String userId;

    private String yearId;

    private String majorName;

    private String graduationNo;

    private String pointNo;

    private String pointContent;
}
