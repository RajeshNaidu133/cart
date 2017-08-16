<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<html:html locale="true">
<head>
	
</head>
	<html:base/>

  

<body>

<center>
   
  <table align="center" width="100%">
		<tr>
		      
				<td valign="top" align="center">
			

      <html:form method="post" action="/admin/login">
			<table bgcolor="#333333" border="0" cellpadding="2" cellspacing="1" bordercolor="#6699CC">
			<tbody>
			<tr bgcolor="#6699CC">
			   <td colspan="2" align="center"><b><font color="white">Administrator Login</font></b></td>
			  </tr>
			  <tr>
				<td align="center" colspan="2" bgcolor="#FFFFFF" valign="middle"><font color="red" size="2"><html:errors/></font></td>
			 </tr>
				  <tr bgcolor="#ffffff"> 
					<td align="right"><b>Login Id:</b></td>
					<td> 
					  <html:text property="userid" size="30" maxlength="30"/>
			  </tr>
				  <tr bgcolor="#ffffff"> 
					<td align="right"><b>Password:</b></td>
					<td> 
					  <html:password property="password" size="30" maxlength="30"/></td>
			  </tr>
			  		  
			  </tr>
			  
				 <tr bgcolor="#ffffff">
					 <td  align="center" colspan="2"><html:submit>Sign-In !</html:submit></td>
				 </tr> 

			</tbody>
			</table>

    
  </html:form>



 </td>
  </tr>
          
</table>

</center>
<body>
</html:html>