package com.lab2.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.lab2.backend.service.ActaService;
import com.lab2.backend.model.Acta;


@RestController
@RequestMapping("/api/acta")
@Slf4j
@RequiredArgsConstructor
public class ActaController {
    @Autowired
    private ActaService actaService;

    //devuelve una lista con todas las actas 
    @GetMapping
    public ResponseEntity<List<Acta>> findAll() {
        return ResponseEntity.ok(actaService.findAll());
    }

    //devuelve una lista con las actas con estatus "A"
    @GetMapping("/activos")
    public ResponseEntity<List<Acta>> findActivos() {
        return ResponseEntity.ok(actaService.actasActivas());
    }

    //registra las actas con el api
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Acta acta) {
        return ResponseEntity.ok(actaService.save(acta));
    }


    //consulta un solo registro por id
    @GetMapping("/{id}")
    public ResponseEntity<Acta> findById(@PathVariable Integer id) {
        Optional<Acta> acta = actaService.findById(id);
        if (!acta.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(acta.get());
    }

    //actualiza las actas. Nota: Se deben pasar con todos los atributos porque sino le pone null
    @PutMapping("/{id}")
    public ResponseEntity<Acta> update(@PathVariable Integer id, @Valid @RequestBody Acta acta) {
        if (!actaService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(actaService.save(acta));
    }

    //elimina las actas de forma lógica
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!actaService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Acta acta = new Acta();
        acta = actaService.findById(id).get();
        acta.setEstatus('I');
        actaService.save(acta);

        return ResponseEntity.ok().build();
    }

    //filtra actas por decanato 
    @GetMapping("/decanato/{id}")
    public ResponseEntity<List<Acta>> actasPorDecanato(@PathVariable Long id) {
        return ResponseEntity.ok(actaService.findByDecanato(id));
    }
}
