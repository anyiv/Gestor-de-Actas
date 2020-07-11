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

@RestController
@RequestMapping("/api/reporte")
@RequiredArgsConstructor
public class ReporteController {
    @Autowired
    private ActaService actaService;

    //Reporte de cantidad de Actas por mes y decanato
    @GetMapping("/actasPorDecanato/{cod}/{mes}")
    public ResponseEntity<Integer> actasPorDecanato(@PathVariable Long cod,@PathVariable Integer mes) {
        return ResponseEntity.ok(actaService.contarActasPorDecanato(cod, mes));
    }
    
    //Muestra una lista de las actas filtradas por acta y decanato
    @GetMapping("/listadeActas/{cod}/{mes}")
    public ResponseEntity<List<Acta>> listaActas(@PathVariable Long cod,@PathVariable Integer mes) {
        return ResponseEntity.ok(actaService.findByMesYDecanato(cod, mes));
    }
}