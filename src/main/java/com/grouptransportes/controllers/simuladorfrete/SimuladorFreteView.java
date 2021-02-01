package com.grouptransportes.controllers.simuladorfrete;

import java.math.BigDecimal;

import com.grouptransportes.controllers.utils.View;
import com.grouptransportes.dto.VeiculoDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimuladorFreteView extends View {
	private static final long serialVersionUID = 1L;
	
	private VeiculoDTO veiculo;
	private Long kmViaPavimentada;
	private Long kmViaNaoPavimentada;
	private Long pesoLiquido;
	private BigDecimal resultado;
	
}
