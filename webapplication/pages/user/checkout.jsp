<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.*"%>
<%
String csymbol=(String)request.getAttribute("csymbol");
%>
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

function validate(formObj){ 
	//validations
	

	if(formObj.firstName.value.length==0){
		alert("Please enter your first name!");
		formObj.firstName.focus();
		return false;
   }
	if(formObj.lastName.value.length==0){
		alert("Please enter your last name!");
		formObj.lastName.focus();
		return false;
   }
   if(formObj.email.value.length==0){
		alert("Please enter your email!");
		formObj.email.focus();
		return false;
   }
   if(formObj.phone.value.length==0){
		alert("Please enter your phone number!");
		formObj.phone.focus();
		return false;
   }
   if (!formObj.phone.value.match(/^\d+$/)) {
		alert('Enter correct phone number !');
		formObj.phone.focus();
		return false;
	}

    if(formObj.address.value.length==0){
		alert("Please enter your address!");
		formObj.address.focus();
		return false;
   }

   if(formObj.city.value.length==0){
		alert("Please enter your city name!");
		formObj.city.focus();
		return false;
   }


if(formObj.state.value.length==0){
		alert("Please enter your state name!");
		formObj.state.focus();
		return false;
   }


if(formObj.zipCode.value.length==0){
		alert("Please enter zip code!");
		formObj.zipCode.focus();
		return false;
   }
 if (!formObj.zipCode.value.match(/^\d+$/)) {
		alert('Enter correct zip code !');
		formObj.zipCode.focus();
		return false;
	}



   if(formObj.country.value.length==0){
		alert("Please enter country!");
		formObj.country.focus();
		return false;
   }

   if(formObj.creditCardType.value.length==0){
		alert("Please select credit card type!");
		formObj.creditCardType.focus();
		return false;
   }

if(formObj.creditCardNumber.value.length==0){
		alert("Please enter credit card number!");
		formObj.creditCardNumber.focus();
		return false;
   }

 if (!formObj.creditCardNumber.value.match(/^\d+$/)) {
		alert('Enter correct credit card number !');
		formObj.creditCardNumber.focus();
		return false;
	}

   if(formObj.expirationDate.value.length==0){
		alert("Please enter expiration date!");
		formObj.expirationDate.focus();
		return false;
   }
    if(formObj.cardHolderName.value.length==0){
		alert("Please enter cardHolder name!");
		formObj.cardHolderName.focus();
		return false;
   }

   if(formObj.cvvNumber.value.length==0){
		alert("Please enter cvv number!");
		formObj.cvvNumber.focus();
		return false;
   }


 if (!formObj.cvvNumber.value.match(/^\d+$/)) {
		alert('Enter correct CVV number !');
		formObj.cvvNumber.focus();
		return false;
	}


   formObj.actionUpdateData.value="update";
   return true;
}
//-->expirationDate 
</SCRIPT>

</head>

<body>

<%@ include file="../top.jsp"%>  
<%@ include file="../left.jsp"%>


<c:set var="total" value="${0}"/>
 <c:forEach var="result1" items="${cartItems}">      	

			<c:set var="total" value="${total + result1.perItemCost}" scope="page" />
							
</c:forEach>

