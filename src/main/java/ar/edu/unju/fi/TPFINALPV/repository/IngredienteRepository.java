package ar.edu.unju.fi.TPFINALPV.repository;

import ar.edu.unju.fi.TPFINALPV.entity.Ingrediente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
    @Query(value = "SELECT i FROM Ingrediente i WHERE i.estado = true")
    public List<Ingrediente> listarIngredientesActivos();
}
