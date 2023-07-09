package ar.edu.unju.fi.TPFINALPV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pesoideal")
public class PesoIdealController {

@GetMapping()
public String GetPesoIdealPage(){
    return "pesoideal";
}

@GetMapping("/consultarPI")
public String getEliminarPage(Model model,@RequestParam Long codigo) {	
	model.addAttribute("info",true);
	return "pesoideal";
}






}
