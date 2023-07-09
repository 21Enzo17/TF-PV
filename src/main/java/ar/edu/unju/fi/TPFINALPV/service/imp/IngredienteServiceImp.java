package ar.edu.unju.fi.TPFINALPV.service.imp;

import ar.edu.unju.fi.TPFINALPV.entity.Ingrediente;
import ar.edu.unju.fi.TPFINALPV.repository.IngredienteRepository;
import ar.edu.unju.fi.TPFINALPV.service.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteServiceImp implements IIngredienteService {
    @Autowired
    IngredienteRepository ingredienteRepository;
    @Autowired
    Ingrediente ingrediente;

    /**
     * Metodo que permite guardar un ingrediente
     * @param ingrediente
     */
    @Override
    public void saveIngrediente(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    /**
     * Metodo que permite buscar un ingrediente por su id
     * @param id
     * @return ingrediente que coincida con el id
     */
    @Override
    public Ingrediente buscarIngrediente(Long id) {
        return ingredienteRepository.findById(id).orElse(null);
    }

    /**
     * Metodo que permite eliminar un ingrediente, colocando su estado en false
     * @param id
     */
    @Override
    public void eliminarIngrediente(Long id) {
        Ingrediente encontrado = ingredienteRepository.findById(id).orElse(null);
        if (encontrado != null){
            encontrado.setEstado(false);
            ingredienteRepository.save(encontrado);
        }
    }

    /**
     * Metodo que permite listar los ingredientes activos (estado = true)
     * @return lista de ingredientes activos
     */
    @Override
    public List<Ingrediente> listarIngredientesActivos() {
        return ingredienteRepository.listarIngredientesActivos();
    }

    /**
     * Metodo que permite obtener un ingrediente
     * @return ingrediente
     */
    @Override
    public Ingrediente getIngrediente() {
        return ingrediente;
    }
}
