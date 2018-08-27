<%@page import="com.candidjava.controller.LoginController"%>
<%@page import="com.candidjava.dto.User"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="a" uri="/struts-tags" %>

<a:include value="header.jsp"></a:include>

<div class=" container " style="text-align: center">

	<h1>Privacy</h1>
		
		<script> 
$(document).ready(function(){
	
	

	function getCookie(cname) {
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
	    return "";
	}


	
	$("#table").hide();
	$("#divCookie").hide();
	$("#table").hide();
    $("#mostraData").click(function(){
		$("#table").show(2000);
    });
    $("#cookie").click(function(){
		$("#divCookie").show();
    	});
    $("#cookieHide").click(function(){
		$("#divCookie").hide();
    	});
    $("#nascondiData").click(function(){
        $("#table").hide(1500);
    });
    $("#formModifica").hide();
    $("#modifica").click(function(){
		$("#formModifica").show(2500);
		 $("#div").animate({ top:'400px'});
    });
    $("#annulla").click(function(){
		$("#formModifica").hide(2500);
    });
    
    $("#div").click(function(){
        $("#div").hide(1500);
       });
});
</script>


<div class="pos-f-t col-3">
	  <div class="collapse" id="prova" style="text-align: left;">
	    <div class="bg-dark p-4">
	      <h5 class="text-white h4">Menu</h5>
	     
		<button class="btn-xs btn-link" style="margin: 5px;" id="mostraData">Modifica Password</button>
		<br>
		<button class="btn-xs btn-link" style="margin: 5px;" id="cookie">Cookie</button>
		<br>
		<a href="/strutslogin/controllo.action"><button style="margin: 5px;" class="btn-xs btn-link">Home</button></a>
		<br>
		<a href="/strutslogin/logout.action"><button style="margin: 5px;" class="btn-xs btn-link">Loguot</button></a>
	    </div>
	    </div>
	  </div>
	  <nav class="navbar navbar-dark bg-dark">
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#prova" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	  </nav>
	

<div id="table" style="text-align: center; margin: 20px;">
	
			<div>
				<button class="btn btn-primary" style="margin: 10px;" id="modifica">Modifica Password</button>
				<button class="btn btn-success" style="margin: 10px;" id="annulla">Annulla</button>
				<s:form id="formModifica" action="modificaPassword" style="margin: 0 auto;" >
					<b><a:property value="utente"/></b><br/>
					<s:password name="passwordVecchia"  required="required" class="add" label="Password vecchia"/>
					<s:password name="passwordNuova"  required="required" class="add" label="Nuova password"/>
					<s:password name="passwordNuova1"  required="required" class="add" label="Ripetere nuova password"/>
					
					<s:submit class="btn btn-primary" value="Modifica" align="right" />
				</s:form>
			</div>
</div>

		<div id="divCookie"  class="container" style="text-align: center; position:absolute">
			<h3>Cookie Section</h3>
			<p>Lorem Ipsum è un testo segnaposto utilizzato nel settore della tipografia e della stampa. Lorem Ipsum è considerato il testo segnaposto standard sin dal sedicesimo secolo, quando un anonimo tipografo prese una cassetta di caratteri e li assemblò per preparare un testo campione. È sopravvissuto non solo a più di cinque secoli, ma anche al passaggio alla videoimpaginazione, pervenendoci sostanzialmente inalterato. Fu reso popolare, negli anni ’60, con la diffusione dei fogli di caratteri trasferibili “Letraset”, che contenevano passaggi del Lorem Ipsum, e più recentemente da software di impaginazione come Aldus PageMaker, che includeva versioni del Lorem Ipsum.</p>
			<button class="btn-xs btn-link" style="margin: 5px;" id="cookieHide">Close</button>
		</div>
	
	<div id="div"  class="container" style="text-align: center; position:absolute">
		<b><a:property value="modifica"/></b><br/>
	</div>
</div>
</body>
</html>




	
</body>
</html>

