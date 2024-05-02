package br.com.facility.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Peptideo save(@RequestBody Peptideo peptideo){
	 return peptideoService.save(peptideo);
	}
}