package br.com.desafioGrupoWL.desafioUnidac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioGrupoWL.desafioUnidac.exceptions.DadosDuplicadosException;
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
	
	public Boolean deletarColaborador (Long id, Colaborador colaborador) {
		Optional<Colaborador> idInexistente = colaboradorRepository.findById(colaborador.getId());
		if (!idInexistente.isPresent()) {
			 new DadosDuplicadosException("Colaborador inexistente, digite um Id válido");
		}
		colaboradorRepository.deleteById(id);
		return true;
	}
	
	public void verificaDadosDuplicados(Colaborador colaborador) {
		Optional<Colaborador> nomeDuplicado = colaboradorRepository.findByNome(colaborador.getNome());
		if (nomeDuplicado.isPresent()) {
			throw new DadosDuplicadosException("Já existe um colaborador com o mesmo nome.");
		}
		
		Optional<Colaborador> cpfDuplicado = colaboradorRepository.findByCpf(colaborador.getCpf());
		if (cpfDuplicado.isPresent()) {
			throw new DadosDuplicadosException("Já existe um colaborador com o mesmo cpf.");
		}
		
		Optional<Colaborador> cafeDuplicado = colaboradorRepository.findByCafe(colaborador.getcafe());
		if (cafeDuplicado.isPresent()) {
			throw new DadosDuplicadosException("Já existe um colaborador com o memo café da manhã.");
		}
	}
}
