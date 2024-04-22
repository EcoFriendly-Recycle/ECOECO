package com.recycle.ecoeco.board.notice.controller.manager;


import com.recycle.ecoeco.board.notice.model.dto.NoticeDTO;
import com.recycle.ecoeco.board.notice.service.manager.AdminNoticeService;
import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/manager/board")
public class AdminNoticeController {

    private final AdminNoticeService adminNoticeService;

    @Autowired
    public AdminNoticeController(AdminNoticeService adminNoticeService) {
        this.adminNoticeService = adminNoticeService;
    }

    // 공지사항 리스트 페이지
    @GetMapping("/noticeList")
    public void checkedBoard(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(required = false) String searchCondition,
                             @RequestParam(required = false) String searchValue,
                             @RequestParam(required = false) String searchConditionDate,
                             Model model) {

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("searchConditionDate", searchConditionDate);

        Map<String, Object> noticeListAndPaging = adminNoticeService.selectNoticeList(searchMap, page);
        model.addAttribute("paging", noticeListAndPaging.get("paging"));
        model.addAttribute("noticeList", noticeListAndPaging.get("noticeList"));
//        List<NoticeDTO> noticeList = noticeService.selectNoticeList();
//        model.addAttribute("noticeList", noticeList);
    }

    // 공지사항 상세보기
    @GetMapping("/noticeDetail")
    public String getBoardDetail(@RequestParam int noticeNo, Model model){

        NoticeDTO noticeDetail = adminNoticeService.selectNoticeDetail(noticeNo);
        log.info("noticeDetail : {}", noticeDetail);
        model.addAttribute("noticeDetail", noticeDetail);

        System.out.println(noticeDetail);

        return "manager/board/noticeDetail";
    }

    // 공지사항 작성 페이지
    @GetMapping("/write")
    public String getWriteBoard() {
        return "manager/board/noticeWrite";
    }

    @PostMapping("/write")
    public String writeBoard(@ModelAttribute NoticeDTO notice,
                             @AuthenticationPrincipal UserInfoDTO user) {

        /* 로그인 기능 구현 후 수정해야댐. 임시로 관리자 번호 때려넣음 */
        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setUserNo(1);
        notice.setWriter(userInfo);

        //notice.setWriter(user);
        log.info("writeBoard notice : {}", notice);

        adminNoticeService.writeBoard(notice);

        return "redirect:/manager/board/noticeList";
    }

    // 공지사항 삭제
    @PostMapping("/deleteNotice")
    public ResponseEntity<String> deleteNotice(@RequestBody NoticeDTO deleteNotice) {

        log.info("deleteNotice no : {}", deleteNotice.getNoticeNo());

        adminNoticeService.deleteNotice(deleteNotice);

        return ResponseEntity.ok("게시글 삭제 완료");
    }
}
