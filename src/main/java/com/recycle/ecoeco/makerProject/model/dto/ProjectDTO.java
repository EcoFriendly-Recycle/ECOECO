package com.recycle.ecoeco.makerProject.model.dto;

import java.sql.Date;



public class ProjectDTO {

    /* 사용자+관리자 */
    private int projectNo;
    private int categoryCode;
    private int projectStatus;
    private Date startDate;
    private Date endDate;
    private char deliveryYN; //배송여부
    private int targetAmount;//목표금액
    private String projectName;
    private String thumbnail;
    private int serviceCharge; //서비스 요금(수수료, 수정해야함);



    /*관리자*/
    private char projectSorN; //프로젝트 성공여부
    private int achievedAmount; //달성액
    private Date requestDate; //요청일
    private Date approvalDate; //승인일
    private Date petitionDate; //반려일
    private Date dueDate; //마감일

    public ProjectDTO() {

    }

    public ProjectDTO(int serviceCharge, int projectNo, int categoryCode, int projectStatus, Date startDate, Date endDate, char deliveryYN, int targetAmount, String projectName, String thumbnail, char projectSorN, int achievedAmount, Date requestDate, Date approvalDate, Date petitionDate, Date dueDate) {
        this.projectNo = projectNo;
        this.categoryCode = categoryCode;
        this.projectStatus = projectStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deliveryYN = deliveryYN;
        this.targetAmount = targetAmount;
        this.projectName = projectName;
        this.thumbnail = thumbnail;
        this.projectSorN = projectSorN;
        this.achievedAmount = achievedAmount;
        this.requestDate = requestDate;
        this.approvalDate = approvalDate;
        this.petitionDate = petitionDate;
        this.dueDate = dueDate;
        this.serviceCharge = serviceCharge;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(int serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public char getDeliveryYN() {
        return deliveryYN;
    }

    public void setDeliveryYN(char deliveryYN) {
        this.deliveryYN = deliveryYN;
    }

    public int getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(int targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public char getProjectSorN() {
        return projectSorN;
    }

    public void setProjectSorN(char projectSorN) {
        this.projectSorN = projectSorN;
    }

    public int getAchievedAmount() {
        return achievedAmount;
    }

    public void setAchievedAmount(int achievedAmount) {
        this.achievedAmount = achievedAmount;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getPetitionDate() {
        return petitionDate;
    }

    public void setPetitionDate(Date petitionDate) {
        this.petitionDate = petitionDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", categoryCode=" + categoryCode +
                ", projectStatus=" + projectStatus +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", deliveryYN=" + deliveryYN +
                ", targetAmount=" + targetAmount +
                ", projectName='" + projectName + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", projectSorN=" + projectSorN +
                ", achievedAmount=" + achievedAmount +
                ", requestDate=" + requestDate +
                ", approvalDate=" + approvalDate +
                ", petitionDate=" + petitionDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
