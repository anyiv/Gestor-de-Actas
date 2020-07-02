package com.lab2.backend.restful.acta;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/acta")
@Slf4j
@RequiredArgsConstructor
public class ActaAPI {
    private final ActaService actaService;

    @GetMapping
    public ResponseEntity<List<Acta>> findAll() {
        return ResponseEntity.ok(actaService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Acta acta) {
        return ResponseEntity.ok(actaService.save(acta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acta> findById(@PathVariable Integer id) {
        Optional<Acta> acta = actaService.findById(id);
        if (!acta.isPresent()) {
            log.error("El acta con el código " + id + " no existe");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(acta.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acta> update(@PathVariable Integer id, @Valid @RequestBody Acta acta) {
        if (!actaService.findById(id).isPresent()) {
            log.error("El acta con el código " + id + " no existe");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(actaService.save(acta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!actaService.findById(id).isPresent()) {
            log.error("El acta con el código " + id + " no existe");
            ResponseEntity.badRequest().build();
        }
        Acta acta = new Acta();
        acta = actaService.findById(id).get();
        acta.setEstatus('I');
        actaService.save(acta);

        return ResponseEntity.ok().build();
    }
}
