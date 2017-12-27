package board.model;

import board.Action.Action;
import board.Action.ActionForward;
import board.dao.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardHitUpdate implements Action {
    private String path;

    public BoardHitUpdate(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        int board_num = Integer.parseInt(req.getParameter("board_num"));
        // 조회수 업데이트
        BoardDAO dao = new BoardDAO();
        int result = dao.hitUpdate(board_num);

        if (result > 0) {
            path += "?board_num=" + board_num;
            System.out.println("대");
        } else {
            path = "index.html";
            System.out.println("안대");
        }

        return new ActionForward(path, true);
    }
}
