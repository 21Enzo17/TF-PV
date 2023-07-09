package ar.edu.unju.fi.TPFINALPV.service.imp;

import ar.edu.unju.fi.TPFINALPV.entity.Ingrediente;
import ar.edu.unju.fi.TPFINALPV.entity.Receta;
import ar.edu.unju.fi.TPFINALPV.repository.IngredienteRepository;
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

    @Override
    public void saveReceta(Receta receta) {

        recetaRepository.save(receta);
    }

    @Override
    public Receta buscarReceta(Long id) {
        return recetaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarReceta(Long id) {
        Receta encontrado = recetaRepository.findById(id).orElse(null);
        if (encontrado != null) {
            encontrado.setEstado(false);
            recetaRepository.save(encontrado);
        }
    }

    @Override
    public List<Receta> listarRecetasActivas() {
        return recetaRepository.listarRecetasActivas();
    }

//    @Override
//    public List<Receta> listarRecetasConIngredientes() {
//        return recetaRepository.listarRecetasConIngredientes();
//    }

    @Override
    public Receta getReceta() {
        return receta;
    }
}
