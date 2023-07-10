package ar.edu.unju.fi.TPFINALPV.controller;

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

import ar.edu.unju.fi.TPFINALPV.entity.User;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUserService userService;

    @Autowired
    private User formUsuario;
    private User user;


    @GetMapping("/nuevo-usuario")
    public String getUserForm(Model model){
        user = userService.getSesion();
        model.addAttribute("formUsuario", formUsuario);
        return "registro";
    }

    @PostMapping("/guardar-usuario")
    public ModelAndView nuevoUsuario(@Valid @ModelAttribute("formUsuario")User formUsuario, BindingResult result){
        ModelAndView modelView;
        if(result.hasErrors()){
            if(formUsuario.getId()==null){
                modelView = new ModelAndView("registro");
            }else{
                modelView = new ModelAndView("modificar-usuario");
                modelView.addObject("logueado", true);
            }
            
        }else{
            if(formUsuario.getId()==null){
                modelView = new ModelAndView("registro");
                userService.addUser(formUsuario);
                modelView.addObject("mensaje","Se registro perfectamente su usuario, su id es: "+formUsuario.getId() );
                formUsuario.SetUserNull(formUsuario);
            }else{
                modelView = new ModelAndView("registro");
                userService.addUser(formUsuario);
                modelView.addObject("mensaje", "Se modifico perfectamente su usuario, su id es: " +formUsuario.getId() );
                formUsuario.SetUserNull(formUsuario);
            }
            
        }
        return modelView;
    }

    @GetMapping("/editar-usuario")
    public String modificarUsuario(Model model){
        user = userService.getSesion();
        model.addAttribute("sesion", user);
        if(user == null){
            model.addAttribute("logueado", false);
            return "login";
        }else{
            model.addAttribute("formUsuario", user);
            model.addAttribute("logueado", true);
            return "modificar-usuario";
        }
        
        
    }

    @GetMapping("/login")
    public String getUsuarioLogueado(@RequestParam("id")String id,Model model){
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
                model.addAttribute("formUsuario",user);
            }
        }
        return "modificar-usuario";
    }

    @GetMapping("/sign-in")
    public String getUsuarioSingIn(){
        return "login";
    }

    @GetMapping("/auth")
    public ModelAndView authUser(@RequestParam String iduser){
        ModelAndView modelview;
        if(iduser.equals(null) || iduser.equals("")){
            modelview = new ModelAndView("login");
            modelview.addObject("error", "Envie datos validos");
        }else{
            User user = userService.findByUser(Long.parseLong(iduser));
            if (user != null){
                userService.setSesion(user);
                modelview = new ModelAndView("index");
                modelview.addObject("sesion", user);
            }else {
                modelview = new ModelAndView("login");
                modelview.addObject("error", "No se encontro el usuario");
            }
        }
        
        return modelview;
    }

    @GetMapping("/logout")
    public ModelAndView logoutUser(){
        ModelAndView modelview = new ModelAndView("index");
        userService.setSesion(null);
        return modelview;
    }
}
