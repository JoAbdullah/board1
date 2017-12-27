package board.Action;

public class ActionForward {
    // 액션 결과에 따라서 이동할 방법
    // 이동할 경로를 가지고 처리해줌

    private String path;
    private boolean redirect;

    public ActionForward(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }
}
