
  <%
 String userid=(String)session.getAttribute("UserID");
if(userid == null)
{
	response.sendRedirect("../pages/user/userlogin.jsp");
	
}else{
%> 
 <%@ taglib uri="/tags/struts-bean" prefix="bean" %>
 <%@ taglib uri="/tags/struts-html" prefix="html" %>
 <html:html locale="true">
 <head>
 <title></title>
 <html:base/>
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

<html:form action="/user/AddEditOrderedcart"  method="post" onsubmit="return validateForm(this);">
   <html:hidden property="orderid" />
   <html:hidden property="action"/>
   <html:hidden property="actionUpdateData"/>
   
   <html:errors/>
   <table>

 <tr>
      <td align="center" colspan="2">
       <font size="4">Please Enter the Following Details</font>
      </td>
 </tr>
 <tr>
      <td align="right">Product Id</td>
      <td align="left">
         <html:text property="productid" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr>
      <td align="right">name</td>
      <td align="left">
         <html:text property="name" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr>
      <td align="right">price</td>
      <td align="left">
         <html:text property="price" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr>
      <td align="right">quantity</td>
      <td align="left">
         <html:text property="quantity" size="30" maxlength="120"/>
      </td>
 </tr>
   <tr>
      <td align="center" colspan="2">
          <html:submit>Save</html:submit>
			&nbsp;
		  <html:cancel>Cancel</html:cancel>
      </td>
 </tr>
 </table>
 </html:form>
 </body>
 </html:html>
<%
}			  
%>