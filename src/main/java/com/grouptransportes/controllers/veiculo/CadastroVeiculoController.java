package com.grouptransportes.controllers.veiculo;

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
import com.grouptransportes.exception.DadosRequestException;
import com.grouptransportes.exception.EntidadeJaExistenteException;
import com.grouptransportes.exception.EntidadeNaoEncontradaException;
import com.grouptransportes.service.query.VeiculoQuery;
import com.grouptransportes.service.veiculo.VeiculoService;

@Controller
@RequestMapping("/cadastroVeiculo")
public class CadastroVeiculoController extends ControllerUtils {

	@Autowired
	protected VeiculoService veiculoService;
	@Autowired
	protected VeiculoQuery veiculoQuery;
	
	@GetMapping(params="load")
	public String load(@ModelAttribute("view") CadastroVeiculoView view) {
		return "cadastroVeiculos";
	}
	
	@PostMapping(params="pesquisar")
	public @ResponseBody String pesquisar(@ModelAttribute("view") CadastroVeiculoView view) {
		return jsonViewGrid(veiculoQuery.findAll());
	}
	
	@PostMapping(params="salvar")
	public @ResponseBody String salvar(UserRequest user, @ModelAttribute("view") CadastroVeiculoView view) {
		try {
		
			VeiculoDTO veiculo = view.getVeiculo();
			
			validaDados(
					new CheckRequestParam("Código").require( veiculo.getCodigo() ).maxLength(10).build(),
					new CheckRequestParam("Descrição").require( veiculo.getDescricao() ).maxLength(80).build()
			);
			
			veiculoService.salvar(
					user, 
					veiculo.getId(),
					veiculo.getCodigo(), 
					veiculo.getDescricao(), 
					veiculo.getFatorMultiplicador(), 
					veiculo.getLimiteTonelada(), 
					veiculo.getCustoKmViaPav(), 
					veiculo.getCustoKmViaNaoPav(), 
					veiculo.getCustoKmExcessoTon()
			);
			
			view.cleanform("veiculoForm");
			view.refreshGrid("grid");
			
		} catch (DadosRequestException e) {
			view.showMessagesAlert(e.getResponse());
			
		} catch (EntidadeJaExistenteException e) {
			// TODO implementar futuramente...
			e.printStackTrace();
			
		} catch (EntidadeNaoEncontradaException e) {
			// TODO implementar futuramente...
			e.printStackTrace();
			
		}
		
		return view.jsonResponse();
	}
	
}
