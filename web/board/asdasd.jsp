<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017-12-13
  Time: 오전 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <!--반응형 웹-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!--BootStrap CSS-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">


    <title>asdasd</title>

    <style>
        .buttons {
            margin-left: auto;
            margin-right: auto;
        }

        .td_label {
            text-align: center;
            /*text-align: justify;*/
        }

        table {
            alignment: center;
        }
    </style>
</head>

<body>

<form action="../qWrite.jsp" method="post" enctype="multipart/form-data">
    <table>
        <caption>글쓰자</caption>
        <tr>
            <td class="td_label"><label for="writer">작성자</label></td>
            <td><input type="text" id="writer" name="board_name" maxlength="20" required></td>
        </tr>
        <tr>
            <td class="td_label"><label for="subject">제목</label></td>
            <td><input type="text" id="subject" name="board_subject" maxlength="50" required></td>
        </tr>
        <tr>
            <td class="td_label"><label for="content">내용</label></td>
            <td><textarea id="content" cols="70" rows="20" name="board_content" required></textarea></td>
        </tr>
        <tr>
            <td class="td_label"><label for="passwd"></label></td>
            <td><input type="password" id="passwd" name="board_pass" required></td>
        </tr>
        <tr>
            <td class="td_label"><label for="file">파일첨부</label></td>
            <td><input type="file" id="file" name="board_file"></td>
        </tr>
        <tr>
            <td class="buttons">
                <input type="submit" value="등록">
                <%--<input type="reset" value="취소">--%>
                <input type="button" value="취소" onclick="javascript:history.back()">
                <input type="button" value="버튼">
            </td>
        </tr>
    </table>
</form>
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
