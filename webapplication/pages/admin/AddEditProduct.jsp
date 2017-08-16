 <%
 String userid=(String)session.getAttribute("adminUserID");
if(userid == null)
{
	response.sendRedirect("../pages/admin/adminlogin.jsp");
	
}else{



String csymbol=(String)request.getAttribute("csymbol");



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


	 if(formObj.productname.value.length==0){
		alert("Please enter Product Name!");
		formObj.productname.focus();
		return false;
   }

   if(formObj.productprice.value.length==0){
		alert("Please enter Product Price!");
		formObj.productprice.focus();
		return false;
   } 


    
   if(isNaN(formObj.productprice.value)){
		alert("Please enter correct Product Price!");
		formObj.productprice.focus();
		return false;
   }


 if(formObj.listprice.value.length !=0){
		
      if(isNaN(formObj.listprice.value)){
		alert("Please enter correct List Price !");
		formObj.listprice.focus();
		return false;
	}
     

   } 


     if(formObj.quantity.value.length==0){
		alert("Please enter Quantity!");
		formObj.quantity.focus();
		return false;
     } 

	  if(isNaN(formObj.quantity.value)){
		alert("Please enter correct Quantity !");
		formObj.quantity.focus();
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

<html:form action="/admin/product"  method="post" onsubmit="return validateForm(this);" enctype="multipart/form-data">
   <html:hidden property="productid" /> 
   <html:hidden property="action"/>
   <html:hidden property="actionUpdateData"/>
   
   
   
   <table cellpadding="1" cellspacing="1" bgcolor="#6699CC" align="center" width="60%">

 <tr bgcolor="#FFFFFF">
      <td align="center" colspan="2">
       <font size="4">Please Enter the Following Details</font>
	   <br><font color="red"><html:errors/></font>
      </td>
 </tr>



 <%--
 <tr>
      <td align="right">productid</td>
      <td align="left">
         <html:text property="productid" size="30" maxlength="120"/>
      </td>
 </tr>
 --%>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Category Id</b><font color="#FF0000">*</font></td>
      <td align="left">
         <html:text property="categoryid" size="40" maxlength="120" readonly="true"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Product Name</b><font color="#FF0000">*</font></td>
      <td align="left">
         <html:text property="productname" size="40" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Product Price</b><font color="#FF0000">*</font>(<%=csymbol%>)</td>
      <td align="left">
         <html:text property="productprice" size="40" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>List Price</b>(<%=csymbol%>)</td>
      <td align="left">
         <html:text property="listprice" size="40" maxlength="120"/>
      </td>
 </tr>

  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Upload Image</b></td>
      <td align="left">
	  <html:file property="theFile"/> 
       <%--  <html:file property="theFile" size="40" maxlength="120"/> --%>
		

      </td>
 </tr>
		 
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Quantity</b><font color="#FF0000">*</font></td>
      <td align="left">
         <html:text property="quantity" size="40" maxlength="120"/>
      </td>
 </tr>

<tr bgcolor="#FFFFFF">
      <td align="right"><b>Brief Discription</b></td>
      <td align="left">
        
		  <html:textarea property="briefdisc" cols="50" rows="4"/>
      </td>
 </tr>

  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Description</b></td>
      <td align="left">
         <html:textarea property="description" cols="50" rows="6"/>
         
      </td>
 </tr>
  
   <tr bgcolor="#FFFFFF">
      <td align="center" colspan="2">
          <html:submit>Save</html:submit>
			
      </td>
 </tr>
 </table>

 </html:form>
 <%@ include file="bottom.jsp"%>
 </body>
 </html:html>
<%}%>
 