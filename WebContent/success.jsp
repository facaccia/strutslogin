<%@page import="com.candidjava.controller.LoginController"%>
<%@page import="com.candidjava.dto.User"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="a" uri="/struts-tags" %>

<a:include value="header.jsp"></a:include>

<div class=" container " style="text-align: center">

	<h1>Piano 2.0 <b><br/><a:property value="msg"/>,</b>
		
		look for your records </h1>
		
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
	$("#table2").hide();
    $("#mostraData").click(function(){
		$("#table").show(1000);
		$("#table2").show(1000);
    });
    $("#nascondiData").click(function(){
        $("#table").hide(1000);
        $("#table2").hide(1000);
    });
    $("#formModifica").hide();
    $("#modifica").click(function(){
		$("#formModifica").show(1000);
		 $("#div").animate({ top:'400px'});
    });
    $("#annulla").click(function(){
		$("#formModifica").hide(1000);
    });
    $("#formCommessa").hide();
    $("#aggiungiCommessa").click(function(){
		$("#formCommessa").show(1000);
    });
    $("#annullaCommessa").click(function(){
		$("#formCommessa").hide(1000);
		 $("#div").animate({ top:'400px'});
    });
    $("#div").click(function(){
        $("#div").hide(1000);
       });
});
</script>


<div class="pos-f-t col-3" style="float: left;">
	  <div class="collapse" id="prova" style="text-align: left;">
	    <div class="bg-dark p-4">
	      <h5 class="text-white h4">Menu</h5>
	     
		<button class="btn-xs btn-link" style="margin: 5px;" id="mostraData">Mostra dati personali</button>
		<br>
		<button class="btn-xs btn-link" style="margin: 5px;" id="nascondiData">Nascondi dati personali</button>
		<br>
		<a href="/strutslogin/download.jsp"><button style="margin: 5px;" class="btn-xs btn-link">File</button></a>
		<br>
		<a href="/strutslogin/privacy.jsp"><button style="margin: 5px;" class="btn-xs btn-link">Privacy</button></a>
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
	
<div class="card1" style="float: right;">
<div id="table" style="text-align: center; margin: 20px;  float: right;" class="col-12">
	
<table style="margin: 0 auto;">
	<thead>
		<tr>
			
			<th>ID</th>
			<th>NOME</th>
			<th>COGNOME</th>
			<th>EMAIL</th>
						
		</tr>
				</thead>
				
				
				<s:iterator value="user">
					<tr>
						<td class="tabella"><s:property value="idUsers" /></td>
						<td class="tabella"><s:property value="nome" /></td>
						<td class="tabella"><s:property value="cognome" /></td>
						<td class="tabella"><s:property value="email" /></td>
					</tr>
				</s:iterator>
				
			</table>
			
			<div>
				<button class="btn btn-primary" style="margin: 10px;" id="modifica">Modifica campo tabella</button>
				<button class="btn btn-success" style="margin: 10px;" id="annulla">Annulla</button>
				<s:form id="formModifica" action="modifica" style="margin: 0 auto;" >
					<s:textfield name="modificaInput"  required="required" class="add" label="Inserisci modifica"/>
					<s:select id="campoModifica"  class="add" name="campoModifica" label="Campo" cssStyle="text-align:'right'"
					
						list="#{'nome':'Nome', 'cognome':'Cognome', 'email':'Email'}"
						>
					</s:select>
					<s:submit class="btn btn-primary" value="Modifica" align="right" />
				</s:form>
			</div>
</div>

	<div id="table2"  style="text-align: center; float: right;" class="col-12">
			<table style="margin: 0 auto;">
				<thead>
					<tr>
						
						<th>ID</th>
						<th>Lavoro Svolto</th>
						<th>Data</th>
									
					</tr>
					</thead>
					
					
					<s:iterator value="datiLavoratore">
						<tr>
							<td class="tabella"><s:property value="idUsers" /></td>
							<td class="tabella"><s:property value="lavoroSvolto" /></td>
							<td class="tabella"><s:property value="data" /></td>
						</tr>
					</s:iterator>
				<a:property value="modifica"/>
				</table>
				
			<div>
				<button class="btn btn-primary" style="margin: 10px;" id="aggiungiCommessa">Aggiungi nuova commessa</button>
				<button class="btn btn-success" style="margin: 10px;" id="annullaCommessa">Annulla</button>
				<s:form id="formCommessa" action="creaCommessa" style="margin: 0 auto;" >
					<s:textfield name="lavoroSvolto"  required="required" class="add" label="Lavoro Svolto"/>
					<s:textfield name="data"  required="required" placeholder="yyyy/mm/dd" class="add" label="Data"/>
					
					<s:submit style="margin-bottom:20px;" class="btn btn-primary" value="Aggiungi" align="right" />
				</s:form>
			</div>
	</div>
</div>
	<div id="div"  class="container" style=" margin-top:30px; text-align: center; position:absolute">
		<h2><a:property value="modifica"/></h2><br/>
	</div>
	
	
	<div   style=" border:1px solid #007bff; margin-top: 50px;   text-align: center; float: right;" class="col-12 prova">
	<h2 style=" color: blue; ">Newsletter</h2>
			<table style="margin: 0 auto;">
				<thead>
					<tr>
						
						<th>Notizie</th>
						<th>Data</th>
									
					</tr>
					</thead>
					
					
					<s:iterator value="notizie">
						<tr>
							<td class="tabella"><s:property value="notizia" /></td>
							<td class="tabella"><s:property value="data" /></td>
						</tr>
					</s:iterator>
				</table>
			<div>
	</div>
</div>
</div>

</body>
</html>