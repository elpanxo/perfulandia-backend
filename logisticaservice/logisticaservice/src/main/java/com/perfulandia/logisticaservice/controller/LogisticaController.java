package com.perfulandia.logisticaservice.controller;

import com.perfulandia.logisticaservice.model.Entrega;
import com.perfulandia.logisticaservice.model.Repartidor;
import com.perfulandia.logisticaservice.repository.EntregaRepository;
import com.perfulandia.logisticaservice.repository.RepartidorRepository;
import com.perfulandia.logisticaservice.service.LogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/logistica")
public class LogisticaController {

    private final LogisticaService logisticaService;

    public LogisticaController(LogisticaService logisticaService) {
        this.logisticaService = logisticaService;
    }

    @PostMapping("/entrega")
    public Entrega asignarEntrega(@RequestBody Entrega entrega) {
        return logisticaService.asignarEntrega(entrega);
    }

    @Autowired
    private RepartidorRepository repartidorRepo;

    @Autowired
    private EntregaRepository entregaRepo;


    @PostMapping("/repartidor")
    public ResponseEntity<Repartidor> crearRepartidor(@RequestBody Repartidor repartidor) {
        Repartidor guardado = repartidorRepo.save(repartidor);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/entregas/{id}/completar")
    public ResponseEntity<?> completarEntrega(@PathVariable Long id) {
        Optional<Entrega> entregaOpt = entregaRepo.findById(id);

        if (entregaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega no encontrada");
        }

        Entrega entrega = entregaOpt.get();
        Repartidor repartidor = entrega.getRepartidor();

        if (repartidor != null) {
            repartidor.setDisponible(true);
            repartidorRepo.save(repartidor);
        }

        entregaRepo.deleteById(id);
        return ResponseEntity.ok("Entrega completada y repartidor liberado");
    }

}
