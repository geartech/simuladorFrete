<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>

	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<meta charset="UTF-8" >
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- REFERENCIAS CSS -->	
		<link rel="stylesheet" href="/bootstrap337/bootstrap.min.css" type="text/css">
		<link rel="stylesheet" href="/fontAwesome4/css/font-awesome.min.css" type="text/css">
		<link rel="stylesheet" href="/commons/css/datatables.min.css" type="text/css">
		<link rel="stylesheet" href="/commons/datatablesExt/Buttons-1.2.2/css/buttons.bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="/commons/css/animate.css" type="text/css">
		<link rel="stylesheet" href="/commons/css/master.css" type="text/css">
		
	</head>
	
<style type="text/css">
html, body {
	height: 100% !important;
}
body { 
	/* background-image: url("static/img/imagemFundo.jpg"); */
	background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100%;
    background-color: #ECECEC;
}
</style>

<!-- REFERENCIAS JS -->		
<script type="text/javascript" src="/commons/js/jquery3.min.js"></script>
<script type="text/javascript" src="/bootstrap337/bootstrap.min.js"></script>
<script type="text/javascript" src="/commons/js/moment.min.js"></script>
<script type="text/javascript" src="/commons/js/datatables.min.js"></script>
<script type="text/javascript" src="/commons/datatablesExt/Buttons-1.2.2/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="/commons/js/jquery.mask.min.js"></script>
<script type="text/javascript" src="/commons/js/master.js"></script>
	
