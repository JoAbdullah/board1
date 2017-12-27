package board.model;

import board.Action.Action;
import board.Action.ActionForward;
import board.dao.BoardDAO;
import board.vo.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Vector;

public class BoardViewAction implements Action {
    private String path;

    public BoardViewAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // qna_board_list.jsp 에서 넘어오는 값 가져오기

        int board_num;

        // board_num 가져오기


        board_num = Integer.parseInt(req.getParameter("board_num"));
        System.out.println(board_num);


        // board_num과 일치하는 db내용 가져오기
        BoardDAO dao = new BoardDAO();
        // dao.getRow(board_num);

        BoardVO viewPost = dao.getRow(board_num);
        if (viewPost == null) {
            path = "index.html";
            System.out.println("error" + path);
        } else {
            System.out.println("호호홍");
            req.setAttribute("viewPost", viewPost);
        }


        return new ActionForward(path, false);
    }
}
