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

import v2v1.entity.Parcelamento;
import v2v1.representation.ParcelamentoRepresentation;
import v2v1.service.ParcelamentoService;

@CrossOrigin
@RestController
@RequestMapping("/parcelamentos")
public class ParcelamentoController {

	@Autowired
	private ParcelamentoService parcelamentoService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<ParcelamentoRepresentation>> listAll() {
		List<Parcelamento> parcelamentos = parcelamentoService.findAll();
		List<ParcelamentoRepresentation> parcelamentoRepresentation = new ArrayList<>();
		for (Parcelamento c : parcelamentos) {
			parcelamentoRepresentation.add(new ParcelamentoRepresentation(c));
		}
		return ResponseEntity.ok(parcelamentoRepresentation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<ParcelamentoRepresentation> findById(@PathVariable("id") Long id) {

		Parcelamento parcelamento = parcelamentoService.findById(id);
		ParcelamentoRepresentation parcelamentoRepresentation = new ParcelamentoRepresentation(parcelamento);

		return ResponseEntity.ok(parcelamentoRepresentation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(
			@Valid @RequestBody ParcelamentoRepresentation parcelamentoRepresentation) {

		Parcelamento parcelamento = parcelamentoService
				.save(ParcelamentoRepresentation.build(parcelamentoRepresentation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(parcelamento.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody ParcelamentoRepresentation parcelamentoRepresentation,
			@PathVariable("id") Long id) {

		parcelamentoRepresentation.setIdentifier(id);
		parcelamentoService.update(ParcelamentoRepresentation.build(parcelamentoRepresentation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<ParcelamentoRepresentation> delete(@PathVariable("id") Long id) {

		Parcelamento parcelamento = parcelamentoService.findById(id);
		ParcelamentoRepresentation parcelamentoRepresentation = new ParcelamentoRepresentation(parcelamento);
		parcelamentoService.delete(parcelamento);

		return ResponseEntity.ok(parcelamentoRepresentation);
	}
}
