/*
 * 生成节点
 */
function generateNodes(){
	 var num=document.getElementById("num").value;  
	 _deleteMsg();
	 _deleteMaxWeight();
	 if(num>=2 && num<=9){
		 _getNodes(num);
		 removeRoutes();
	 }else{		 
		 _setMsg("节点数应该在2~9范围内");
	 }
	
}
 
/*
 * 生成提示信息
 */
function _setMsg(msg){
	document.getElementById("msg").innerHTML=msg;
}

/**
 * 删除提示信息
 */
function _deleteMsg(){
	document.getElementById("msg").innerHTML="";
} 
/**
 * 显示上次最大权值
 */
function _setMaxWeight(_maxNodes){
	var max="上一轮次最大权值：";
	for(var i=0;i<_maxNodes.length;i++){
		max+=(_maxNodes[i].node_A+_maxNodes[i].node_B+"="+_maxNodes[i].weight);
	}
	document.getElementById("maxWeight").innerHTML=max;
} 
/**
 * 删除旧的最大权值
 */
function _deleteMaxWeight(){
	document.getElementById("maxWeight").innerHTML="";
} 
/* 
 *获得路径 
 */
function _getRoutes(){ 
		_deleteMsg();
		_deleteMaxWeight();
		var start=document.getElementById("start").value; 
		var end=document.getElementById("end").value;
		if(start=="" || end==""){
			_deleteMsg();
			_setMsg("节点名称不能为空");
		}else if(start==end){
			_deleteMsg();
			_setMsg("两节点名称不能相同");
		}else{
			 var xmlhttp;  
				if (window.XMLHttpRequest) {
					// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
					xmlhttp = new XMLHttpRequest();
				} else {
					// IE6, IE5 浏览器执行代码
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {		
						var result =xmlhttp.responseText;
						if(result!=null && result!="" && result!=[]){
							var json = eval("(" + result + ")");
							if(json!=null && json!="" && json!=[]){
								//生成路径表
								var _routess=new Array();
								_routess=json[0];
								if(_routess!=null && _routess!="" && _routess!=[]){
									generaterRoutes(_routess);
								}else{
									_deleteMsg();
									_setMsg("请输入正确的节点名称");
								}
								
								//画图
								var _nodes=new Array();
								_nodes=json[1];
								
								var _relations=new Array();
								_relations=json[2];
								
								if(_nodes!=null && _nodes!="" && _relations!=null && _relations!="" ){
									_draw(_nodes,_relations);
								}
								
							}else{
								_deleteMsg();
								_setMsg("请输入正确的节点名称");
							}
						}else{
							_deleteMsg();
							_setMsg("请先输入节点数初始化拓补图");
						}
					}
				}
				xmlhttp.open("POST", "getRoutes", true);
				xmlhttp.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");
				xmlhttp.send("start="+start+"&end="+end);
		}
	   
} 

/* 生成路径表 */
function generaterRoutes(_routes){
	
	if (_routes != null || _routes != "") {
		
		removeRoutes();
		
		var tabNode = document.getElementById("myTbody");
		for(var i=0;i<_routes.length;i++){
			var trNode = tabNode.insertRow(); 			
			for(var j=0;j<4;j++){
				 var tdNode=trNode.insertCell(); 
				 var text="";
				 if(j==0){
					 text=i+1;
				 }else if(j==1){
					 text=_routes[i].route;
				 }else if(j==2){
					 text=_routes[i].weights;
				 }else if(j==3){
					 text=_routes[i].length;
				 }
			     tdNode.innerHTML=text; 
			}
			
		}				    
	} 
} 

/* 删除路径表 */
function removeRoutes(){
	var tb = document.getElementById("myTable");
	//var tb = document.getElementById('attAchments');
    var rowNum=tb.rows.length;
    for (i=1;i<rowNum;i++)
    {
        tb.deleteRow(i);
        rowNum=rowNum-1;
        i=i-1;
    }
}

