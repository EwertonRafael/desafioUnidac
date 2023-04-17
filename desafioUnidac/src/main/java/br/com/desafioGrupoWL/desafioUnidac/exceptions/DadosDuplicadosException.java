package br.com.desafioGrupoWL.desafioUnidac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DadosDuplicadosException {

	public DadosDuplicadosException(String eMensagem) {
        super(eMensagem);
	}
	
}
