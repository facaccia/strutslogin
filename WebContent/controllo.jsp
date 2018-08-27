<%@page import="com.candidjava.service.UserServiceImpl"%>
<%@page import="com.candidjava.service.UserService"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="a" uri="/struts-tags" %>
<a:include value="header.jsp" ></a:include>

<script>




$( document ).ready( function(){
	var url = "/strutslogin/controllo.action" ; 
	 document.forms[0].action = url;
	 document.forms[0].submit();
	
});
</script>
<body>
<s:form id="formModifica" action="modifica" style="margin: 0 auto;" >
</s:form>
</body>
	