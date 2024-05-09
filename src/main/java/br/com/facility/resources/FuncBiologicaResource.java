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

import br.com.facility.domain.FuncBiologica;
import br.com.facility.dto.FuncBiologicaDTO;
import br.com.facility.service.FuncBiologicaService;

@RestController
@RequestMapping("/api/v1/funcoesbiologicas")
public class FuncBiologicaResource {
	@Autowired
	private FuncBiologicaService funcBiologicaService;

	@GetMapping
	public ResponseEntity<List<FuncBiologicaDTO>> findAll() {
		List<FuncBiologicaDTO> funcsBiologicas = funcBiologicaService.findAll();
		if (funcsBiologicas == null || funcsBiologicas.isEmpty()) {
			return new ResponseEntity<List<FuncBiologicaDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FuncBiologicaDTO>>(funcsBiologicas, HttpStatus.OK);
	}

	@PostMapping
	public FuncBiologica create(@RequestBody FuncBiologica funcBiologica) {
		return funcBiologicaService.save(funcBiologica);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return funcBiologicaService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<FuncBiologica> update(@PathVariable("id") Long id, @RequestBody FuncBiologica funcBiologica) {
		return funcBiologicaService.findById(id).map(record -> {
			record.setFuncBiolDesc(funcBiologica.getFuncBiolDesc());
			record.setPeptideo(funcBiologica.getPeptideo());
			FuncBiologica updated = funcBiologicaService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return funcBiologicaService.findById(id).map(record -> {
			funcBiologicaService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}