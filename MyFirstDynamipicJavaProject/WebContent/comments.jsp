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
<form action="CommentsServlet"     NAME="form1"  METHOD="POST"    >

  <div class="back_line">        <input type="submit" value="BACK" name="back"  class="button_reset" >           </div>
  <br>
   Back to previous page.
 <div align="center">
 
 <p class="header"> actor in  ${mess1_txt}  </p>




    <table>
    <tr>   <th>  <th>   <th> </th>    <th> </th>    <th> </th>      </tr> 
    
    <tr>   <td> actor name: <td>   <td>  <input type="text" name="aname"></td>    <td> </td>    <td> </td>      </tr> 
    <tr>   <td>nationality:  <td>   <td>  <input type="text" name="nacionality"> </td>    <td> </td>    <td> </td>      </tr> 
    <tr>   <td>other movies: <td>   <td> <input type="text" name="text"> </td>    <td> </td>    <td> </td>      </tr> 
    <tr>   <td> <br> </td>   <td> </td>    <td> </td>    <td> </td>      </tr> 
    
    </table>
      
      
 <br>
      
      
   
     <table>
    <tr >   <td align="center">  <input type="submit" value="ADD" name="btn_comments"  class="button_add">   <input type="reset" class="button_reset">  </td>         </tr> 
    
     </table> 
      
      
     
      
      

     <br><br> 
      

      
      
      
      
        <div class="container">
        <p> ${mess_txt} </p>
        
        </div>
 
      
      </div>

</form>







</body>
</html>