package br.com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facility.domain.Celular;

@Repository
public interface CelularRepository extends JpaRepository<Celular, Long>{
	
}