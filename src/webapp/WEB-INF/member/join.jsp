<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--Rq사용하기-->
<%@ page import="sbs.jsp.board.Rq" %>
<%@ page import="java.util.Map" %>

<%
Rq rq = new Rq(request, response);

%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입</title>
</head>
<body>
<style>
        body, ul, li {
            margin: 0;
        }
</style>

<script>
    function JoinForm_submit(form) {
        let JoinForm__submitDone = false;
        if (JoinForm__submitDone) {
            alert('처리 중입니다.');
            return;
        }

        form.loginId.value = form.loginId.value.trim();
        if (form.loginId.value.length == 0) {
            alert('로그인 아이디를 입력해주세요.');
            form.loginId.focus();
            return;
        }

        form.loginPw.value = form.loginPw.value.trim();
        if (form.loginPw.value.length == 0) {
            alert('로그인 비번을 입력해주세요.');
            form.loginPw.focus();
            return;
        }

        form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
        if (form.loginPwConfirm.value.length == 0) {
            alert('로그인 비번 확인을 입력해주세요.');
            form.loginPwConfirm.focus();
            return;
        }

        if (form.loginPw.value != form.loginPwConfirm.value) {
            alert('로그인 비번이 일치하지 않습니다.');
            form.loginPwConfirm.focus();
            return;
        }

        form.name.value = form.name.value.trim();
        if (form.name.value.length == 0) {
            alert('이름을 입력해주세요.');
            form.name.focus();
            return;
        }

        form.email.value = form.email.value.trim();
        if (form.email.value.length == 0) {
            alert('이메일을 입력해주세요.');
            form.email.focus();
            return;
        }
        alert('회원가입 성공!');
        form.submit();
        JoinForm__submitDone = true;
    }
</script>

<div class="member_join_box">
    <div class="con">
        <h1>회원가입</h1>
        <form action="doJoin" method="POST" onsubmit="JoinForm_submit(this); return false;">
            <div>로그인 아이디 : <input placeholder="아이디를 입력해주세요." name="loginId" type="text"></div>
            <div>로그인 비밀번호 : <input placeholder="비밀번호 입력해주세요." name="loginPw" type="password"></div>
            <div>로그인 비밀번호 확인 : <input placeholder="비밀번호 확인을 입력해주세요." name="loginPwConfirm" type="password"></div>
            <div>이름 : <input placeholder="이름을 입력해주세요." name="name" type="text"></div>
            <div>이메일 : <input placeholder="이메일을 입력해주세요." name="email" type="email"></div>
            <div class="btn-group">
                <button type="submit">회원가입</button>
                <button type="button">
                    <a href="/home/main">취소</a>
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>