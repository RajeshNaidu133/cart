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
<%@ include file="left.jsp"%>


<table align="center" width="100%">
		<tr>
		       <td valign="top" align="center">

                 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
					<tr  bgcolor="#FFFFFF">
						

                           <td width="25%">
					        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="100%">
					           <tr>
			                        <td valign="top"><%@ include file="leftmenu.jsp"%></td>
									
		   			           </tr>
							   
					        </table>
                      </td>

							<td align="center" width="75%" >
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
							
								<tr><td align ="left" colspan="3" valign="top" height="100"><strong>Welcome to roseindia shopping cart ! </strong><br>This page will show List of categories with their images								  </td>
								</tr>
								<tr>
								<td valign="top" >

								<table border="0" cellpadding="5" cellspacing="1" bgcolor="#6699CC" width="100%">
								
									
									<c:forEach var="result" items="${categoryList}">
												
												<c:if test = "${result.pid == 0 }">
													<tr bgcolor="#F0F8FF">	
												</c:if>
												
												<c:if test = "${result.pid > 0 }">
													<tr bgcolor="#FAFCE0">	
												</c:if>

												<c:if test = "${result.pid == 0 }">
													<td><b><c:out value="${result.value}"/></b></td>
												</c:if>
												
												<c:if test = "${result.pid > 0 }">
													<td>&nbsp;&nbsp;&nbsp;<a href="../viewprice/<c:out value="${result.id}"/>"><c:out value="${result.value}"/></a></td>
												</c:if>
													
													
												</tr>			  
									</c:forEach>			
										
									
								
								<table>

								</td>
								</tr>
							</table>
							</td>
						
					</tr>
                 </table>


			   </td>
  </tr>
          
</table>

<%@ include file="bottom.jsp"%>

</body>
</html:html>