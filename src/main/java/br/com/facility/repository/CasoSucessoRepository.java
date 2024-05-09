package br.com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facility.domain.CasoSucesso;

@Repository
public interface CasoSucessoRepository extends JpaRepository<CasoSucesso, Long>{
	
}