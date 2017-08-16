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

<%@ include file="../top.jsp"%>  
<%@ include file="../left.jsp"%>



 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
	<tr bgcolor="#FFFFFF" height="60%">
		<td align="center" >
		
              
		  <font color="red" size="4"> Your order successfuly placed !</font>	

        
		 </td>
	</tr>
 </table>


<%@ include file="../bottom.jsp"%>


 </body>
 </html:html>
