package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.roadassist.model.CompatibilityVehicleWinchModel;

public interface ICompatibilityVehicleWinchRepo extends JpaRepository<CompatibilityVehicleWinchModel,UUID>{
    @Query(value = "SELECT * FROM tbl_compatibility_vehicle_winch C WHERE C.type_winch_id = ?1 AND C.type_vehicle_id = ?2", nativeQuery = true)
    CompatibilityVehicleWinchModel findByTypeWinchAndTypeVehicle(UUID typeWinchId, UUID typeVehicleId);
}
