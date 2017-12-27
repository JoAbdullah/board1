package board.control;

import board.Action.Action;
import board.Action.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class BoardControlServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 넘어오는 데이터 한글 처리
        req.setCharacterEncoding("UTF-8");

        // URL 분리하기
        String requgetURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String cmd = requgetURI.substring(contextPath.length());

        System.out.println("cmd : " + cmd);

        // cmd에 따라서 액션 생성
        BoardActionFactory baf = BoardActionFactory.getInstance();
        Action action = baf.action(cmd);

        // 액션에 일 시키기
        ActionForward af = null;
        try {
            af = action.execute(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //결과에 따라 이동
        if (af.isRedirect()) {
            res.sendRedirect(af.getPath());
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(af.getPath());
            rd.forward(req, res);
        }
    }
}
