package bg.softuni.cardealer.repository;

import bg.softuni.cardealer.model.entity.ExRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExRateRepository extends JpaRepository<ExRate, Long> {
}
