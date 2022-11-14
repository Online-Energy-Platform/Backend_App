package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.EnergyConsumption;

import java.util.List;
import java.util.UUID;

@Repository
public interface EnergyConsumptionRepository extends JpaRepository<EnergyConsumption, UUID> {

    @Query(value = "SELECT e FROM EnergyConsumption e WHERE e.device.id = :deviceId")
    List<EnergyConsumption> getEnergyConsumptionByDeviceId(@Param("deviceId") UUID deviceId);

}
