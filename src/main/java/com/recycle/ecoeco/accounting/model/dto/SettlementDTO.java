package com.recycle.ecoeco.accounting.model.dto;

import com.recycle.ecoeco.makerProject.model.dto.MakerDTO;
import com.recycle.ecoeco.makerProject.model.dto.ProjectDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class SettlementDTO implements java.io.Serializable{

    private int settlementNo;
    private char settlementStatus;
    private int settlementPrice;
    private LocalDateTime settlementDate;
    private int makerNo;
    private int projectNo;

    private MakerDTO maker;
    private ProjectDTO project;

    private double achievementRate; // 새로운 필드 추가

}
