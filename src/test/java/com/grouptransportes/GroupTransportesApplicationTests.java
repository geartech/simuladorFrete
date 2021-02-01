package com.grouptransportes;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.grouptransportes.config.GroupTransportesApplication;
import com.grouptransportes.dto.VeiculoDTO;
import com.grouptransportes.exception.DadosInsuficientesException;
import com.grouptransportes.exception.EntidadeJaReferenciadaException;
import com.grouptransportes.exception.EntidadeNaoEncontradaException;
import com.grouptransportes.service.veiculo.VeiculoService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = GroupTransportesApplication.class)
class GroupTransportesApplicationTests {

	@Autowired
	VeiculoService veiculoService;
	
	@Test
	public void testaCalculoFrete() throws EntidadeNaoEncontradaException {
		VeiculoDTO veiculo = veiculoService.recuprar("01");
		
		try {
			
			BigDecimal result1 = veiculoService.simularCalculoFrete(veiculo.getId(), 90L, 0L, 8L);
			BigDecimal result2 = veiculoService.simularCalculoFrete(veiculo.getId(), 0L, 85L, 1L);
			BigDecimal result3 = veiculoService.simularCalculoFrete(veiculo.getId(), 20L, 80L, 12L);
			BigDecimal result4 = veiculoService.simularCalculoFrete(veiculo.getId(), 70L, 20L, 5L);
				
			BigDecimal resultTotal = result1.add(result2).add(result3).add(result4);
			Assertions.assertEquals((275.70), resultTotal.doubleValue());
			
		} catch (EntidadeJaReferenciadaException | DadosInsuficientesException e) {
			
		}
		
		
	}

}
