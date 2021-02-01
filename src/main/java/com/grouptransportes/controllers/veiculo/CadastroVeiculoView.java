package com.grouptransportes.controllers.veiculo;

import com.grouptransportes.controllers.utils.View;
import com.grouptransportes.dto.VeiculoDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroVeiculoView extends View {
	private static final long serialVersionUID = 1L;
	
	private VeiculoDTO veiculo;

	
}
