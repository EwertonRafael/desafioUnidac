package br.com.desafioGrupoWL.desafioUnidac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioGrupoWL.desafioUnidac.model.Colaborador;
import br.com.desafioGrupoWL.desafioUnidac.service.ColaboradorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

	private ColaboradorService colaboradorService;

	public ColaboradorController(ColaboradorService colaboradorService) {
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
	public ResponseEntity<Colaborador> atualizarColaborador(@RequestBody @Valid Colaborador colaborador) {
		return ResponseEntity.status(200).body(colaboradorService.atualizarColaborador(colaborador));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Colaborador> deletarColaborador(@PathVariable Long id) {
		colaboradorService.deletarColaborador(id);
		return ResponseEntity.status(204).build();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
			
		});
		return errors;
	}
}