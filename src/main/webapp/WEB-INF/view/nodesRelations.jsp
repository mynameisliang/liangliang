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
<script type="text/javascript">
	function _search() {
		 var a=document.getElementById("search").value;
		 var form = document.getElementById("_searchForm");		 
		 form.action="${rootPath}weight/find?search="+a;
		 form.submit(); 
	}  
</script>
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
                                	 <li class="active"><a href="${rootPath}weight/find">权值管理</a></li>
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
		<div class="container" style="padding-top:30px">
		
			<div class="input-group" style="float:right">
				<form id="_searchForm" action="${rootPath}weight/find" method="get" onsubmit="return _search();">	
					<input type="text" id="search" name="search" class="form-control">
					<input type="submit" value="搜索"  class="btn btn-default btn-primary" onclick="_search();" style="margin-top:-10px">	
				</form>
			</div>
		
	         	<table class="table table-striped table-hover ">	  
				  <thead>
				    <tr>	      
				      <th>节点名称</th>
				      <th>节点名称</th>
				      <th>权值</th>	      
				      <th>删除</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach var="n"   items="${pc.data}"   varStatus="i">
				  		<tr>	      
					      <td>${n.node_A}</td>
					      <td>${n.node_B}</td>
					      <td>${n.weight}</td>
					      <td><a href="${rootPath}weight/delete?id=${n.id}">删除</a></td>		      
					    </tr>
				  	</c:forEach>
			
				  </tbody>
				</table>
				<div class="list-page">
					<ul class="pagination">
						<li><a href="${rootPath}weight/find?curr=${pc.prePage}&search=${search}">上一页</a></li>
						<c:if test="${1 < pc.currentPage -3}">
							<li><a href="${rootPath}weight/find?curr=1&search=${search}">1</a></li>
						</c:if>
			
						<c:forEach var="i"
							begin="${pc.currentPage-3>0?pc.currentPage-3:1 }"
							end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
							<c:choose>
								<c:when test="${i>0 && i == pc.currentPage }">
									<li class="active"><a
										href="${rootPath}weight/find?curr=${i}&search=${search}">${i}</a></li>
								</c:when>
			
								<c:when test="${i>0 && i != postPS.currentPage }">
									<li><a href="${rootPath}weight/find?curr=${i}&search=${search}">${i}</a></li>
								</c:when>
							</c:choose>
						</c:forEach>
						<li><a
							href="${rootPath}weight/find?curr=${pc.nextPage}&search=${search}">下一页</a></li>
					</ul>		
				</div>
				<h3 style="color: red;text-align: center;">${msg }</h3>	 
	     </div>
	     <!--/.container-->
	</div> 
	<div class="footer">
        <div class="container">
            <p>本项目由河南科技学院提供技术支持，版权所有</p>
        </div>
    </div>
	
	<script src="${rootPath}js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	
</body>
</html>