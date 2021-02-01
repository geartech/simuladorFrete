package com.grouptransportes.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.beans.BeanUtils;

import com.grouptransportes.dto.VeiculoDTO;
import com.grouptransportes.model.entities.utils.EntityUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

@Entity
@Table(name = "veiculo", schema = "public")
public class Veiculo extends EntityUtils {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "dthrCriacao")
	private LocalDateTime dthrCriacao;
	
	@Column(name = "codUserCriacao")
	private String codUserCriacao;
	
	@Column(name = "dthrUltimaAtualizacao")
	private LocalDateTime dthrUltimaAtualizacao;
	
	@Column(name = "codUserUltimaAtualizacao")
	private String codUserUltimaAtualizacao;
	
	@Version
	@Column(name="version")
	private Integer version;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "fatorMultiplicador")
	private BigDecimal fatorMultiplicador;
	
	@Column(name = "limiteTonelada")
	private Long limiteTonelada;
	
	@Column(name = "custoKmViaPav")
	private BigDecimal custoKmViaPav;
	
	@Column(name = "custoKmViaNaoPav")
	private BigDecimal custoKmViaNaoPav;
	
	@Column(name = "custoKmExcessoTon")
	private BigDecimal custoKmExcessoTon;

	@Override
	protected void setdthrUltimaAtualizacao(LocalDateTime dthrUltimaAtualizacao) {
		this.dthrUltimaAtualizacao = dthrUltimaAtualizacao;
		
	}

	@Override
	protected void setCodUserUltimaAtualizacao(String codUserUltimaAtualizacao) {
		this.codUserUltimaAtualizacao = codUserUltimaAtualizacao;
		
	}
	
	@PrePersist
	@PreUpdate
	@PreRemove
	@Override
	protected void auditoria() {
		auditar();
	}

	public VeiculoDTO getDTO() {
		VeiculoDTO target = new VeiculoDTO();
		BeanUtils.copyProperties(this, target);
		return target;
	}
	
}
