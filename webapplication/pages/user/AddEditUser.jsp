 <%@ taglib uri="/tags/struts-bean" prefix="bean" %>
 <%@ taglib uri="/tags/struts-html" prefix="html" %>
 <html:html locale="true">
 <head>
 <title></title>
 <html:base/>
<SCRIPT LANGUAGE=javascript>
<!--

function checkEmail(email) {
		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
		return (true)
		}
		alert("Invalid E-mail Address! Please re-enter.")
		return (false);
	}

function validateForm(formObj){
   //TO DO Add Java Script Validation Code Here
  
   if(formObj.userid.value.length==0){
		alert("Please enter User Id!");
		formObj.userid.focus();
		return false;
   }

    if(formObj.password.value.length==0){
		alert("Please enter Password!");
		formObj.password.focus();
		return false;
   }

    if(formObj.firstname.value.length==0){
		alert("Please enter First Name!");
		formObj.firstname.focus();
		return false;
   }


    if(formObj.lastname.value.length==0){
		alert("Please enter Last Name!");
		formObj.lastname.focus();
		return false;
   }

   if(formObj.email.value.length==0){
		alert("Please enter Email!");
		formObj.email.focus();
		return false;
   }


   if(!checkEmail(formObj.email.value)){
		   formObj.email.focus();
		   return false;
	   }

   if(formObj.country.value.length==0){
		alert("Please enter Country!");
		formObj.country.focus();
		return false;
   }
  

  if(formObj.zip.value.length==0){
		alert("Please enter zip!");
		formObj.zip.focus();
		return false;
   }

   if(isNaN(formObj.zip.value)){
		alert("Please enter correct Zip Code!");
		formObj.zip.focus();
		return false;
   }

    if(formObj.state.value.length==0){
		alert("Please enter State!");
		formObj.state.focus();
		return false;
   }

 if(formObj.city.value.length==0){
		alert("Please enter City!");
		formObj.city.focus();
		return false;
   }
    if(formObj.address.value.length==0){
		alert("Please enter Address!");
		formObj.address.focus();
		return false;
   }
 

    if(formObj.phone.value.length==0){
		alert("Please enter Phone!");
		formObj.phone.focus();
		return false;
   }

   if(isNaN(formObj.phone.value)){
		alert("Please enter correct Phone No.!");
		formObj.phone.focus();
		return false;
   }

    if(formObj.fax.value.length==0){
		alert("Please enter Fax!");
		formObj.fax.focus();
		return false;
   }

   if(isNaN(formObj.fax.value)){
		alert("Please enter correct Fax No.!");
		formObj.fax.focus();
		return false;
   }

    

   formObj.actionUpdateData.value="update";
   return true;
}
//-->
</SCRIPT>
 </head>
 <body>

<%@ include file="../top.jsp"%>  
<%@ include file="../left.jsp"%>


 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
	<tr bgcolor="#FFFFFF">
		<td align="center">
		<br>
              
			  <html:form action="/user/AddEditUser"  method="post" onsubmit="return validateForm(this);">
   <html:hidden property="id" />
   <html:hidden property="action"/>
   <html:hidden property="actionUpdateData"/>
   
  <font color="red"> <html:errors/></font>
  
   <table width="50%" border="0" bgcolor="#6699CC" cellpadding="0" cellspacing="1" height="100%">

 <tr bgcolor="#FFFFFF">
      <td align="center" colspan="2">
       <font size="4">Please Enter the Following Details</font>
      </td>
 </tr>
 
  <tr bgcolor="#FFFFFF">
      <td align="right" width="50%"><b>UserId</b></td>
      <td align="left" width="50%">
         <html:text property="userid" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Password</b></td>
      <td align="left">
         <html:text property="password" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>First Name</b></td>
      <td align="left">
         <html:text property="firstname" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Last Name</b></td>
      <td align="left">
         <html:text property="lastname" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Email</b></td>
      <td align="left">
         <html:text property="email" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Country</b></td>
      <td align="left">
         <html:text property="country" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Zip</b></td>
      <td align="left">
         <html:text property="zip" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>State</b></td>
      <td align="left">
         <html:text property="state" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>City</b></td>
      <td align="left">
         <html:text property="city" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Address</b></td>
      <td align="left">
         <html:text property="address" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Phone</b></td>
      <td align="left">
         <html:text property="phone" size="30" maxlength="120"/>
      </td>
 </tr>
  <tr bgcolor="#FFFFFF">
      <td align="right"><b>Fax</b></td>
      <td align="left">
         <html:text property="fax" size="30" maxlength="120"/>
      </td>
 </tr>
   <tr bgcolor="#FFFFFF">
      <td align="center" colspan="2">
          <html:submit>Save</html:submit>
			
      </td>
 </tr>
 </table>

  </html:form>

      <br>    
		 </td>
	</tr>
 </table>


<%@ include file="../bottom.jsp"%>


 </body>
 </html:html>
