<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:message scope="request" code="label.veiculo.codigo" var="codigoLabel" />
<spring:message scope="request" code="label.veiculo.descricao" var="descricaoLabel" />
<spring:message scope="request" code="label.veiculo.fatormultiplicador" var="fatorMultiplicadorLabel" />
<spring:message scope="request" code="label.veiculo.limitetonelada" var="liniteToneladaLabel" />
<spring:message scope="request" code="label.veiculo.custokmviapav" var="custoKmViaPavimentadaLabel" />
<spring:message scope="request" code="label.veiculo.custokmvianaopav" var="custoKmViaNaoPavimentadaLabel" />
<spring:message scope="request" code="label.veiculo.custokmexcessoton" var="custoKmExcessoToneladaLabel" />


<script>
$(function () {

	var table = $('#grid').DataTable({
		ajax: {url:'cadastroVeiculo?pesquisar&'+$('#veiculoForm').serialize(), type: 'POST'},
		searching: true, scrollX: true,
		columns: [     
		    {data: "ID"},
		    {data: "CODIGO", className:'text-center txt50'},
			{data: "DESCRICAO", className:'text-left txt300'},
			{data: "FATORMULTIPLICADOR", className:'text-center txt50'},
			{data: "CUSTOKMVIAPAV", className:'text-center txt50'},
			{data: "CUSTOKMVIANAOPAV", className:'text-center txt50'},
			{data: "LIMITETONELADA", className:'text-center txt50'},
			{data: "CUSTOKMEXCESSOTON", className:'text-center txt50'}
		]
	});
	
	$('#btnSalvar').click(function() {
		$.submit({form:'veiculoForm', method:'salvar'});
	});	
	
	$('#btnCancelar').click(function() {
		window.location.reload();
	});	
	
});
</script>

<!-- FORMULÁRIO -->
<div class="panel panel-primary formulario">	
	<div class="panel-body"> 
	
		<form:form id="veiculoForm" modelAttribute="view" method="post" action="cadastroVeiculo" cssClass="form-responsive"> 
		<form:hidden id="id" path="veiculo.id"/>
		
			 <fieldset>	
			 <legend>Cadastro Veículos</legend> 
			 <div class="viewMessages"></div>	
				 <div class="panel panel-default">
				 	<div class="panel-body">	
					
						<div class="row">
							<div class="col-xs-12 col-sm-4 col-md-2 col-lg-2">	
				 				<label>${codigoLabel}</label>
					 			<form:input id="codigo" path="veiculo.codigo"/>
							</div>
							<div class="col-xs-12 col-sm-8 col-md-10 col-lg-10">	
				 				<label>${descricaoLabel}</label>
					 			<form:input id="descricao" path="veiculo.descricao"/>
							</div>
						</div>	
					
						<div class="row">
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${fatorMultiplicadorLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-asterisk"></i></span>
								  <form:input id="fatorMultiplicador" path="veiculo.fatorMultiplicador" cssClass="numerico" aria-describedby="basic-addon1"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${custoKmViaPavimentadaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-dollar"></i></span>
								  <form:input id="custoKmViaPavimentada" path="veiculo.custoKmViaPav" cssClass="numerico" aria-describedby="basic-addon1"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${custoKmViaNaoPavimentadaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-dollar"></i></span>
								  <form:input id="custoKmViaNaoPavimentada" path="veiculo.custoKmViaNaoPav" cssClass="numerico" aria-describedby="basic-addon1"/>
								</div>
							</div>	
						</div>
						
						<div class="row">
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${liniteToneladaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-warning"></i></span>
								  <form:input id="liniteTonelada" path="veiculo.limiteTonelada" cssClass="soNumeros" aria-describedby="basic-addon1"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${custoKmExcessoToneladaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-dollar"></i></span>
								  <form:input id="custoKmExcessoTonelada" path="veiculo.custoKmExcessoTon" cssClass="numerico" aria-describedby="basic-addon1"/>
								</div>
							</div>	
						</div>
						
						<div class="row text-right">
							<input type="button" id="btnSalvar" class="btn btn-success" value="Salvar"/>
							<input type="button" id="btnCancelar" class="btn btn-danger" value="Cancelar"/>
						</div>
						
						<br />
						
						<fieldset>	
						<legend>Listagem De Veículos</legend> 
							<table id="grid" class="grid table table-striped table-hover table-bordered">
								<thead>
									<tr>
										<th>#</th>
										<th>${codigoLabel}</th>
										<th>${descricaoLabel}</th>
										<th>${fatorMultiplicadorLabel}</th>
										<th>${custoKmViaPavimentadaLabel}</th>
										<th>${custoKmViaNaoPavimentadaLabel}</th>
										<th>${liniteToneladaLabel}</th>
										<th>${custoKmExcessoToneladaLabel}</th>
									</tr>
								</thead>
								<tfoot><tr><td colspan="8"></td></tr></tfoot>
							</table>
						</fieldset>
						
					</div>
				</div>
			</fieldset>
		</form:form>
				 
	</div>
</div>
