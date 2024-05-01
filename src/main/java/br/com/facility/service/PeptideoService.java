package br.com.facility.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.repository.PeptideoRepository;

@Service
public class PeptideoService {
	@Autowired
	private PeptideoRepository peptideoRepository;

}