package board.model;

import board.Action.Action;
import board.Action.ActionForward;
import board.dao.BoardDAO;
import board.vo.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardPwdCheckAction implements Action {
    private String path;

    public BoardPwdCheckAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        int board_num = 0;
        String board_pass = null;

//        qna_board_pwdCheck.jsp 에서 넘긴 값 가져오기;
//        board_num = req.getParameter("board_num");
        board_num = Integer.parseInt(req.getParameter("board_num"));
        board_pass = req.getParameter("board_pass");
        System.out.println("board_num : " + board_num + "\r\nboard_pass : " + board_pass);


        // board_pass, board_num

        // 비밀번호 맞는지 확인하기
        BoardDAO dao = new BoardDAO();
        int result = dao.pwdCheck(board_num, board_pass);
        System.out.println(result);

        if (result == 0) {
            path = "board/pwdError.html";
            System.out.println("비번틀림");
        } else {
            path += "?board_num=" + board_num;
        }
        String isModify = req.getParameter("modify");






        System.out.println("고고싱" + board_num);

        return new ActionForward(path, true);
    }
}
