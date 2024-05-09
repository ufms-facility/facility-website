package br.com.facility.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.AtivAntifungica;
import br.com.facility.dto.AtivAntifungicaDTO;
import br.com.facility.repository.AtivAntifungicaRepository;

@Service
public class AtivAntifungicaService {
	@Autowired
	private AtivAntifungicaRepository ativAntiFungicaRepository;

	public AtivAntifungica save(AtivAntifungica ativAntifungica) {
		return ativAntiFungicaRepository.save(ativAntifungica);
	}

	public List<AtivAntifungicaDTO> findAll() {
		return ativAntiFungicaRepository.findAll().stream().map(ativAntifungica -> new AtivAntifungicaDTO(ativAntifungica)).collect(Collectors.toList());
	}

	public Optional<AtivAntifungica> findById(Long id) {
		return ativAntiFungicaRepository.findById(id);
	}

	public AtivAntifungica update(AtivAntifungica ativAntifungica) {
		return ativAntiFungicaRepository.save(ativAntifungica);
	}

	public void deleteById(Long id) {
		ativAntiFungicaRepository.deleteById(id);
	}
}
