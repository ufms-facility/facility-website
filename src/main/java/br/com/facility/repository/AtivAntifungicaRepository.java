package br.com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facility.domain.AtivAntifungica;

@Repository
public interface AtivAntifungicaRepository extends JpaRepository<AtivAntifungica, Long>{
	
}