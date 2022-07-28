package com.jit.emsystemapi.service.impl;

import com.jit.emsystemapi.dao.mapper.TargetSupportMapper;
import com.jit.emsystemapi.service.SupportGradeService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.support.EditDataParam;
import com.jit.emsystemapi.vo.param.support.GetSupportParam;
import com.jit.emsystemapi.vo.support.SupportGradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupportGradeServiceImpl implements SupportGradeService {

    private static String[] typeEncodings = {"支撑数", "达成度", "评价等级", "学生评分占比"};

    @Autowired
    private TargetSupportMapper targetSupportMapper;

    @Override
    public Result getAllSupport(GetSupportParam getSupportParam) {
        String  userId = getSupportParam.getUserId();

        List<SupportGradeVo> supportGradeVos = targetSupportMapper.findByUserId(userId);

        if (supportGradeVos.isEmpty()) {
            for (String typeEncoding : typeEncodings) {
                supportGradeVos.add(new SupportGradeVo(typeEncoding));
                targetSupportMapper.addDataByUserId(userId, typeEncoding);
            }
        }
        return Result.success(supportGradeVos,"获取成功");
    }

    @Override
    public Result editAllNum(EditDataParam editDataParam) {
        String userId = editDataParam.getUserId();
        String typeEncoding = editDataParam.getTypeEncoding();
        String gradeNum = editDataParam.getGradeNum();

        Integer updateCnt = targetSupportMapper.updateGradeNum(userId, typeEncoding, gradeNum);

        if(updateCnt > 0)
            return Result.success(null,"更新成功");
        else
            return Result.success(null, "更新失败");
    }
}
