<%
 String userid=(String)session.getAttribute("adminUserID");
if(userid == null)
{
	response.sendRedirect("../pages/admin/adminlogin.jsp");
	
}else{
%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@page import="javax.sql.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="roseindia.web.common.*"%>

 <html>

 <body>

 <%@ include file="top.jsp"%>  
 <%--
 
<%@ include file="left.jsp"%>  
--%>

	


<table width="100%">
 <tr>
		       <td valign="top">

                 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
					    
						<td colspan="3"><b>Orders Detail</b><br><hr color="#6699CC"></td>
						</tr><tr>
							<td>
							
							<table border="0" width="100%" bgcolor="#6699CC" cellpadding="1" cellspacing="1">
				     
                              <tr bgcolor="#EAEAFF">
							
							<td><b>Order Id</b></td>
							<td><b>Customer</b></td>
							<td><b>Email</b></td>
							<td><b>Address</b></td>
							<td><b>Phone number</b></td>
							<td><b>Ordered products</b></td>
							<td><b>Order total</b></td>
							<td><b>Order time</b></td>
							<td><b>Quantity</b></td>
							
							
							
							
						</tr>
					       
					
				 	<c:forEach var="result" items="${showorders}">

						<tr bgcolor="#FFFFEC">
							
							<td><c:out value="${result.orderid}"/></td>
							<td><c:out value="${result.custfirstname}"/>&nbsp;<c:out value="${result.custlastname}"/> </td>
							<td><c:out value="${result.custemail}"/></td>
							<td><c:out value="${result.custaddress}"/>&nbsp;<c:out value="${result.custcity}"/>&nbsp;<c:out value="${result.custstate}"/>&nbsp;(<c:out value="${result.custcountry}"/>)&nbsp;pin:<c:out value="${result.custzip}"/></td>
							<td><c:out value="${result.custphone}"/>,<c:out value="${result.custfax}"/></td>
							<td><c:out value="${result.productname}"/></td>
							
							<td><c:out value="${result.price}"/></td>

							<td><c:out value="${result.ordertime}"/></td>
							<td><c:out value="${result.quantity}"/></td>
							
							
						</tr>

                    
					</c:forEach>

				
				 
				 
				</table>

			   </td>
		   </tr>
		   </table>
          <%--
		   <%@ include file="bottom.jsp"%>
		   --%>
</body>
</html>
<%
}
%>
