package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.matrix.AssignCourseParam;
import com.jit.emsystemapi.vo.param.matrix.DeleteAssignCourseParam;
import com.jit.emsystemapi.vo.param.matrix.EditAssignCourseParam;
import com.jit.emsystemapi.vo.param.matrix.GetAllCourseParam;

public interface SupportMatrixService {
    Result assignCourse(AssignCourseParam assignCourseParam);

    Result editAssignCourse(EditAssignCourseParam editAssignCourseParam);

    Result deleteAssignCourse(DeleteAssignCourseParam deleteAssignCourseParam);

    Result getAllCourse(GetAllCourseParam getAllCourseParam);
}
