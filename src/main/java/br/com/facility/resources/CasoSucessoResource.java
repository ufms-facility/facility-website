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

import br.com.facility.domain.CasoSucesso;
import br.com.facility.dto.CasoSucessoDTO;
import br.com.facility.service.CasoSucessoService;

@RestController
@RequestMapping("/api/v1/casossucesso")
public class CasoSucessoResource {
	@Autowired
	private CasoSucessoService casoSucessoService;

	@GetMapping
	public ResponseEntity<List<CasoSucessoDTO>> findAll() {
		List<CasoSucessoDTO> casosSucessos = casoSucessoService.findAll();
		if (casosSucessos == null || casosSucessos.isEmpty()) {
			return new ResponseEntity<List<CasoSucessoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CasoSucessoDTO>>(casosSucessos, HttpStatus.OK);
	}

	@PostMapping
	public CasoSucesso create(@RequestBody CasoSucesso casoSucesso) {
		return casoSucessoService.save(casoSucesso);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return casoSucessoService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CasoSucesso> update(@PathVariable("id") Long id, @RequestBody CasoSucesso casoSucesso) {
		return casoSucessoService.findById(id).map(record -> {
			record.setCaso(casoSucesso.getCaso());
			record.setPeptideo(casoSucesso.getPeptideo());
			CasoSucesso updated = casoSucessoService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return casoSucessoService.findById(id).map(record -> {
			casoSucessoService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}