<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%

String ustorename=(String)request.getAttribute("ustorename");

%>

<html:html locale="true">
<head>
<title>index page</title>
<html:base/>
<style type="text/css">


A:active { COLOR: green; TEXT-DECORATION: none } 
A:hover { COLOR: red; TEXT-DECORATION: none; font-weight: none }

</style>
</head>

<body>


<%@ include file="../top.jsp"%>  
<%@ include file="../left.jsp"%>


								
				 <html:form method="post" action="/user/login">
						<table bgcolor="#333333" border="0" cellpadding="2" cellspacing="1" bordercolor="#6699CC" align="center">
						<tbody>
						<tr bgcolor="#6699CC">
						   <td colspan="2" align="center"><b><font color="white">User Login</font></b></td>
						  </tr>
						  <tr>
							<td align="center" colspan="2" bgcolor="#FFFFFF" valign="middle"><font color="red" size="2"><html:errors/></font></td>
						 </tr>
							  <tr bgcolor="#ffffff"> 
								<td align="right"><b>Logn ID:</b></td>
								<td> 
								  <html:text property="userid" size="30" maxlength="30"/>
						  </tr>
							  <tr bgcolor="#ffffff"> 
								<td align="right"><b>Password:</b></td>
								<td> 
								  <html:password property="password" size="30" maxlength="30"/></td>
						  </tr>


						  
						 
						  
							 <tr bgcolor="#ffffff">
								 <td  align="center" colspan="2"><html:submit>Sign-In !</html:submit></td>
							 </tr> 


							<tr bgcolor="#ffffff"> 
								<td align="right" colspan="2"><html:link page="/pages/user/AddEditUser.jsp"><b>New User Register Here !</b></html:link></td>
								
						  </tr>


						</tbody>
						</table>

    
				</html:form>

			
<%@ include file="../bottom.jsp"%>

</body>
</html:html>