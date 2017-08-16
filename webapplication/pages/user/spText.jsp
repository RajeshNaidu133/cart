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


<table align="center" width="100%">
		<tr>
		       <td valign="top" align="center">

                 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6699CC" >
					<tr>
						

                           <td width="25%">
					        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
					           <tr>
			                        <td valign="top"><%@ include file="../leftmenu.jsp"%></td>
									
		   			           </tr>
							   
					        </table>
                      </td>

							<td align="center" width="75%" >
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" height="600">
							
								<tr><td align ="left" colspan="3" valign="top" height="100"><strong>Welcome to roseindia shopping cart ! </strong><p>
								Here you can provide information about shipping and payment options.
								<p>
								This HTML text can be edited in the administrative mode.

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