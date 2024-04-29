package com.recycle.ecoeco.makerProject.model.dto;

public class MakerDTO{
    private int makerNo;
    private String makerName;
    private String email;
    private String phone;

    private int projectNo;
    ProjectDTO projectDTO;

//    private String prImage;
    public MakerDTO(){

    }

    public MakerDTO(String makerName){
        this.makerName = makerName;
    }

    public MakerDTO(int makerNo, String makerName, String email, String phone, int projectNo, ProjectDTO projectDTO) {
        this.makerNo = makerNo;
        this.makerName = makerName;
        this.email = email;
        this.phone = phone;
        this.projectNo = projectNo;
        this.projectDTO = projectDTO;
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

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    @Override
    public String toString() {
        return "MakerDTO{" +
                "makerNo=" + makerNo +
                ", makerName='" + makerName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", projectNo=" + projectNo +
                ", projectDTO=" + projectDTO +
                '}';
    }
}
