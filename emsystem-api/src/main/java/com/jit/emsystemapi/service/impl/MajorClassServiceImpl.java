package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.ClassMapper;
import com.jit.emsystemapi.service.MajorClassService;
import com.jit.emsystemapi.vo.MajorClassVo;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.MajorClassParam;
import com.jit.emsystemapi.vo.tableDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorClassServiceImpl implements MajorClassService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public Result getAllMajorClass(MajorClassParam majorClassParam) {

        String gradeId = majorClassParam.getYearSearch();

        String majorName = majorClassParam.getMajorSearch();

        String classId = majorClassParam.getClassSearch();

        List<MajorClassVo> majorClassVos = classMapper.selectAllMajorClass(gradeId, majorName, classId);
        
        return Result.success(new tableDataVo(majorClassVos),"获取成功");
    }

}
