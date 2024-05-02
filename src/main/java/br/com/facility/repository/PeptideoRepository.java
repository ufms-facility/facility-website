package br.com.facility.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.facility.domain.Peptideo;

@Repository
public interface PeptideoRepository extends CrudRepository<Peptideo, Long>{

}