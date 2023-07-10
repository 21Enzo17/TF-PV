package ar.edu.unju.fi.TPFINALPV.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFINALPV.entity.Testimonio;

public interface ITestimonioRepository extends CrudRepository<Testimonio, Long> {

	@Query(value="SELECT t FROM Testimonio t WHERE t.estado=true")
	public List<Testimonio> testimoniosDisponibles();
	
    @Query("select t from Testimonio t WHERE t.autor.nombre LIKE ?1 and t.estado=true")
    public List<Testimonio> buscarPorAutor(String nombre);

}
