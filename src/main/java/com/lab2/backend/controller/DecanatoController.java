package com.lab2.backend.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import com.lab2.backend.service.DecanatoService;
import com.lab2.backend.service.DecanatoService;
import com.lab2.backend.model.Decanato;

@RestController
@RequestMapping("/api/decanato")
@RequiredArgsConstructor
public class DecanatoController {
    @Autowired
    private DecanatoService decService;

    //devuelve una lista con todas los decanatos 
    @GetMapping
    public ResponseEntity<List<Decanato>> findAll() {
        return ResponseEntity.ok(decService.findAll());
    }

    //devuelve una lista con las decanatos con estatus "A"
    @GetMapping("/activos")
    public ResponseEntity<List<Decanato>> findActivos() {
        return ResponseEntity.ok(decService.decActivas());
    }

    //registra las decanatos con el api
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Decanato dec) {
        return ResponseEntity.ok(decService.save(dec));
    }

    //consulta un solo registro por id
    @GetMapping("/{id}")
    public ResponseEntity<Decanato> findById(@PathVariable Long id) {
        Optional<Decanato> dec = decService.findById(id);
        if (!dec.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(dec.get());
    }

    //actualiza las actas. Nota: Se deben pasar con todos los atributos porque sino le pone null
    @PutMapping("/{id}")
    public ResponseEntity<Decanato> update(@PathVariable Long id, @Valid @RequestBody Decanato dec) {
        if (!decService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(decService.save(dec));
    }
    
    //elimina las actas de forma lógica
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!decService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Decanato dec = new Decanato();
        dec = decService.findById(id).get();
        dec.setEstatus('I');
        decService.save(dec);

        return ResponseEntity.ok().build();
    }    
}