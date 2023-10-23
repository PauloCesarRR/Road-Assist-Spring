package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.roadassist.model.CompatibilityVehicleWinchModel;

public interface ICompatibilityVehicleWinchRepo extends JpaRepository<CompatibilityVehicleWinchModel,UUID>{
    @Query(
        "SELECT * FROM COMPATIBILITY_VEHICLE_WINCH WHERE VEHICLE_ID=".concat()
    )
    CompatibilityVehicleWinchModel findByTypeWinchIdAndTypeVehicleId(UUID typeWinchId, UUID typeVehicleId);
}
