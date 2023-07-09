package ar.edu.unju.fi.TPFINALPV.service.imp;

import ar.edu.unju.fi.TPFINALPV.entity.Categoria;
import ar.edu.unju.fi.TPFINALPV.repository.CategoriaRepository;
import ar.edu.unju.fi.TPFINALPV.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements ICategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    Categoria categoria;

    /**
     * Metodo que permite guardar una categoria
     * @param categoria
     */
    @Override
    public void saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    /**
     * Metodo que permite buscar una categoria por su id
     * @param id
     * @return categoria que coincida con el id
     */
    @Override
    public Categoria buscarCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    /**
     * Metodo que permite eliminar una categoria, colocando su estado en false
     * @param id
     */
    @Override
    public void eliminarCategoria(Long id) {
        Categoria encontrado = categoriaRepository.findById(id).orElse(null);
        if (encontrado != null) {
            encontrado.setEstado(false);
            categoriaRepository.save(encontrado);
        }
    }

    /**
     * Metodo que permite listar las categorias activas (estado = true)
     * @return lista de categorias activas
     */
    @Override
    public List<Categoria> listarCategoriasActivas() {
        return categoriaRepository.listarCategoriasActivas();
    }

    /**
     * Metodo que permite obtener una categoria
     * @return categoria
     */
    @Override
    public Categoria getCategoria() {
        return categoria;
    }
}
