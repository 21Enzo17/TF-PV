package ar.edu.unju.fi.TPFINALPV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecetaController {
    @GetMapping("/recetas")
    public String getRecetasPage() {
        return "recetas";
    }
}
