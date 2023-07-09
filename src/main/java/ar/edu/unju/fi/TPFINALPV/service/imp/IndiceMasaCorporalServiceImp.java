package ar.edu.unju.fi.TPFINALPV.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFINALPV.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.TPFINALPV.entity.User;
import ar.edu.unju.fi.TPFINALPV.repository.IIndiceMasaCorporalRepository;
import ar.edu.unju.fi.TPFINALPV.service.IIndiceMasaCorporalService;

@Service
public class IndiceMasaCorporalServiceImp implements IIndiceMasaCorporalService {
    
    @Autowired
    IIndiceMasaCorporalRepository indiceMasaCorporalRepository;

    /**
     * Metodo que retorna la lista de imc de un usuario
     */
    @Override
    public List<IndiceMasaCorporal> getAllIMC(User user) {
        return indiceMasaCorporalRepository.findByUsuario(user);
    }

    /**
     * Metodo que guarda un registro de imc
     */
    @Override
    public void addIMC(IndiceMasaCorporal imc) {
        indiceMasaCorporalRepository.save(imc);
    }
    
}
