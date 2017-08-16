<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@page import="javax.sql.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="roseindia.web.common.*"%>

<%
    String CID=(String)request.getAttribute("catid"); //category id
%>

 <html>

 <body>
 <%@ include file="top.jsp"%>  
<%-- <%@ include file="../left.jsp"%> --%>  


	


<table width="100%">
 <tr>
		       <td valign="top">

                 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
					<tr>
					    
						<td colspan="7"><b>Products Listing</b><br><hr color="#6699CC"></td>
						</tr><tr>
							<td>
							
							<table border="0" width="100%" bgcolor="#6699CC">
				     
                              <tr bgcolor="#EAEAFF">
							
							<td><b>Sr.No.</b></td>
							<td><b>Product Name</b></td>
							<td><b>Product Price</b></td>
							<td><b>List Price</b></td>
							<td><b>imagename</b></td>
							<td><b>quantity</b></td>
							<td><b>briefdisc</b></td>
							<td><b>description</b></td>
							
						</tr>
					       
					<c:set var="catid" value="0"/>
					<c:set var="sno" value="0"/>
				 	<c:forEach var="result" items="${showproducts}">
                     <c:set var="sno" value="${sno+1}"/>
						<tr bgcolor="#FFFFEC">
							
							<td><c:out value="${sno}"/></td>
							<td><a href="../admin/product.do?action=Edit&proid=<c:out value="${result.productid}"/>"><c:out value="${result.productname}"/></a></td>
							<td><c:out value="${result.productprice}"/></td> 
							<td><c:out value="${result.listprice}"/></td>
							<td><c:out value="${result.imagename}"/></td>
							<td><c:out value="${result.quantity}"/></td>
                            <td><c:out value="${result.briefdisc}"/></td>
							<td><c:out value="${result.description}"/></td>
						</tr>
                         <c:set var="catid" value="${result.categoryid}"/> 
                         
					</c:forEach>

				   
				 
				 
				</table>

			   </td>

		   </tr>

		   
          
		   <tr bgcolor="#FFFFFF"><td colspan="4" align="center"><br><br><a href="../admin/product.do?catid=<%=CID %>"><font size="4">Add Product</font></a></td></tr>

		   </table>

		 <%--  <%@ include file="../bottom.jsp"%> --%>
</body>
</html>