/*
 * 下一步
 */
function _nextRoutes(){
	 _deleteMsg();
	 var xmlhttp;  
		if (window.XMLHttpRequest) {
			// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {		
				 
				 var result =xmlhttp.responseText;
				if(result!=null && result!=""){
					var json = eval("(" + result + ")");
					
					//最大权值
					var _maxNodes=new Array();
					_maxNodes=json[0];
					if(_maxNodes!=null && _maxNodes!=""){
						_deleteMaxWeight();
						_setMaxWeight(_maxNodes);
					}
						
					//节点
					var _nodes=new Array();
					_nodes=json[1];
									
					//节点关系
					var _relations=new Array();
					_relations=json[2];
					
					//画图
					if(_nodes!=null && _nodes!="" && _relations!=null && _relations!=""){
						_draw(_nodes,_relations); 
					}
					
					
					//路径
					var _routess=new Array();
					_routess=json[3];
					if(_routess!=null && _routess!=""){						
						for(var i=0;i<_routess.length;i++){
							if(_routess[i].length==_maxNodes[0].weight){
								_deleteMsg();
								_setMsg("生成最终路径");
							}
						}
					}
					
					generaterRoutes(_routess);
				}else{
					_deleteMsg();
					_setMsg("请选择节点生成路径");
				}
				
			}
		}
		xmlhttp.open("GET", "nextRoutes", true);
		//xmlhttp.setRequestHeader("Content-type",
				//"application/x-www-form-urlencoded");
		xmlhttp.send();
}
/*
 * 获得节点和关系数据
  */
function _getNodes(num){ 
	
	    var xmlhttp;  
		if (window.XMLHttpRequest) {
			// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {		
				var result = xmlhttp.responseText;
				if(result!=null && result!=[] && result!=""){
					var json = eval("(" + result + ")");
					
					//节点
					var _nodes=new Array(); 
					_nodes=json[0];
	    	
			    	//节点权值
			    	var _relations=new Array(); 
					_relations=json[1];
	   				
					//画图
					if(_nodes!=null && _nodes!="" && _relations!=null && _relations!=""){
						_draw(_nodes,_relations); 
					}
			    	
				}
	 	
			}
		}
		xmlhttp.open("POST", "generateNodes", true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("num="+num);
} 

/**
 * 根据数据库中的节点画图 
 */
function getOldNodes(){
	var xmlhttp;  
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {		
			var result = xmlhttp.responseText;
			if(result!=null && result!=[] && result!=""){
				var json = eval("(" + result + ")");
				
				//节点
				var _nodes=new Array(); 
				_nodes=json[0];
    	
		    	//节点权值
		    	var _relations=new Array(); 
				_relations=json[1];
   				
				//画图
				if(_nodes!=null && _nodes!="" && _relations!=null && _relations!=""){
					_draw(_nodes,_relations); 
				}
		    	
			}
 	
		}
	}
	xmlhttp.open("GET", "getOldNodes", true);
	/* xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded"); */
	xmlhttp.send();
}




//重置节点
function resetNodes() {
	_deleteMsg();
	_deleteMaxWeight();
	removeRoutes();
	var xmlhttp;  
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {		
			var result = xmlhttp.responseText;
			if(result!=null && result!=[] && result!=""){
				var json = eval("(" + result + ")");
				
				//节点
				var _nodes=new Array(); 
				_nodes=json[0];
    	
		    	//节点权值
		    	var _relations=new Array(); 
				_relations=json[1];
   				
				//画图
				if(_nodes!=null && _nodes!="" && _relations!=null && _relations!=""){
					_draw(_nodes,_relations); 
				}
		    	
			}else{
				_setMsg("请先输入节点数初始化拓补图");
			}
 	
		}
	}
	xmlhttp.open("GET", "resetNodes", true);
	/* xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded"); */
	xmlhttp.send();
}
