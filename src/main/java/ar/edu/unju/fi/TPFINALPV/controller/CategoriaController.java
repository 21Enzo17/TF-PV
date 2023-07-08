package ar.edu.unju.fi.TPFINALPV.controller;

import ar.edu.unju.fi.TPFINALPV.entity.Categoria;
import ar.edu.unju.fi.TPFINALPV.service.ICategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    ICategoriaService categoriaService;

    @GetMapping("/listado")
    public String getCategoriasPage(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        return "categorias";
    }

    @GetMapping("/nueva-categoria")
    public String getNuevaCategoriaPage(Model model) {
        model.addAttribute("categoriaForm", categoriaService.getCategoria());
        return "nueva-categoria";
    }

    @PostMapping("/guardar-categoria")
    public ModelAndView guardarCategoria(@Valid @ModelAttribute("categoriaForm") Categoria categoria, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("nueva-categoria");
            modelView.addObject("categoriaForm", categoriaService.getCategoria());
            return modelView;
        }
        else {
            modelView = new ModelAndView("categorias");
            categoriaService.saveCategoria(categoria);
            modelView.addObject("categorias", categoriaService.listarCategoriasActivas());
            return modelView;
        }
    }

    @GetMapping("/editar-categoria/{id}")
    public String getEditarCategoriaPage(Model model, @PathVariable Long id) {
        model.addAttribute("categoriaForm", categoriaService.buscarCategoria(id));
        return "editar-categoria";
    }

    @PostMapping("/modificar-categoria")
    public ModelAndView modificarCategoria(@Valid @ModelAttribute("categoriaForm") Categoria categoria, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("editar-categoria");
            modelView.addObject("categoriaForm", categoriaService.getCategoria());
            return modelView;
        }
        else {
            modelView = new ModelAndView("categorias");
            categoriaService.saveCategoria(categoria);
            modelView.addObject("categorias", categoriaService.listarCategoriasActivas());
            return modelView;
        }
    }

    @PostMapping("/eliminar-categoria/{id}")
    public ModelAndView eliminarCategoria(@PathVariable Long id) {
        ModelAndView modelView = new ModelAndView("categorias");
        categoriaService.eliminarCategoria(id);
        modelView.addObject("categorias", categoriaService.listarCategoriasActivas());
        return modelView;
    }
}
