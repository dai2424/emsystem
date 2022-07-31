package com.jit.emsystemapi.vo.param.graduation;

import lombok.Data;

import java.util.List;

@Data
public class DeleteNoParam {
    private String userId;

    private List<String> reqArray;
}
