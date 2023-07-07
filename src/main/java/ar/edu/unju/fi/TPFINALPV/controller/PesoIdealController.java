package ar.edu.unju.fi.TPFINALPV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pesoideal")
public class PesoIdealController {

@GetMapping()
public String GetPesoIdealPage(){
    return "pesoideal";
}







}
