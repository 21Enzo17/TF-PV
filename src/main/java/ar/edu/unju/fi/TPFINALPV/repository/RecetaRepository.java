package ar.edu.unju.fi.TPFINALPV.repository;

import ar.edu.unju.fi.TPFINALPV.entity.Receta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetaRepository extends CrudRepository<Receta, Long> {
    @Query(value = "SELECT r FROM Receta r WHERE r.estado = true")
    public List<Receta> listarRecetasActivas();
//    @Query(value = "SELECT r FROM Receta r JOIN r.ingredientes i WHERE r.estado = true")
//    public List<Receta> listarRecetasConIngredientes();
}
