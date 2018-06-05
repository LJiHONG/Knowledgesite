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
			 body{background: url(img/3.jpg) no-repeat;background-size:cover;}  
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
          <li><a href="Dofindintegral">Home</a></li>
          <li><a href="putquestion.jsp">发起提问</a></li>
          <li><a href="writearticle.jsp">写文章</a></li>
          <li><a href="Doqueryquestion">回答问题</a></li>
          <li class="active"><a href="puttopic.jsp">发起话题</a></li>
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
      <h1>发起话题</h1>
    </div>
	    <form class="form-horizontal" action="Doputtopic" method="post">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">发起人：</label>
		    <div class="col-sm-10">
		      <p class="form-control-static"><c:out value="${sessionScope.u_name}"></c:out></p>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">话题内容：</label>
		    <div class="col-sm-10">
		      <textarea name="content" id="groupinfo" rows="10" cols="30" class="form-control" placeholder="话题内容"></textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-primary">发布</button>
		    </div>
		  </div>
	</form>
  </div>
</div>

<div id="footer">
  <div class="container">
    <p class="text-muted credit">发起话题</p>
  </div>
</div>

	<!-- script references -->
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>
	</body>
</html>