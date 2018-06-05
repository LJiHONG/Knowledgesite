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
		
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
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
          <li><a href="puttopic.jsp">发起话题</a></li>
          <li><a href="Doquerytopic">查看话题</a></li>
          <li class="active"><a href="Doqueryfocus">我关注的话题</a></li>
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
      <h1>我关注的话题</h1>
    </div>
    <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr class='info'>
                  <th>话题ID</th>
                  <th>发起人</th>
                  <th>话题内容</th>
                  <th>发起时间</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${requestScope.ltpc}" var="g">
                <tr>
                  <td><c:out value="${g.tpcId}"></c:out></td>
                  <td><c:out value="${g.userName}"></c:out></td>
                  <td><c:out value="${g.tpcContent}"></c:out></td>
                  <td><c:out value="${g.tpcTime}"></c:out></td>
               	 <td><a href="Doquerytopicbyid?id=${g.tpcId}">去发言</a></td>
               	</tr>
               </c:forEach>
              </tbody>
            </table>
          </div>
  </div>
</div>
<div id="footer">
  <div class="container">
    <p class="text-muted credit">我关注的话题</p>
  </div>
</div>

	<!-- script references -->
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>
	</body>
</html>