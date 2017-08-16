<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>

<layout:pager maxPageItems="5">
<layout:collection title="news.list" 
                   name="allNews" 
                   id="news"
                   styleClass="FORM">
  <layout:collectionItem title="news.id" property="id"/>
  <layout:collectionItem title="news.title" property="title" sortable="true"/>
  <layout:collectionItem title="news.subject" property="subject.name" sortable="true"/>
  <layout:collectionItem title="news.body" property="body"/>
 
</layout:collection>
</layout:pager>

<layout:row>
	<layout:collection title="news.list" 
	                   name="allNews" 
	                   styleClass="FORM"
	                   id="news"
	                   indexId="newsId"
	                   sortAction="client">
	  <layout:collectionItem title="news.id" property="id"/>
	  <layout:collectionItem title="news.date" property="date" type="date" sortable="true"/>
	  <layout:collectionDetail property="title"/>
	  <layout:collectionDetail property="subject.name"/>
	  <layout:collectionItem title="news.body" property="body"/>

	 
	  
	</layout:collection>

	<layout:column>
		<layout:panel key="news.details" styleClass="FORM">
			<layout:detail key="news.title" property="title" styleClass="LABEL"/>
			<layout:detail key="news.subject" property="subject.name" styleClass="LABEL"/>
		</layout:panel>
	</layout:column>
</layout:row>