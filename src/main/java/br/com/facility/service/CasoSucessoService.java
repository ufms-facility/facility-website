package br.com.facility.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.CasoSucesso;
import br.com.facility.dto.CasoSucessoDTO;
import br.com.facility.repository.CasoSucessoRepository;

@Service
public class CasoSucessoService {
	@Autowired
	private CasoSucessoRepository casoSucessoRepository;

	public CasoSucesso save(CasoSucesso casoSucesso) {
		return casoSucessoRepository.save(casoSucesso);
	}

	public List<CasoSucessoDTO> findAll() {
		return casoSucessoRepository.findAll().stream().map(casoSucesso -> new CasoSucessoDTO(casoSucesso)).collect(Collectors.toList());
	}

	public Optional<CasoSucesso> findById(Long id) {
		return casoSucessoRepository.findById(id);
	}

	public CasoSucesso update(CasoSucesso CasoSucesso) {
		return casoSucessoRepository.save(CasoSucesso);
	}

	public void deleteById(Long id) {
		casoSucessoRepository.deleteById(id);
	}
}
