<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sdn水下传感器网络初始化最大权值路由系统</title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.min.css"/>
<link rel="stylesheet" href="${rootPath}css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${rootPath}css/theme.css" />
<link rel="stylesheet" type="text/css" href="${rootPath}images/icons/css/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="${rootPath}css/index.css"/>
<link rel="stylesheet" href="${rootPath}css/welcome.css" />
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
                                		<li ><a href="${rootPath}user/find">用户管理</a></li>
                                	</c:if>
                                	<li><a href="${rootPath}show.jsp">说明书</a></li>
		                            <li class="active"><a href="${rootPath}welcome.jsp">关于我们</a></li>
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
		<div class="container">
			<div class="center">
				<div class="header">
					<i class="xglogo"></i>
					<h1>sdn水下传感器网络最大权值路由系统</h1>
					<hr />
				</div>
			</div>
			<div class="context">
				<div class="text">
					<p style="font-size: 24px;">TIPS:</p>
					<span style="text-indent: 40px;">如您在使用过程中出现问题，无法正常使用该系统，请阅读说明书,然后进行操作
					</span>
					<p>如有技术问题，请联系我们</p>
					<p>责任人:焦祥宇</p>
					<p>联系QQ:1062100557</p>
					<p>技术支持:河南科技学院javaweb第六组</p>
					<p>版权所有:河南科技学院</p>
				</div>
			</div>
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