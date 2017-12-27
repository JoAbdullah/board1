<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017-12-18
  Time: 오후 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String board_num = request.getParameter("board_num");
    String modify = request.getParameter("modify");
    String delete = request.getParameter("delete");%>
<html>
<head>
    <title>비번확인</title>
</head>
<body onload="pwdCheck.pwd.focus()">

        <% if (modify != null) {
            System.out.println("modify : " + modify);%>
        <form action="../qPwdCheckModify.do" name="pwdCheck" method="post">
            <table>
                <tr>
                    <td>비밀번호를 입력해 주세요</td>
                </tr>
                <tr>
                    <td><input type="password" size="20" name="board_pass" required>
                        <input type="submit" value="수정">
                        <input type="button" value="돌아가기" onclick="javascript:history.back();">

                    </td>
                </tr>


            <% } else if (delete != null) {
                    System.out.println("delete : " + delete);%>
        <form action="../qPwdCheckDelete.do" name="pwdCheck" method="post">
            <table>
                <tr>
                    <td>비밀번호를 입력해 주세요</td>
                </tr>
                <tr>
                    <td><input type="password" size="20" name="board_pass" required>
                        <input type="submit" value="삭제">
                        <input type="button" value="돌아가기" onclick="javascript:history.back();">

                    </td>
                </tr>
                <% } %>

            </table>
            <input type="hidden" name="board_num" value="<%=board_num%>">
        </form>


        <%--<h4>비밀번호를 입력 해 주세요</h4>--%>
        <%--<input type="password"><input type="submit" value="삭제"><<input type="button" value="돌아가기">--%>
</body>
</html>
