package br.com.facility.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.NomePopular;
import br.com.facility.dto.NomePopularDTO;
import br.com.facility.repository.NomePopularRepository;

@Service
public class NomePopularService {
	@Autowired
	private NomePopularRepository nomePopularRepository;

	public NomePopular save(NomePopular nomePopular) {
		return nomePopularRepository.save(nomePopular);
	}

	public List<NomePopularDTO> findAll() {
		return nomePopularRepository.findAll().stream().map(nomePopular -> new NomePopularDTO(nomePopular)).collect(Collectors.toList());
	}

	public Optional<NomePopular> findById(Long id) {
		return nomePopularRepository.findById(id);
	}

	public NomePopular update(NomePopular nomePopular) {
		return nomePopularRepository.save(nomePopular);
	}

	public void deleteById(Long id) {
		nomePopularRepository.deleteById(id);
	}
}
