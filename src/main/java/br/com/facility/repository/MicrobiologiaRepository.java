package br.com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facility.domain.Microbiologia;

@Repository
public interface MicrobiologiaRepository extends JpaRepository<Microbiologia, Long>{
	
}