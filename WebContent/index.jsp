<%@page import="com.candidjava.service.UserServiceImpl"%>
<%@page import="com.candidjava.service.UserService"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="a" uri="/struts-tags" %>
<a:include value="header.jsp" ></a:include>

<script>




$( window ).on( "load", function(){
	
	
	function getCookie(cname) {
		risposta= "empty";
	    var name = cname + "=";
	    var decodedCookie = decodeURIComponent(document.cookie);
	    var ca = decodedCookie.split(';');
	    for(var i = 0; i <ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0) == ' ') {
	            c = c.substring(1);
	        }
	        if (c.indexOf(name) == 0) {
	            return c.substring(name.length, c.length);
	        }
	    }
	    return risposta;
	}
	
	if(getCookie("id")!=="empty"){
		
	 var url = "/strutslogin/controllo.action" ; 
	 document.forms[0].action = url;
	 document.forms[0].submit();
	}

	
});
</script>
<div class="wrapper"> 
	<div class="container col-6 card" style="text-align: center">

		<h1 style="margin-top: 40px;">
			Login Struts2
		</h1>
	
		<div class="col-12">
			<s:form action="login" style="margin: 0 auto;" >
				<s:textfield class="add" name="uname"  required="required"  label="Enter Username"/>
				<br>
				<s:password class="add" name="pass" required="required" label="Enter Password" />
				<br>
				<s:submit class="btn btn-danger" value="Login" align="center" />
			</s:form>  
			<br>
			<h4 style="color:red;"><a:property value="errore"/></h4><br/>
		</div>
				<a href="registrazione.jsp">Registrati</a>

	</div>
</div>
</body>
</html>
