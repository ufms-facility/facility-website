package br.com.facility.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.facility.domain.Organismo;
import br.com.facility.service.OrganismoService;

@RestController
@RequestMapping("/api/v1/organismos")
public class OrganismoResource {
	@Autowired
	private OrganismoService organismoService;

	@GetMapping
	public ResponseEntity<List<Organismo>> findAll() {
		List<Organismo> organismos = organismoService.findAll();
		if (organismos == null || organismos.isEmpty()) {
			return new ResponseEntity<List<Organismo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Organismo>>(organismos, HttpStatus.OK);
	}

	@PostMapping
	public Organismo create(@RequestBody Organismo organismo) {
		return organismoService.save(organismo);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return organismoService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Organismo> update(@PathVariable("id") Long id, @RequestBody Organismo organismo) {
		return organismoService.findById(id).map(record -> {
			record.setEspecie(organismo.getEspecie());
			record.setOrigem(organismo.getOrigem());
			record.setFamilia(organismo.getFamilia());
			record.setNomeCientifico(organismo.getNomeCientifico());
			Organismo updated = organismoService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return organismoService.findById(id).map(record -> {
			organismoService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}