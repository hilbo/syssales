<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Lyonte Tecnologia</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<table style="border: solid; border-bottom: none; border-width: 0.1mm; border-color: white; width: 100% ">
		<tr style="background-color:  #D3D3D3; border: solid; border-width: 0.2mm; border-color: #C0C0C0;">
			<td WIDTH="8.7%" style="color: black; border: none; border-width: 0.2mm; border-color: #C0C0C0; font-size: 20px; font-family: sans-serif;">Id</td>
			<td WIDTH="80%px" style="color: black; border: none; border-width: 0.2mm; border-color: #C0C0C0;  font-size: 20px; font-family: sans-serif;">Department</td>
		</tr>
	</table>
	<c:forEach var="dep" items="${list}">
		<form action="system" method="post">
			<table style="border: solid; border-bottom: none; border-width: 0.1mm; border-color: white; width: 100% ">
				<tr>
					<td WIDTH="10%" style="border: solid; border-width: 0.2mm; border-color: #C0C0C0; font-size: 15px; font-family: sans-serif; ">${dep.id}
					<td />
					<td WIDTH="80%" style=" border: solid; border-width: 0.2mm; border-color: #C0C0C0; font-size: 15px; font-family: sans-serif;">${dep.name}
					<td />
					<td WIDTH="30px"><button formaction="" formmethod="post" type="submit" name="logica"
							value="DeleteDepartment">Apagar</button></td>
					<td WIDTH="30px"><button formaction="" formmethod="post" type="submit" name="logica"
							value="OpenUpdateDepartment">Alterar</button></td>
				</tr>
			</table>
		</form>
	</c:forEach>
<br>
<font color="red" size=+2 face="arial">${statuserror}</font>
<font color="blue" size=+2 face="arial">${statusok}</font>
<font color="red" size=+2 face="arial">${statusname}</font>
<br>
<br>
<br>
<br>
</body>
</html>