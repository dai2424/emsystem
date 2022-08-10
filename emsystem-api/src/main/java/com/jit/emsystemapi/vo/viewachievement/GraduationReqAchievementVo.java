package com.jit.emsystemapi.vo.viewachievement;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GraduationReqAchievementVo {
    private String Achievement;

    private String No;

    private String Content;

    private List<TargetPointAchievementVo> children;

    public GraduationReqAchievementVo(String grAchievement, String no, String content) {
        this.Achievement = grAchievement;
        this.No = no;
        this.Content = content;
        this.children = new ArrayList<>();
    }
}
