package ar.edu.unju.fi.TPFINALPV.controller;

import ar.edu.unju.fi.TPFINALPV.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    IUserService userService;
    @GetMapping("/index")
    public String getIndexPage(Model model){
        return "index";
    }

    @GetMapping("/administracion")
    public String getAdministracionPage(Model model){
        model.addAttribute("sesion", userService.getSesion());
        return "gestion";
    }
}
