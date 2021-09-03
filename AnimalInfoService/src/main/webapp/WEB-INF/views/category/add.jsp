<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/category.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <h1>카테고리 추가</h1>
    <div class="cate_wrap">
        <span>카테고리명</span>
        <input type="text" id="cate_name">
        <button id="add">추가</button>
    </div>

    <div id="cate_list" class="list">
        <table id="cate_tb">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>이름</td>
                    <td></td>
                </tr>
            </thead>
            <tbody id="cate_tb_body">

            </tbody>
        </table>
    </div>
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>