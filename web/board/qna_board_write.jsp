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

    <script defer src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>

    <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">




    <title>asdasd</title>

    <style>
        .table {
            /*size: auto;*/
            width: auto;
            height: auto;
            margin-left: auto;
            margin-right: auto;
            margin-top: 25px;
        }

        .td_label {
            text-align: center;
        }


        textarea {
            resize: none;
        }


    </style>
</head>
<%@include file="navBar.jsp" %>
<body>

<form action="/qWrite.do" method="post" enctype="multipart/form-data">
    <table class="table table-hover">
        <caption>글쓰자</caption>
        <tr class="p-3 mb-2 bg-primary text-white">
            <td class="td_label"><label for="board_name">작성자</label></td>
            <td><input type="text" id="board_name" name="board_name" maxlength="20" required></td>
        </tr>
        <tr>
            <td class="td_label"><label for="board_subject">제목</label></td>
            <td><input type="text" id="board_subject" name="board_subject" maxlength="50" required></td>
        </tr>
        <tr>
            <td class="td_label"><label for="board_content">내용</label></td>
            <td><textarea id="board_content" cols="70" rows="20" name="board_content" required></textarea></td>
        </tr>
        <tr>
            <td><label for="board_file">파일첨부</label></td>
            <td><input type="file" name="board_file" id="board_file"></td>
        </tr>
        <tr>
            <td class="td_label"><label for="board_pass">패스워드</label></td>
            <td><input type="password" id="board_pass" name="board_pass" required></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="작성" class="btn btn-success btn-sm">
                <input type="button" value="취소" onclick="javascript:history.back()" class="btn btn-danger btn-sm">
                <input type="button" value="목록" class="btn btn-info btn-sm">
            </td>
        </tr>
    </table>

</form>

<button type="button" class="btn btn-default" aria-label="Left Align">
    <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
</button>

<button type="button" class="btn btn-default btn-lg">
    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
</button>

<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">Profile</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
    </li>
</ul>


<div class="tab-content" id="pills-tabContent">
    <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">qweqwe</div>
    <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">qweqwerq</div>
    <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">rasdas</div>
</div>

<br><br><br><br><br>

<label class="custom-file">
    <input type="file" id="file2" class="custom-file-input" >
    <span class="custom-file-control" ></span>
</label>

<br><br><br>



<nav class="nav nav-tabs" id="myTab" role="tablist">
    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Home</a>
    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Profile</a>
    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Contact</a>
</nav>
<div class="tab-content" id="nav-tabContent">
    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">...</div>
    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">...</div>
    <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">...</div>
</div>


<i class="fas fa-file-alt" style="font-size: 32px"></i>






<br><br><br><br><br>

<script defer src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>

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
