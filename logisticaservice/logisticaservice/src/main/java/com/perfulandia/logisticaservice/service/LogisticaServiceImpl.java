package com.perfulandia.logisticaservice.service;

import com.perfulandia.logisticaservice.model.Entrega;
import com.perfulandia.logisticaservice.model.Repartidor;
import com.perfulandia.logisticaservice.repository.EntregaRepository;
import com.perfulandia.logisticaservice.repository.RepartidorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogisticaServiceImpl implements LogisticaService {

    private final EntregaRepository entregaRepo;
    private final RepartidorRepository repartidorRepo;

    public LogisticaServiceImpl(EntregaRepository entregaRepo, RepartidorRepository repartidorRepo) {
        this.entregaRepo = entregaRepo;
        this.repartidorRepo = repartidorRepo;
    }

    @Override
    public Entrega asignarEntrega(Entrega entrega) {
        Optional<Repartidor> repartidorOpt = repartidorRepo.findFirstByDisponibleTrue();
        if (repartidorOpt.isPresent()) {
            Repartidor repartidor = repartidorOpt.get();
            repartidor.setDisponible(false);
            entrega.setRepartidor(repartidor);
            repartidorRepo.save(repartidor);
            return entregaRepo.save(entrega);
        } else {
            throw new RuntimeException("No hay repartidores disponibles");
        }
    }
}
