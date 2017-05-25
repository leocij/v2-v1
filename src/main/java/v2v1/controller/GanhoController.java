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

import v2v1.entity.Ganho;
import v2v1.representation.GanhoRepresentation;
import v2v1.service.GanhoService;

@CrossOrigin
@RestController
@RequestMapping("/ganhos")
public class GanhoController {

	@Autowired
	private GanhoService ganhoService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<GanhoRepresentation>> listAll() {
		List<Ganho> ganhos = ganhoService.findAll();
		List<GanhoRepresentation> ganhoRepresentation = new ArrayList<>();
		for (Ganho c : ganhos) {
			ganhoRepresentation.add(new GanhoRepresentation(c));
		}
		return ResponseEntity.ok(ganhoRepresentation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GanhoRepresentation> findById(@PathVariable("id") Long id) {

		Ganho ganho = ganhoService.findById(id);
		GanhoRepresentation ganhoRepresentation = new GanhoRepresentation(ganho);

		return ResponseEntity.ok(ganhoRepresentation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody GanhoRepresentation ganhoRepresentation) {

		Ganho ganho = ganhoService.save(GanhoRepresentation.build(ganhoRepresentation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ganho.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody GanhoRepresentation ganhoRepresentation,
			@PathVariable("id") Long id) {

		ganhoRepresentation.setIdentifier(id);
		ganhoService.update(GanhoRepresentation.build(ganhoRepresentation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<GanhoRepresentation> delete(@PathVariable("id") Long id) {

		Ganho ganho = ganhoService.findById(id);
		GanhoRepresentation ganhoRepresentation = new GanhoRepresentation(ganho);
		ganhoService.delete(ganho);

		return ResponseEntity.ok(ganhoRepresentation);
	}
}
