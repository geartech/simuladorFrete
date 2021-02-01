<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<spring:message scope="request" code="label.configuracoes" var="configuracoesLabel" />
<spring:message scope="request" code="label.veiculos" var="veiculoLabel" />
<spring:message scope="request" code="label.simulador" var="simuladorLabel" />

<style type="text/css">
.sidebar-logo { color: white; }
</style>

<script>
$(function() {
	
	$("#close-sidebar").click(function() {
		if ($(".page-wrapper").hasClass("toggled")) {
			$(".page-wrapper").removeClass("toggled");
			$("#btnMenu i.fa").removeClass('fa-chevron-left');
			$("#btnMenu i.fa").addClass('fa-bars');
		} else {
			$(".page-wrapper").addClass("toggled");
			$("#btnMenu i.fa").toggleClass('fa-close');
			$("#btnMenu i.fa").removeClass('fa-bars');
			$("#btnMenu i.fa").addClass('fa-chevron-left');
		}	
		var formMenu = parseInt($('.formMenu').css('height'));
		$(".formBody").css('margin-top', formMenu);
	});

});
</script>

<nav id="sidebar" class="sidebar-wrapper">
	<div class="sidebar-content">
    	
		<div class="hidden-sm hidden-md hidden-lg text-right" style="padding: 3px 15px 0px 0px;">
         	<i id="close-sidebar" class="fa fa-close" style="font-size: 20px;"></i>
       	</div>			
		
    	<div class="sidebar-brand text-center">
        	<div class="row">
        		<div class="sidebar-logo text-center" style="width: 180px;">
		      		<h3>Group Transportes</h3>
        		</div>
        	</div>
      	</div>
      
		<div class="sidebar-menu">
	    	<ul>
	    	
	          	<!-- MENU INICIO -->
	          	<li class="sidebar-dropdown">
		            
		            <a href="#">
		              <i class="fa fa-cogs"></i>
		              <span>${configuracoesLabel}</span>
		              <span class="fa fa-chevron-right seta"></span>
		            </a>
		          
		            <div class="sidebar-submenu">
						<ul>
							<li><a href="cadastroVeiculo?load">${veiculoLabel}</a></li>	
							<li><a href="simuladorFrete?load">${simuladorLabel}</a></li>	
        				</ul>
		            </div>
		            
	          	 </li>
	          	 <!-- MENU FIM -->
	          
	        </ul>
    	</div>
    </div>    
</nav>