package board.dao;

import board.vo.BoardVO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class BoardDAO {

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    DataSource ds = null;

    // Connection 얻어오기
    public Connection getConnection() {
        Context ctx;

        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
            con = ds.getConnection();
        } catch (Exception e) {
            System.out.println("DB커넥션 실패" + e);
        }
        return con;
    }

    public void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void close(PreparedStatement pstmt) {

        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(ResultSet rs) {

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int insertArticle(BoardVO vo) {
        int num = 0, result = 0;
        try {
            con = getConnection();
            // 글을 하나 등록하기 전에 글 번호를 알기 위해 값 가져오기
            pstmt = con.prepareStatement("SELECT MAX(board_num) FROM board");
            con.setAutoCommit(false);
            rs = pstmt.executeQuery();
            if (rs.next())
                num = rs.getInt(1) + 1;
            else
                num = 1;
            String sql = "insert into board values(?,?,?,?,?,?,?,?,?,?,now())";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.setString(2, vo.getBoard_name());
            pstmt.setString(3, vo.getBoard_pass());
            pstmt.setString(4, vo.getBoard_subject());
            pstmt.setString(5, vo.getBoard_content());
            pstmt.setString(6, vo.getBoard_file());
            pstmt.setInt(7, num);
            pstmt.setInt(8, 0);
            pstmt.setInt(9, 0);
            pstmt.setInt(10, 0);
            System.out.println("1번" + pstmt);
            result = pstmt.executeUpdate();
            if (result > 0)
                con.commit();
        } catch (Exception e) {

            System.out.println(e + "qwe");

            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            close(pstmt);
            close(con);
        }

        return result;
    }


    // 전체 게시물 수 가져오기
    public int total_rows() {


        String sql = "SELECT count(*) FROM board";
        int total_rows = 0;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next())
                total_rows = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
            close(con);
        }
        return total_rows;

    }


    public Vector<BoardVO> getList(int page, int limit) {
        // page 값에 의해 몇번째 레코드부터 보여줄 것인지 결정
        int start = (page - 1) * 10;

        Vector<BoardVO> list = new Vector<BoardVO>();
        // 번호, 제목, 작성자, 날짜, 조회수 뽑아서 Vector에 담기
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT board_num,board_subject,board_name,board_date,board_readcount FROM board ORDER BY board_num LIMIT ?,?;";
//            String sql = "SELECT * FROM board ORDER BY board_re_ref DESC ,board_re_seq ASC limit ?,?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,page);
            pstmt.setInt(2,limit);


            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setBoard_num(rs.getInt(1));
                vo.setBoard_subject(rs.getString(2));
                vo.setBoard_name(rs.getString(3));
                vo.setBoard_date(rs.getDate(4));
                vo.setBoard_readcount(rs.getInt(5));
                list.add(vo);
            }
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            close(pstmt);
            close(con);
            close(rs);
        }

        System.out.println("dd");
        return list;
    }

    public BoardVO getRow(int board_num) {
        Vector<BoardVO> postView = new Vector<BoardVO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BoardVO vo = null;

        try {
            con = getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT * FROM board WHERE board_num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, board_num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                vo = new BoardVO();
//                vo.setBoard_num(rs.getInt(rs.getInt("board_num")));
//                vo.setBoard_name(rs.getString("board_name"));
//                vo.setBoard_subject(rs.getString("board_subject"));
//                vo.setBoard_content(rs.getString("board_content"));
//                vo.setBoard_file(rs.getString("board_file"));
//                vo.setBoard_re_ref(rs.getInt("board_re_ref"));
//                vo.setBoard_re_lev(rs.getInt("board_re_lev"));
//                vo.setBoard_re_seq(rs.getInt("board_re_seq"));

                vo.setBoard_num(rs.getInt(1));
                vo.setBoard_name(rs.getString(2));
                vo.setBoard_pass(rs.getString(3));
                vo.setBoard_subject(rs.getString(4));
                vo.setBoard_content(rs.getString(5));
                vo.setBoard_file(rs.getString(6));
                vo.setBoard_re_ref(rs.getInt(7));
                vo.setBoard_re_lev(rs.getInt(8));
                vo.setBoard_re_seq(rs.getInt(9));
                vo.setBoard_readcount(rs.getInt(10));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
            close(rs);
        }

        return vo;
    }

    public int hitUpdate(int board_num) {
        int result = 0;
        String sql = "UPDATE board SET board_readcount=board_readcount+1 WHERE board_num=?";
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, board_num);
            System.out.println("board num : " + board_num);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }
        return result;
    }

//    public int pwdCheck(int board_num, String board_pass) {
//
//        //SELECT * FROM board WHERE board_num=? AND board_pass=?;
//        int result = 0;
//
//        return result;
////        String sql = "SELECT * FROM board WHERE board_num=? AND board_pass=?";
//
//    }

    public int pwdCheck(int board_num, String board_pass) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;

        try {
            con = getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT * FROM board WHERE board_num=? AND board_pass=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, board_num);
            pstmt.setString(2, board_pass);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("입력 전 result = " + result);
                result = board_num;
                System.out.println("입력 후 result = " + result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
            close(rs);
        }

        return result;
    }


    public int board_delete(int board_num) {


        //DELETE FROM board WHERE board_num=?;
        System.out.println("삭제할수있나");
        int result = 0;

        String sql = "DELETE FROM board WHERE board_num=?";
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, board_num);
            result = pstmt.executeUpdate();
//            if (rs.next()) {
//                result = 1;
//                System.out.println("삭제 성공함");
//            }
        } catch (Exception e) {
            System.out.println("board_delete sql error");
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }


        return result;
    }

    public int board_modify(String board_subject, String board_content, int board_num) {
        int result = 0;

        String sql = "UPDATE board SET board_subject=?,board_content=? WHERE board_num=? LIMIT 1";
//        UPDATE board SET board_subject='asd',board_content='qwe' WHERE board_num=1 LIMIT 1;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, board_subject);
            pstmt.setString(2, board_content);
            pstmt.setInt(3, board_num);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("board_modify sql error");
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }


        return result;
    }

}
