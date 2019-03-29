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
<link rel="stylesheet" href="${rootPath}css/introduce.css" />
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
                                	<li ><a href="${rootPath}show.jsp">说明书</a></li>
		                            <li ><a href="${rootPath}welcome.jsp">关于我们</a></li>
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
				<div class="title">
           		 	<h2 class="head">sdn水下传感器网络最大权值路由系统说明书</h2>
           		 </div>
           		 <div class="introduce">
           		 	<h4>欢迎您阅读说明书，本项目模拟的水下的传感器网络,进行网络的模拟，由于浏览器无法承受10万条路径，所以本次选取5个节点来进行数据的说明，如果你输入的点数太多，可能需要很多时间</h4>
           		 	<img src="images/map2.png" alt="散点图" width="720px" height="331px"/>
           		 	<h4>1.在下拉框选择2-9的数字，点击生成节点按钮，上图将自动生成散点图</h4>
           		 	<h4>2.在开始的节点和结束的节点有两个下拉框，可以根据你的意愿，进行点的选取</h4>
           		 	<h4>3.选后点后，点击开始按钮，路由表就会出现，就如上图所示</h4>
           		 	<h4>4.点击下一步，系统会找到最大权值，进行减操作，直到生成最大权值的路径为止</h4>
           		 	<img src="images/map3.png" alt="权值减操作" width="720px" height="331px"/>
           		 	<img src="images/map4.png" alt="权值减操作" width="720px" height="331px"/>
           		 	<img src="images/map5.png" alt="权值减操作" width="720px" height="331px"/>
           		 	<img src="images/map6.png" alt="权值减操作" width="720px" height="331px"/>
           		 	<h4 style="margin-top: 40px;">最后的结果是：</h4>
           		 	<img src="images/map7.png" alt="最后的结果" width="720px" height="331px"/>
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