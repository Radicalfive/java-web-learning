<%--
  Created by IntelliJ IDEA.
  User: radical
  Date: 2022/2/24
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.radical.entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书详情页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <style type="text/css">
        h2, h3 {
            color: rgb(73, 73, 73);
        }

        #search {
            height: 80px;
            background-color: rgb(246, 246, 241);
            display: flex;
            align-items: center;
            padding-left: 8%;
            margin-bottom: 10px;
        }

        .search-input {
            flex: 0 0 40%;
            height: 35px;
            background-color: #fff;
            border: none;
            border-radius: 3px;
            margin-left: 50px;
        }

        .search-btn {
            width: 35px;
            height: 35px;
            background-color: rgb(155, 154, 143);
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .search-btn img {
            width: 50%;
            height: 50%;
        }


        .col-4 img {
            margin: 10px 5px 20px 5px;
            width: 80%;
        }

        hr {
            width: 90%;
            color: #eee;
            margin-top: 10px;
        }

        .col-6 {
            height: 400px;
            padding-right: 10px;
        }

        .col-6 img {
            width: 100%;
            height: 100%;
            border-radius: 20px;
        }

        .label {
            background-color: white;
            width: 58px;
            height: 30px;
            margin-left: 15px;
            font-size: 12px;
            border: 1px solid #ddd;
            border-radius:2px;
        }
        .label:hover {
            background-color: #936995;
        }
        .btn {
            background-color: white;
            width: 82px;
            height: 30px;
            margin-left: 15px;
            margin-top: 30px;
            font-size: 14px;
            border: 1px solid #ddd;
        }
        .btn:hover {
            background-color: #936995;;
        }
    </style>
</head>
<body>
<%
    Book book = (Book) request.getAttribute("book");
    pageContext.setAttribute("book", book);
%>

<div id="top">
    <jsp:include page="top.jsp"/>
</div>

<div id="search">
    <h2>读书时刻</h2>
    <input type="text" placeholder=" 书名 、 作者 、 ISBN" class="search-input">
    <div class="search-btn">
        <img src="${pageContext.request.contextPath}/images/search.png" alt="">
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-8">
            <h3>${book.name}</h3>
            <hr>
            <div class="row">
                <div class="col-6">
                    <br/>
                    <img src="/images/${book.cover}" alt="">
                    <br/>
                    <br/>
                    <h4>当情绪在某一刻占了上风，理智就永远没赢过</h4>
                </div>
                <div class="col-4">
                    <br/>
                    <h2>书名：${book.name}</h2>
                    <br/>
                    <h4>作者：${book.author}</h4>
                    <br/>
                    <input type="submit" value="青春" class="label">
                    <input type="submit" value="热血" class="label">
                    <input type="submit" value="斗争" class="label">
                    <input type="submit" value="正能量" class="label">
                    <br>
                    <input type="submit" value="立即阅读" class="btn">
                    <input type="submit" value="目录" class="btn">
                    <input type="submit" value="加入书架" class="btn">
                </div>
            </div>
        </div>
        <div class="col-4">
            <h3>热门标签</h3>
            <hr>
            <img src="${pageContext.request.contextPath}/images/right.png" alt="">
        </div>
    </div>

</div>
</body>
</html>
