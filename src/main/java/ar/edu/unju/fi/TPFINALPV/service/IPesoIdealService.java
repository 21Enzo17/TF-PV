package ar.edu.unju.fi.TPFINALPV.service;

import ar.edu.unju.fi.TPFINALPV.entity.PesoIdeal;

public interface IPesoIdealService{
    
    public  PesoIdeal getPesoIdeal();
	public void guardar(PesoIdeal registroPesoIdeal);
	public void modificar(PesoIdeal registroPesoIdeal);
	public void eliminar(Long id);

}