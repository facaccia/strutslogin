<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="a" uri="/struts-tags" %>
<a:include value="header.jsp"></a:include>

	<div class="container" style="text-align: center">

		<h1>
			Registrazione Struts2
		</h1>
		
			<s:form action="registrazione" style="margin:0 auto;" >
				<s:textfield class="add" name="uname"  required="required"  label="Username"/>
				<br>
				<s:password class="add" name="pass" required="required" label="Password" />
				<br>
				<s:textfield class="add" name="cognome"  required="required"  label="Cognome"/>
				<br>
				<s:textfield class="add" name="email" required="required" label="Email" />
				<br>
				<s:submit class="btn btn-danger" value="Registrati" align="center" />
			</s:form> 
	<a href="index.jsp">Login</a>
		
	</div>

</body>
</html>
