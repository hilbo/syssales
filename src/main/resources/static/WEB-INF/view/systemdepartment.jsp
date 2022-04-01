<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sistema</title>
</head>
<body>
	<div style="border: solid 0mm; width: auto; text-align: center;">
		<font style="color: blue; font-size: 25px; font-family: sans-serif;">DEPARTMENT</font>
	</div>
	<br>
	<form>
		<table style="width: 100%;height: auto; border: solid; border-width: 0.5mm ">
			<tr style="width: 100%; border: solid;"> 
				<td style="width: 50%; border: none;"><font style="width: 20px; font-family: sans-serif;">Inserir department:  </font>
				<input style="width: 300px " type="text" name="depName">  
				<input type="hidden" name="class" value="SystemDepartment">
				<input type="hidden" name="method" value="insert">
				<button formaction="controllersystem" formmethod="post" style="position: static; width: 150px">INSERIR</button></td>
			</tr>
		</table>
		</form>
		<form>
		<br><br>
		<table style="width: 100%;height: auto; border: solid; border-width: 0.5mm ">
			<tr style="width: 100%; border: solid;"> 
				<td style="width: 50%; border: none;"><font style="width: 20px; font-family: sans-serif;">Lista completa:  <input type="hidden" name="class" value="SystemDepartment"> </font><button formaction="controllersystem" formmethod="post" type="submit" name="method" value="findAll" style="width: 80px">LISTAR</button></td>
				<td style="width: 50%; border: none;"><font style="width: 20px; font-family: sans-serif;">Busca por nome:  <input type="text" name="depName"></font>  <button formaction="controllersystem" formmethod="post" type="submit" name="method" value="findPerName" style="width: 80px">BUSCAR</button></td>
			</tr>
		</table>
		</form>
	<br><br>
	<c:set var="statuspage" value="${status}"/>
		<font color="red" style="font-size: 25px; font-family: sans-serif;">${statuspage}</font>
	<c:import url="/WEB-INF/view/departmentfindall.jsp"></c:import>
</body>
</html>