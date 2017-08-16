
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%

 String storename= (String)session.getAttribute("storename");
 
%>
          
<table border="0" width="100%" cellpadding="0" cellspacing="0"> 
<tr>
				<td align="left" colspan="2" width="50%">
					<p><font size="6" face="Monotype Corsiva" style="color: #6699CC"><%=storename%></font></p>				
				</td>
				<td align="right">
				
				    <%if((String)session.getAttribute("adminUserID") != null){ %> <html:link page="/logout.do"> Logout</html:link> <%}else{%>
											
						<html:link page="/pages/admin/adminlogin.jsp">Login</html:link>
                        <%}%>
				
				</td>
				
				
				     
  </tr>

          <tr>
				<td align="center" bgcolor="#6699CC" width="25%">

					
					<html:link page="/pages/admin/loginsuccess.jsp"><font color="white">Home</font></html:link>
					
					</td>
					<td width="25%" align="center" bgcolor="#6699CC">
											
						<html:link page="/catelog.do"><font color="white">Catelog</font></html:link>

					</td>

					<td bgcolor="#6699CC" align="center" width="25%">

						
                        <html:link page="/admin/showorders.do"><font color="white">Orders</font></html:link>

					</td>

					<td bgcolor="#6699CC" align="center" colspan="1"> 

				
                     <html:link page="/pages/admin/config.jsp"><font color="white">Configuration</font></html:link>
				


					</td>
				   			
           </tr>
			
<tr> <td colspan="5">&nbsp;</td></tr>
</table>
  
	  
