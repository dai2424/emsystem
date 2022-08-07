package com.jit.emsystemapi.controller;

import com.jit.emsystemapi.service.ClassCourseAchieveService;
import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.achievement.GetScoreRecordedParam;
import com.jit.emsystemapi.vo.param.achievement.GetTeacherScoreRecordedParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //解决跨域
@RestController
@RequestMapping
public class AchievementController {
    @Autowired
    private ClassCourseAchieveService classCourseAchieveService;

    @PostMapping("getScoreRecorded")
    public Result getScoreRecorded(@RequestBody GetScoreRecordedParam getScoreRecordedParam) {
        return classCourseAchieveService.getScoreRecorded(getScoreRecordedParam);
    }

    @PostMapping("getTeacherScoreRecorded")
    public Result getTeacherScoreRecorded(@RequestBody GetTeacherScoreRecordedParam getTeacherScoreRecordedParam) {
        return classCourseAchieveService.getTeacherScoreRecorded(getTeacherScoreRecordedParam);
    }

}
