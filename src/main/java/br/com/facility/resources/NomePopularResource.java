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

import br.com.facility.domain.NomePopular;
import br.com.facility.dto.NomePopularDTO;
import br.com.facility.service.NomePopularService;

@RestController
@RequestMapping("/api/v1/organismos")
public class NomePopularResource {
	@Autowired
	private NomePopularService nomePopularService;

	@GetMapping
	public ResponseEntity<List<NomePopularDTO>> findAll() {
		List<NomePopularDTO> nomesPopulares = nomePopularService.findAll();
		if (nomesPopulares == null || nomesPopulares.isEmpty()) {
			return new ResponseEntity<List<NomePopularDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<NomePopularDTO>>(nomesPopulares, HttpStatus.OK);
	}

	@PostMapping
	public NomePopular create(@RequestBody NomePopular nomePopular) {
		return nomePopularService.save(nomePopular);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return nomePopularService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<NomePopular> update(@PathVariable("id") Long id, @RequestBody NomePopular nomePopular) {
		return nomePopularService.findById(id).map(record -> {
			record.setNome(nomePopular.getNome());
			record.setOrganismo(nomePopular.getOrganismo());
			NomePopular updated = nomePopularService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return nomePopularService.findById(id).map(record -> {
			nomePopularService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}