package com.grouptransportes.service.veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptransportes.controllers.utils.UserRequest;
import com.grouptransportes.dto.VeiculoDTO;
import com.grouptransportes.exception.DadosInsuficientesException;
import com.grouptransportes.exception.EntidadeJaExistenteException;
import com.grouptransportes.exception.EntidadeJaReferenciadaException;
import com.grouptransportes.exception.EntidadeNaoEncontradaException;
import com.grouptransportes.model.entities.Veiculo;
import com.grouptransportes.model.repository.veiculo.VeiculoRepository;

@Service
@Transactional
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	protected VeiculoRepository veiculoRepository;
	
	
	@Override
	public VeiculoDTO recuprar(Long id) {
		Optional<Veiculo> veiculo = id != null ? veiculoRepository.findById(id) : Optional.empty();
		return veiculo.isPresent() ? veiculo.get().getDTO() : null;
	}

	@Override
	public VeiculoDTO recuprar(String codigo) {
		Optional<Veiculo> veiculo = codigo != null ? veiculoRepository.findByCodigo(codigo) : Optional.empty();
		return veiculo.isPresent() ? veiculo.get().getDTO() : null;
	}
	
	@Override
	public VeiculoDTO salvar(UserRequest user, Long id, String codigo, String descricao, BigDecimal fatorMultiplicador,
			Long limiteTonelada, BigDecimal custoKmViaPav, BigDecimal custoKmViaNaoPav, BigDecimal custoKmExcessoTon) throws EntidadeNaoEncontradaException, EntidadeJaExistenteException {
		
		if (id != null) {
			return atualizar(user, id, codigo, descricao, fatorMultiplicador, limiteTonelada, custoKmViaPav, custoKmViaNaoPav, custoKmExcessoTon);
		} else {
			return criar(user, codigo, descricao, fatorMultiplicador, limiteTonelada, custoKmViaPav, custoKmViaNaoPav, custoKmExcessoTon);
		}

	}

	@Override
	public void remover(Long id) {
		Optional<Veiculo> optVeiculo = id != null ? veiculoRepository.findById(id) : Optional.empty();
		if (optVeiculo.isPresent()) {
			veiculoRepository.delete(optVeiculo.get());
		}
	}

	public VeiculoDTO criar(UserRequest user, String codigo, String descricao, BigDecimal fatorMultiplicador,
			Long limiteTonelada, BigDecimal custoKmViaPav, BigDecimal custoKmViaNaoPav, BigDecimal custoKmExcessoTon) throws EntidadeJaExistenteException {
		
		Optional<Veiculo> optVeiculo = codigo != null ? veiculoRepository.findByCodigo(codigo) : null;
		if (!optVeiculo.isEmpty()) {
			new EntidadeJaExistenteException();
		} 
		
		
		Veiculo veiculo = Veiculo.builder()
				.codigo(codigo)
				.codUserCriacao(user.getUserName())
				.dthrCriacao(LocalDateTime.now())
				.codigo(codigo)
				.descricao(descricao)
				.fatorMultiplicador(fatorMultiplicador)
				.custoKmViaPav(custoKmViaPav)
				.custoKmViaNaoPav(custoKmViaNaoPav)
				.limiteTonelada(limiteTonelada)
				.custoKmExcessoTon(custoKmExcessoTon)
				.build();
		
		veiculo = veiculoRepository.save(veiculo);
		return veiculo != null ? veiculo.getDTO() : null;
		
	}
	
	public VeiculoDTO atualizar(UserRequest user, Long id, String codigo, String descricao, BigDecimal fatorMultiplicador,
			Long limiteTonelada, BigDecimal custoKmViaPav, BigDecimal custoKmViaNaoPav, BigDecimal custoKmExcessoTon) throws EntidadeNaoEncontradaException {
		
		Optional<Veiculo> optVeiculo = id != null ? veiculoRepository.findById(id) : Optional.empty();
		
		Veiculo veiculo = optVeiculo.orElseThrow(() -> new EntidadeNaoEncontradaException("codigo", codigo));
		
		veiculo.setCodigo(codigo);
		veiculo.setDescricao(descricao);
		veiculo.setFatorMultiplicador(fatorMultiplicador);
		veiculo.setCustoKmViaPav(custoKmViaPav);
		veiculo.setCustoKmViaNaoPav(custoKmViaNaoPav);
		veiculo.setLimiteTonelada(limiteTonelada);
		veiculo.setCustoKmExcessoTon(custoKmExcessoTon);
				
		veiculo = veiculoRepository.save(veiculo);
		return veiculo != null ? veiculo.getDTO() : null;
	}

	@Override
	public BigDecimal simularCalculoFrete(Long idVeiculo, Long kmViaPavimentada, Long kmViaNaoPavimentada, Long pesoLiquido) throws EntidadeJaReferenciadaException, DadosInsuficientesException {
		VeiculoDTO veiculo = recuprar(idVeiculo);
		
		BigDecimal custoViaPavimentada = calculaCustoViaPavimentada(veiculo.getFatorMultiplicador(), veiculo.getCustoKmViaPav(), kmViaPavimentada);
		BigDecimal custoViaNaoPavimentada = calculaCustoViaNaoPavimentada(veiculo.getFatorMultiplicador(), veiculo.getCustoKmViaNaoPav(), kmViaNaoPavimentada);
		
		Long totalKm = kmViaPavimentada + kmViaNaoPavimentada;
		BigDecimal custoKmExcessoPeso = calculaCustoKmExcessoPeso(veiculo.getLimiteTonelada(), veiculo.getCustoKmExcessoTon(), pesoLiquido, totalKm);
		
		return custoViaPavimentada.add(custoViaNaoPavimentada).add(custoKmExcessoPeso);
		
	}

	private BigDecimal calculaCustoViaPavimentada(BigDecimal fatorMultiplicador, BigDecimal custoKmViaPav, Long kmViaPavimentada) throws DadosInsuficientesException {
		checkIsNull(fatorMultiplicador);
		checkIsNull(custoKmViaPav);
		checkIsNull(kmViaPavimentada);
		
		return fatorMultiplicador.multiply(custoKmViaPav.multiply(new BigDecimal(kmViaPavimentada)));
	}
	
	private BigDecimal calculaCustoViaNaoPavimentada(BigDecimal fatorMultiplicador, BigDecimal custoKmViaNaoPav, Long kmViaNaoPavimentada) throws DadosInsuficientesException {
		checkIsNull(fatorMultiplicador);
		checkIsNull(custoKmViaNaoPav);
		checkIsNull(kmViaNaoPavimentada);
		
		return fatorMultiplicador.multiply(custoKmViaNaoPav.multiply(new BigDecimal(kmViaNaoPavimentada)));		
	}
	
	private BigDecimal calculaCustoKmExcessoPeso(long limiteTonelada, BigDecimal custoKmExcessoPeso, Long pesoLiquido, Long totalKm) throws DadosInsuficientesException {
		BigDecimal resultado = BigDecimal.ZERO;
		
		checkIsNull(limiteTonelada);
		checkIsNull(custoKmExcessoPeso);
		checkIsNull(pesoLiquido);
		checkIsNull(totalKm);
		
		if (pesoLiquido > limiteTonelada) {
			Long excesso = pesoLiquido - limiteTonelada;
			resultado = custoKmExcessoPeso.multiply(new BigDecimal(excesso)).multiply(new BigDecimal(totalKm));
			
		} 
		return resultado;
	}
	
	/**
	 * Checa valores nuéricos nullos
	 * @param object
	 * @throws DadosInsuficientesException 
	 */
	private void checkIsNull(Object object) throws DadosInsuficientesException {
		if (object == null) {
			throw new DadosInsuficientesException();
		}
	}
}
