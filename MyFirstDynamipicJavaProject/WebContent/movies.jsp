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
<form action="MoviesServlet">

<div class="back_line">        <input type="submit" value="BACK" name="btn_back"  class="button_reset" >    </div>
<br>
 Back to previous page.


 <div align="center"> 
 
 <p class="header"> Movies library </p>
 
 
 <table>
 
 <tr class="header1"> <th colspan="2"> kind movie  </th>     <th> movie name </th><th>   </th>   </tr> 
 <tr> <td> movie:</td>   <td>    <input type="radio" name="ticket_name" value="movies" checked>  </td>  
 
  <td rowspan="3"> 
  
  <textarea rows="6" cols="50" name="description" ></textarea>
  
 
  
  </td>    </tr>
 
 <tr> <td>reality show: </td>   <td> <input type="radio" name="ticket_name" value="reality">  </td>   <td> </td>    </tr>
  <tr> <td>kinder movies: </td>   <td> <input type="radio" name="ticket_name" value="kinder"> </td>   <td> </td>    </tr>
 <tr > <td> <br> <br></td>  <td> </td><td> </td>      </tr>
 
  <tr > <td colspan="3" align="center" >     <input  type="submit" value="ADD Movie" class=button_add> <input type="reset" class="button_reset">  </td>    </tr>
 
 </table>
 
 
 
      <br> <br> <br> 
            
      
    
      <br> <br> <br> 

        <div class="container">
        <p> ${mess_txt} </p>
        
        </div>
 


  </div>
  </form>
</body>
</html>