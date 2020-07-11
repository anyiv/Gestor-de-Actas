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
import com.lab2.backend.service.EstadoService;
import com.lab2.backend.model.Estado;

@RestController
@RequestMapping("/api/estado")
@RequiredArgsConstructor
public class EstadoController {
    @Autowired
    private EstadoService estService;

    //devuelve una lista con todas los estados 
    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        return ResponseEntity.ok(estService.findAll());
    }

    //devuelve una lista con los estados con estatus "A"
    @GetMapping("/activos")
    public ResponseEntity<List<Estado>> findActivos() {
        return ResponseEntity.ok(estService.estadosActivos());
    }

    //registra los estados con el api
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Estado est) {
        return ResponseEntity.ok(estService.save(est));
    }

    //consulta un solo registro por id
    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(@PathVariable Integer id) {
        Optional<Estado> est = estService.findById(id);
        if (!est.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(est.get());
    }

    //actualiza los estados
    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Integer id, @Valid @RequestBody Estado est) {
        if (!estService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(estService.save(est));
    }

    //elimina los estados de forma lógica
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!estService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Estado est = new Estado();
        est = estService.findById(id).get();
        est.setEstatus('I');
        estService.save(est);

        return ResponseEntity.ok().build();
    }
}