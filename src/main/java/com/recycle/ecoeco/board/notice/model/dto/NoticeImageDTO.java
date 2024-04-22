package com.recycle.ecoeco.board.notice.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class NoticeImageDTO {

    private int noticeImgNo;
    private String noticeOriginFileName;
    private String noticeSaveName;
    private String noticePath;
    private int noticeNo;
}
