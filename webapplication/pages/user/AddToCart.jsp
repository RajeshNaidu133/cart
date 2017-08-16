 <%
 String userid=(String)session.getAttribute("UserID");
if(userid == null)
{
	response.sendRedirect("../pages/user/userlogin.jsp");
	
}else{
%> 
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@page import="roseindia.web.struts.form.*"%>

<%

String csymbol=(String)request.getAttribute("csymbol");


%>

<html:html locale="true">
<head>
<title>Add items into Cart</title>

<style type="text/css">


A:active { COLOR: green; TEXT-DECORATION: none } 
A:hover { COLOR: red; TEXT-DECORATION: none; font-weight: none }

</style>

<SCRIPT LANGUAGE=javascript>
<!--

function validateForm(formObj){

 
	if(formObj.totalitems.value != 0){

		for(var i=1;i < formObj.totalitems.value;i++){
			var itemName="quantity"+i;
			var fieldName = document.getElementById(itemName); 

				if(fieldName.value*1 == 0){
					alert("Quantity can't be zero!");
					fieldName.focus();
					return false;
				}


				if (!fieldName.value.match(/^\d+$/)) {
					alert('Enter correct quantity !');
					return false;
				}

			}

		return true;
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

<c:set var="total" value="${0}"/>
 <c:forEach var="result1" items="${cartitems}">      	

			<c:set var="total" value="${total + result1.perItemCost}" scope="page" />
							
</c:forEach>



<c:set var="counter" value="${1}" scope="session"  />

<div align="center">
<table align="center" width="100%">
		<tr>
		       <td valign="top" align="center">

                 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
					<tr>
						
					<!--
                      <td width="25%" bgcolor="#FFFFFF">
					        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
					          
							   
					        </table>
                      </td>

					  -->

							<td align="center" width="75%" >
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
							
								<tr><td align ="left" colspan="4" valign="top" height="100"><strong>My Shopping Cart ! </strong>								  </td>
								</tr>
								<tr>
									<td valign="top" align="center">								

					<html:form action="/user/AddToCart"  method="post" onsubmit="return validateForm(this);">
						<html:hidden property="productid" />
						<html:hidden property="action"/>
						<html:hidden property="actionUpdateData"/>

						<TABLE cellSpacing=1 cellPadding=2 width="75%" bgColor="#6699CC" border=0>
							<TBODY>
								<TR align=middle bgColor=#6699CC>
									<TD><font color="white">Product Name</font></TD>
									<TD><font color="white">Quantity</font></TD>
									<TD><font color="white">Cost</font></TD>
									<TD width=20></TD>
								</TR>

						 <c:forEach var="result" items="${cartitems}">
							<TR bgColor=white>
								<TD>
								<input type="hidden" name='itemcode<c:out value="${sessionScope.counter}" />' value="<c:out value="${result.itemCode}"/>">
								<c:out value="${result.itemName}"/></TD>
								<TD align=middle>
									<input type="text" id="quantity<c:out value="${sessionScope.counter}" />" name="quantity<c:out value="${sessionScope.counter}" />" size="10" maxlength="120" value='<c:out value="${result.qty}"/>'/>
																
								</TD>
								<TD align="right"> <%=csymbol%>
								
								<c:out value="${result.perItemCost}"/>
								<input type="hidden" name="cost<c:out value="${sessionScope.counter}" />" value="<c:out value="${result.perItemCost}"/>">	
								
								</TD>
<TD align=middle>
<a href="./AddToCart.do?action=delete&pid=<c:out value="${result.itemCode}"/>">Remove</a>
</TD>
							</TR>
							  <c:set var="counter" value="${sessionScope.counter + 1}" scope="session"  />
							</c:forEach>
							<TR bgColor=white>
								<TD><FONT class=cat><B>Total:</B></FONT></TD>
								<TD><BR><BR></TD>
								<TD align=middle bgColor="#F2F2FF">
								<div align="right"><B><%=csymbol%>&nbsp;&nbsp;<fmt:formatNumber type="number" maxFractionDigits="2" value="${total}" />
								
								</B></div>
								</TD>
								<TD></TD>
							</TR>
						</TBODY>
						</TABLE>
						<input type="hidden" name="totalitems" value="<c:out value="${sessionScope.counter}" />">
						<P>
						<TABLE width="75%" border=0>
							<TBODY>
								<TR>
									<TD align=right><html:submit>Update</html:submit></TD>
								</TR>
							</TBODY>
						</TABLE>

					</html:form>

					<FORM action="checkout.jsp" method=get>
						<TABLE width="75%" border=0>
						<TBODY>
						<TR>
						<TD align=middle><INPUT onclick="window.location='../cart/Welcome.do';" type=button value="Back to shopping"></TD>
						<TD align=middle><INPUT onclick="window.location='../user/checkout.do';" type=button value="Proceed to checkout"></TD></TR></TBODY></TABLE>
					</FORM>

					</CENTER>
					</TD></TR>
					<TR>
					<TD colSpan=2> </TD></TR></TBODY></TABLE>

									     
									</td>
									
								</tr>
							</table>
							</td>
						
					</tr>
                 </table>


			   </td>
  </tr>
          
</table>


<%@ include file="../bottom.jsp"%>

</body>
</html:html>
<%}%>