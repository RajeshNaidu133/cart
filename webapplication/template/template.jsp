<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

 
	 
<c:set var="p" value="${param.page}"/>

<%

String csymbol=(String)request.getAttribute("csymbol");

%>
 

<!-- H E A D -->
<tiles:get name="begin"/>
<!-- / H E A D -->

<body>

<!-- T I T R E -->
<%--
<tiles:get name="title"/>
--%>
<!-- / T I T R E -->


<table border="0" cellpadding="0" cellspacing="0" width="100%"  bgcolor="#E7FDFE">
  <tr>
    <td width="100%" colspan="2"  valign="top">
	  <tiles:get name="top"/>
	  
    </td>
	
  </tr>
  <tr height="100%">
   <td align="left" valign="top" width="20%"><br/><tiles:get name="content"/></td></td>
    <td width="80%" valign="top"  valign="top">
	
	<c:if test="${p == null}">
	<c:if test="${categoryList != null}">


	
	   <table border="0" cellpadding="5" cellspacing="1" bgcolor="#E7FDFE" height="600" width="100%>
							
								<tr><td align ="left" colspan="3" valign="top" ></td>
								</tr>
								
								<tr>
								<td valign="top" ><h3>Products Categories</h3>

								<table border="0" cellpadding="5" cellspacing="1" bgcolor="#E7FDFE" width="100%">
								
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
	 </c:if>
	 </c:if>
	
	<br>
	<!-- for about us -->
	 <c:if test="${aboutus != null}">
	

         <c:forEach var="result2" items="${aboutus}">

			<c:out value="${result2.aboutustext}"/>
							
		</c:forEach>

	
	</c:if>

   <!-- for shipping & delivery -->

      
	   
	 <c:if test="${shipDelivery != null}">
	

         <c:forEach var="result" items="${shipDelivery}">

				<c:out value="${result.shipdeltext}"/>
							
		</c:forEach>


	
	</c:if>
  <!-- for price list -->


  
<% // if(para.equals("price")){%>

 
  <c:if test="${p =='price'}">
  <c:if test="${categoryList != null}">
  <%--
  <table width="100%">
  <tr><td><font size="4">Compare Prices</font><br>Please select a product and compare prices.</td></tr>
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
    </table>
	--%>

      <table border="0" cellpadding="5" cellspacing="1" bgcolor="#E7FDFE" height="600" width="100%>
								<tr><td align ="left" colspan="3" valign="top" >Please click on a product and compare prices.</td>
								</tr>
								
								<tr>
								<td valign="top" ><h4>Compare Prices:</h4>

								<table border="0" cellpadding="5" cellspacing="1" bgcolor="#E7FDFE" width="100%">
								
								<tr>   <td>
									<c:forEach var="result" items="${categoryList}">
												
												                       
										
											<c:if test = "${result.pid == 0 }">
                                              
												<br><li><b><c:out value="${result.value}"/></li></b><br>&nbsp;&nbsp;&nbsp;
												
											</c:if>
											<c:if test = "${result.pid > 0 }">
												<a href="../viewprice/<c:out value="${result.id}"/>"><c:out value="${result.value}"/></a>&nbsp;|&nbsp;
											</c:if>	
											
											
										  
									</c:forEach>			
									</td></tr>	



										
								
								</table>

								</td>
								</tr>

							
							</table>

   </c:if>
  </c:if>

<c:if test="${viewprice != null}">

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



</c:if>

<c:if test="${viewproducts != null}">

   <table align="left" width="80%" border="0" cellpadding="5" cellspacing="1" bgcolor="#E7FDFE">
		<tr>
             

						<td align="center" width="75%" >
							<table width="100%" border="0" cellpadding="5" cellspacing="1"  height="600">
							
								<tr><td align ="left" colspan="3" valign="top" height="100"></td>
								</tr>
								
								<tr>
								<td valign="top" ><h3>Products</h3>

								<table border="0" cellpadding="5" cellspacing="1"  width="100%">
								
								<tr>   <td>
									<c:forEach var="result" items="${viewproducts}">

										<tr>
										<td valign="top" width="15%">
										<c:if test = "${result.imagename != '' }">
										<img  src="../images/<c:out value="${result.imagename}"/>" alt="<c:out value="${result.imagename}"/>" width="70" height="99"/>
										</c:if>
										<c:if test = "${result.imagename == '' }">
											<img  src="../images/nophoto.gif" width="70" height="99"/>
										</c:if>
										</td>	
										<td width="50%" valign="top"><B><font color="#30249D"><a href="../largeview/<c:out value="${result.productid}"/>"><c:out value="${result.productname}"/></a></font></B><br><font color="#30249D">
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

</c:if>


<c:if test="${largeview != null}">

   <table align="left" width="80%" border="0" cellpadding="5" cellspacing="1" bgcolor="#E7FDFE">
		<tr>
             

						<td align="center" width="75%" >
							<table width="100%" border="0" cellpadding="5" cellspacing="1"  height="600">
							
								<tr><td align ="left" colspan="3" valign="top" height="100"></td>
								</tr>
								
								<tr>
								<td valign="top" ><h3>Products</h3>

								<table border="0" cellpadding="5" cellspacing="1"  width="100%">
								
								<tr>   <td>
									<c:forEach var="result" items="${largeview}">

										<tr>
										<td valign="top" width="15%">
										<c:if test = "${result.imagename != '' }">
										<img  src="../images/<c:out value="${result.imagename}"/>" alt="<c:out value="${result.imagename}"/>" width="100" height="150"/>
										</c:if>
										<c:if test = "${result.imagename == '' }">
											<img  src="../images/nophoto.gif" width="70" height="99"/>
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

										<br>

										<c:if test = "${result.description != '' }">
										<font color="#30249D"><c:out value="${result.description}"/></font>

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

</c:if>
 
	</td>
     
	

    
  </tr>
  <tr>
    <td width="100%" colspan="2"  valign="top"><tiles:get name="bottom"/></td>
  </tr>
</table>
</body>
</html>