<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css">
<script type="text/javascript" src="jquery-1.8.2.min.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$("#qx").click(function(){
		$(":checkbox").attr("checked",true);
	});
	$("#qbx").click(function(){
		$(":checkbox").attr("checked",false);
	});
	$("#fx").click(function(){
		$(":checkbox").each(function(){
			this.checked=!this.checked;
		});
	});
});
function del(){
	var ids=$(":checkbox:checked").map(function(){
		return $(this).val();
	}).get().join(",");
	if(ids==null || ids==''){
		alert("删除的数据不能为空,请选择您要删除的数据!");
	}else{
		if(confirm("您确定要删除编号为  "+ids+" 的数据吗?")){
			$.post("deleteAll.do",{"ids":ids},function(data){
				if(data){
					alert("删除成功!");
					location="list.do";
				}
			});
		}
	}
}
</script>
<body>
<form action="list.do" method="post">
电影名称:<input type="text" name="mname" value="${mname}">
<input type="submit" value="搜索">
</form>
<input type="button" value="批量删除" onclick="del()">
<a href="add.jsp"><input type="button" value="添加影视"></a>
<table>
	<tr>
		<td>
			<input type="button" value="全选" id="qx">
			<input type="button" value="全不选" id="qbx">
			<input type="button" value="反选" id="fx">
		</td>
		<td>电影编号</td>
		<td>电影名称</td>
		<td>电影介绍</td>
		<td>电影类型</td>
		<td>导演</td>
		<td>发行日期</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${page.list }" var="m">
		<tr>
			<td>
				<input type="checkbox" name="mid" value="${m.mid }">
			</td>
			<td>${m.mid }</td>
			<td>${m.mname }</td>
			<td>${m.introduction }</td>
			<td>${m.tname }</td>
			<td>${m.author }</td>
			<td>${m.mdate }</td>
			<td>
				<a href="update.jsp?mid=${m.mid }"><input type="button" value="修改"></a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="10">
			当前${page.pageNum}页/共${page.pages}页&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="?pageNum=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="?pageNum=${page.pageNum-1<1?page.pageNum:page.pageNum-1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="?pageNum=${page.pageNum+1>page.pages?page.pageNum:page.pageNum+1 }">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="?pageNum=${page.pages }">尾页</a>
		</td>
	</tr>
</table>
</body>
</html>