package br.com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.facility.domain.Organismo;

public interface OrganismoRepository extends JpaRepository<Organismo, Long>{
	
}
