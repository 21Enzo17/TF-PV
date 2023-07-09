package ar.edu.unju.fi.TPFINALPV.service;

import java.util.List;

import ar.edu.unju.fi.TPFINALPV.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.TPFINALPV.entity.User;

public interface IIndiceMasaCorporalService {

    public List<IndiceMasaCorporal> getAllIMC(User user);

    public void addIMC(IndiceMasaCorporal imc);


    
}
