<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <script src="/assets/js/login.js"></script>
    
</head>
<body>
    <header>
        <div class="header_menu">
            <c:if test="${member == null}">
                <a href="/member/login">로그인</a>
                <span>|</span>
                <a href="/member/join">회원가입</a>
            </c:if>
            <c:if test="${member != null}">
                <span class="status">
                    <c:if test = "${member.status==1}">회원</c:if>
                    <c:if test = "${member.status==0}">관리자</c:if></span>${member.id}님</a>
                    <span>|</span>
                    <a href="/member/info?seq=${member.seq}" id="memberinfo">회원정보</a>
                    <span>|</span>
                    <a href="/member/logout" id="logout">로그아웃</a>
            </c:if>
        </div>
        <div class="header">
            <ul class="left_menu">
                <li>
                    <a href="/dog">강아지</a>
                </li>
                <li>
                    <a href="/cat">고양이</a>
                </li>
                <li>
                    <a href="/other">기타동물</a>
                </li>
                <li>
                    <a href="/center">보호센터</a>
                </li>
            </ul>
            <a href="/" id="logo">
                <img src="/assets/images/logo.svg">
            </a>
            <ul class="right_menu">
                <li>
                    <a href="/member/calendar">입양예약</a>
                </li>
                <li>
                    <a href="/lost/list">분실센터</a>
                </li>
                <li>
                    <a href="/notice/nList">공지사항</a>
                </li>
                <li>
                    <a href="/support/list">문의</a>
                </li>
            </ul>
        </div>
    </header>
</body>
</html>
