package com.grepp.boot.controller;


import com.grepp.boot.model.dto.BoardDTO;
import com.grepp.boot.model.dto.FileDTO;
import com.grepp.boot.model.service.BoardService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(name = "page", defaultValue = "1")int page) throws SQLException {
        ModelAndView mav = new ModelAndView("list"); // /WEB-INF/views/list.jsp
        System.out.println(boardService.getBoards(page));
        mav.addObject("pageData", boardService.getBoards(page)); // 현재 페이지를 기준으로 하단의 페이지 링크 정보와 보여질 게시글 목록 데이터까지 다 담아뒀음.
        return mav;
    }

    @GetMapping("/write")
    public String write(){ // 로그인 안된 사용자는 글쓰기 못하게 하고 싶음.
        return "write_form";
    }

    @PostMapping(value="/write")//, headers = ("content-type=multipart/*"))
    public ModelAndView write(BoardDTO board, HttpSession session, @RequestParam(value="uploadFile", required = false) MultipartFile[] uploadFile) throws SQLException, IOException {// 로그인 안된 사용자는 글쓰기 못하게 하고 싶음.

        // 첨부파일 저장 이전에 일단 게시글부터 작성완료 되어야 하고.
        board.setWriter((String) session.getAttribute("loginId"));

        System.out.println("작성 직전 : "+board); // 글번호 no = 0
        int result = boardService.write(board);
        System.out.println("글 작성 결과 : "+result); // 결과는 insert 된 갯수 = 1
        System.out.println("방금 작성한 글 : "+board); // 글번호 no = 237

//        try {
            List<FileDTO> savedFiles = saveFiles(uploadFile); // C://programmers_upload/ 폴더에 해당 파일들 저장시키고 저장정보 얻어오기
            System.out.println("파일 저장 완료 : "+savedFiles);
            System.out.println("파일 정보 디비에 기록 완료 : "+boardService.saveFileInfos(savedFiles, board.getNo()));
//        }catch (IOException ex){
//            System.out.println("파일 저장 실패");
//            mav.addObject("msg", "write fail. 관리자에게 문의바람.");
//            mav.setViewName("error");
//            ex.printStackTrace();
//        }
        ModelAndView mav = new ModelAndView("alert"); // /WEB-INF/views/list.jsp
        mav.addObject("msg", "write success");
        mav.addObject("path", "list");

        return mav;
    }

    // 객체지향 설계 레이어 상. 파일처리 까지 컨트롤러에 구현된 모습이 아름답지는 않아요.. 유틸리티 클래스로 분리시키는게 좀 더 적합하겠네요ㅠㅠ;; ㅎㅎ
    private List<FileDTO> saveFiles(MultipartFile[] uploadFile) throws IOException {
        List<FileDTO> fileDTOList = new ArrayList<>();
        if(uploadFile != null && uploadFile.length>0){ // 첨부된 파일이 확실히 있는 경우 저장절차 진행.
            String uploadPath = "c:/programmers_upload/";
            if(new File(uploadPath).exists() == false)
                new File(uploadPath).mkdir(); // 해당 폴더가 없으면 생성해라.

            for(MultipartFile f: uploadFile){
                String savedName = new Random().nextInt(1000000000)+""; // 확률상 10억범위 랜덤이면 설마 안겹치겠지 ;; 여러분은 FileNamePolicy 검색해서 쓰세요!!
                File savedFile = new File(uploadPath+savedName); // c:/programmers_upload/184546223 이런 식으로 파일 생성

                f.transferTo(savedFile); // 클라이언트가 업로드한 파일을 서버 컴퓨터 폴더에 비어있는 c:/programmers_upload/184546223 파일에 저장시키는 메소드!
                FileDTO saveFileInfo = new FileDTO();
                saveFileInfo.setSavedPath(uploadPath+savedName); // 서버에 저장된 파일 경로+이름
                saveFileInfo.setOriginalName(f.getOriginalFilename()); // 나중에 다운로드 하거나 할때는 원래 koala.jpg 이랬던 이름으로 보여줘야 함!

                fileDTOList.add(saveFileInfo);
            }
        }
        return fileDTOList;
    }

    @GetMapping("/read")
    public ModelAndView read(@RequestParam("no") int no) throws SQLException {// 로그인 안된 사용자는 글읽기 못하게 하고 싶음.
        ModelAndView mav = new ModelAndView("view");
        mav.addObject("bbb",boardService.read(no));
        return mav;
    }

    @GetMapping("/download")
    public void download(@RequestParam("fno")int fno, HttpServletResponse response) throws IOException {
        FileDTO fileDTO = boardService.getFileInfo(fno); // originalFile, savedPath 정보 조회함.

        String fileName = new String(fileDTO.getOriginalName().getBytes("UTF-8"), "ISO-8859-1");

        // response는 기본적으로 html을 응답하는 헤더가 설정되어 있음.
        // 하지만, 지금은 html을 응답하는게 아니라 파일 그 자체를 전송할거임. 응답 객체의 헤더정보를 파일전송 버전으로 변경하자!
        response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\""); // filename="right.png"
        response.setHeader("Content-Transfer-Encoding", "binary");

        FileInputStream fis = new FileInputStream(fileDTO.getSavedPath());
        OutputStream os = response.getOutputStream(); // response로 응답하는 스트림(문자열 단위 아니고 바이트 단위로 보내게 됨.)
        FileCopyUtils.copy(fis, os);
    }
}
