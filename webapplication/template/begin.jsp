<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>


<html>

<!-- H E A D E R -->
<head>
	<layout:skin includeScript="true"/> 
    <title></title>
	

    <script language="JavaScript" src="<layout:resource type="cfg" name="swap.js"/>"></script>
    <script language="JavaScript">

    function save1Cookie(days,skinName) {
          if (days) {
                var date = new Date();
                date.setTime(date.getTime()+(days*24*60*60*1000));
                var expires = "; expires="+date.toGMTString();
          }
          else expires = "";
          document.cookie = "skinName="+skinName+expires+"; path=/";
    }

    function choix(choix) {
        save1Cookie(60,choix);
    }
   </script>
 </head>
