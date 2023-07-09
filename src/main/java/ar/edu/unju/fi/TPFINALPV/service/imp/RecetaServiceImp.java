package ar.edu.unju.fi.TPFINALPV.service.imp;

import ar.edu.unju.fi.TPFINALPV.entity.Receta;
import ar.edu.unju.fi.TPFINALPV.repository.RecetaRepository;
import ar.edu.unju.fi.TPFINALPV.service.IRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaServiceImp implements IRecetaService {
    @Autowired
    RecetaRepository recetaRepository;
    @Autowired
    Receta receta;

    /**
     * Metodo que permite guardar una receta
     * @param receta
     */
    @Override
    public void saveReceta(Receta receta) {

        recetaRepository.save(receta);
    }

    /**
     * Metodo que permite buscar una receta por su id
     * @param id
     * @return receta que coincida con el id
     */
    @Override
    public Receta buscarReceta(Long id) {
        return recetaRepository.findById(id).orElse(null);
    }

    /**
     * Metodo que permite eliminar una receta, colocando su estado en false
     * @param id
     */
    @Override
    public void eliminarReceta(Long id) {
        Receta encontrado = recetaRepository.findById(id).orElse(null);
        if (encontrado != null) {
            encontrado.setEstado(false);
            recetaRepository.save(encontrado);
        }
    }

    /**
     * Metodo que permite listar las recetas activas (estado = true)
     * @return lista de recetas activas
     */
    @Override
    public List<Receta> listarRecetasActivas() {
        return recetaRepository.listarRecetasActivas();
    }

    /**
     * Metodo que permite obtener una receta
     * @return receta
     */
    @Override
    public Receta getReceta() {
        return receta;
    }
}
