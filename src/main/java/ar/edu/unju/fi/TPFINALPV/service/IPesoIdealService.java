package ar.edu.unju.fi.TPFINALPV.service;

import java.util.List;

import ar.edu.unju.fi.TPFINALPV.entity.PesoIdeal;

public interface IPesoIdealService{
	public List<PesoIdeal> getListaPI();
    public  PesoIdeal getPesoIdeal();
	public void guardar(PesoIdeal registroPesoIdeal);
	public void modificar(PesoIdeal registroPesoIdeal);
	public void eliminar(Long id);

}