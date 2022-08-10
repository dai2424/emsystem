package com.jit.emsystemapi.vo.targetpoint;

import lombok.Data;

@Data
public class TpVo {
    private String tpId;

    private String tpNo;

    public TpVo(String tpId, String tpNo) {
        this.tpId = tpId;
        this.tpNo = tpNo;
    }
}
