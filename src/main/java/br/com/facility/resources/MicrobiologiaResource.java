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

import br.com.facility.domain.Microbiologia;
import br.com.facility.dto.MicrobiologiaDTO;
import br.com.facility.service.MicrobiologiaService;

@RestController
@RequestMapping("/api/v1/microbiologia")
public class MicrobiologiaResource {
	@Autowired
	private MicrobiologiaService microbiologiaService;

	@GetMapping
	public ResponseEntity<List<MicrobiologiaDTO>> findAll() {
		List<MicrobiologiaDTO> microbiologias = microbiologiaService.findAll();
		if (microbiologias == null || microbiologias.isEmpty()) {
			return new ResponseEntity<List<MicrobiologiaDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MicrobiologiaDTO>>(microbiologias, HttpStatus.OK);
	}

	@PostMapping
	public Microbiologia create(@RequestBody Microbiologia microbiologia) {
		return microbiologiaService.save(microbiologia);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return microbiologiaService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Microbiologia> update(@PathVariable("id") Long id, @RequestBody Microbiologia microbiologia) {
		return microbiologiaService.findById(id).map(record -> {
			record.setMicrobioDesc(microbiologia.getMicrobioDesc());
			record.setPeptideo(microbiologia.getPeptideo());
			Microbiologia updated = microbiologiaService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return microbiologiaService.findById(id).map(record -> {
			microbiologiaService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}