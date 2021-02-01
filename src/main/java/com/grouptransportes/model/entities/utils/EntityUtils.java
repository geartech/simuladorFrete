package com.grouptransportes.model.entities.utils;

import java.time.LocalDateTime;

public abstract class EntityUtils {

	protected abstract void setdthrUltimaAtualizacao(LocalDateTime dthrUltimaAtualizacao);
	protected abstract void setCodUserUltimaAtualizacao(String codUserUltimaAtualizacao);
	protected abstract void auditoria();
	
	public void auditar() {
		setdthrUltimaAtualizacao(LocalDateTime.now());
		setCodUserUltimaAtualizacao("usuarioDaRequisicao");      
	}
	
}
