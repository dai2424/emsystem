package com.jit.emsystemapi.vo.viewachievement;

import lombok.Data;

@Data
public class TargetPointAchievementVo {
    private String Achievement;

    private String No;

    private String Content;

    public TargetPointAchievementVo(Integer achievement, String tpNo, String content) {
        this.Achievement = String.valueOf(achievement);
        this.No = tpNo;
        this.Content = content;
    }
}
