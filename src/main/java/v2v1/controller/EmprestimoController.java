package v2v1.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import v2v1.entity.Emprestimo;
import v2v1.representation.EmprestimoRepresentation;
import v2v1.service.EmprestimoService;

@CrossOrigin
@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoService emprestimoService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<EmprestimoRepresentation>> listAll() {
		List<Emprestimo> emprestimos = emprestimoService.findAll();
		List<EmprestimoRepresentation> emprestimoRepresentation = new ArrayList<>();
		for (Emprestimo c : emprestimos) {
			emprestimoRepresentation.add(new EmprestimoRepresentation(c));
		}
		return ResponseEntity.ok(emprestimoRepresentation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<EmprestimoRepresentation> findById(@PathVariable("id") Long id) {

		Emprestimo emprestimo = emprestimoService.findById(id);
		EmprestimoRepresentation emprestimoRepresentation = new EmprestimoRepresentation(emprestimo);

		return ResponseEntity.ok(emprestimoRepresentation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody EmprestimoRepresentation emprestimoRepresentation) {

		Emprestimo emprestimo = emprestimoService.save(EmprestimoRepresentation.build(emprestimoRepresentation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emprestimo.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody EmprestimoRepresentation emprestimoRepresentation,
			@PathVariable("id") Long id) {

		emprestimoRepresentation.setIdentifier(id);
		emprestimoService.update(EmprestimoRepresentation.build(emprestimoRepresentation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<EmprestimoRepresentation> delete(@PathVariable("id") Long id) {

		Emprestimo emprestimo = emprestimoService.findById(id);
		EmprestimoRepresentation emprestimoRepresentation = new EmprestimoRepresentation(emprestimo);
		emprestimoService.delete(emprestimo);

		return ResponseEntity.ok(emprestimoRepresentation);
	}
}
