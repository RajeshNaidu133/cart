<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>


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




					<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
							
						<tr>
							<td align ="center" colspan="3" valign="top" height="100"><strong>Welcome</strong> 
								<br>You are registered successfuly !
								
							</td>
						</tr>
								
								
					</table>
							

<%@ include file="../bottom.jsp"%>

</body>
</html:html>