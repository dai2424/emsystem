package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.achievement.GetScoreRecordedParam;
import com.jit.emsystemapi.vo.param.achievement.GetTeacherScoreRecordedParam;

public interface ClassCourseAchieveService {
    Result getScoreRecorded(GetScoreRecordedParam getScoreRecordedParam);

    Result getTeacherScoreRecorded(GetTeacherScoreRecordedParam getTeacherScoreRecordedParam);
}
