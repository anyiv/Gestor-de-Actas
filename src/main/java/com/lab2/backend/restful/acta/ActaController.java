package com.lab2.backend.restful.acta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActaController {
    @GetMapping("/")
    public String list(){
        return "actas";
    }
}
