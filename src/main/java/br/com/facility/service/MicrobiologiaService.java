package br.com.facility.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.Microbiologia;
import br.com.facility.dto.MicrobiologiaDTO;
import br.com.facility.repository.MicrobiologiaRepository;

@Service
public class MicrobiologiaService {
	@Autowired
	private MicrobiologiaRepository microbiologiaRepository;

	public Microbiologia save(Microbiologia microbiologia) {
		return microbiologiaRepository.save(microbiologia);
	}

	public List<MicrobiologiaDTO> findAll() {
		return microbiologiaRepository.findAll().stream().map(microbiologia -> new MicrobiologiaDTO(microbiologia)).collect(Collectors.toList());
	}

	public Optional<Microbiologia> findById(Long id) {
		return microbiologiaRepository.findById(id);
	}

	public Microbiologia update(Microbiologia microbiologia) {
		return microbiologiaRepository.save(microbiologia);
	}

	public void deleteById(Long id) {
		microbiologiaRepository.deleteById(id);
	}
}
