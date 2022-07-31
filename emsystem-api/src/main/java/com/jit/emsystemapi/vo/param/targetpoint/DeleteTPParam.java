package com.jit.emsystemapi.vo.param.targetpoint;

import lombok.Data;

import java.util.List;

@Data
public class DeleteTPParam {

    private String userId;

    private List<String> pointArray;
}
