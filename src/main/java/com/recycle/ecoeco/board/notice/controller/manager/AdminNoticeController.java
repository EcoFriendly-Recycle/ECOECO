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

import java.util.*;

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
    @GetMapping("/adminNoticeList")
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
    @GetMapping("/adminNoticeDetail")
    public String getBoardDetail(@RequestParam int noticeNo, Model model){

        NoticeDTO noticeDetail = adminNoticeService.selectNoticeDetail(noticeNo);
        log.info("noticeDetail : {}", noticeDetail);
        model.addAttribute("noticeDetail", noticeDetail);

        System.out.println(noticeDetail);

        return "manager/board/adminNoticeDetail";
    }

    // 공지사항 작성 페이지
    @GetMapping("/write")
    public String getWriteBoard() {
        return "manager/board/adminNoticeWrite";
    }

    @PostMapping("/write")
    public String writeBoard(@ModelAttribute NoticeDTO notice,
                             @AuthenticationPrincipal UserInfoDTO user) {

//        /* 로그인 기능 구현 후 수정해야댐. 임시로 관리자 번호 때려넣음 */
//        UserInfoDTO userInfo = new UserInfoDTO();
//        userInfo.setUserNo(1);
//        notice.setWriter(userInfo);

        notice.setWriter(user);
        log.info("writeBoard notice : {}", notice);

        adminNoticeService.writeBoard(notice);

        return "redirect:/manager/board/adminNoticeList";
    }

    // 공지사항 삭제
    @PostMapping("/deleteNotice")
    public ResponseEntity<String> deleteNotice(@RequestBody NoticeDTO deleteNotice) {

        log.info("deleteNotice no : {}", deleteNotice.getNoticeNo());

        adminNoticeService.deleteNotice(deleteNotice);

        return ResponseEntity.ok("게시글 삭제 완료");
    }

    // 공지사항 수정 페이지 이동
    @GetMapping("/adminNoticeModify")
    public String showNoticeWriteModifyPage(@RequestParam int noticeNo, Model model) {

        // 1. 데이터 가져오기
        NoticeDTO noticeModify = adminNoticeService.noticeModify(noticeNo);

        log.info("noticeModify : {}", noticeModify);

        // 2. 모델 등록
        model.addAttribute("noticeNo", noticeNo);
        model.addAttribute("noticeModify", noticeModify);

        // 3. 페이지 출력
        return "manager/board/adminNoticeModify";
    }

    @PostMapping("/adminNoticeModify")
    public String updateNotice(@RequestParam int noticeNo, NoticeDTO notice) {
        notice.setNoticeNo(noticeNo);

        adminNoticeService.updateNotice(notice);

        return "redirect:/manager/board/adminNoticeDetail?noticeNo=" + noticeNo;
    }

//    @PostMapping("multi-file")
//    public String multiFileUpload(@RequestParam String multiFileDescription,
//                                  @RequestParam List<MultipartFile> multiFile,
//                                  Model model) {
//
//        System.out.println("multiFileDescription : " + multiFileDescription);
//        System.out.println("multiFile : " + multiFile);
//
//        String root = "src/main/resources/static";
//        String filePath = root + "/uploadFiles";
//
//        File dir = new File(filePath);
//        System.out.println(dir.getAbsolutePath());
//
//        if (!dir.exists()) dir.mkdirs();
//
//        List<NoticeImageDTO> files = new ArrayList<>();
//
//        /* 파일명 변경 처리 후 저장 : 다중 파일 반복문 처리 */
//        try {
//            for (MultipartFile file : multiFile) {
//                String noticeOriginFileName = file.getOriginalFilename();
//                String ext = noticeOriginFileName.substring(noticeOriginFileName.lastIndexOf("."));
//                String noticeSaveName = UUID.randomUUID() + ext;
//
//                /* 파일에 관한 정보 추출 후 보관 */
//                files.add(new NoticeImageDTO(noticeOriginFileName, noticeSaveName, filePath));
//
//                /* 파일 저장 */
//                file.transferTo(new File(filePath + "/" + noticeSaveName));
//            }
//            /* 서버의 정해진 경로로 파일 저장이 완료되면 List<FileDTO> 타입의 객체에 저장된 정보를 DB에 insert 한다. */
//            model.addAttribute("message", "파일 업로드 완료!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            /* 파일 저장 중간에 실패 시 이전에 저장 된 파일 삭제 */
//            for (NoticeImageDTO file : files) {
//                new File(filePath + "/" + file.getNoticeSaveName()).delete();
//            }
//            model.addAttribute("message", "파일 업로드 실패..");
//        }
//        return "result";
//    }
}
