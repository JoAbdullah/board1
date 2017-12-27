package board.model;

import board.Action.Action;
import board.Action.ActionForward;
import board.dao.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteAction implements Action {
    private String path;

    public BoardDeleteAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        int board_num = 0;

        board_num = Integer.parseInt(req.getParameter("board_num"));
        BoardDAO dao = new BoardDAO();

        int result = dao.board_delete(board_num);
        if (result == 0) {
            path = "index.html";
            System.out.println("삭제실패");
        } else {
            System.out.println("삭제성공");
        }


        return new ActionForward(path, true);
    }
}
