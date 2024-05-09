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

import br.com.facility.domain.Celular;
import br.com.facility.dto.CelularDTO;
import br.com.facility.service.CelularService;

@RestController
@RequestMapping("/api/v1/celulares")
public class CelularResources {
	@Autowired
	private CelularService celularService;

	@GetMapping
	public ResponseEntity<List<CelularDTO>> findAll() {
		List<CelularDTO> celulares = celularService.findAll();
		if (celulares == null || celulares.isEmpty()) {
			return new ResponseEntity<List<CelularDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CelularDTO>>(celulares, HttpStatus.OK);
	}

	@PostMapping
	public Celular create(@RequestBody Celular celular) {
		return celularService.save(celular);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return celularService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Celular> update(@PathVariable("id") Long id, @RequestBody Celular celular) {
		return celularService.findById(id).map(record -> {
			record.setCelularDesc(celular.getCelularDesc());
			record.setPeptideo(celular.getPeptideo());
			Celular updated = celularService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return celularService.findById(id).map(record -> {
			celularService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}