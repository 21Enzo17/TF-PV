package ar.edu.unju.fi.TPFINALPV.controller;

import ar.edu.unju.fi.TPFINALPV.entity.Receta;
import ar.edu.unju.fi.TPFINALPV.service.ICategoriaService;
import ar.edu.unju.fi.TPFINALPV.service.IIngredienteService;
import ar.edu.unju.fi.TPFINALPV.service.IRecetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recetas")
public class RecetaController {
    @Autowired
    IRecetaService recetaService;
    @Autowired
    IIngredienteService ingredienteService;
    @Autowired
    ICategoriaService categoriaService;
    @Autowired
    Receta receta;

    @GetMapping("/listado")
    public String getRecetasPage(Model model) {
        model.addAttribute("recetas", recetaService.listarRecetasActivas());
        System.out.println(recetaService.listarRecetasConIngredientes());
        return "recetas";
    }

    @GetMapping("/nueva-receta")
    public String getNuevaRecetaPage(Model model) {
        model.addAttribute("recetaForm", receta);
        model.addAttribute("ingredientes", ingredienteService.listarIngredientesActivos());
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        return "nueva-receta";
    }

    @PostMapping("/guardar-receta")
    public ModelAndView guardarReceta(@Valid @ModelAttribute("recetaForm") Receta receta, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("nueva-receta");
            modelView.addObject("receta", receta);
            modelView.addObject("ingredientes", ingredienteService.listarIngredientesActivos());
            modelView.addObject("categorias", categoriaService.listarCategoriasActivas());
            return modelView;
        }
        else {
            modelView = new ModelAndView("recetas");
            recetaService.saveReceta(receta);
            modelView.addObject("recetas", recetaService.listarRecetasActivas());
            return modelView;
        }
    }

    @GetMapping("/editar-receta/{id}")
    public String getEditarRecetaPage(Model model, @PathVariable Long id) {
        model.addAttribute("receta", recetaService.buscarReceta(id));
        return "editar-receta";
    }

    @PostMapping("/modificar-receta")
    public ModelAndView modificarReceta(@Valid @ModelAttribute("recetaForm") Receta receta, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("editar-receta");
            modelView.addObject("receta", receta);
            return modelView;
        }
        else {
            modelView = new ModelAndView("recetas");
            recetaService.saveReceta(receta);
            modelView.addObject("recetas", recetaService.listarRecetasActivas());
            return modelView;
        }
    }

    @PostMapping("/eliminar-receta/{id}")
    public ModelAndView eliminarReceta(@PathVariable Long id) {
        ModelAndView modelView = new ModelAndView("recetas");
        recetaService.eliminarReceta(id);
        modelView.addObject("recetas", recetaService.listarRecetasActivas());
        return modelView;
    }

}
