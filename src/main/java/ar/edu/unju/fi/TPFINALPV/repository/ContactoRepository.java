package ar.edu.unju.fi.TPFINALPV.repository;

import ar.edu.unju.fi.TPFINALPV.entity.Contacto;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactoRepository extends CrudRepository<Contacto, Long> {
	public List<Contacto> findByEstado(boolean estado);
}




