package ar.edu.unju.fi.TPFINALPV.controller;

import ar.edu.unju.fi.TPFINALPV.entity.Receta;
import ar.edu.unju.fi.TPFINALPV.service.ICategoriaService;
import ar.edu.unju.fi.TPFINALPV.service.IIngredienteService;
import ar.edu.unju.fi.TPFINALPV.service.IRecetaService;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;
import ar.edu.unju.fi.TPFINALPV.util.UploadFile;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;

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
    UploadFile uploadFile;
    @Autowired
    IUserService userService;

    /**
     * endpoint que permite listar todas las recetas activas
     * @param model
     * @return
     */
    @GetMapping("/listado")
    public String getRecetasPage(Model model) {
        model.addAttribute("recetas", recetaService.listarRecetasActivas());
        model.addAttribute("sesion", userService.getSesion());
        return "recetas";
    }

    /**
     * endpoint que devuelve la página de recetas
     * @param model
     * @return página de recetas
     */
    @GetMapping("/nueva-receta")
    public String getNuevaRecetaPage(Model model) {
        model.addAttribute("recetaForm", recetaService.getReceta());
        model.addAttribute("ingredientes", ingredienteService.listarIngredientesActivos());
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        model.addAttribute("sesion", userService.getSesion());
        return "nueva-receta";
    }

    /**
     * endpoint que permite guardar una receta
     * @param receta
     * @param result
     * @param image
     * @return página de recetas
     * @throws Exception
     */
    @PostMapping("/guardar-receta")
    public ModelAndView guardarReceta(@Valid @ModelAttribute("recetaForm") Receta receta, BindingResult result, @RequestParam("file") MultipartFile image) throws Exception {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("nueva-receta");
            modelView.addObject("receta", receta);
            modelView.addObject("ingredientes", ingredienteService.listarIngredientesActivos());
            modelView.addObject("categorias", categoriaService.listarCategoriasActivas());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
        else {
            modelView = new ModelAndView("recetas");
            String uniqueFileName = uploadFile.copy(image);
            receta.setImagen(uniqueFileName);
            recetaService.saveReceta(receta);
            modelView.addObject("recetas", recetaService.listarRecetasActivas());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
    }

    /**
     * endpoint que permite eliminar una receta por su id
     * @param id
     * @return página de recetas
     */
    @GetMapping("/editar-receta/{id}")
    public String getEditarRecetaPage(Model model, @PathVariable Long id) {
        model.addAttribute("recetaForm", recetaService.buscarReceta(id));
        model.addAttribute("ingredientes", ingredienteService.listarIngredientesActivos());
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        model.addAttribute("sesion", userService.getSesion());
        return "modificar-receta";
    }

    /**
     * endpoint que guarda los cambios de una receta
     * @param receta
     * @param result
     * @param image
     * @return página de recetas
     * @throws Exception
     */
    @PostMapping("/modificar-receta")
    public ModelAndView modificarReceta(@Valid @ModelAttribute("recetaForm") Receta receta, BindingResult result, @RequestParam("file") MultipartFile image) throws Exception {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("modificar-receta");
            modelView.addObject("recetaForm", receta);
            modelView.addObject("ingredientes", ingredienteService.listarIngredientesActivos());
            modelView.addObject("categorias", categoriaService.listarCategoriasActivas());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
        else {
            receta.setImagen(recetaService.buscarReceta(receta.getId()).getImagen());
            modelView = new ModelAndView("recetas");
            if(!image.isEmpty()){
                uploadFile.delete(receta.getImagen());
                String uniqueFileName = uploadFile.copy(image);
                receta.setImagen(uniqueFileName);
            }
            recetaService.saveReceta(receta);
            modelView.addObject("recetas", recetaService.listarRecetasActivas());
            modelView.addObject("sesion", userService.getSesion());
            return modelView;
        }
    }

    /**
     * endpoint que permite eliminar una receta por su id
     * @param id
     * @return página de recetas
     */
    @GetMapping("/eliminar-receta/{id}")
    public ModelAndView eliminarReceta(@PathVariable Long id) {
        ModelAndView modelView = new ModelAndView("recetas");
        recetaService.eliminarReceta(id);
        modelView.addObject("recetas", recetaService.listarRecetasActivas());
        modelView.addObject("sesion", userService.getSesion());
        return modelView;
    }

    /**
     * endpoint que permite cargar una imagen
     * @param filename
     * @return imagen
     */
    @GetMapping("uploads/{filename}")
    public ResponseEntity<Resource> cargarImagen(@PathVariable String filename){
        Resource resource = null;
        try{
            resource = uploadFile.load(filename);
        }catch (MalformedURLException e ){
            e.printStackTrace();
        }return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
