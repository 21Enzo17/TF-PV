package ar.edu.unju.fi.TPFINALPV.controller;

import ar.edu.unju.fi.TPFINALPV.entity.Ingrediente;
import ar.edu.unju.fi.TPFINALPV.service.IIngredienteService;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;
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
    @Autowired
    IUserService userService;

    /**
     * endpoint que permite listar todos los ingredientes activos
     * @param model
     * @return página de ingredientes
     */
    @GetMapping("/listado")
    public String getIngredientesPage(Model model) {
        model.addAttribute("ingredientes", ingredienteService.listarIngredientesActivos());
        model.addAttribute("sesion", userService.getSesion());
        return "ingredientes";
    }

    /**
     * endpoint que devuelve la página del formulario nuevo ingrediente
     * @param model
     * @return formulario nuevo ingrediente
     */
    @GetMapping("/nuevo-ingrediente")
    public String getNuevoIngredientePage(Model model) {
        model.addAttribute("ingredienteForm", ingredienteService.getIngrediente());
        model.addAttribute("sesion", userService.getSesion());
        return "nuevo-ingrediente";
    }

    /**
     * endpoint que permite guardar un ingrediente
     * @param ingrediente
     * @param result
     * @return página de ingredientes
     */
    @PostMapping("/guardar-ingrediente")
    public ModelAndView guardarIngredientePage(@Valid @ModelAttribute("ingredienteForm") Ingrediente ingrediente, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("nuevo-ingrediente");
            modelView.addObject("ingredienteForm", ingrediente);
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
        else {
            ingredienteService.saveIngrediente(ingrediente);
            modelView = new ModelAndView("ingredientes");
            modelView.addObject("ingredientes", ingredienteService.listarIngredientesActivos());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
    }

    /**
     * endpoint que devuelve la página del formulario modificar ingrediente
     * @param model
     * @param id
     * @return formulario modificar ingrediente
     */
    @GetMapping("/editar-ingrediente/{id}")
    public String getEditarIngredientePage(Model model, @PathVariable Long id) {
        model.addAttribute("ingredienteForm", ingredienteService.buscarIngrediente(id));
        model.addAttribute("sesion", userService.getSesion());
        return "modificar-ingrediente";
    }

    /**
     * endpoint que guarda los cambios de un ingrediente
     * @param ingrediente
     * @param result
     * @return página de ingredientes
     */
    @PostMapping("/modificar-ingrediente")
    public ModelAndView modificarIngredientePage(@Valid @ModelAttribute("ingredienteForm") Ingrediente ingrediente, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("modificar-ingrediente");
            modelView.addObject("ingredienteForm", ingrediente);
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
        else {
            ingredienteService.saveIngrediente(ingrediente);
            modelView = new ModelAndView("ingredientes");
            modelView.addObject("ingredientes", ingredienteService.listarIngredientesActivos());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
    }

    /**
     * endpoint que permite eliminar un ingrediente
     * @param id
     * @return página de ingredientes
     */
    @GetMapping("/eliminar-ingrediente/{id}")
    public ModelAndView eliminarIngredientePage(@PathVariable Long id) {
        ModelAndView modelView = new ModelAndView("ingredientes");
        ingredienteService.eliminarIngrediente(id);
        modelView.addObject("ingredientes", ingredienteService.listarIngredientesActivos());
        modelView.addObject("sesion", userService.getSesion());
        return modelView;
    }
}
