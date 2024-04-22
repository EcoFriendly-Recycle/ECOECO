package com.recycle.ecoeco.makerProject.model.dto;

public class MakerDTO {
    private int makerNo;
    private String makerName;
    private String primage;
    private String email;
    private String phone;
    private int userNo;

    public MakerDTO() {
    }

    public MakerDTO(int makerNo, String makerName, String primage, String email, String phone, int userNo) {
        this.makerNo = makerNo;
        this.makerName = makerName;
        this.primage = primage;
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

    public String getPrimage() {
        return primage;
    }

    public void setPrimage(String primage) {
        this.primage = primage;
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
                ", primage='" + primage + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userNo=" + userNo +
                '}';
    }
}
