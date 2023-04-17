package br.com.desafioGrupoWL.desafioUnidac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafioGrupoWL.desafioUnidac.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

	Optional<Colaborador> findByNome(String nome);
	Optional<Colaborador> findByCpf(String cpf);
	Optional<Colaborador> findByCafe(String cafe);
}
