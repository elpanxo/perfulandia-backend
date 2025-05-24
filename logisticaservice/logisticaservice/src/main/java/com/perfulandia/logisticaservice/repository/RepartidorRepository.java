package com.perfulandia.logisticaservice.repository;
import com.perfulandia.logisticaservice.model.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RepartidorRepository extends JpaRepository<Repartidor, Long> {
    Optional<Repartidor> findFirstByDisponibleTrue();
}
