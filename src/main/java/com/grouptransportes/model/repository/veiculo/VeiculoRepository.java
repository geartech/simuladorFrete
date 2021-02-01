package com.grouptransportes.model.repository.veiculo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grouptransportes.model.entities.Veiculo;

/**
 * Repository da entidade Veiculo
 * @author Leandro Marques
 *
 */
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	public Optional<Veiculo> findByCodigo(String codigo);
	
}
