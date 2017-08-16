<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%

//String sstorename=(String)request.getAttribute("sstorename");

%>

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
						
                     <!--
                           <td width="25%">
					        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="100%">
					           <tr>
			                        <td valign="top"><%@ include file="leftmenu.jsp"%></td> 
									
		   			           </tr>
							   
					        </table>
                      </td>
                      -->
							<td align="center" width="75%" >
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
							
								<tr><td align ="left" colspan="3" valign="top" height="100"><strong>Welcome to roseindia shopping cart ! </strong><br>This page will show List of categories with their images								  </td>
								</tr>
								
								<tr>
								<td valign="top" ><h3>Products Categories</h3>

								<table border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" width="100%">
								
								<tr>   <td>
									<c:forEach var="result" items="${categoryList}">
												
												                       
										
											<c:if test = "${result.pid == 0 }">
                                              
												<br><li><b><c:out value="${result.value}"/></li></b><br>&nbsp;&nbsp;&nbsp;
												
											</c:if>
											<c:if test = "${result.pid > 0 }">
												<a href="../viewproducts/<c:out value="${result.id}"/>"><c:out value="${result.value}"/></a>&nbsp;|&nbsp;
											</c:if>	
											
											
										  
									</c:forEach>			
									</td></tr>	
										
								
								</table>

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