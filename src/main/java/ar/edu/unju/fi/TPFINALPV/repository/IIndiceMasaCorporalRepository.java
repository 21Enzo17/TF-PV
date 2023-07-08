package ar.edu.unju.fi.TPFINALPV.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.TPFINALPV.entity.IndiceMasaCorporal;

@Repository
public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal,Long>{
    
}
