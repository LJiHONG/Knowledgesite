<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>首页</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		
		<link href="css/main1.css" rel="stylesheet">
		<style type="text/css"> 
			 body{background: url(img/4.jpg) no-repeat;background-size:cover;}  
		</style>
	</head>
	<body>
<!-- Wrap all page content here -->
<div id="wrap">
  
  <!-- Fixed navbar -->
  <!-- 导航栏 开始-->
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">大型知识类问答网站</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav nav-tabs">
          <li class="active"><a href="Dofindintegral">Home</a></li>
          <li><a href="putquestion.jsp">发起提问</a></li>
          <li><a href="writearticle.jsp">写文章</a></li>
          <li><a href="Doqueryquestion">回答问题</a></li>
          <li><a href="puttopic.jsp">发起话题</a></li>
          <li><a href="Doquerytopic">查看话题</a></li>
          <li><a href="Doqueryfocus">我关注的话题</a></li>
          <li><a href="Doqueryfocusquestion">我关注的提问</a></li>
          <li><a href="Doqueryarticle">查看文章</a></li>
          <li><a href="Doqueryuser">关注用户</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
   <!-- 导航栏 结束-->
  <!-- Begin page content -->
  <div class="container">
    <div class="page-header">
      <h1>成功登录！</h1>
    </div>
    <p class="lead">欢迎您：<c:out value="${sessionScope.u_name}"></c:out></p>
    <p class="lead">你当前的积分为：<c:out value="${requestScope.integral}"></c:out></p>
    	<div class="form-group">
		    <div class="col-sm-1">
		      <a class="btn btn-info btn-block" href="Dosignin">去签到</a>
		    </div>
		  </div>
  </div>
</div>

<div id="footer">
  <div class="container">
    <p class="text-muted credit">home</p>
  </div>
</div>

	<!-- script references -->
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>
	</body>
</html>