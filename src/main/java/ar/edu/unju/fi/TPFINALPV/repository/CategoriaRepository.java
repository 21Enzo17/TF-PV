package ar.edu.unju.fi.TPFINALPV.repository;

import ar.edu.unju.fi.TPFINALPV.entity.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    @Query(value = "SELECT c FROM Categoria c WHERE c.estado = true")
    public List<Categoria> listarCategoriasActivas();
}
