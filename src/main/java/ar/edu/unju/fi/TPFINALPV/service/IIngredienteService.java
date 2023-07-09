package ar.edu.unju.fi.TPFINALPV.service;

import ar.edu.unju.fi.TPFINALPV.entity.Ingrediente;

import java.util.List;

public interface IIngredienteService {
    /**
     * Metodo que permite guardar un ingrediente
     * @param ingrediente
     */
    public void saveIngrediente(Ingrediente ingrediente);
    /**
     * Metodo que permite buscar un ingrediente por su id
     * @param id
     * @return ingrediente que coincida con el id
     */
    public Ingrediente buscarIngrediente(Long id);
    /**
     * Metodo que permite eliminar un ingrediente, colocando su estado en false
     * @param id
     */
    public void eliminarIngrediente(Long id);
    /**
     * Metodo que permite listar los ingredientes activos (estado = true)
     * @return lista de ingredientes activos
     */
    public List<Ingrediente> listarIngredientesActivos();
    /**
     * Metodo que permite obtener un ingrediente
     * @return ingrediente
     */
    public Ingrediente getIngrediente();

}
