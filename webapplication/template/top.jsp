<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%

 String sstorename=(String)session.getAttribute("sstorename");

 if((sstorename==null) || (sstorename.equals(""))){
 
   sstorename=(String)request.getAttribute("ustorename");

 }

 //System.out.println("Storename:"+sstorename);

%>
          
<table border="0" width="100%" cellpadding="0" cellspacing="0"> 
<tr>
				<td align="left" colspan="2" width="50%">
<p><font size="6" face="Monotype Corsiva" style="color: #6699CC"><%=sstorename%></font></p>				
				</td>
                 
				 <td align="right" colspan="2">

                       
						<%if((String)session.getAttribute("UserID") != null){ %> <html:link page="/userlogout.do"> <font color="Red">Logout</font></html:link> <%}else{%>
											
						<html:link page="/pages/user/userlogin.jsp"><font color="red">Login</font></html:link>
                        <%}%>

					</td>

				
				
				     
  </tr>

          <tr>
				<td align="center" bgcolor="#6699CC" width="20%">

					
					<html:link page="/cart/Welcome.do"><font color="white"> Home</font></html:link>
					
					</td>
					<td width="20%" align="center" bgcolor="#6699CC">
											
						<html:link page="/product/pricelist.do?page=price"><font color="white">Price List</font></html:link>

					</td>

					

                   <td width="20%" align="center" bgcolor="#6699CC">
											
						

						<%if((String)session.getAttribute("UserID") != null){ %> <html:link page="/user/AddEditUser.do?action=Edit"> <font color="white">Update Profile</font></html:link> <%}else{%>
											
						<html:link page="/pages/user/AddEditUser.jsp"><font color="white">Register / Sign Up</font></html:link>
                        <%}%>




					</td>
					

					<td bgcolor="#6699CC" align="center" width="20%">

						
                        <html:link page="/pages/aboutus.do"><font color="white">About us </font></html:link>

					</td>

					<td bgcolor="#6699CC" align="center" width="20%"> 

				
                     <html:link page="/pages/shipdel.do"><font color="white">Shipping and delivery</font></html:link>
				


					</td>
				   			
           </tr>
			
<tr> <td colspan="5">&nbsp;</td></tr>
</table>
  
	  
