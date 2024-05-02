package br.com.facility.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.Peptideo;
import br.com.facility.repository.PeptideoRepository;

@Service
public class PeptideoService {
	@Autowired
	private PeptideoRepository peptideoRepository;
	
	public Peptideo save(Peptideo peptideo) {
		return peptideoRepository.save(peptideo);
	}
	
	public List<Peptideo> findAll(){
		return (List<Peptideo>) peptideoRepository.findAll();
	}
	public Optional<Peptideo> findById(Long id) {
		return peptideoRepository.findById(id);
	}
	public Peptideo update(Peptideo peptideo) {
		return peptideoRepository.save(peptideo);
	}
	
	public void deleteById(Long id) {
		peptideoRepository.deleteById(id);
	}
}