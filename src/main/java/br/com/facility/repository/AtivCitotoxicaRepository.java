package br.com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facility.domain.AtivCitotoxica;

@Repository
public interface AtivCitotoxicaRepository extends JpaRepository<AtivCitotoxica, Long>{
	
}