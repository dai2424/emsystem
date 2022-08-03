package com.jit.emsystemapi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private Object data;

    private Meta meta;

    public static Result success(Object data, String msg) {
        return new Result(data, new Meta(200, msg));
    }

    public static Result fail(int status, String msg) {
        return new Result(null, new Meta(status, msg));
    }
}