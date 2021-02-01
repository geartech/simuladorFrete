package com.grouptransportes.controllers.simuladorfrete;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grouptransportes.controllers.utils.CheckRequestParam;
import com.grouptransportes.controllers.utils.ControllerUtils;
import com.grouptransportes.controllers.utils.UserRequest;
import com.grouptransportes.dto.VeiculoDTO;
import com.grouptransportes.exception.DadosInsuficientesException;
import com.grouptransportes.exception.DadosRequestException;
import com.grouptransportes.exception.EntidadeJaReferenciadaException;
import com.grouptransportes.exception.EntidadeNaoEncontradaException;
import com.grouptransportes.service.veiculo.VeiculoService;

@Controller
@RequestMapping("/simuladorFrete")
public class SimuladorFreteController extends ControllerUtils {

	@Autowired
	protected VeiculoService veiculoService;

	@GetMapping(params="load")
	public String load(@ModelAttribute("view") SimuladorFreteView view) {
		return "simuladorFrete";
	}
	
	@PostMapping(params="pesquisar")
	public String pesquisar(@ModelAttribute("view") SimuladorFreteView view) {
		
		VeiculoDTO veiculo = view.getVeiculo();
		
		try {
			validaDados( new CheckRequestParam("Código").require( veiculo.getCodigo() ).maxLength(10).build() );
			veiculo = veiculoService.recuprar(veiculo.getCodigo());
			view.setVeiculo(veiculo);
			
		} catch (DadosRequestException e) {
			view.showMessagesAlert(e.getResponse());
		} catch (EntidadeNaoEncontradaException e) {
			view.showMessagesAlert("Nenhum Veículo encontrado!");
			e.printStackTrace();
		}
		
		return "simuladorFrete";
	}
	
	@PostMapping(params="calcular")
	public @ResponseBody String calcular(UserRequest user, @ModelAttribute("view") SimuladorFreteView view) {
		try {
		
			VeiculoDTO veiculo = view.getVeiculo();
			
			validaDados(
					new CheckRequestParam("Código").require( view.getKmViaPavimentada() ).build(),
					new CheckRequestParam("Descrição").require( view.getKmViaNaoPavimentada() ).build(),
					new CheckRequestParam("Descrição").require( view.getPesoLiquido() ).build()
			);
			
			DecimalFormat df = new DecimalFormat("#0.00");
			BigDecimal resultado = veiculoService.simularCalculoFrete(veiculo.getId(), view.getKmViaPavimentada(), view.getKmViaNaoPavimentada(), view.getPesoLiquido());		
			view.setElementValue("resultado", df.format(resultado));
			
		} catch (DadosRequestException e) {
			view.showMessagesAlert(e.getResponse());
		} catch (EntidadeJaReferenciadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosInsuficientesException e) {
			view.showMessagesAlert("É necessário informar todos os dados para o cálculo!");
			e.printStackTrace();
		}
		
		return view.jsonResponse();
	}
	
}
