
 
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
 <title></title>
 <html:base/>
<SCRIPT LANGUAGE=javascript>
<!--
function validateForm(formObj){


	 if(formObj.categoryname.value.length==0){
		alert("Please enter Category Name!");
		formObj.categoryname.focus();
		return false;
   }
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

<html:form action="/category/Edit"  method="post" onsubmit="return validateForm(this);">

   <html:hidden property="action"/>
   <html:hidden property="actionUpdateData"/>
   
<table align="center">
<tr bgcolor="#6699CC">
<td>
<table bgcolor="#FFFFFF">

 <tr>
      <td align="center" colspan="2">
       <font size="4">Please Enter the Following Details</font>
      </td>
 </tr>

  <tr><td colspan="2" align="center"><font color="red"><html:errors/></font>&nbsp;</td></tr>

 <tr>
      <td align="right"><b>Category Id:</b></td>
      <td align="left">
         <html:text property="categoryid" size="30" maxlength="120" readonly="true"/>
      </td>
 </tr>


 

  <tr>
      <td align="right"><b>Category Name:</b></td>
      <td align="left">
         <html:text property="categoryname" size="30" maxlength="120"/>
      </td>
 </tr>
  


  <tr>
      <td align="right"><b>Parent Id:</b></td>
      <td align="left">
         <html:text property="parentid" size="30" maxlength="120" readonly="true"/>
      </td>
 </tr>
 


   <tr>
      <td align="center" colspan="2">
          <html:submit>Save</html:submit>
			
      </td>
 </tr>
 </table>
 </td>
 <tr>
 </table>
 </html:form>
 <%@ include file="bottom.jsp"%>
 </body>
 </html:html>
<%}%>