package com.recycle.ecoeco.makerProject.model.dto;

import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MakerDTO {
    private int makerNo;
    private String makerName;
    private String prImage;
    private String email;
    private String phone;
    private int userNo;
    private int projectNo;

    private UserInfoDTO user;
    private ProjectDTO project;
    public MakerDTO() {
    }

    public MakerDTO(int makerNo, String makerName, String prImage, String email, String phone, int userNo) {
        this.makerNo = makerNo;
        this.makerName = makerName;
        this.prImage = prImage;
        this.email = email;
        this.phone = phone;
        this.userNo = userNo;
    }

    public int getMakerNo() {
        return makerNo;
    }

    public void setMakerNo(int makerNo) {
        this.makerNo = makerNo;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getPrImage() {
        return prImage;
    }

    public void setPrImage(String prImage) {
        this.prImage = prImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    @Override
    public String toString() {
        return "MakerDTO{" +
                "makerNo=" + makerNo +
                ", makerName='" + makerName + '\'' +
                ", primage='" + prImage + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userNo=" + userNo +
                '}';
    }
}
