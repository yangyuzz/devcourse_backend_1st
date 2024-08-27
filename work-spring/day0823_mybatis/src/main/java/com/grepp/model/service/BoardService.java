package com.grepp.model.service;

import com.grepp.model.dto.BoardDTO;
import com.grepp.model.dto.FileDTO;
import com.grepp.model.repository.BoardRepository;
import com.grepp.model.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// SQL 실행은 Repo가 담당하고 나는 뭘 검사하고 판단하고 조작해내는 비즈니스 로직에 대한 책임만 구현함.
//@Component
@Service
public class BoardService {
    private static final int COUNT_PER_PAGE=10; // 한 페이지당 보여줄 글의 갯수
    @Autowired
    private BoardRepository repo;//= BoardRepositoryMysql.getInstance();

    @Autowired
    private FileRepository fileRepo;

//    private BoardService(){}
//    private static BoardService instance = new BoardService();
//    public static BoardService getInstance() {
//        return instance;
//    }
  ///////////////////////////////////////////////////////////////////////////////
    // 글 읽기 수행할 때 작성자와 읽는 사용자가 일치하는지 검사해서 조회수 증가 update 여부를 판단하거나
    // 이미 이 글을 읽은 사용자는 조회수가 중복해서 증가하지 않도록 검사하거나
//  public BoardDTO read(int bno, String loginId) throws SQLException {
//      BoardDTO board = repo.selectOne(bno);
//      if (!board.getWriter().equals(loginId)){ // 작성자와 현재 로그인 아이디가 일치하지 않을 때만 조회수 증가시키기.
//          repo.updateReadCount(bno);
//      }
//      return board;
//  }
    // 위에처럼 로직을 수행하는 메소드. 지금은 처리하지 않았음.
    public BoardDTO read(int bno) throws SQLException {
        BoardDTO boardDTO = repo.selectOne(bno); // board_tb에서 조회
//        boardDTO.setFileDTOList(fileRepo.selectFiles(bno)); // file_tb에서 조회
        return boardDTO;
    }

    @Transactional
    public int write(BoardDTO board) throws SQLException {
        return repo.insert(board);
    }

//    public List<BoardDTO> getBoards() throws SQLException {
//        return repo.selectAll();
//    }

    // 현재 보고자 하는 페이지 정보가 들어왔을 때, 실제 해당 페이지에 보여져야 하는 List<BoardDTO>를 포함해서 페이지가 총 몇개 필요하고, 하단 페이지 링크는 1~10 or 11~20 같은 페이지 구간 계산
    @Transactional
    public Map<String, Object> getBoards(int page){
        int totalCount = repo.selectCount(); // 총 게시글의 갯수(ex : 27)
        int totalPageCount = totalCount / COUNT_PER_PAGE; // (ex : 27/10 = 2.7 = 2page 일단 필요하고)
        if(totalCount%COUNT_PER_PAGE>0){ // 10개씩 2페이지 하고 7개의 글이 남은 상태라 페이지 하나 늘려주기.
            totalPageCount++; // 총 페이지는 3개
        }

        int startPage = (page-1)/10 * 10 +1; // 현재 페이지가 11,12,13,...,20 이었을 때 -1 해서 10~19로 바꾸고. /10*10 하면 11,12,..,19 다 동일하게 10으로 통일됨.
        int endPage = startPage+9; // 보통 화면 하단 시작페이지가 11이면 끝은 20, 21이면 30에서 끝나던데?
        if(totalPageCount < endPage){ // 21~30이라고 계산했는데 총 페이지수가 28밖에 없었다? 페이지 너무 많다고 뻥치고 있네?
            endPage = totalPageCount; // 마지막 페이지 링크를 총 페이지수로 줄여줍시다.
        }

        int startRow = (page-1) * COUNT_PER_PAGE; // 한 페이지당 보여질 글의 갯수 반영해서 db에 모든 글을 다 읽어오지 않고 여기부터 끊어서 읽으라고 알려줄 수 있음.
        List<BoardDTO> boardList = repo.selectList(startRow, COUNT_PER_PAGE);
        /////////////////// Service는 이렇게 여러가지 비즈니스 로직을 수행해서 데이터를 계산해냄. 계산한 데이터들을 싹 한군데에 모아서 주기.
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("page", page);
        resultData.put("startPage", startPage);
        resultData.put("endPage", endPage);
        resultData.put("totalPageCount", totalPageCount);
        resultData.put("bList", boardList);
        return resultData;
    }

    public int saveFileInfos(List<FileDTO> fileDTOList, int bno){ // 작성된 글 하나에 파일이 여러개 첨부될 수 있음.
        if(fileDTOList == null || fileDTOList.isEmpty()) return 0;

        for(FileDTO f: fileDTOList){ // 파일이름originalName, 저장된경로savedPath만 설정되어 있으니까 게시글 번호 붙여서 insert 시켜야 됨!
            f.setBno(bno);
        }
        return fileRepo.insertFiles(fileDTOList);
    }

    public FileDTO getFileInfo(int fno){
        // file 다운로드 카운트를 update 한다던지 뭐 부가작업 필요하면 여기서 해야 함.
        return fileRepo.selectFile(fno);
    }
}
