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

import v2v1.entity.Barganha;
import v2v1.representation.BarganhaRepresentation;
import v2v1.service.BarganhaService;

@CrossOrigin
@RestController
@RequestMapping("/barganhas")
public class BarganhaController {

	@Autowired
	private BarganhaService barganhaService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<BarganhaRepresentation>> listAll() {
		List<Barganha> barganhas = barganhaService.findAll();
		List<BarganhaRepresentation> barganhaRepresentation = new ArrayList<>();
		for (Barganha c : barganhas) {
			barganhaRepresentation.add(new BarganhaRepresentation(c));
		}
		return ResponseEntity.ok(barganhaRepresentation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<BarganhaRepresentation> findById(@PathVariable("id") Long id) {

		Barganha barganha = barganhaService.findById(id);
		BarganhaRepresentation barganhaRepresentation = new BarganhaRepresentation(barganha);

		return ResponseEntity.ok(barganhaRepresentation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody BarganhaRepresentation barganhaRepresentation) {

		Barganha barganha = barganhaService.save(BarganhaRepresentation.build(barganhaRepresentation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(barganha.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody BarganhaRepresentation barganhaRepresentation,
			@PathVariable("id") Long id) {

		barganhaRepresentation.setIdentifier(id);
		barganhaService.update(BarganhaRepresentation.build(barganhaRepresentation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<BarganhaRepresentation> delete(@PathVariable("id") Long id) {

		Barganha barganha = barganhaService.findById(id);
		BarganhaRepresentation barganhaRepresentation = new BarganhaRepresentation(barganha);
		barganhaService.delete(barganha);

		return ResponseEntity.ok(barganhaRepresentation);
	}
}
