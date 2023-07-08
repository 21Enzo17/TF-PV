package ar.edu.unju.fi.TPFINALPV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imc")
public class IndiceMasaCorporalController {
    @GetMapping("/calculadora")
    public String getCalculadora() {
        return "imc";
    }
}
