package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.support.EditDataParam;
import com.jit.emsystemapi.vo.param.support.GetSupportParam;

public interface SupportGradeService {
    Result getAllSupport(GetSupportParam getSupportParam);

    Result editAllNum(EditDataParam editDataParam);
}
