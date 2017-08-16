<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


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
</head>

<body>

<%@ include file="../top.jsp"%>  
<%@ include file="../left.jsp"%>


<table align="center" width="100%">
		<tr>
             <%--
		       <td valign="top" align="center">
                 
                 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
					<tr  bgcolor="#FFFFFF">
						

                           <td width="25%">
					        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="100%">
							
					           <tr>
			                        <td valign="top"><%@ include file="../leftmenu.jsp"%></td>
									
		   			           </tr>
							 
					        </table>
                      </td> --%>	 

						<td align="center" width="75%" >
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
							
								<tr><td align ="left" colspan="3" valign="top" height="100"><strong>Welcome to roseindia shopping cart ! </strong><br>This page will show List of categories with their images								  </td>
								</tr>
								
								<tr>
								<td valign="top" ><h3>Products</h3>

								<table border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" width="100%">
								
								<tr>   <td>
									<c:forEach var="result" items="${viewproducts}">

										<tr>
										<td valign="top" width="15%">
										<c:if test = "${result.imagename != '' }">
										<img  src="C:/tomcat/apache-tomcat-5.5.12/webapps/roseindia/cart/images/<c:out value="${result.imagename}"/>" alt="image" width="70" height="99"/>
										</c:if>
										<c:if test = "${result.imagename == '' }">
											<img  src="C:/tomcat/apache-tomcat-5.5.12/webapps/roseindia/cart/images/nophoto.gif" width="70" height="99"/>
										</c:if>
										</td>	
										<td width="50%" valign="top"><B><font color="#30249D"><c:out value="${result.productname}"/></font></B><br><font color="#30249D">
										Price:</font><font color="red"><%=csymbol%>&nbsp;<c:out value="${result.productprice}"/></font>&nbsp;&nbsp;
										<c:if test = "${result.listprice != '' }">
										<font color="#30249D">List Price:</font><font color="red"> <%=csymbol%>&nbsp;<c:out value="${result.listprice}"/></font>
										</c:if>	<br>

										<c:if test = "${result.briefdisc != '' }">
										<font color="#30249D"><c:out value="${result.briefdisc}"/></font>
										</c:if>
											
										</td><td align="left">
<a href="/cart/user/AddToCart.do?action=Edit&productid=<c:out value="${result.productid}"/>"><b>Add To<br>Cart</b></a></td>
										</tr>

                    
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

<%@ include file="../bottom.jsp"%>

</body>
</html:html>