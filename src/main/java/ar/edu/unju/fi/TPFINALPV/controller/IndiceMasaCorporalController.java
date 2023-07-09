package ar.edu.unju.fi.TPFINALPV.controller;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFINALPV.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.TPFINALPV.entity.User;
import ar.edu.unju.fi.TPFINALPV.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/imc")
public class IndiceMasaCorporalController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IndiceMasaCorporal imc;
    
    @Autowired
    private IIndiceMasaCorporalService indiceMasaCorporalService; 

    @Autowired
    private User user;
    /**
     * Metodo que retorna la pagina calculadora
     * @param model
     * @return "imc"
     */
    @GetMapping("/calculadora")
    public String getCalculadora(Model model) {
        model.addAttribute("logueado", false);
        return "imc";
    }
    /**
     * Metodo que permite el logueo de un usuario
     * @param id
     * @param model
     * @return "imc"
     */
    @GetMapping("/login")
    public String getCalculadoraLogueado(@RequestParam("id")String id,Model model){
        if(id.equals(null) || id.equals("")){
            model.addAttribute("logueado", false);
            model.addAttribute("error", "Envie datos validos");
        }else{
            user = userService.findByUser(Long.parseLong(id));
            if(user == null){
                model.addAttribute("logueado", false);
                model.addAttribute("error", "No se encontro el usuario");
            }else{
                model.addAttribute("logueado", true);
                model.addAttribute("user", user);
                model.addAttribute("listaImc", indiceMasaCorporalService.getAllIMC(user));
                model.addAttribute("nuevoImc", imc);
            }
        }
        return "imc";
    }

    /**
     * Metodo que permite guardar un registro de Indice de masa corporal
     * @param imc
     * @param result
     * @param id
     * @return "imc"
     */
    @PostMapping("/nuevo-imc")
    public ModelAndView nuevoImc(@Valid @ModelAttribute("nuevoImc")IndiceMasaCorporal imc,BindingResult result,@RequestParam("usuario") Long id){
        ModelAndView modelView = new ModelAndView("imc");
        user=userService.findByUser(id);
        if(result.hasErrors()){
            modelView.addObject("logueado", true);
            modelView.addObject("user", user);
            modelView.addObject("listaImc", indiceMasaCorporalService.getAllIMC(user));
            modelView.addObject("nuevoImc", imc);
        }else{
            imc.setFecha(LocalDate.now());
            imc.setEstado(true);
            indiceMasaCorporalService.addIMC(imc);
            modelView.addObject("logueado", true);
            modelView.addObject("user", user);
            modelView.addObject("creado", true);
            modelView.addObject("nuevoImc", imc);
            modelView.addObject("listaImc", indiceMasaCorporalService.getAllIMC(user));
        }
        return modelView;
    }
}
