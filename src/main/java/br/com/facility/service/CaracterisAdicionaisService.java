package br.com.facility.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facility.domain.CaracterisAdicionais;
import br.com.facility.dto.CaracterisAdicionaisDTO;
import br.com.facility.repository.CaracterisAdicionaisRepository;

@Service
public class CaracterisAdicionaisService {
	@Autowired
	private CaracterisAdicionaisRepository caracterisAdicionaisRepository;

	public CaracterisAdicionais save(CaracterisAdicionais caracterisAdicionais) {
		return caracterisAdicionaisRepository.save(caracterisAdicionais);
	}

	public List<CaracterisAdicionaisDTO> findAll() {
		return caracterisAdicionaisRepository.findAll().stream().map(caracterisAdicionais -> new CaracterisAdicionaisDTO(caracterisAdicionais)).collect(Collectors.toList());
	}

	public Optional<CaracterisAdicionais> findById(Long id) {
		return caracterisAdicionaisRepository.findById(id);
	}

	public CaracterisAdicionais update(CaracterisAdicionais caracterisAdicionais) {
		return caracterisAdicionaisRepository.save(caracterisAdicionais);
	}

	public void deleteById(Long id) {
		caracterisAdicionaisRepository.deleteById(id);
	}
}
