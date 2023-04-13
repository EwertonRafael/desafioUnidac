package br.com.desafioGrupoWL.desafioUnidac.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioGrupoWL.desafioUnidac.model.Colaborador;
import br.com.desafioGrupoWL.desafioUnidac.service.ColaboradorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	
	private ColaboradorService colaboradorService;
	
	public ColaboradorController (ColaboradorService colaboradorService) {
		this.colaboradorService = colaboradorService;
	}
	
	@GetMapping
	public ResponseEntity<List<Colaborador>> listarColaboradores() {
		return ResponseEntity.status(200).body(colaboradorService.listarColaborador());
	}
	@PostMapping()
	public ResponseEntity<Colaborador> criarColaborador(@RequestBody @Valid Colaborador colaborador) {
		return ResponseEntity.status(201).body(colaboradorService.criarColaborador(colaborador));
	}
	@PutMapping()
	public ResponseEntity<Colaborador> atualizarColaborador(@RequestBody Colaborador colaborador) {
		return ResponseEntity.status(200).body(colaboradorService.atualizarColaborador(colaborador));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Colaborador> deletarColaborador(@PathVariable Long id) {
		colaboradorService.deletarColaborador(id);
		return ResponseEntity.status(204).build();

}
}