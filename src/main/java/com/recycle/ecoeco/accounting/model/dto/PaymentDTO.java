package com.recycle.ecoeco.accounting.model.dto;

import com.recycle.ecoeco.makerProject.model.dto.ProjectDTO;
import com.recycle.ecoeco.makerProject.model.dto.RewardDTO;
import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PaymentDTO implements java.io.Serializable{
    private int paymentNo;
    private int paymentPrice;
    private LocalDateTime paymentDate;
    private String apiPayNo;
    private int projectNo;
    private int orderNo;
    private int rewardNo;
    private int userNo;

    private ProjectDTO project;     // 프로젝트 DTO -> 프로젝트명
    private OrderDTO order;
    private RewardDTO reward;
    private UserInfoDTO orderer;
}
