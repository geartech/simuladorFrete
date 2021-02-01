package com.grouptransportes.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String codigo;
	private String descricao;
	private BigDecimal fatorMultiplicador;
	private Long limiteTonelada;
	private BigDecimal custoKmViaPav;
	private BigDecimal custoKmViaNaoPav;
	private BigDecimal custoKmExcessoTon;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getFatorMultiplicador() {
		return fatorMultiplicador;
	}
	public void setFatorMultiplicador(BigDecimal fatorMultiplicador) {
		this.fatorMultiplicador = fatorMultiplicador;
	}
	public Long getLimiteTonelada() {
		return limiteTonelada;
	}
	public void setLimiteTonelada(Long limiteTonelada) {
		this.limiteTonelada = limiteTonelada;
	}
	public BigDecimal getCustoKmViaPav() {
		return custoKmViaPav;
	}
	public void setCustoKmViaPav(BigDecimal custoKmViaPav) {
		this.custoKmViaPav = custoKmViaPav;
	}
	public BigDecimal getCustoKmViaNaoPav() {
		return custoKmViaNaoPav;
	}
	public void setCustoKmViaNaoPav(BigDecimal custoKmViaNaoPav) {
		this.custoKmViaNaoPav = custoKmViaNaoPav;
	}
	public BigDecimal getCustoKmExcessoTon() {
		return custoKmExcessoTon;
	}
	public void setCustoKmExcessoTon(BigDecimal custoKmExcessoTon) {
		this.custoKmExcessoTon = custoKmExcessoTon;
	}

	
}
