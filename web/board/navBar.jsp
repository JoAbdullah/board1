<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017-12-21
  Time: 오전 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
        body {
            padding-top: 3.5rem;
        }
    </style>
</head>
<body>


<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="../../../../../index.html">
            <!--<i class="fas fa-certificate fa-spin fa-2x"></i>-->
            <i class="fab fa-studiovinari fa-2x"></i>

        </a>
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse"
                data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="../../../../../../board/qna_board_write.jsp">write<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="../../../../../../qList.do">list<span class="sr-only">(current)</span></a>
                </li>

            </ul>
            <form class="form-inline my-2 my-lg-0">
                <select name="criteria" class="custom-select">
                    <option value="board_name">작성자</option>
                    <option value="board_subject">제목</option>
                    <option value="board_content">글내용</option>
                </select>
                <input class="form-control mr-sm-2" name="searchword" type="text" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" oncl>Search</button>
            </form>
        </div>
    </div>
</nav>

</body>
</html>
</body>
</html>
