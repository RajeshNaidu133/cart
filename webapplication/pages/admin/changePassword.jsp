<%
 String userid=(String)session.getAttribute("adminUserID");
if(userid == null)
{
	response.sendRedirect("./pages/admin/adminlogin.jsp");
	
}else{
%> 
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>


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
<%@ include file="left.jsp"%>


<table align="center" width="100%">
		<tr>
		       <td valign="top" align="center">

                 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
					<tr bgcolor="white">
						

                          

							<td align="center" width="75%" >
                            <%@ include file="configHeader.jsp"%>  
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
							<tr >
									<td valign="top" align="center" >
									




                <html:form action="/admin/changepwd" method="post" >
			  
			      <table border="0" cellspacing="1" cellpadding="1" width="50%" bgcolor="#6699CC">
				  <tr bgcolor="#FFFFFF">
				     <td align="center" colspan="2"><font size="5">Change Password</font></td>
				  </tr> 
				 
				  <!-- display errors -->
					  <tr bgcolor="#FFFFFF">
							<td colspan="2" align="center"><font color="red" size="2"><html:errors/></font></td>
					  </tr>
                  
				  <tr align="center" bgcolor="#FFFFFF">
					  <td align="right"><b>Old Password:</b><font color="red">*</font></td> 
					  <td><html:password property="oldpassword" size="30" maxlength="30"/></td>
				 </tr>  
				 <tr align="center" bgcolor="#FFFFFF">
					  <td align="right"><b>New Password:</b><font color="red">*</font></td> 
					  <td><html:password property="newpassword" size="30" maxlength="30"/></td>
				 </tr> 
				 
				 <tr align="center" bgcolor="#FFFFFF">
					  <td align="right"><b>Confirm New Password:</b><font color="red">*</font></td> 
					  <td><html:password property="cnewpassword" size="30" maxlength="30"/></td>
				 </tr> 

                 

				  <tr bgcolor="#FFFFFF">
				      <td  align="center" colspan="2"><html:submit>Change Password</html:submit></td>
				 </tr> 
				 </table>
           </html:form>


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