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

    @Override
    public void saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscarCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCategoria(Long id) {
        Categoria encontrado = categoriaRepository.findById(id).orElse(null);
        if (encontrado != null) {
            encontrado.setEstado(false);
            categoriaRepository.save(encontrado);
        }
    }

    @Override
    public List<Categoria> listarCategoriasActivas() {
        return categoriaRepository.listarCategoriasActivas();
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }
}
