package br.com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facility.domain.CaracterisAdicionais;

@Repository
public interface CaracterisAdicionaisRepository extends JpaRepository<CaracterisAdicionais, Long>{
	
}