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
	<input type="hidden" name="mid">
	影视名称:<input type="text" name="mname"><br><br>
	影视介绍:<input type="text" name="introduction"><br><br>
	
	<div id="div1">
			影视类型:
	</div><br>
	导演:<input type="text" name="author"><br><br>
	发行日期:<input type="date" name="mdate"><br><br>
	<input type="button" value="保存" onclick="update()">
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
		$.post("queryById.do",{"mid":"${param.mid}"},function(data){
			$("[name='mid']").val(data.mid);
			$("[name='mname']").val(data.mname);
			$("[name='introduction']").val(data.introduction);
			var tids = data.tids.split(",");
			$("[name='tids']").each(function(){
				for ( var i in tids) {
					if(tids[i]==this.value){
						this.checked=true;
					}
				}
			});
			$("[name='author']").val(data.author);
			$("[name='mdate']").val(data.mdate);
		});
	});
});
function update(){
	$.post("update.do",$("form").serialize(),function(data){
		if(data){
			alert("数据修改成功!");
			location="list.do";
		}
	});
}
</script>
</html>