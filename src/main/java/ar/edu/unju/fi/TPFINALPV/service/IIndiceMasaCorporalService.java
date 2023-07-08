package ar.edu.unju.fi.TPFINALPV.service;

import java.util.List;

import ar.edu.unju.fi.TPFINALPV.entity.IndiceMasaCorporal;

public interface IIndiceMasaCorporalService {

    public List<IndiceMasaCorporal> getAllIMC();

    public List<IndiceMasaCorporal> getDisponibles();

    public void addIMC(IndiceMasaCorporal imc);


    
}