<script>
$(function () {
	
	$('.soNumeros').mask('0#', {maxlength: false});
	$('.numerico').mask('000.000.000.000.000,00', {placeholder:"0,00", reverse: true});
	
	//Bloqueia a tecla ENTER
    $('input').keypress(function (e) {
        var code = null;
        code = (e.keyCode ? e.keyCode : e.which);                
        return (code == 13) ? false : true;
    });  
    $(document).on('keyup', 'input', function(e) {
		 if(e.keyCode == 13 && e.target.type !== 'submit') {
		   var inputs = $(e.target).parents("form").eq(0).find(":input:visible:not([readonly]):enabled"),
		   idx = inputs.index(e.target);
		       if (idx == inputs.length - 1) {
		          inputs[0].select()
		       } else {
		          inputs[idx + 1].focus();
		          inputs[idx + 1].select();
		       }
		 }
	});	 
  
    //Controle do LOAD durante a chamada ajax start
    var AJAX_BLOCK_LOAD = false;
    $(document).ajaxStart(function() {
    	$('body').off();
    	$('body').css('padding-right', 0);
    });
    
    //Controle do LOAD durante a chamada ajax complete
    $(document).ajaxComplete(function(e, x, settings, exception) {
    	$('body').on();
    	$.endLoad();
    	$('body').css('padding-right', 0);

    });
    
	$(".sidebar-dropdown > a").click(function() {
    	$(".sidebar-submenu").slideUp(200);
    	if ($(this).parent().hasClass("active")) {
    		$(".sidebar-dropdown > a").find('span.seta').removeClass("fa-chevron-down");
    		$(".sidebar-dropdown > a").find('span.seta').addClass("fa-chevron-right");
    		
   			$(".sidebar-dropdown").removeClass("active");
   			$(this).parent().removeClass("active");
   			$(this).find('span.seta').removeClass("fa-chevron-down");
   			$(this).find('span.seta').addClass("fa-chevron-right");
 		} else {
 			$(".sidebar-dropdown > a").find('span.seta').removeClass("fa-chevron-down");
    		$(".sidebar-dropdown > a").find('span.seta').addClass("fa-chevron-right");
    		
		    $(".sidebar-dropdown").removeClass("active");
		    $(this).next(".sidebar-submenu").slideDown(200);
   			$(this).parent().addClass("active");
   			$(this).find('span.seta').removeClass("fa-chevron-right");
   			$(this).find('span.seta').addClass("fa-chevron-down");
 		}
	});

	$(".sidebar-dropdown-submenu > a").click(function() {
    	$(".sidebar-submenu2").slideUp(200);
 		if ($(this).parent().hasClass("active")) {
 			$(".sidebar-dropdown-submenu > a").find('span.seta').removeClass("fa-angle-down");
    		$(".sidebar-dropdown-submenu > a").find('span.seta').addClass("fa-angle-right");
    		
 			$(".sidebar-dropdown-submenu").removeClass("active");
   			$(this).parent().removeClass("active");
   			$(this).find('span.seta').removeClass("fa-angle-down");
   			$(this).find('span.seta').addClass("fa-angle-right");
 		} else {
 			$(".sidebar-dropdown-submenu > a").find('span.seta').removeClass("fa-angle-down");
    		$(".sidebar-dropdown-submenu > a").find('span.seta').addClass("fa-angle-right");
    		
 			$(".sidebar-dropdown-submenu").removeClass("active");
		    $(this).next(".sidebar-submenu2").slideDown(200);
   			$(this).parent().addClass("active");
   			$(this).find('span.seta').removeClass("fa-angle-right");
   			$(this).find('span.seta').addClass("fa-angle-down");
 		}
	});
	
	$(".sidebar-dropdown-submenu2 > a").click(function() {
    	$(".sidebar-submenu3").slideUp(200);
 		if ($(this).parent().hasClass("active")) {
 			$(".sidebar-dropdown-submenu2 > a").find('span.seta').removeClass("fa-angle-down");
    		$(".sidebar-dropdown-submenu2 > a").find('span.seta').addClass("fa-angle-right");
    		
 			$(".sidebar-dropdown-submenu2").removeClass("active");
   			$(this).parent().removeClass("active");
   			$(this).find('span.seta').removeClass("fa-angle-down");
   			$(this).find('span.seta').addClass("fa-angle-right");
 		} else {
 			$(".sidebar-dropdown-submenu2 > a").find('span.seta').removeClass("fa-angle-down");
    		$(".sidebar-dropdown-submenu2 > a").find('span.seta').addClass("fa-angle-right");
    		
 			$(".sidebar-dropdown-submenu2").removeClass("active");
		    $(this).next(".sidebar-submenu3").slideDown(200);
   			$(this).parent().addClass("active");
   			$(this).find('span.seta').removeClass("fa-angle-right");
   			$(this).find('span.seta').addClass("fa-angle-down");
 		}
	});
	
	$("#btnMenu").click(function() {
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
	
	 //Inicia e finaliza o load
    $.loading = function() {
    	$('.modalLoad').modal({backdrop: "static", keyboard: false});
    };
    $.endLoad = function() {
    	$('.modalLoad').modal('hide');
    	$('.modalLoad').removeAttr('display', 'none');
    };
	
    //Submita o formulário (default = POST/AJAX)
	$.submit = function(options) {
		$.loading();
		var config = { 'form': null, 'method': null, 'ajax': true, 'params': null, 'handler': null, 'type': 'post' };
		if (options) {
			$.extend(config, options);
		}
		
		var formulario = $('#'+config.form);
		
		if (config.ajax) {
			var action = formulario.attr('action');
			var urlview = action +'?'+ config.method +'&'+ formulario.serialize();
			
			$.ajax({
				url: urlview,
				data: config.params,
				type: config.type,
				success: function(response) {
					var view = jQuery.parseJSON(response);
					var tam = String(view.sizePopup).trim();
					var msg = String(view.popupMsg).trim();
					
					$.submitComplemento(formulario, view);
					
					if (config.handler != null) {
						var fn = window[config.handler];
						if (typeof fn === "function") { fn.apply(); }
					}
				}
			});
			
		}else {
			var action = formulario.attr('action');
			var urlview = action +'?'+ config.method;
			formulario.prop('method', config.type);
			formulario.prop('action', urlview);
			formulario.submit();
		}
	}
  
	$.submitComplemento = function(formulario, view) {
		
		var isMsgAlertas = view.isMsgAlertas;
		var isReloadGrid = view.isReloadGrid;
		var isCleanForm = view.isReloadGrid;
		var isSetAttribute = view.isSetAttribute;
		
		//Limpa os inputs
		if (isCleanForm) {
			var element = view.formName;
			
			if ($('#'+element).is('form')) {
				$('#'+element+' *').each(function() {
					if($(this).is('input[type=text]')) {
						$(this).val('');
					}
				});
			}	
		}
		
		//Set attributos no form
		if (isSetAttribute) {
			for (i = 0; i < view.attributes.length; i++) {
				$('#'+view.attributes[i].name).val(view.attributes[i].value);
			}
		}
		
		//Atualiza o grid
		if (isReloadGrid) {
			$.reloadGrid(view.gridName);
		}
		
		//verifica se existem alertas de mensagem
		if (isMsgAlertas) {
			var msgAlertas = '';
			for (i = 0; i < view.alertas.length; i++) {
				msgAlertas += '<li>' + view.alertas[i].msg + '</li>';
			}
			
			$('.viewMessages').html('');
			var formAlertas = '<div id="viewAlertas" class="alert alert-dismissible alert-warning row">'+
								'<h4><span class="fa fa-exclamation-triangle">&nbsp;</span><spring:message code="label.atencao"/></h4>'+
								'<ol id="msg">'+ msgAlertas +'</ol>'+
							  '</div>';
			$('.viewMessages').append(formAlertas);
			$('.viewMessages').removeClass('invisivel');
			$('.viewMessages').addClass('animated flash');
		}else {
			$('.viewMessages').addClass('invisivel');
		}
		
	}
	
	$.reloadGrid = function(gridName) {
		var grid = $('#'+gridName).DataTable();
		grid.ajax.reload();
	}
	
});	 
</script>

<body>

	<!-- Menu Page -->
	<div class="page-wrapper chiller-theme toggled">
		
		<nav class="menuBar">
			<tiles:insertAttribute name="menu" />
		</nav> 			
		
		<!-- Body Page -->
		<section class="page-content">
			<div id="pagePrincipal">
				<tiles:insertAttribute name="body" />
			</div>
		</section>
		
	</div>	
	
	<!-- DIV LOADING... -->
	<div id="divModalLoad" class="modal fade modalLoad" role="dialog" data-backdrop="static" data-keyboard="false">	
		<div class="centralizaLoad-vert">
			<h1 class="txtCarregando">Processando...</h1><br />
			<div class="cssload-box cssload-loading"></div>	
		</div>
	</div>
	
</body>

</html>