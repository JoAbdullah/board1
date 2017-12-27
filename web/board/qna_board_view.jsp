<%@ page import="board.vo.BoardVO" %>
<% BoardVO vo = (BoardVO) request.getAttribute("viewPost");%>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017-12-18
  Time: 오전 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function list_submit() {
            location.href = "qList.do";
        }

        function reply_list() {

        }

        function modify_list() {
            <%--location.href = "qModify.do?board_num=<%=vo.getBoard_num()%>";--%>
            location.href = "board/qna_board_pwdCheck.jsp?board_num=<%=request.getParameter("board_num")%>&modify=true";
            <%--location.href = "qModify.do?board_num=<%=request.getParameter("board_num")%>";--%>


        }

        function delete_list() {
            <%--location.href = "board/qna_board_pwdCheck.jsp?board_num=<%=vo.getBoard_num()%>";--%>
            location.href = "board/qna_board_pwdCheck.jsp?board_num=<%=request.getParameter("board_num")%>&delete=true";


        }
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

    <title>글본다</title>
    <style>
        .table {
            width: auto;
            height: auto;
            /*width: 695px;*/
            /*height: 400px;*/
            margin-left: auto;
            margin-right: auto;
            margin-top: 2%;
        }

        .setTextCenter {
            text-align: center;
        }

        td {
            width: 850px;
        }


    </style>
</head>
<%@include file="navBar.jsp" %>
<body>

<main role="main">
    <table class="table table-bordered">
        <tr class="p-3 mb-2 bg-primary text-white" align="center">

            <th class="setTextCenter">제목</th>
            <td><%=vo.getBoard_subject()%>
            </td>
        </tr>
        <tr>
            <th class="setTextCenter">작성자</th>
            <td><%=vo.getBoard_name()%>
            </td>
        </tr>
        <tr>
            <th class="setTextCenter">내용</th>
            <td><%=vo.getBoard_content()%>
            </td>
        </tr>
        <% if (vo.getBoard_file() != null) { %>
        <%--
        <%
        String fileName = vo.getBoard_file();

        if(fileName!=null){
            fileName = new String(fileName.getBytes(), "UTF-8");
        %>
        <%=fileName%>
        <%}%>

        --%>
        <tr>
            <th class="setTextCenter">파일첨부</th>
            <td><%=vo.getBoard_file()%>
            </td>
        </tr>
        <% } %>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="답변" onclick="reply_list()" class="btn btn-success btn-sm">
                <input type="button" value="수정" onclick="modify_list()" class="btn btn-info btn-sm">
                <input type="button" value="삭제" onclick="delete_list()" class="btn btn-danger btn-sm">
                <input type="button" value="목록" onclick="list_submit()" class="btn btn-primary btn-sm">
            </td>
        </tr>

    </table>
</main>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
</body>
</html>
