package com.jit.emsystemapi.service;

import com.jit.emsystemapi.vo.Result;
import com.jit.emsystemapi.vo.param.teachar.*;

public interface TeacherService {
    Result addTeacher(AddTeacherParam addTeacherParam);

    Result editTeacher(EditTeacherParam editTeacherParam);

    Result deleteTeacher(DeleteTeacherParam deleteTeacherParam);

    Result getAllTeacher(GetAllTeacher getAllTeacher);

    Result editStatus(EditStatusParam editStatusParam);
}
