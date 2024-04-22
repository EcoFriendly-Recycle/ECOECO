package com.recycle.ecoeco.accounting.model.dto;

import com.recycle.ecoeco.makerProject.model.dto.ProjectDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class RefundDTO {
    private int refundNo;
    private int accountnum;
    private LocalDateTime refundRequestDate;
    private LocalDateTime refundDate;
    private String refundStatus;
    private int paymentNo;

    private PaymentDTO payment;
    private ProjectDTO project;

}
