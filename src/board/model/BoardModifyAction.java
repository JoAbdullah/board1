package board.model;

import board.Action.Action;
import board.Action.ActionForward;
import board.dao.BoardDAO;
import board.vo.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardModifyAction implements Action {
    private String path;

    public BoardModifyAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // board_view.jsp 에서 넘어오는 board_num 가져오기
        int board_num;

        board_num = Integer.parseInt(req.getParameter("board_num"));

        BoardVO vo_modify = new BoardVO();
        BoardDAO dao = new BoardDAO();

        vo_modify.setBoard_subject(req.getParameter("board_subject"));
        vo_modify.setBoard_content(req.getParameter("board_content"));
        vo_modify.setBoard_file(req.getParameter("board_file"));
        return new ActionForward(path, false);
    }
}
