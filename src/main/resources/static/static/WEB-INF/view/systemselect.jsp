<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>SYSTEM</title>
</head>
<img alt="" src="image/logo.jpg" />
<img alt="" src="image/nome_empresa.jpg" />
<br>
<br>
<body>
	<div style=" border: solid 0mm; width: auto; text-align: center;">
		<font style="color: blue; font-size: 25px; font-family: sans-serif;">SISTEMA DE VENDAS</font>
	</div>
	<br><br><br>
	<form method="post" style="width: 100%; height: auto; text-align: center;">
		<font style="width: 40%;"><button formaction="controllerdirection" type="submit" name="method" value="department" style="width: 49.8%; height: 50px; border: solid; border-color: white; background-color: #4169E1; cursor: pointer; color: white; font-size: 15px " title="Department">DEPARTMENTS</button></font>
		<font style="width: 40%;"><button formaction="controllerdirection" type="submit" name="method" value="department" style="width: 49.8%; height: 50px; border: solid; border-color: white; background-color: #4169E1; cursor: pointer; color: white; font-size: 15px "title="Sellers">SELLERS</button></font>
	</form>
	<br>
	<br>
			
	<c:set var="pagesystemselect" value="${page}"></c:set>
	<c:if test="${pagesystemselect == null}">
		<c:import url="/WEB-INF/view/empty.jsp"></c:import>
	</c:if>
	<c:if test="${pagesystemselect != null}">
		<c:import url="${pagesystemselect}"></c:import>
	</c:if>
	
</body>
<footer style="position: static; bottom: 0">
	<img height="60" align="middle" src="image/rodape.jpg" />
</footer>
</html>