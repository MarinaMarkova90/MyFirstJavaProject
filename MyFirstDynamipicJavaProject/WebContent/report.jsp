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
<form action="ReportServlet">
<div class="back_line">
<input type="submit" name="btn_back" value="BACK" class="button_back"> 
<br>




</div>

 <h1 align="center" class="header"> Reports
  </h1> <br>

 <table align="center">
<tr>
<td
 class="header1" align="center">select the kind movies 
</td>   
<td >  
</td>
<td>
</td>
</tr>
 <tr>
 <td>
 movies
 </td>
 <td> <input type="radio" name="check_movies" checked value="movies">  </td>
 <td>
 </td>
 </tr>
 <tr>
 <td>
 reality show
 </td>
 <td>
 <input type="radio" name="check_movies" value="reality"  > 
 </td>
 <td>
 </td>
  </tr>
       
 <tr>
 <td>
 kinder movies
 </td>
<td> <input type="radio" name="check_movies" value="kinder">  </td>
 <td>
 </td>
</tr>
</table>

 <div align="center">
 <br>
 <br>
 <input type="submit" name="submit" value="Report" class="button_reset"> 
 
 </div>
<div  align="center">

  ${report_place}
  
  
 </div>


</form>
</body>
</html>