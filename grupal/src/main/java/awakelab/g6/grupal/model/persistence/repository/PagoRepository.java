package awakelab.g6.grupal.model.persistence.repository;

import awakelab.g6.grupal.model.persistence.entity.Pago;
import awakelab.g6.grupal.model.persistence.entity.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
