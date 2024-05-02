package br.com.facility.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.Organismo;
import br.com.facility.dto.OrganismoDTO;
import br.com.facility.repository.OrganismoRepository;

@Service
public class OrganismoService {
	@Autowired
	private OrganismoRepository organismoRepository;

	public Organismo save(Organismo organismo) {
		return organismoRepository.save(organismo);
	}

	public List<OrganismoDTO> findAll() {
		return organismoRepository.findAll().stream().map(organismo -> new OrganismoDTO(organismo)).collect(Collectors.toList());
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
