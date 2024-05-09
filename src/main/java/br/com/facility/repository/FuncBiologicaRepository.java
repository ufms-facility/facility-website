package br.com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facility.domain.FuncBiologica;

@Repository
public interface FuncBiologicaRepository extends JpaRepository<FuncBiologica, Long>{
	
}