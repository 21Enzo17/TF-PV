package ar.edu.unju.fi.TPFINALPV.service;

import ar.edu.unju.fi.TPFINALPV.entity.Ingrediente;

import java.util.List;

public interface IIngredienteService {
    public void saveIngrediente(Ingrediente ingrediente);
    public Ingrediente buscarIngrediente(Long id);
    public void eliminarIngrediente(Long id);
    public List<Ingrediente> listarIngredientesActivos();
    public Ingrediente getIngrediente();

}