<table align="center" width="100%">
	<tr>
		<td valign="top" align="center">

			 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
				<tr bgcolor="white">
					<td align="center" width="75%"><br>
					 <html:form  method="post" action="/user/checkout" onsubmit="return validate(this)">

							
							<html:hidden property="action"/>
							<html:hidden property="actionUpdateData"/>

							<table bgcolor="#6699CC" border="0" cellpadding="2" cellspacing="1" align="center" width="70%">
								<tbody>
								<tr bgcolor="#6699CC">
								<td align="center"colspan="2" ><b><font color="white">Proceed to Checkout</font></b></td>

								</tr>

								<tr bgcolor="#ffffff">
								<td colspan="2"><br><font color="red">Payment details</font><hr color="#6699CC"></td>
								</tr>

								<tr bgcolor="#ffffff">
								<td colspan="2">
								
								
										<table cellSpacing="1" cellPadding="5" width="100%">
										  <tbody>
											<tr bgcolor="#E1E1E1">
											  <td width="15%"><b>Qty</b></td>											
											  <td width="65%"><b>Product</b></td>
											  <td align="right" width="20%"><b>Price</b></td>							  
											</tr>

											 <c:forEach var="result" items="${cartItems}">
													<tr>
													  <td><c:out value="${result.qty}"/></td>
													 
													  <td><c:out value="${result.itemName}"/></td>
													  <td align="right"><%=csymbol%>&nbsp;&nbsp;<c:out value="${result.perItemCost}"/></td>											 
													</tr>

											</c:forEach>

										<tr bgcolor="#ffffff">
											<td>&nbsp;</td><td align="right"><b>Total:</b></td>
											<td align="right"><hr><b><%=csymbol%>&nbsp;&nbsp;<fmt:formatNumber type="number" maxFractionDigits="2" value="${total}" /></b></td>
										</tr>

										  </tbody>
										</table>
									


								
								</td>
								</tr>


								<tr bgcolor="#ffffff">
								<td colspan="2"><br><font color="red">Personal information</font><hr color="#6699CC"></td>
								</tr>
								<%--
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Order Id:</b></td>
								<td><html:text property="orderId" size="30"/></td>
								</tr>
									
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Order Time:</b></td>
								<td><html:text property="orderTime" size="30"/></td>
								</tr>
								--%>

								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>First name:</b></td>
								<td><html:text property="firstName" size="30"/></td>
								</tr>
								<tr bgcolor="#ffffff">
								<td><font color="#FF0000">*</font><b>Last name:</b></td>
								<td><html:text property="lastName" size="30"/></td>
								</tr>
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Email:</b></td>
								<td><html:text property="email" size="30"/></td>
								</tr>
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Phone number:</b></td>
								<td><html:text property="phone" size="30"/></td>
								</tr>

								<tr bgcolor="#ffffff">
								<td><b>Fax No.:</b></td>
								<td><html:text property="fax" size="30"/></td>
								</tr>

								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Address:(billing & shipping)</b></td>
								<td><html:textarea  rows="5" cols="23" property="address"></html:textarea></td>
								</tr>
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>City:</b></td>
								<td><html:text property="city" size="30"/></td>
								</tr>
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>State:</b></td>
								<td><html:text property="state" size="30"/></td>
								</tr>
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Zip code:</b></td>
								<td><html:text property="zipCode" size="30"/></td>
								</tr>
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Country:</b></td>
								<td><html:text property="country" size="30"/></td>
								</tr>
								<tr bgcolor="#ffffff">

								<td colspan="2" align="left" bgcolor="#FFFFFF"><br><font color="red">Payment method: Credit Card</font><hr color="#6699CC"></td>
								</tr>

								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Credit card type:</b></td>
								<td>
								<%-- <html:text property="creditCardType" size="30"/> --%>

									
									<html:select property="creditCardType">
														
										<html:option value="">Select Card Type</html:option>

										<html:option value="VISA">Visa</html:option>
										<html:option value="MC">MasterCard</html:option>
										<html:option value="AMEX">American Express</html:option>
										<html:option value="DICL">Diners Club</html:option>
										<html:option value="JCB">JCB</html:option>
										<html:option value="CARTE">Carte Blanche</html:option>
										<html:option value="ABC">Australian BankCard</html:option>
										<html:option value="DINO">Discover/Novus</html:option>
										<html:option value="SW">Maestro/Switch</html:option>
										<html:option value="SO">Solo</html:option>
										<html:option value="ERT">enRoute</html:option>
										<html:option value="UKE">Visa Electron</html:option>
										
									</html:select>

									</td>		
								</tr>

								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Credit card number:</b></td>
								<td><html:text property="creditCardNumber" size="30"/></td>
								</tr>
                               
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Expiration date:</b></td>
								<td><html:text property="expirationDate" size="30"/></td>
								</tr>
                               
								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>Card holder name:</b></td>
								<td><html:text property="cardHolderName" size="30"/></td>
								</tr>

								<tr bgcolor="#ffffff">
								<td><b><font color="#FF0000">*</font>CVV Number:</b></td>
								<td><html:text property="cvvNumber" size="30"/></td>
								</tr>

								<tr bgcolor="#ffffff">
								<td><b>Customer Notes:</b></td>
								<td><html:textarea rows="5" cols="23" property="customerNotes"></html:textarea></td>
								</tr>

								<tr bgcolor="#ffffff">

								<td colspan="2" align="center" bgcolor="#FFFFFF"><html:submit>Place Order</html:submit></td>
								</tr>
								</tbody>
							</table>

					</html:form>
				</td>
	 </tr>
          
</table>

<%@ include file="../bottom.jsp"%>

</body>
</html:html>