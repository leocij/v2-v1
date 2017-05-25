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

import v2v1.entity.Controle;
import v2v1.representation.ControleRepresentation;
import v2v1.service.ControleService;

@CrossOrigin
@RestController
@RequestMapping("/controles")
public class ControleController {

	@Autowired
	private ControleService controleService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<ControleRepresentation>> listAll() {
		List<Controle> controles = controleService.findAll();
		List<ControleRepresentation> controleRepresentation = new ArrayList<>();
		for (Controle c : controles) {
			controleRepresentation.add(new ControleRepresentation(c));
		}
		return ResponseEntity.ok(controleRepresentation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<ControleRepresentation> findById(@PathVariable("id") Long id) {

		Controle controle = controleService.findById(id);
		ControleRepresentation controleRepresentation = new ControleRepresentation(controle);

		return ResponseEntity.ok(controleRepresentation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody ControleRepresentation controleRepresentation) {

		Controle controle = controleService.save(ControleRepresentation.build(controleRepresentation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(controle.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody ControleRepresentation controleRepresentation,
			@PathVariable("id") Long id) {

		controleRepresentation.setIdentifier(id);
		controleService.update(ControleRepresentation.build(controleRepresentation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<ControleRepresentation> delete(@PathVariable("id") Long id) {

		Controle controle = controleService.findById(id);
		ControleRepresentation controleRepresentation = new ControleRepresentation(controle);
		controleService.delete(controle);

		return ResponseEntity.ok(controleRepresentation);
	}
}
