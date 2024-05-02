package br.com.facility.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.facility.domain.Peptideo;
import br.com.facility.enums.TipoPeptideo;

@Repository
public interface PeptideoRepository extends CrudRepository<Peptideo, Long>{
	List<Peptideo> findByTipoPeptideo(TipoPeptideo tipoPeptideo);
	
}