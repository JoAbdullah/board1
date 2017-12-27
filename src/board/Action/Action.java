package board.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
}

// cmd에 따라 만드는 모든 액션들의 부모 역할
// 동일한 틀을 제공하기 위해 사용