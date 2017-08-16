<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@page import="javax.sql.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="roseindia.web.common.*"%>

 <html>

 <body>
 <%@ include file="../top.jsp"%>  
<%@ include file="../left.jsp"%>  


	


<table width="100%">
 <tr>
		       <td valign="top">

                 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
					<tr>
					    
						<td colspan="3"><b>Price Detail</b><br><hr color="#6699CC"></td>
						</tr><tr>
							<td>
							
							<table border="0" width="100%" bgcolor="#6699CC" cellpadding="0" cellspacing="1">
				     
                              <tr bgcolor="#EAEAFF">
							
							<td><b>Product Name</b></td>
							<td><b>Product Price</b></td>
							<td><b>List Price</b></td>
							
							
						</tr>
					       
					
				 	<c:forEach var="result" items="${viewprice}">

						<tr bgcolor="#FFFFEC">
							
							<td><c:out value="${result.productname}"/></td>
							<td><c:out value="${result.productprice}"/></td>
							<td><c:out value="${result.listprice}"/></td>
							
							
						</tr>

                    
					</c:forEach>

				
				 
				 
				</table>

			   </td>
		   </tr>
		   </table>

		   <%@ include file="../bottom.jsp"%>
</body>
</html>
