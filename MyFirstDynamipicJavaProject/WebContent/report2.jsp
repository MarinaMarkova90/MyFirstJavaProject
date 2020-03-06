<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8181/MyFirstDynamipicJavaProject/css/styles.css"/>
</head>
<body>
<form action="Report2Servlet">
<div>
<input type="submit" name="btn_back" class="button_back" value="BACK">
<h2 class="header1">Back to menu.
 </h2>
</div>

<div>
 <h2 class="header" align="center"> Report 2  
 </h2>
</div>

<table align="center">
 <tr>
 <td class="header1" align="center">select the kind movies 
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
 <h2 align="center"> 
 Movie name <br>
 <input type="text" name="movie_name" style="width: 467px; height: 45px; ">
 </h2>
 </div> 
 <div align="center">
<input type="submit" name="" value="Search" class="button_report" >
</div>
<div  align="center">

  ${report_place}
  
  
</div>






</form>

</body>
</html>