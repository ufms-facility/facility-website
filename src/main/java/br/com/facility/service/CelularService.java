package br.com.facility.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.Celular;
import br.com.facility.dto.CelularDTO;
import br.com.facility.repository.CelularRepository;

@Service
public class CelularService {
	@Autowired
	private CelularRepository celularRepository;

	public Celular save(Celular celular) {
		return celularRepository.save(celular);
	}

	public List<CelularDTO> findAll() {
		return celularRepository.findAll().stream().map(celular -> new CelularDTO(celular)).collect(Collectors.toList());
	}

	public Optional<Celular> findById(Long id) {
		return celularRepository.findById(id);
	}

	public Celular update(Celular celular) {
		return celularRepository.save(celular);
	}

	public void deleteById(Long id) {
		celularRepository.deleteById(id);
	}
}
