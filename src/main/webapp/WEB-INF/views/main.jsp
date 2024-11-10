<%--
  Created by IntelliJ IDEA.
  User: zhangxin
  Date: 2019/5/13
  Time: 15:45
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>校园二手商城</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/style1.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.js"></script>


    <script>

    </script>
    <style type="text/css">
        .button
        {
            clear:both;
            margin:10px auto;
            text-align:center;
            font-size: 20px;
            padding:10px 0;
            line-height:25px;
            color:#666;
            border-top:#ddd 1px solid;
        }
        .button a
        {
            margin:0 7px;
            color:#666;
        }
        .button a:hover
        {
            color:#000;
            text-decoration:none;
        }

        .owl-item{
            display: inline;
            float:left;
        }
    </style>
</head>
<body>
<div id="main" class="container">

    <div id="header">
        <%@ include file="header.jsp" %>

        <!-- 旋转图 -->
        <div class="header-bottom">
            <div class="sort">
                <div class="sort-channel">
                    <ul class="sort-channel-list list-group">
                        <c:forEach items="${categoryList}" var="com" varStatus="v">
                            <li class="list-group-item"><a href="${pageContext.request.contextPath}/category?cateId=${com.cateid}">${com.catename}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div id="mycarousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/image/img/1.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/image/img/2.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/image/img/3.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/image/img/4.jpg" alt="">
                    </div>
                </div>

                <ol class="carousel-indicators">
                    <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#mycarousel" data-slide-to="1"></li>
                    <li data-target="#mycarousel" data-slide-to="2"></li>
                    <li data-target="#mycarousel" data-slide-to="3"></li>
                </ol>

                <a class="left carousel-control" href="#mycarousel" role="button"
                   data-slide="prev" style="display: none;"> <span
                        class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a> <a class="right carousel-control" href="#mycarousel" role="button"
                        data-slide="next" style="display: none;"> <span
                    class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            </div>
            <div class="clear-float"></div>
        </div>
    </div>
    <div class="content">


</div>

    <div class="owl-wrapper-outer">
        <div class="owl-wrapper" style="width:96%; left:2px; display: block;text-align: center">

            <c:forEach varStatus="s" var="com" items="${goodsList}">
            <div class="owl-item" style="width: 251px;">
                <div class="item">
                    <div class="item-inner">
                    <div class="item-img"><div class="item-img-info">
                        <a class="product-image" title="${com.goodsname}" href="/shop/detail?goodsid=${com.goodsid}">
                            <img alt="Retis lapen casen" style="width: 280px;height: 280px;" src="${pageContext.request.contextPath}/${com.imagePath.path}"></a>
                    </div>
                    </div>
                    <div class="item-info">
                        <div class="info-inner"><div class="item-title">
                            <a title="${com.goodsname}" href="/shop/detail?goodsid=${com.goodsid}">${com.goodsname}</a>
                        </div>
                           <div class="item-content">
                                <div class="price-box">
                                    <span class="regular-price"><span class="price" style="color: red">${com.price}</span>&nbsp;RMB</span>
                                </div>
                                <div class="action">
                                    <form action="${pageContext.request.contextPath}/addCart" method="post">
                                        <input type="hidden" value="${com.goodsid}" name="goodsid"/>
                                        <input type="hidden" value="1" name="goodsnum">
                                    <button class="button btn-cart" type="submit"><span>立即购买</span></button>
                                    </form>
                                </div></div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
            </c:forEach>

        </div>
    </div>

<div class="button">校园二手商城网</div>
</body>
</html>


