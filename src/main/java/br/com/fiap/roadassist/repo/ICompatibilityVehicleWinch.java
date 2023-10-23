package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.CompatibilityVehicleWinchModel;

public interface ICompatibilityVehicleWinch extends JpaRepository<CompatibilityVehicleWinchModel,UUID>{
    CompatibilityVehicleWinchModel findByTypeWinchIdAndTypeVehicleId(UUID typeWinch, UUID typeVehicle);
}
