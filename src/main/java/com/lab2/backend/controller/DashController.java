package com.lab2.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import com.lab2.backend.service.ActaService;
import com.lab2.backend.model.Acta;
import org.springframework.http.MediaType;
import com.lab2.backend.service.DecanatoService;
import com.lab2.backend.service.UsuarioService;

@RestController
@RequestMapping("/api/dash")
@RequiredArgsConstructor
public class DashController {
    @Autowired
    private ActaService actaService;
    @Autowired
    private DecanatoService decService;
    @Autowired
    private UsuarioService userService;
    
    @GetMapping(value = "/contadores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  contadores(){
        return ResponseEntity.ok("{" + 
            "\"actas\" : \"" + actaService.countActas('A').toString() + "\"," + 
            "\"decanatos\" : \"" + decService.countDec('A').toString() + "\"," + 
            "\"usuarios\" : \"" + userService.countUser('A').toString() + "\""
        + "}");
    }

}