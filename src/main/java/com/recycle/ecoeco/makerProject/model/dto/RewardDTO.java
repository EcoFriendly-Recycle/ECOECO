package com.recycle.ecoeco.makerProject.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RewardDTO {
    private int rewardNo;
    private String rewardName;
    private int rewardSum;          //리워드 금액
    private String rewardInfo;      //리워드 설명
    private int projectNo;          // 프로젝트 번호
    private ProjectDTO project;     // 프로젝트  정보
}
