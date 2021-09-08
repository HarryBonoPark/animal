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
    <link rel="stylesheet" href="/assets/css/noticeList.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/assets/js/noticeList.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <div class="container">
        <h1>Notice</h1>
        <div class="list">
            <div class="text_area">
                <table id="notice_tb">
                    <thead>
                        <tr>
                            <td>No</td>
                            <td>제목</td>
                            <td>작성일</td>
                        </tr>
                    </thead>
                    <tbody id="notice_tbody">
                        
                    </tbody>
                </table>
            </div>
            <div class="notice_list list">
                <div class="search_area">
                    <span>카테고리</span>
                    <select id="cate_search">
                        <option>전체</option>
                        <c:forEach items="${clist}" var="cate">
                            <option value="${cate.cate_seq}">${cate.cate_name}</option>
                        </c:forEach>
                    </select>
                    <input type="text" id="search_keyword" placeholder="공지사항 검색">
                    <button id="search">검색</button>
                    <c:if test="${member_info.status == 0}">
                        <a href="/notice">글쓰기</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>