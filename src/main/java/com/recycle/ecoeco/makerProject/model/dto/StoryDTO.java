package com.recycle.ecoeco.makerProject.model.dto;

public class StoryDTO {
    private int storyNo;
    private String storySummary;
    private String storyImg;
    private String storyInfo;
    private int projectNo;

    public StoryDTO() {
    }

    public StoryDTO(int storyNo, String storySummary, String storyImg, String storyInfo, int projectNo) {
        this.storyNo = storyNo;
        this.storySummary = storySummary;
        this.storyImg = storyImg;
        this.storyInfo = storyInfo;
        this.projectNo = projectNo;
    }

    public int getStoryNo() {
        return storyNo;
    }

    public void setStoryNo(int storyNo) {
        this.storyNo = storyNo;
    }

    public String getStorySummary() {
        return storySummary;
    }

    public void setStorySummary(String storySummary) {
        this.storySummary = storySummary;
    }

    public String getStoryImg() {
        return storyImg;
    }

    public void setStoryImg(String storyImg) {
        this.storyImg = storyImg;
    }

    public String getStoryInfo() {
        return storyInfo;
    }

    public void setStoryInfo(String storyInfo) {
        this.storyInfo = storyInfo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "StoryDTO{" +
                "storyNo=" + storyNo +
                ", storySummary='" + storySummary + '\'' +
                ", storyImg='" + storyImg + '\'' +
                ", storyInfo='" + storyInfo + '\'' +
                ", projectNo=" + projectNo +
                '}';
    }
}
