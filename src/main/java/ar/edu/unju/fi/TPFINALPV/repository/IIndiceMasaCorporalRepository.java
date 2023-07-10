package ar.edu.unju.fi.TPFINALPV.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.TPFINALPV.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.TPFINALPV.entity.User;

@Repository
public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal,Long>{
    
    public List<IndiceMasaCorporal> findByUsuario(User usuario);

}
