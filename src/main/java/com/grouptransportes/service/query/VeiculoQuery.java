package com.grouptransportes.service.query;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * Interface responsável por realizar consultas no DataBase relacionadas ao objeto Veiculo
 * @author Leandro Marques
 *
 */
@Mapper
public interface VeiculoQuery {

	/**
	 * Consulta uma lista de veículos 
	 * @param codigo [opcional]
	 * @return Lista de Objetos [Collection<VeiculoDTO>]
	 */
	public List<Map<String, Object>> findAll();
	
}
