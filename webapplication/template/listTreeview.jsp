<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>

<script>
/*
	function refresh() {
		lockTreeview('news');
		window.location.reload(true);
	}
	setTimeout( "refresh()", 10*1000 );
*/	
</script>

<layout:grid>
	<layout:panel styleClass="FORM">
		<layout:treeview name="news"/>
	</layout:panel>
	<logic:present name="subjects">
	</logic:present>
</layout:grid>
	<layout:space/>
	