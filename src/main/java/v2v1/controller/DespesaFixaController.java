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

import v2v1.entity.DespesaFixa;
import v2v1.representation.DespesaFixaRepresentation;
import v2v1.service.DespesaFixaService;

@CrossOrigin
@RestController
@RequestMapping("/despesaFixas")
public class DespesaFixaController {

	@Autowired
	private DespesaFixaService despesaFixaService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<DespesaFixaRepresentation>> listAll() {
		List<DespesaFixa> despesaFixas = despesaFixaService.findAll();
		List<DespesaFixaRepresentation> despesaFixaRepresentation = new ArrayList<>();
		for (DespesaFixa c : despesaFixas) {
			despesaFixaRepresentation.add(new DespesaFixaRepresentation(c));
		}
		return ResponseEntity.ok(despesaFixaRepresentation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<DespesaFixaRepresentation> findById(@PathVariable("id") Long id) {

		DespesaFixa despesaFixa = despesaFixaService.findById(id);
		DespesaFixaRepresentation despesaFixaRepresentation = new DespesaFixaRepresentation(despesaFixa);

		return ResponseEntity.ok(despesaFixaRepresentation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(
			@Valid @RequestBody DespesaFixaRepresentation despesaFixaRepresentation) {

		DespesaFixa despesaFixa = despesaFixaService.save(DespesaFixaRepresentation.build(despesaFixaRepresentation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(despesaFixa.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody DespesaFixaRepresentation despesaFixaRepresentation,
			@PathVariable("id") Long id) {

		despesaFixaRepresentation.setIdentifier(id);
		despesaFixaService.update(DespesaFixaRepresentation.build(despesaFixaRepresentation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<DespesaFixaRepresentation> delete(@PathVariable("id") Long id) {

		DespesaFixa despesaFixa = despesaFixaService.findById(id);
		DespesaFixaRepresentation despesaFixaRepresentation = new DespesaFixaRepresentation(despesaFixa);
		despesaFixaService.delete(despesaFixa);

		return ResponseEntity.ok(despesaFixaRepresentation);
	}
}
