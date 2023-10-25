package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.CompatibilityVehicleWinchModel;

public interface ICompatibilityVehicleWinchRepo extends JpaRepository<CompatibilityVehicleWinchModel,UUID>{
    CompatibilityVehicleWinchModel findByTypeWinchAndTypeVehicleContaining(UUID typeWinchId, UUID typeVehicleId);
}
