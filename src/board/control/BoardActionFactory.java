package board.control;

import board.Action.Action;
import board.model.*;

public class BoardActionFactory {
    // 서블릿의 의뢰를 받아서 각각의 cmd에 따라 액션 생성해서 넘겨주기
    // 액션 생성해서 넘겨주기
    private BoardActionFactory() {
    }

    private static BoardActionFactory baf = null;

    public static BoardActionFactory getInstance() {
        if (baf == null)
            baf = new BoardActionFactory();
        return baf;
    }

    Action action = null;


    public Action action(String cmd) {
        if (cmd.equals("/qWrite.do")) {
            action = new BoardInsertAction("qList.do");
        } else if (cmd.equals("/qList.do")) {
            action = new BoardListAction("board/qna_board_list.jsp");
        } else if (cmd.equals("/qView.do")) {
            System.out.println("글보기 in");
            action = new BoardViewAction("board/qna_board_view.jsp");
            System.out.println("글보기 out");
        } else if (cmd.equals("/qHitUpdate.do")) {
            action = new BoardHitUpdate("qView.do");
        } else if (cmd.equals("/qPwdCheckDelete.do")) { // 삭제 요청 _ 비밀번호 확인
            action = new BoardPwdCheckAction("qDelete.do");
        } else if (cmd.equals("/qPwdCheckModify.do")) {
            action = new BoardPwdCheckAction("qModify.do");
        } else if (cmd.equals("/qDelete.do")) { //
            action = new BoardDeleteAction("qList.do");
        } else if (cmd.equals("/qModify.do")) {
            action = new BoardModifyAction("board/qna_board_modify.jsp");

        } else {
            System.out.println("노놉");
        }

        return action;
    }
}
