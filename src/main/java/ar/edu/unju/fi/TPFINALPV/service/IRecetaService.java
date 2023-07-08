package ar.edu.unju.fi.TPFINALPV.service;

import ar.edu.unju.fi.TPFINALPV.entity.Receta;

import java.util.List;

public interface IRecetaService {
    /**
     * Metodo que permite guardar una receta
     * @param receta
     */
    public void saveReceta(Receta receta);

    /**
     * Metodo que permite buscar una receta por id
     * @param id
     * @return receta
     */
    public Receta buscarReceta(Long id);

    /**
     * Metodo que permite eliminar una receta por id
     * @param id
     */
    public void eliminarReceta(Long id);

    /**
     * Metodo que permite listar las recetas activas
     * @return una lista de recetas activas
     */
    public List<Receta> listarRecetasActivas();
    public List<Receta> listarRecetasConIngredientes();
    public Receta getReceta();
}
