<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/assets/js/notice.js"></script>
</head>
<body>
    <h1>notice</h1>
    <div>
        <h1>공지사항 추가</h1>
        <table>
            <tbody>
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select id="ca_seq">
                            <option value="null">카테고리 선택</option>
                            <c:forEach items="${clist}" var="cate">
                                <option value="${cate.cate_seq}">${cate.cate_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" id="title" placeholder="공지명"></td>
                </tr>
                <tr>
                    <td>공지내용</td>
                    <td><textarea id="content" placeholder="공지내용"></textarea></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <button id="save">등록</button>
                        <button type="button" onclick="location.href='/notice/nList'" id="noticeList">목록</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>