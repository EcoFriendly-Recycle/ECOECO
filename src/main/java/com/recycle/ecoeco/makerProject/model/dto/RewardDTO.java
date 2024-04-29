package com.recycle.ecoeco.makerProject.model.dto;

public class RewardDTO{
    private int rewardNo;//리워드 번호
    private String rewardName;
    private int rewardSum; //리워드 금액
    private String rewardInfo; //리워드 설명
    private int projectNo; //프로젝트 번호
    ProjectDTO projectDTO;

    public RewardDTO(){

    }

    public RewardDTO(int rewardNo, String rewardName, int rewardSum, String rewardInfo, int projectNo, ProjectDTO projectDTO) {
        this.rewardNo = rewardNo;
        this.rewardName = rewardName;
        this.rewardSum = rewardSum;
        this.rewardInfo = rewardInfo;
        this.projectNo = projectNo;
        this.projectDTO = projectDTO;
    }

    public int getRewardNo() {
        return rewardNo;
    }

    public void setRewardNo(int rewardNo) {
        this.rewardNo = rewardNo;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public int getRewardSum() {
        return rewardSum;
    }

    public void setRewardSum(int rewardSum) {
        this.rewardSum = rewardSum;
    }

    public String getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(String rewardInfo) {
        this.rewardInfo = rewardInfo;
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
        return "RewardDTO{" +
                "rewardNo=" + rewardNo +
                ", rewardName='" + rewardName + '\'' +
                ", rewardSum=" + rewardSum +
                ", rewardInfo='" + rewardInfo + '\'' +
                ", projectNo=" + projectNo +
                ", projectDTO=" + projectDTO +
                '}';
    }
}
