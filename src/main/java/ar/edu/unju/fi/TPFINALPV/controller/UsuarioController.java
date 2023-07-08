package ar.edu.unju.fi.TPFINALPV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFINALPV.entity.User;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {

    @Autowired
    private IUserService userService;

    @Autowired
    private User formUsuario;

    @GetMapping("/nuevo-usuario")
    public String getUserForm(Model model){
        model.addAttribute("formUsuario", formUsuario);
        return "registro";
    }

    @PostMapping("/guardar-usuario")
    public ModelAndView nuevoUsuario(@Valid @ModelAttribute("formUsuario")User formUsuario, BindingResult result){
        ModelAndView modelView;
        if(result.hasErrors()){
            modelView = new ModelAndView("registro");
        }else{
            modelView = new ModelAndView("registro");
            userService.addUser(formUsuario);
            modelView.addObject("mensaje",formUsuario.getId() );
            formUsuario.SetUserNull(formUsuario);
        }
        return modelView;
    }
}
