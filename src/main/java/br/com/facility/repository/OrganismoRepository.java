package br.com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facility.domain.Organismo;


@Repository
public interface OrganismoRepository extends JpaRepository<Organismo, Long>{
	
}
