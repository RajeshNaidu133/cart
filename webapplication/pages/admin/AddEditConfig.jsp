
<%
 String userid=(String)session.getAttribute("adminUserID");
if(userid == null)
{
	response.sendRedirect("../pages/admin/adminlogin.jsp");
	
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

<SCRIPT LANGUAGE=javascript>
<!--
function validateForm(formObj){
   //TO DO Add Java Script Validation Code Here
   /*
   if(formObj.link.value.length==0){
		alert("Please enter URL of Tutorial!");
		formObj.link.focus();
		return false;
   }
   */
   formObj.actionUpdateData.value="update";
   return true;
}
//-->
</SCRIPT>

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
							
								<tr><td align ="left" colspan="3" valign="top">
								
								             <br><br>

<html:form action="/admin/config"  method="post" onsubmit="return validateForm(this);">
   <html:hidden property="id" />
   <html:hidden property="action"/>
   <html:hidden property="actionUpdateData"/>
   
   <html:errors/>
<table align="center" cellpadding="0" cellspacing="1" bgcolor="#6699CC" width="60%">
<tr bgcolor="#FFFFFF">
<td align="center" bgcolor="#D9EAFD" colspan="2"><b>Configuration</b></td>
</tr>
 <tr bgcolor="#FFFFFF">
      <td width="50%">Store name:</td>
      <td width="50%"><html:text property="storename" size="30" maxlength="120"/></td>
  </tr>
    <tr bgcolor="#FFFFFF">
      <td>Store URL:</td>
      <td> <html:text property="storeurl" size="30" maxlength="120"/></td>
    </tr>
	<!--
    <tr bgcolor="#FFFFFF">
      <td>General contact email address:</td>
      <td><input type="text" name="generalcontactemailaddress"></td>
    </tr>
	-->
    <tr bgcolor="#FFFFFF">
      <td>Order notifications email:</td>
      <td><html:text property="ordernoticeemail" size="30" maxlength="120"/></td>
    </tr>
	<tr bgcolor="#FFFFFF">
	<td align="center" bgcolor="#D9EAFD" colspan="2"><b>Currency</b></td>
	</tr>
	
    
    <tr bgcolor="#FFFFFF">
      <td>Currency symbol
(shown left to the price value):</td>
      <td> <html:text property="cursymbol" size="30" maxlength="120"/></td>
    </tr>
	
    <tr bgcolor="#FFFFFF">
      <td></font>Currency ISO3 code
(e.g. USD, EUR, GBP):</td>
      <td> <html:text property="curcode" size="30" maxlength="120"/></td>
    </tr>
	<tr bgcolor="#FFFFFF">
	<td align="center" bgcolor="#D9EAFD" colspan="2"><b>Auxiliary information</b></td>
	</tr>
	<tr bgcolor="#D9EAFD">
	
	     <td align="center">About Us</td>
		 <td align="center">Shipping & Delivery</td>
	
	</tr>
    <tr bgcolor="#FFFFFF">
      <td><html:textarea property="aboutustext" cols="35" rows="20"/></td>
      <td><html:textarea property="shipdeltext" cols="35" rows="20"/></td>
    </tr>
   
	<tr bgcolor="#FFFFFF">
	<td align="center" colspan="2" bordercolor="#00FFCC" bgcolor="#FFFFFF"><html:submit>Save</html:submit></td>
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