package br.com.desafioGrupoWL.desafioUnidac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioGrupoWL.desafioUnidac.model.Colaborador;
import br.com.desafioGrupoWL.desafioUnidac.repository.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	
	public List<Colaborador> listarColaborador(){
		List<Colaborador> lista = colaboradorRepository.findAll();
		return lista;
	}
	
	public Colaborador criarColaborador(Colaborador colaborador) {
		Colaborador criarColaborador = colaboradorRepository.save(colaborador);
		return criarColaborador;
	}
	
	public Colaborador atualizarColaborador(Colaborador colaborador) {
		Colaborador atualizarColaborador = colaboradorRepository.save(colaborador);
		return atualizarColaborador;
	}
	
	public Boolean deletarColaborador (Long id) {
		colaboradorRepository.deleteById(id);
		return true;
	}
}
