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

<spring:message scope="request" code="label.veiculo.kmviapav" var="kmViaPavimentadaLabel" />
<spring:message scope="request" code="label.veiculo.kmvianaopav" var="kmViaNaoPavimentadaLabel" />
<spring:message scope="request" code="label.veiculo.pesoliquido" var="pesoLiquidoLabel" />
<spring:message scope="request" code="label.veiculo.resultado" var="resultadoLabel" />

<script>
$(function () {

	$('#btnPesquisar').click(function() {
		$.submit({form:'simuladorForm', method:'pesquisar', ajax: false});
	});	
	
	$('#btnCalcular').click(function() {
		$.submit({form:'simuladorForm', method:'calcular'});
	});	
	
});
</script>

<!-- FORMULÁRIO -->
<div class="panel panel-primary formulario">	
	<div class="panel-body"> 
	
		<form:form id="simuladorForm" modelAttribute="view" method="post" action="simuladorFrete" cssClass="form-responsive"> 
		<form:hidden id="id" path="veiculo.id"/>
		
			 <fieldset>	
			 <legend>Simulador de Cálculo de Frete</legend> 
			 <div class="viewMessages"></div>	
				 <div class="panel panel-default">
				 	<div class="panel-body">	
					
						<div class="row">
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${codigoLabel}</label>
								<div class="input-group">
									<form:input id="codigo" path="veiculo.codigo" placeholder="Pesquisar Código"/>
							      	<span class="input-group-btn">
							        	<input type="button" id="btnPesquisar" class="btn btn-info" value="Pesquisar Veículo" />
							      	</span>
							    </div>
							</div> 
							<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">	
				 				<label>${descricaoLabel}</label>
					 			<form:input id="descricao" path="veiculo.descricao" disabled="true"/>
							</div>
						</div>	
					
						<div class="row">
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${fatorMultiplicadorLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-asterisk"></i></span>
								  <form:input id="fatorMultiplicador" path="veiculo.fatorMultiplicador" aria-describedby="basic-addon1" disabled="true"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${custoKmViaPavimentadaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-dollar"></i></span>
								  <form:input id="custoKmViaPavimentada" path="veiculo.custoKmViaPav" aria-describedby="basic-addon1" disabled="true"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${custoKmViaNaoPavimentadaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-dollar"></i></span>
								  <form:input id="custoKmViaNaoPavimentada" path="veiculo.custoKmViaNaoPav" aria-describedby="basic-addon1" disabled="true"/>
								</div>
							</div>	
						</div>
						
						<div class="row">
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${liniteToneladaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-warning"></i></span>
								  <form:input id="liniteTonelada" path="veiculo.limiteTonelada" aria-describedby="basic-addon1" disabled="true"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">	
				 				<label>${custoKmExcessoToneladaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-dollar"></i></span>
								  <form:input id="custoKmExcessoTonelada" path="veiculo.custoKmExcessoTon" aria-describedby="basic-addon1" disabled="true"/>
								</div>
							</div>	
						</div>
						
						<br />
						
						<fieldset>	
						<legend>Calcular Frete</legend> 
							<div class="alert alert-info" role="alert">
							  Informe a distância em Km's que o veíclo vai percorrer e o Peso Líquido em Toneladas. 
							</div>
							<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">	
				 				<label>${kmViaPavimentadaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="glyphicon glyphicon-road"></i></span>
								  <form:input id="kmViaPavimentada" path="kmViaPavimentada" cssClass="soNumeros" aria-describedby="basic-addon1"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">	
				 				<label>${kmViaNaoPavimentadaLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="glyphicon glyphicon-road"></i></span>
								  <form:input id="kmViaNaoPavimentada" path="kmViaNaoPavimentada" cssClass="soNumeros" aria-describedby="basic-addon1"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">	
				 				<label>${pesoLiquidoLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-cubes"></i></span>
								  <form:input id="pesoLiquido" path="pesoLiquido" cssClass="soNumeros" aria-describedby="basic-addon1"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">	
				 				<label>${resultadoLabel}</label>
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-dollar"></i></span>
								  <form:input id="resultado" path="resultado" cssClass="numerico" aria-describedby="basic-addon1" readonly="true"/>
								</div>
							</div>	
							
							<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2" style="margin-top: 23px;">	
								<input type="button" id="btnCalcular" class="btn btn-success" value="Calcular"/>
							</div>	
							
						</fieldset>
						
					</div>
				</div>
			</fieldset>
		</form:form>
				 
	</div>
</div>
