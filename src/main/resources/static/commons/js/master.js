
//LOAD DA APLICAÇÃO
$(document).ready(function() {
	
	/* CONTRUÇÃO RESPONSIVA PARA ELEMENTOS */
	if ($('.form-responsive').length) {
		$('.form-responsive').addClass('form-group');
		
		$('.form-responsive').find('div.row').addClass('form-group');
		$('.form-responsive').find('input[type="text"]').addClass('form-control');
		$('.form-responsive').find('input[type="password"]').addClass('form-control');
		$('.form-responsive').find('textarea').addClass('form-control');
		$('.form-responsive').find('select').addClass('form-control');
		
	}
	
	/* LOCALE E CONFIG (DEFAULT) DO datatable.js */
	$.extend(true, $.fn.dataTable.defaults, {
		language: {
		    processing:     "<label class='gridProgress animated flash'>Processando...</label>",
		    search:         "Pesquisa&nbsp;:",
		    lengthMenu:     "Mostrar _MENU_ linhas",
		    info:           "Visualizando de _START_ a _END_ de _TOTAL_ registros",
		    infoEmpty:      "Visualizando de 0 a 0 de 0 registros.",
		    infoFiltered:   "filtrados (_MAX_ registros no total)",
		    infoPostFix:    "",
		    loadingRecords: "Carregando...",
		    zeroRecords:    "Nenhum resultado encontrado.",
		    emptyTable:     "Nenhum resultado encontrado.",
		    paginate: {
		        first:      "Primeiro",
		        previous:   "Anterior",
		        next:       "Seguinte",
		        last:       "Ultimo"
		    },
		    aria: {
		        sortAscending:  ": permite classificar a coluna em ordem crescente",
		        sortDescending: ": permite classificar a coluna em ordem decrescente"
		    }
		},
		processing: true,
		ordering: true, 
		searching: false,
		//"scrollY": "325px",
		scrollX: false,
	    scrollCollapse: true,
		columnDefs: [{"targets": [0], "visible": false, "searchable": false}],
		drawCallback: function(settings) {
			
	    }
	});
	
	$('a[data-toggle="tab"]').on( 'shown.bs.tab', function (e) {
		$.fn.dataTable.tables( {visible: true, api: true} ).columns.adjust();
	});
	
	
});