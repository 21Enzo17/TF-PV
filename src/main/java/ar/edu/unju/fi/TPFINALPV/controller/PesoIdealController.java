package ar.edu.unju.fi.TPFINALPV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFINALPV.entity.PesoIdeal;
import ar.edu.unju.fi.TPFINALPV.entity.User;
import ar.edu.unju.fi.TPFINALPV.service.IPesoIdealService;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;

@Controller
@RequestMapping("/pesoideal")
public class PesoIdealController {


    @Autowired
    private IUserService userService;
    @Autowired
    private IPesoIdealService pesoService;

    @GetMapping()
    public String GetPesoIdealPage(Model model) {
        model.addAttribute("sesion",userService.getSesion());
        return "pesoideal";
    }

    @GetMapping("/consultarPI")
    public ModelAndView getEliminarPage(Model model, @RequestParam Long codigo) {
        User user=userService.findByUser(codigo);
        ModelAndView modelView;
        modelView=new ModelAndView("pesoideal");
        if(user!=null) {
            modelView.addObject("pesoIdeal",user.getPesoIdeal());
            modelView.addObject("edad",user.getEdad());
            modelView.addObject("encontrado",true);
            PesoIdeal registro=new  PesoIdeal(user.getNombre(),user.getEdad(),user.getEstatura(),user.getPesoIdeal());
            pesoService.guardar(registro);
        }else {
            modelView.addObject("error",true);
            modelView.addObject("encontrado",false);
        }
        modelView.addObject("sesion",user);
        userService.setSesion(user);
        return modelView;
    }

    @GetMapping("/consultaspi")
    public String getConsultasPage(Model model) {
        model.addAttribute("listaPI",pesoService.getListaPI());
        model.addAttribute("sesion",userService.getSesion());
        return "consultaspi";
    }

    @GetMapping("/eliminarRegistro/{id}")
    public String getListaConsultas(Model model, @PathVariable(value = "id") Long id) {
        pesoService.eliminar(id);
        model.addAttribute("listaPI", pesoService.getListaPI());
        if (pesoService.getListaPI().size() == 0) {
            model.addAttribute("Alerta", true);
        }
        model.addAttribute("sesion",userService.getSesion());
        return "consultaspi";
    }

}
