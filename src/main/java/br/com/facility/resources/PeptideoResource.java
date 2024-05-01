package br.com.facility.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.facility.service.PeptideoService;

@RestController
@RequestMapping("/api/v1/peptideos")
public class PeptideoResource {
	@Autowired
	private PeptideoService peptideoService;
}