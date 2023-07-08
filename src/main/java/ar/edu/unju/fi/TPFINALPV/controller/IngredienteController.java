package ar.edu.unju.fi.TPFINALPV.controller;

import ar.edu.unju.fi.TPFINALPV.entity.Ingrediente;
import ar.edu.unju.fi.TPFINALPV.service.IIngredienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {
    @Autowired
    IIngredienteService ingredienteService;

    @GetMapping("/listado")
    public String getIngredientesPage(Model model) {
        model.addAttribute("ingredientes", ingredienteService.listarIngredientesActivos());
        return "ingredientes";
    }

    @GetMapping("/nuevo-ingrediente")
    public String getNuevoIngredientePage(Model model) {
        model.addAttribute("ingredienteForm", ingredienteService.getIngrediente());
        return "nuevo-ingrediente";
    }

    @PostMapping("/guardar-ingrediente")
    public ModelAndView guardarIngredientePage(@Valid @ModelAttribute("ingredienteForm") Ingrediente ingrediente, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("nuevo-ingrediente");
            modelView.addObject("ingredienteForm", ingrediente);
            return modelView;
        }
        else {
            ingredienteService.saveIngrediente(ingrediente);
            modelView = new ModelAndView("ingredientes");
            modelView.addObject("ingredientes", ingredienteService.listarIngredientesActivos());
            return modelView;
        }
    }

    @GetMapping("/editar-ingrediente/{id}")
    public String getEditarIngredientePage(Model model, @PathVariable Long id) {
        model.addAttribute("ingredienteForm", ingredienteService.buscarIngrediente(id));
        return "modificar-ingrediente";
    }

    @PostMapping("/modificar-ingrediente")
    public ModelAndView modificarIngredientePage(@Valid @ModelAttribute("ingredienteForm") Ingrediente ingrediente, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("modificar-ingrediente");
            modelView.addObject("ingredienteForm", ingrediente);
            return modelView;
        }
        else {
            ingredienteService.saveIngrediente(ingrediente);
            modelView = new ModelAndView("ingredientes");
            modelView.addObject("ingredientes", ingredienteService.listarIngredientesActivos());
            return modelView;
        }
    }

    @GetMapping("/eliminar-ingrediente/{id}")
    public ModelAndView eliminarIngredientePage(@PathVariable Long id) {
        ModelAndView modelView = new ModelAndView("ingredientes");
        ingredienteService.eliminarIngrediente(id);
        modelView.addObject("ingredientes", ingredienteService.listarIngredientesActivos());
        return modelView;
    }
}
