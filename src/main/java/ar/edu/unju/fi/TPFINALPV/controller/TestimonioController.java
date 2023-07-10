package ar.edu.unju.fi.TPFINALPV.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFINALPV.entity.Testimonio;
import ar.edu.unju.fi.TPFINALPV.service.IAutorService;
import ar.edu.unju.fi.TPFINALPV.service.ITestimonioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {

	@Autowired
    private ITestimonioService testimonioService;
	
	@Autowired
	private IAutorService autorService;
	
    @Autowired
    private Testimonio formTestimonio;
    
	 /**
     * Método que muestra la página de testimonios
     * @param model
     * @return testimonios.html
     */
    @GetMapping("/listado")
    public String getTestimonio(Model model){
    	model.addAttribute("buscado");
    	model.addAttribute("listaTestimonio", testimonioService.getTestimonio());
    	model.addAttribute("listaAutores", autorService.getDisponibles());
    	return "testimonios";
    }
    
    /**
     * Método que muestra la página para crear un nuevo testimonio
     * @param model
     * @return nuevo-testimonio.html
     */
    @GetMapping("/nuevo-testimonio")
    public String getnuevoTestimonio(Model model) { 	
    	model.addAttribute("listaAutor", testimonioService.getTestimonio());
    	model.addAttribute("listaAutores", autorService.getDisponibles());
        model.addAttribute("formTestimonio",formTestimonio);
        if (autorService.getDisponibles().size() == 0) {
      	  model.addAttribute("alerta", true);
        }
    	return "nuevo-testimonio";
    }
    
    /**
     * Método que crea un nuevo testimonio y lo agrega a la lista
     * @param listaTestimonios
     * @return testimonios.html
     */
 
    @PostMapping("/nuevo-testimonio")
    public ModelAndView crearTestimonio(@Valid @ModelAttribute("formTestimonio")Testimonio nuevoTestimonio, BindingResult result){
    	  ModelAndView modelView;
          if(result.hasErrors()) {
              modelView = new ModelAndView("nuevo-testimonio");
              modelView.addObject("listaAutores",autorService.getDisponibles());
          }else {
        	  nuevoTestimonio.setFecha(LocalDate.now());
              modelView = new ModelAndView ("testimonios");
              testimonioService.addTestimonio(nuevoTestimonio);
              modelView.addObject("listaTestimonio", testimonioService.getDisponibles());
              modelView.addObject("listaAutores",autorService.getDisponibles());
              if (autorService.getDisponibles().size() == 0) {
            	  modelView.addObject("alerta", true);
              }
          }
          return modelView;
    }
    
    /**
     * Metodo que elimina un testimonio de la lista
     * @param id
     * @param model
     * @return testimonios.html
     */
    @GetMapping("/eliminar-testimonios/{id}")
    public String eliminarTestimonio(@PathVariable(value="id")long id,Model model){
        Testimonio testimonio = testimonioService.findTestimonioById(id);
    	testimonioService.eliminarTestimonio(testimonio);
    	model.addAttribute("listaTestimonio", testimonioService.getDisponibles());
    	model.addAttribute("listaAutores", autorService.getDisponibles());
    	return "testimonios";
    }
    
    /*
     * Metodo que permite editar un testimonio por id
     * @param id
     * @param model
     * @return modificar-testimonio.html
     */
    @GetMapping("/editar-testimonios/{id}")
    public String editarTestimonios(@PathVariable(value="id")long id,Model model){
        model.addAttribute("listaAutores", autorService.getDisponibles());
    	model.addAttribute("testimoniosEditar", testimonioService.findTestimonioById(id));
    	return "modificar-testimonio";
    }
    
    /**
     * Metodo que permite guardar el testimonio modificado
     * @param modificado
     * @return  testimonios.html
     */
    @PostMapping("modificar-testimonio")
    public ModelAndView modificarLista(@Valid @ModelAttribute("testimoniosEditar")Testimonio modificado, BindingResult result){
    	ModelAndView modelView;
        if(result.hasErrors()){
            modelView = new ModelAndView("modificar-testimonio");
            modelView.addObject("listaAutores", autorService.getDisponibles());
        }else{
        	Testimonio testimonio = testimonioService.findTestimonioById(modificado.getId());
        	testimonio.setTitulo(modificado.getTitulo());
        	testimonio.setDescripcion(modificado.getDescripcion());
        	testimonio.setAutor(modificado.getAutor());
            testimonioService.addTestimonio(testimonio);
        	modelView = new ModelAndView("testimonios");
        	modelView.addObject("listaTestimonio", testimonioService.getDisponibles());
        	modelView.addObject("listaAutores", autorService.getDisponibles());
        }
    	return modelView;
    }
    
    /**
     * Metodo que permite buscar testimonios por el nombre de autor
     * @param titulo, model
     * @return testimonios.html
     */
  @GetMapping("buscar-testimonio")
   public ModelAndView buscarByNombreAutor(@RequestParam("nombre") String buscado, Model model){
      ModelAndView modelView = new ModelAndView("testimonios");
      List<Testimonio> coincidenteList = new ArrayList<Testimonio>();
      List<Testimonio> autorList = new ArrayList<Testimonio>();
      if(!buscado.isEmpty()) {
    	  autorList=testimonioService.findByAutor(buscado);
      }else {
    	  autorList=testimonioService.getDisponibles();
      }
      System.out.println(coincidenteList.toString());
      for(Testimonio testimonio : autorList) {
    	  if(testimonio.getAutor().getNombre().toLowerCase().contains(buscado.toLowerCase())) {
    		  coincidenteList.add(testimonio); 		  
    	  }
      }
      if(buscado.equals(""))
    	  modelView.addObject("error", true);
      else {
          modelView.addObject("listaAutores", autorService.getDisponibles());
          modelView.addObject("listaTestimonio", coincidenteList);
      }
      if(coincidenteList.size()==0)
    	  modelView.addObject("alerta", true);
	  return modelView;
   }
    
    
}
