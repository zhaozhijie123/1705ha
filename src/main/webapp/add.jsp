<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css">
<script type="text/javascript" src="jquery-1.8.2.min.js"></script>
</head>
<body>
<form action="">
	影视名称:<input type="text" name="mname"><br><br>
	影视介绍:<input type="text" name="introduction"><br><br>
	
	<div id="div1">
			影视类型:
	</div><br>
	导演:<input type="text" name="author"><br><br>
	发行日期:<input type="date" name="mdate"><br><br>
	<input type="button" value="保存" onclick="add()">
</form>
</body>
<script type="text/javascript">
$(function(){
	$.post("findType.do",function(data){
		var str = "";
		for ( var i in data) {
			str += "<input type='checkbox' name='tids' value='"+data[i].tid+"'>"+data[i].tname+"&nbsp;";
		}
		$("#div1").append(str);
	});
});
function add(){
	$.post("add.do",$("form").serialize(),function(data){
		if(data==0){
			location="success.jsp";
		}else if(data==1){
			alert("影视名称不能为空!");
		}else if(data==2){
			alert("导演名称不能为空!");
		}else if(data==3){
			alert("电影介绍不能为空!");
		}else if(data==4){
			alert("发行日期不能为空!");
		}else if(data==5){
			alert("电影类型不能为空!");
		}
	});
}
</script>
</html>