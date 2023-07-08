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

    @Override
    public void saveIngrediente(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    @Override
    public Ingrediente buscarIngrediente(Long id) {
        return ingredienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarIngrediente(Long id) {
        Ingrediente encontrado = ingredienteRepository.findById(id).orElse(null);
        if (encontrado != null){
            encontrado.setEstado(false);
            ingredienteRepository.save(encontrado);
        }
    }

    @Override
    public List<Ingrediente> listarIngredientesActivos() {
        return ingredienteRepository.listarIngredientesActivos();
    }

    @Override
    public Ingrediente getIngrediente() {
        return ingrediente;
    }
}
