package com.jit.emsystemapi.vo.param.GMC;

import lombok.Data;

import java.util.List;

@Data
public class DeleteClassParam {
    private String userId;

    private List<String> classArray;
}
