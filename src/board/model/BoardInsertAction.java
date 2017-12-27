package board.model;

import board.Action.Action;
import board.Action.ActionForward;
import board.dao.BoardDAO;
import board.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class BoardInsertAction implements Action {
    private String path;

    public BoardInsertAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // qna_board_write.jsp에서 넘긴 값들 가져오기


        // 파일 업로드 기능을 구현 했기 때문에 입란 request로 받아올 수 없음


        // 파일 업로드와 관련된 부분
//        String saveDir = "/boardUpload";
//        System.out.println(saveDir);
//        String uploadPath = req.getServletContext().getRealPath(saveDir);
//        String uploadPath = "E:/hi";
        System.out.println("슈발");
        String uploadPath = "C:/hi";
        System.out.println(uploadPath);
        //파일 업로드 사이즈 제한
        int size = 5 * 1024 * 1024;

        MultipartRequest multi;


        try {
            multi = new MultipartRequest(req, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
            // qna_board_write.jsp 에서 넘긴 값 가져오기.
            BoardVO vo = new BoardVO();
            vo.setBoard_name(multi.getParameter("board_name"));
            vo.setBoard_subject(multi.getParameter("board_subject"));
            vo.setBoard_content(multi.getParameter("board_content"));
            vo.setBoard_pass(multi.getParameter("board_pass"));

            // 첨부된 파일 가져오기
            vo.setBoard_file(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));

            // DAO 작업
            BoardDAO dao = new BoardDAO();

            // DAO 메소드 호출 => insert 작업하기

            int result = dao.insertArticle(vo);
            if (result == 0) {
                path = "board/qna_board_write_error.jsp";
            }


        } catch (Exception e) {
            System.out.println("ㅋㅋ");
            e.printStackTrace();
        }

        return new ActionForward(path, true);

    }
}


