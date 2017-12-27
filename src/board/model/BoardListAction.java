package board.model;

import board.Action.Action;
import board.Action.ActionForward;
import board.dao.BoardDAO;
import board.vo.BoardVO;
import board.vo.PageVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Vector;

public class BoardListAction implements Action {

    private String path;

    public BoardListAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // DAO getList() 호출한 후 사용자가 선태한 페이지 번호에 맞는 게시판 목록 가져오기
        int page = 1;

        if (req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));


        BoardDAO dao = new BoardDAO();

        int total_rows = dao.total_rows(); // 전체 게시물 수 가져오기

        int limit = 10; // 한 페이지에 보여줄 갯수 정하기

        int total_page = (int) ((double) total_rows / limit + 0.95); // list페이지 하단에 total_page 결정

        int startPage = (int) ((double) page / 10 + 0.9) * 10 + 1;// 현재 화면에서 보여줄 start 페이지 구하기

        int endPage = startPage + 10 - 1;// 현재 화면에서 보여줄 end페이지 구하기

        if (endPage > total_page)
            endPage = total_page;

        PageVO info = new PageVO();
        info.setPage(page);
        info.setTotalPage(total_page);
        info.setTotalRows(total_rows);
        info.setStartPage(startPage);
        info.setEndPage(endPage);


        // page 변수값에 따라 목록 가져오기
        Vector<BoardVO> list = dao.getList(page, limit);

        if (list.isEmpty()) {
            path = "index.html";
        } else {
            req.setAttribute("list", list);
            req.setAttribute("info", info);
        }
        // 가져온 목록을 request에 담고 페이지 이동
        return new ActionForward(path, false);
    }
}
