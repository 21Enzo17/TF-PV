package ar.edu.unju.fi.TPFINALPV.controller;

import ar.edu.unju.fi.TPFINALPV.entity.Categoria;
import ar.edu.unju.fi.TPFINALPV.service.ICategoriaService;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;
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
    @Autowired
    IUserService userService;

    /**
     * endpoint que permite listar todas las categorias activas
     * @param model
     * @return página de categorias
     */
    @GetMapping("/listado")
    public String getCategoriasPage(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        model.addAttribute("sesion", userService.getSesion());
        return "categorias";
    }

    /**
     * endpoint que devuelve la página del formuario nueva categoria
     * @param model
     * @return formulario nueva categoria
     */
    @GetMapping("/nueva-categoria")
    public String getNuevaCategoriaPage(Model model) {
        model.addAttribute("categoriaForm", categoriaService.getCategoria());
        model.addAttribute("sesion", userService.getSesion());
        return "nueva-categoria";
    }

    /**
     * endpoint que permite guardar una categoria
     * @param categoria
     * @param result
     * @return página de categorias
     */
    @PostMapping("/guardar-categoria")
    public ModelAndView guardarCategoria(@Valid @ModelAttribute("categoriaForm") Categoria categoria, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("nueva-categoria");
            modelView.addObject("categoriaForm", categoriaService.getCategoria());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
        else {
            modelView = new ModelAndView("categorias");
            categoriaService.saveCategoria(categoria);
            modelView.addObject("categorias", categoriaService.listarCategoriasActivas());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
    }

    /**
     * endpoint que devuelve la página del formulario modificar categoria
     * @param model
     * @param id
     * @return formulario modificar categoria
     */
    @GetMapping("/editar-categoria/{id}")
    public String getEditarCategoriaPage(Model model, @PathVariable Long id) {
        model.addAttribute("categoriaForm", categoriaService.buscarCategoria(id));
        model.addAttribute("sesion", userService.getSesion());
        return "modificar-categoria";
    }

    /**
     * endpoint que guarda una categoria modificada
     * @param categoria
     * @param result
     * @return página de categorias
     */
    @PostMapping("/modificar-categoria")
    public ModelAndView modificarCategoria(@Valid @ModelAttribute("categoriaForm") Categoria categoria, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("modificar-categoria");
            modelView.addObject("categoriaForm", categoriaService.getCategoria());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
        else {
            modelView = new ModelAndView("categorias");
            categoriaService.saveCategoria(categoria);
            modelView.addObject("categorias", categoriaService.listarCategoriasActivas());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
    }

    /**
     * endpoint que permite eliminar una categoria
     * @param id
     * @return página de categorias
     */
    @GetMapping("/eliminar-categoria/{id}")
    public ModelAndView eliminarCategoria(@PathVariable Long id) {
        ModelAndView modelView = new ModelAndView("categorias");
        categoriaService.eliminarCategoria(id);
        modelView.addObject("categorias", categoriaService.listarCategoriasActivas());
        modelView.addObject("sesion", userService.getSesion());
        return modelView;
    }
}
