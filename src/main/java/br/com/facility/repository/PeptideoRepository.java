package br.com.facility.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.facility.domain.Peptideo;
import br.com.facility.enums.TipoPeptideo;

@Repository
public interface PeptideoRepository extends JpaRepository<Peptideo, Long>{
	List<Peptideo> findByTipoPeptideo(TipoPeptideo tipoPeptideo);
	
}