

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

<%@ include file="../top.jsp"%>  
<%@ include file="../left.jsp"%>


<table align="center" width="100%">
		<tr>
		       <td valign="top" align="center">

                 <table width="100%" border="1" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
					<tr>
						

                           <td width="25%">
					        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
					           <tr>
			                        <td valign="top"><action path="/allNews.do?reqCode=treeview"/></td>
									
		   			           </tr>
							   
					        </table>
                      </td>

							<td align="center" width="75%" >
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
							
								<tr>
								<td align ="left" colspan="3" valign="top" height="100"><strong>Welcome to roseindia shopping cart ! </strong><p>
								
								<c:forEach var="result" items="${aboutus}">

										<c:out value="${result.aboutustext}"/>
							
								</c:forEach>


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

<%--
<table border="0" cellpadding="0" cellspacing="0" width="100%"  bgcolor="#E7FDFE">
  <tr>
    <td width="100%" colspan="2"  valign="top">
	  <tiles:get name="top"/>
	  
    </td>
	
  </tr>
  <tr>
   <td align="left" valign="top" width="23%"><br/><tiles:get name="content"/></td></td>
    <td width="77%" valign="top"  valign="top">
	
	
	
	
	
	   <table border="0" cellpadding="5" cellspacing="1" bgcolor="#E7FDFE" height="600" width="100%>
							
								<tr><td align ="left" colspan="3" valign="top" ><br><strong>Welcome to roseindia shopping cart ! </strong><br>This page will show List of categories with their images								  </td>
								</tr>
								
								<tr>
								<td valign="top" ><h3>Products Categories</h3>

								<table border="0" cellpadding="5" cellspacing="1" bgcolor="#E7FDFE" width="100%">
								
								<tr>   
								<td align ="left" colspan="3" valign="top" height="100"><strong>Welcome to roseindia shopping cart ! </strong><p>
								
								<c:forEach var="result" items="${aboutus}">

										<c:out value="${result.aboutustext}"/>
							
								</c:forEach>


								</td>
									
									</tr>	
										
								
								</table>

								</td>
								</tr>

							
							</table>
	
	
	
	
	</td>
  </tr>
  <tr>
    <td width="100%" colspan="2"  valign="top"><tiles:get name="bottom"/></td>
  </tr>
</table>
--%>