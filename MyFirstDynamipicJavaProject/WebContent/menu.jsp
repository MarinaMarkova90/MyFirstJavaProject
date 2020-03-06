<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8181/MyFirstDynamipicJavaProject/css/styles.css"/>
</head>


<body>
<form  action="MenuServlet" > 
<br><br><br><br>
<div align="center" > 
<p> ${mess_txt} <p>

</div>
	<div class="header" align="center"> Library for movies.
<br><br>

<table>
<tr>
<td class="header1"> Loading data: </td>  	<td> <input type="submit" name="load" value="Load" class="button_kind">


	<tr> 
	<td class="header1">
	
Add movie:
</td> <td> <input type="submit"  name="btn_add" value="Add" class="button_add" ></td>

<tr> <td class="header1"> Report with filter radio button :</td>

<td> <input type="submit" name="button_report" value="Report1" class="button_report">

</td>

</tr>
<tr> 
<td class="header1">
Report with filter text box:</td>	<td> <input type="submit" name="button_kind" value="Report2" class="button_kind"> 
</td>
	</tr> 
	
<tr> 
<td class="header1"> 
Delete: </td> <td><input type="submit" name="button_delete" class="button_kind" value="Delete" /> </td>
</table>

</div>
</form>
</body>
</html>