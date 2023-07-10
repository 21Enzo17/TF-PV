package ar.edu.unju.fi.TPFINALPV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFINALPV.entity.Contacto;
import ar.edu.unju.fi.TPFINALPV.service.IContactoService;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/contactos")
public class ContactoController {
    @Autowired
    private IContactoService contactoService;

    @Autowired
    private Contacto formContacto;

    @Autowired
    private IUserService userService;

    /**
     * Muestra el formulario de contacto
     * 
     * @param model modelo para agregar el formulario de contacto
     * @return vista del formulario de contacto
     */
    @GetMapping("/formulario")
    public String getContactos(Model model) {
        model.addAttribute("sesion", userService.getSesion());
        model.addAttribute("formContactos", formContacto);
        return "contactos";
    }

    /**
     * Guarda el contacto enviado a través del formulario
     * 
     * @param formContactos formulario de contacto enviado por el usuario
     * @param result       resultado del proceso de validación
     * @return vista del formulario de contacto o vista de mensajes si se guardó
     *         correctamente
     */
    @PostMapping("/contactoGuardar")
    public ModelAndView contacto(@Valid @ModelAttribute("formContactos") Contacto formContactos, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("contactos");
        } else {
            modelView = new ModelAndView("contactos");
            contactoService.crearContacto(formContactos);
            formContactos.setContactoNull(formContactos);
            modelView.addObject("alerta", true);
        }
        modelView.addObject("sesion", userService.getSesion());
        return modelView;
    }

    /**
     * Elimina un contacto por su ID
     * 
     * @param model modelo para agregar la lista actualizada de contactos
     * @param id    ID del contacto a eliminar
     * @return vista de mensajes con la lista actualizada de contactos
     */
    @GetMapping("/eliminar/{id}")
    public String getListaActualizada(Model model, @PathVariable(value = "id") Long id) {
        contactoService.eliminarContacto(id);
        model.addAttribute("sesion", userService.getSesion());
        model.addAttribute("contactoGuardar", contactoService.getListaDeContactos());
        if (contactoService.getListaDeContactos().size() == 0) {
            model.addAttribute("MensajeAlertaVacio", true);
        }
        return "mensajes";
    }

    /**
     * Muestra la lista de mensajes de contacto
     * 
     * @param model modelo para agregar la lista de mensajes de contacto
     * @return vista de mensajes con la lista de contactos
     */
    @GetMapping("/mensajes")
    public String getListaMensajes(Model model) {
        model.addAttribute("contactoGuardar", contactoService.getListaDeContactos());
        model.addAttribute("sesion", userService.getSesion());
        if (contactoService.getListaDeContactos().size() == 0) {
            model.addAttribute("MensajeAlertaVacio", true);
        }
        return "mensajes";
    }
}