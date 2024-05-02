package br.com.facility.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.Organismo;
import br.com.facility.repository.OrganismoRepository;

@Service
public class OrganismoService {
	@Autowired
	private OrganismoRepository organismoRepository;

	public Organismo save(Organismo organismo) {
		return organismoRepository.save(organismo);
	}

	public List<Organismo> findAll() {
		return (List<Organismo>) organismoRepository.findAll();
	}

	public Optional<Organismo> findById(Long id) {
		return organismoRepository.findById(id);
	}

	public Organismo update(Organismo organismo) {
		return organismoRepository.save(organismo);
	}

	public void deleteById(Long id) {
		organismoRepository.deleteById(id);
	}
}
