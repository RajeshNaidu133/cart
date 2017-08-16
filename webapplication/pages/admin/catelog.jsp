<%
 String userid=(String)session.getAttribute("adminUserID");
if(userid == null)
{
	response.sendRedirect("./pages/admin/adminlogin.jsp");
	
}else{
%> 
 <%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

 
<html:html locale="true">
<head>
<title>index page</title>
<html:base/>



<style type="text/css">


A:active { COLOR: green; TEXT-DECORATION: none } 
A:hover { COLOR: red; TEXT-DECORATION: none; font-weight: none }

</style>


</head>

<body>

<%@ include file="top.jsp"%>  

<table width="100%">
	<tr>
		<td>

			<table align="center" border="0" width="80%" bgcolor="#DDDDDD">


			       <tr><td align="center" colspan="5" bgcolor="#6699CC"><font size="4" color="#FFFFFF">Category Listing</font></td></tr>
				   <tr bgcolor="#6699CC"><td><font  color="#FFFFFF">Sr.No.</font></td><td><font  color="#FFFFFF">Category ID</font></td><td colspan="2"><font  color="#FFFFFF">Category Name</font></td><td><font  color="#FFFFFF">Parent ID</font></td></tr>
				  
											     <c:set var="sno" value="0"/>
												  <c:forEach var="result" items="${categoryList}">
															
															<c:if test = "${result.pid == 0 }">
																<c:set var="code" value="#F0F8FF"/>	
															</c:if>
															
															<c:if test = "${result.pid > 0 }">
																<c:set var="code"value="#FAFCE0"/>	
															</c:if>


														<tr bgcolor="<c:out value="${code}"/>">

															<c:if test = "${result.pid == 0 }">
															   <c:set var="sno" value="${sno+1}"/>
															 <td width="5"><b><c:out value="${sno}"/></b></td>
															 <td width="7"><a title="sushil pal" href="/cart/category/Edit.do?action=Edit&categoryid=<c:out value="${result.id}"/>"><c:out value="${result.id}"/></a></td>
																<td colspan="2"><b><c:out value="${result.value}"/></b></td>
																
																<td width="7"><c:out value="${result.pid}"/></td>
															</c:if>
															
															<c:if test = "${result.pid > 0 }">
															    <td>&nbsp;</td>
																<td><a href="/cart/category/Edit.do?action=Edit&categoryid=<c:out value="${result.id}"/>"><c:out value="${result.id}"/></a></td>
																<td><c:out value="${result.value}"/></td>
																<td align="center"><a href="/cart/showproducts/<c:out value="${result.id}"/>"><font size="3" >[Add/Edit Products]</font></a></td>
																<td width="7"><c:out value="${result.pid}"/></td>
															</c:if>
																
															
																
														</tr>	

														<c:if test = "${result.pid == 0 }">	
															<tr bgcolor="white">
															
																<td>&nbsp;</td><td colspan="4"><b>Sub-Category Under this category</b>&nbsp;&nbsp;<a   href="/cart/category/Edit.do?pid=<c:out value="${result.id}"/>">Add Under The Category</a> </td>
															
															<tr>	
															</c:if>
															 
												</c:forEach>
											<tr><td align="center" colspan="4"><font size="4" color="#FF0000"><a href="/cart/category/Edit.do"><b>Add Category</b></a></font></td></tr>	
												

					  
			</table>

		</td>
		
</tr>
</table>


</body>
</html:html>
<%
}	
%>