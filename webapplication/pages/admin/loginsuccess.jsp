<%
 String userid=(String)session.getAttribute("adminUserID");
if(userid == null)
{
	response.sendRedirect("./pages/admin/adminlogin.jsp");
	
}else{
%> 
 <%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

 <%
	 /*
 String userid=(String)session.getAttribute("adminUserID");
if(userid == null)
{
	response.sendRedirect("./adminlogin.jsp");
	
}else{
	*/
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

<%@ include file="top.jsp"%>  


<table align="center" width="100%">
		<tr>
		       <td valign="top" align="center">

                 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
					<tr>
						

                          

							<td align="center" width="75%" >
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
							
								<tr><td align ="left" colspan="3" valign="top" height="100"><strong>Welcome to the administrative back end!</strong><br></td>
								</tr>
								<tr>
									<td valign="top" align="center">
									 
                                      

									</td>
									
								</tr>
							</table>
							</td>
						
					</tr>
                 </table>


			   </td>
  </tr>
          
</table>

<%@ include file="bottom.jsp"%>

</body>
</html:html>
<%
}	
%>