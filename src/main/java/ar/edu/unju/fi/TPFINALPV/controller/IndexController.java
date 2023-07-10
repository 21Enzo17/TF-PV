package ar.edu.unju.fi.TPFINALPV.controller;

import ar.edu.unju.fi.TPFINALPV.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.TPFINALPV.entity.User;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private User auxiliar;

    @Autowired
    private IUserService userService;

    @Autowired
    private IndiceMasaCorporal indiceMasaCorporal;
    @GetMapping("/index")
    public String getIndexPage(Model model){
        model.addAttribute("sesion", userService.getSesion());
        return "index";
    }

    @GetMapping("/administracion")
    public String getAdministracionPage(Model model){
        model.addAttribute("sesion", userService.getSesion());
        return "gestion";
    }

    @GetMapping("/calcular")
    public String calcularIMC(@RequestParam("peso")String peso,@RequestParam("altura")String altura,Model model){
        model.addAttribute("sesion", userService.getSesion());
        if(peso== null || altura ==null || peso.equals("") || altura.equals("") || Float.parseFloat(peso)<1 || Float.parseFloat(altura) < 1){
            model.addAttribute("error", "Ingrese datos validos");
        }else{
            indiceMasaCorporal.setPeso(Float.parseFloat(peso));
            auxiliar.setEstatura(Float.parseFloat(altura));
            indiceMasaCorporal.setUsuario(auxiliar);
            model.addAttribute("mensaje", "Su imc es: "+ indiceMasaCorporal.calcularIMC());
        }
        return "index";
    }
}
