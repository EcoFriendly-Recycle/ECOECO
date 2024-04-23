package com.recycle.ecoeco.makerProject.model.dto;

import java.time.LocalDate;

public class ProjectDTO {

    private int projectNo;
    private String projectName;
    private String projectStatus;
    private String projectSorN;
    private String deliveryYN;
    private int serviceCharge;
    private int targetAmount;
    private LocalDate requestDate;
    private LocalDate approvalDate;
    private LocalDate petitionDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private long achievedAmount;
    private LocalDate dueDate;
    private String thumbnail;
    private int categoryCode;
    private CategoryDTO category;
    private int makerNo;
    private MakerDTO maker;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectNo, String projectName, String projectStatus, String projectSorN, String deliveryYN, int serviceCharge, int targetAmount, LocalDate requestDate, LocalDate approvalDate, LocalDate petitionDate, LocalDate startDate, LocalDate endDate, long achievedAmount, LocalDate dueDate, String thumbnail, int categoryCode, CategoryDTO category, int makerNo, MakerDTO maker) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.projectSorN = projectSorN;
        this.deliveryYN = deliveryYN;
        this.serviceCharge = serviceCharge;
        this.targetAmount = targetAmount;
        this.requestDate = requestDate;
        this.approvalDate = approvalDate;
        this.petitionDate = petitionDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.achievedAmount = achievedAmount;
        this.dueDate = dueDate;
        this.thumbnail = thumbnail;
        this.categoryCode = categoryCode;
        this.category = category;
        this.makerNo = makerNo;
        this.maker = maker;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectSorN() {
        return projectSorN;
    }

    public void setProjectSorN(String projectSorN) {
        this.projectSorN = projectSorN;
    }

    public String getDeliveryYN() {
        return deliveryYN;
    }

    public void setDeliveryYN(String deliveryYN) {
        this.deliveryYN = deliveryYN;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(int serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(int targetAmount) {
        this.targetAmount = targetAmount;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public LocalDate getPetitionDate() {
        return petitionDate;
    }

    public void setPetitionDate(LocalDate petitionDate) {
        this.petitionDate = petitionDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getAchievedAmount() {
        return achievedAmount;
    }

    public void setAchievedAmount(long achievedAmount) {
        this.achievedAmount = achievedAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public int getMakerNo() {
        return makerNo;
    }

    public void setMakerNo(int makerNo) {
        this.makerNo = makerNo;
    }

    public MakerDTO getMaker() {
        return maker;
    }

    public void setMaker(MakerDTO maker) {
        this.maker = maker;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", projectSorN='" + projectSorN + '\'' +
                ", deliveryYN='" + deliveryYN + '\'' +
                ", serviceCharge=" + serviceCharge +
                ", targetAmount=" + targetAmount +
                ", requestDate=" + requestDate +
                ", approvalDate=" + approvalDate +
                ", petitionDate=" + petitionDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", achievedAmount=" + achievedAmount +
                ", dueDate=" + dueDate +
                ", thumbnail='" + thumbnail + '\'' +
                ", categoryCode=" + categoryCode +
                ", category=" + category +
                ", makerNo=" + makerNo +
                ", maker=" + maker +
                '}';
    }
}
