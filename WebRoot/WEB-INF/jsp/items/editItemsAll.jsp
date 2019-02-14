<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
function editItemsAllSubmit(){
	//提交form
	document.itemsForm.action="${pageContext.request.contextPath }/items/editItemsAllSubmit.action";
	document.itemsForm.submit();
}
function queryItems(){
//提交form
	document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems.action";
	document.itemsForm.submit();
}
</script>
</head>
<body> 
<form name="itemsForm" action="${pageContext.request.contextPath }/items/queryItems.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
	<td>
	商品名称：<input type="text" name="itemsCustom.name" /><!-- 注意与ItemsQueryVo.java的属性名保持一致 -->
	</td>
</tr>
<tr>
<td><input type="button" onclick="queryItems()" value="查询"/></td>
<td><input type="button" onclick="editItemsAllSubmit()"  value="批量提交"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	
</tr>
<c:forEach items="${itemsList}" var="item" varStatus="status" >
<input type="hidden" name="itemsCustomList[${status.index}].id" value="${item.id }"/>
<tr>
	<td><input type="text" name="itemsCustomList[${status.index}].name" value="${item.name }"/></td>
	<td><input type="text" name="itemsCustomList[${status.index}].price" value="${item.price }"/></td>
	<td><input type="text" name="itemsCustomList[${status.index}].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
	<td><input type="text" name="itemsCustomList[${status.index}].detail" value="${item.detail }"/></td>
</tr>
</c:forEach>

</table>
</form>
</body>

</html>