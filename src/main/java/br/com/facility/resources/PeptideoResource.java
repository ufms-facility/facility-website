package br.com.facility.resources;

import java.lang.reflect.Field;
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

import br.com.facility.domain.Peptideo;
import br.com.facility.service.PeptideoService;

@RestController
@RequestMapping("/api/v1/peptideos")
public class PeptideoResource {
	@Autowired
	private PeptideoService peptideoService;

	@PostMapping
	public Peptideo save(@RequestBody Peptideo peptideo) {
		return peptideoService.save(peptideo);
	}

	@GetMapping
	public ResponseEntity<List<Peptideo>> findAll() {
		List<Peptideo> peptideos = peptideoService.findAll();
		if (peptideos == null || peptideos.isEmpty()) {
			return new ResponseEntity<List<Peptideo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Peptideo>>(peptideos, HttpStatus.OK);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return peptideoService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

//	@PutMapping(value = "/{id}")
//	public ResponseEntity<Peptideo> update(@PathVariable("id") Long id, @RequestBody Peptideo peptideo) {
//		return peptideoService.findById(id).map(record -> {
//	        record.setPeptideo(peptideo.getPeptideo());
//	        record.setQuantAas(peptideo.getQuantAas());
//	        record.setTipoPeptideo(peptideo.getTipoPeptideo());
//	        record.setSequencia(peptideo.getSequencia());
//	        record.setEstruturaTridimensional(peptideo.getEstruturaTridimensional());
//	        record.setMassaMolecular(peptideo.getMassaMolecular());
//	        record.setImpediEsterico(peptideo.getImpediEsterico());
//	        record.setHidrofobocidade(peptideo.getHidrofobocidade());
//	        record.setPontoIsoeletrico(peptideo.getPontoIsoeletrico());
//	        record.setHidropatia(peptideo.getHidropatia());
//	        record.setAnfipaticidade(peptideo.getAnfipaticidade());
//	        record.setHidrofilicidade(peptideo.getHidrofilicidade());
//	        record.setCargaLiquiTotal(peptideo.getCargaLiquiTotal());
//	        record.setIndiceBoman(peptideo.getIndiceBoman());
//	        record.setDescricao(peptideo.getDescricao());
//	        
//			Peptideo updated = peptideoService.save(record);
//			return ResponseEntity.ok().body(updated);
//		}).orElse(ResponseEntity.notFound().build());
//	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Peptideo> update(@PathVariable("id") Long id, @RequestBody Peptideo peptideo) {
	  return peptideoService.findById(id)
	      .map(record -> {
	        for (Field field : Peptideo.class.getDeclaredFields()) {
	          field.setAccessible(true);
	          try {
	            field.set(record, field.get(peptideo));
	          } catch (IllegalAccessException | IllegalArgumentException e) {
	              System.err.println("Error updating field " + field.getName() + ": " + e.getMessage());
	          }
	        }
	        Peptideo updated = peptideoService.save(record);
	        return ResponseEntity.ok().body(updated);
	      })
	      .orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return peptideoService.findById(id).map(record -> {
			peptideoService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}