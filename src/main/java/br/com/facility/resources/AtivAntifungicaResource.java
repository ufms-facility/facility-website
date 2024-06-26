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

import br.com.facility.domain.AtivAntifungica;
import br.com.facility.dto.AtivAntifungicaDTO;
import br.com.facility.service.AtivAntifungicaService;

@RestController
@RequestMapping("/api/v1/atividadesantifungicas")
public class AtivAntifungicaResource {
	@Autowired
	private AtivAntifungicaService ativAntifungicaService;

	@GetMapping
	public ResponseEntity<List<AtivAntifungicaDTO>> findAll() {
		List<AtivAntifungicaDTO> ativsAntifungicas = ativAntifungicaService.findAll();
		if (ativsAntifungicas == null || ativsAntifungicas.isEmpty()) {
			return new ResponseEntity<List<AtivAntifungicaDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AtivAntifungicaDTO>>(ativsAntifungicas, HttpStatus.OK);
	}

	@PostMapping
	public AtivAntifungica create(@RequestBody AtivAntifungica ativAntifungica) {
		return ativAntifungicaService.save(ativAntifungica);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ativAntifungicaService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AtivAntifungica> update(@PathVariable("id") Long id, @RequestBody AtivAntifungica ativAntifungica) {
		return ativAntifungicaService.findById(id).map(record -> {
			record.setAtivAntiFungDesc(ativAntifungica.getAtivAntiFungDesc());
			record.setPeptideo(ativAntifungica.getPeptideo());
			AtivAntifungica updated = ativAntifungicaService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return ativAntifungicaService.findById(id).map(record -> {
			ativAntifungicaService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}