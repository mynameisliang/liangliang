<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.min.css"/>
<link rel="stylesheet" href="${rootPath}css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${rootPath}css/theme.css" />
<link rel="stylesheet" type="text/css" href="${rootPath}images/icons/css/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="${rootPath}css/index.css"/>
<link rel="stylesheet" type="text/css" href="${rootPath}css/add.css"/>
</head>
<body>
<div class="navbar navbar-fixed-top">
	          <div class="navbar-inner">
	              <div class="container-fluid">
	                  <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
	                      <i class="icon-reorder shaded"></i></a><a class="brand" href="${rootPath}weight/toIndex">sdn水下传感器网络初始化最大权值路由系统</a>
	                  <div class="nav-collapse collapse navbar-inverse-collapse">
	                      <ul class="nav pull-left">
	                      	<ul class="nav nvabar-nav">
	                                  <li><a href="${rootPath}weight/toIndex">首页</a></li>
	                                    <li><a href="${rootPath}node/find">节点管理</a></li>
                                	<li ><a href="${rootPath}weight/find">权值管理</a></li>
                                	<c:if test="${user.type=='管理员'}"> 
                                		<li><a href="${rootPath}user/find">用户管理</a></li>
                                	</c:if>
                                	<li><a href="${rootPath}show.jsp">说明书</a></li>
		                            <li><a href="${rootPath}welcome.jsp">关于我们</a></li> 
	                        </ul>
	                          
	                      </ul>
	                      
	                <ul class="nav pull-right">
                    		<ul class="nav nvabar-nav">
                                <li><a href="${rootPath}user/toUpdate?id=${user.id}"><span><img src="${rootPath}images/user.png" width="20px" height="28px"/><span style="padding-top:5px">${user.username}</span></span></a></li>
                                <li><a href="${rootPath}logout"><span><img src="${rootPath}images/logout.png" width="20px" height="28px"/></span></a></li>
                            </ul>
                    </ul>
	                  </div>
	                  <!-- /.nav-collapse -->
	              </div>
	          </div>
	          <!-- /navbar-inner -->
	      </div>
	<div class="wrapper">
	<div class="container" style="margin-top:60px">
		<div class="title">
			<h3>用户信息</h3>
		</div>	
		<form action="${rootPath}user/update" method="post">
			<input type="hidden" name="id" value="${userInfo.id}">
			<div class="form-group">
				<label for="name" class="form-inline">用户名</label>
				<input type="text" class="form-control" 
			  	 placeholder="${userInfo.username}" name="username" value="${userInfo.username}">
			</div>
			<div class="form-group">
				<label for="name" class="form-inline">身份</label>
				<c:if test="${user.type=='普通用户'}">
					<input type="text" class="form-control"  disabled="disabled"
			  	 placeholder="${userInfo.type}" name="type" value="${userInfo.type}">
				</c:if>
				<c:if test="${user.type=='管理员'}">
					<select class="form-group" name="type">
						<c:if test="${userInfo.type=='管理员'}">
							<option value="管理员">管理员</option>
							<option value="普通用户">普通用户</option>
						</c:if>
						<c:if test="${userInfo.type=='普通用户'}">
							<option value="普通用户">普通用户</option>
							<option value="管理员">管理员</option>
						</c:if>
					</select>
				</c:if>
				
			</div>
			<div class="form-group">
				<label for="name" class="form-inline">密码</label>
				<input type="password" class="form-control"  
			  	 placeholder="${userInfo.password}" name="password" value="${userInfo.password}">
			</div>
			<button type="submit" class="btn btn-default btn-primary">修&nbsp;&nbsp;改</button>
		</form>
		<h3 style="color:red;text-align: center;margin: 20px; ">${msg}</h3>
	</div>
	</div>
	<div class="footer">
        <div class="container">
            <p>本项目由河南科技学院提供技术支持，版权所有</p>
        </div>
    </div>
	
	<script src="${rootPath}js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>