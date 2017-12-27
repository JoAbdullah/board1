<%@ page import="board.vo.BoardVO" %>
<%@ page import="java.util.Vector" %>
<%@ page import="board.vo.PageVO" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017-12-15
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Vector<BoardVO> list = (Vector<BoardVO>) request.getAttribute("list");
    PageVO info = (PageVO) request.getAttribute("info");

    int total_page = info.getTotalPage();
    int current_page = info.getPage();
    int endPage = info.getEndPage();
    int startPage = info.getStartPage();
    int totalRows = info.getTotalRows();
//
//    int total_page = info.getTotalPage();
//    int current_page = info.getPage();
//    int endPage = info.getEndPage();
//    int startPage = info.getStartPage();
//    int totalRows = info.getTotalRows();

%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

    <script defer src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>

    <title>qweqwe</title>
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

    </style>
</head>
<body>

<%@include file="navBar.jsp" %>

<table class="table table-striped table-hover">
    <tr class="p-3 mb-2 bg-primary text-white" align="center">
        <th width="35">#</th>
        <th width="350">글 제목</th>
        <th width="100">작성자</th>
        <th width="150">작성일</th>
        <th width="75">조회수</th>
    </tr>
    <%

        for (BoardVO vo : list) {

    %>
    <tr>
        <th><%=vo.getBoard_num()%>
        </th>
        <td>
            <a href="qHitUpdate.do?board_num=<%=vo.getBoard_num()%>"><%=vo.getBoard_subject()%>
            </a>
            <%--<a href="qView.do?board_num<%=vo.getBoard_num()%>"></a>--%>
            <%--<%=vo.getBoard_subject()%>--%>
        </td>
        <td><%=vo.getBoard_name()%>
        </td>
        <td><%=vo.getBoard_date()%>
        </td>
        <td><%=vo.getBoard_readcount()%>
        </td>
    </tr>


    <%} %>
    <tr>
        <td colspan="5">
            <%
                for (int i = startPage; i <= endPage; i++) {
                    if (i == current_page) {
                        out.print(i);
                    } else {
                        out.print(i);
                    }
                }
            %>
        </td>
    </tr>

</table>

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
