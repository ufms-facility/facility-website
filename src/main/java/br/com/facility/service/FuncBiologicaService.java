package br.com.facility.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.FuncBiologica;
import br.com.facility.dto.FuncBiologicaDTO;
import br.com.facility.repository.FuncBiologicaRepository;

@Service
public class FuncBiologicaService {
	@Autowired
	private FuncBiologicaRepository funcBiologicaRepository;

	public FuncBiologica save(FuncBiologica funcBiologica) {
		return funcBiologicaRepository.save(funcBiologica);
	}

	public List<FuncBiologicaDTO> findAll() {
		return funcBiologicaRepository.findAll().stream().map(funcBiologica -> new FuncBiologicaDTO(funcBiologica)).collect(Collectors.toList());
	}

	public Optional<FuncBiologica> findById(Long id) {
		return funcBiologicaRepository.findById(id);
	}

	public FuncBiologica update(FuncBiologica funcBiologica) {
		return funcBiologicaRepository.save(funcBiologica);
	}

	public void deleteById(Long id) {
		funcBiologicaRepository.deleteById(id);
	}
}
