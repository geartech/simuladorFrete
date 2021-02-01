package com.grouptransportes.service.veiculo;

import java.math.BigDecimal;

import com.grouptransportes.controllers.utils.UserRequest;
import com.grouptransportes.dto.VeiculoDTO;
import com.grouptransportes.exception.DadosInsuficientesException;
import com.grouptransportes.exception.EntidadeJaExistenteException;
import com.grouptransportes.exception.EntidadeJaReferenciadaException;
import com.grouptransportes.exception.EntidadeNaoEncontradaException;

/**
 * Service da entidade Veiculo
 * @author Leandro Marques
 *
 */
public interface VeiculoService {

	/**
	 * Repcupera um objeto [VeiculoDTO] pelo id
	 * @param id [Obrigatório]
	 * @return VeiculoDTO
	 */
	public VeiculoDTO recuprar(Long id) throws EntidadeNaoEncontradaException;
	
	/**
	 * Repcupera um objeto [VeiculoDTO] pelo codigo
	 * @param id [Obrigatório]
	 * @return VeiculoDTO
	 */
	public VeiculoDTO recuprar(String codigo) throws EntidadeNaoEncontradaException;
	
	/**
	 * Persiste no DataBase um objeto Veiculo
	 * @param user [Obrigatório]
	 * @param id [Opcional]
	 * @param codigo [Obrigatório]
	 * @param descricao [Obrigatório]
	 * @param fatorMultiplicador [Obrigatório]
	 * @param limiteTonelada [Obrigatório]
	 * @param custoKmViaPav [Obrigatório]
	 * @param custoKmViaNaoPav [Obrigatório]
	 * @param custoKmExcessoTon [Obrigatório]
	 * @return VeiculoDTO
	 * @throws EntidadeNaoEncontradaException 
	 */
	public VeiculoDTO salvar(UserRequest user, Long id, String codigo, String descricao, BigDecimal fatorMultiplicador, Long limiteTonelada,
			BigDecimal custoKmViaPav, BigDecimal custoKmViaNaoPav, BigDecimal custoKmExcessoTon) throws EntidadeJaExistenteException, EntidadeNaoEncontradaException;
	
	/**
	 * Exclui do DataBase um ojeto Veiculo
	 * @param id [Obrigatório]
	 */
	public void remover(Long id) throws EntidadeJaReferenciadaException;
	
	/**
	 * Simula o calculo de frete
	 * @param idVeiculo  [Obrigatório]
	 * @param kmViaPavimentada [Obrigatório]
	 * @param kmViaNaoPavimentada [Obrigatório]
	 * @param pesoLiquido [Obrigatório]
	 * @return BigDecimal
	 * @throws DadosInsuficientesException 
	 */
	public BigDecimal simularCalculoFrete(Long idVeiculo, Long kmViaPavimentada, Long kmViaNaoPavimentada, Long pesoLiquido) throws EntidadeJaReferenciadaException, DadosInsuficientesException;
	
}
