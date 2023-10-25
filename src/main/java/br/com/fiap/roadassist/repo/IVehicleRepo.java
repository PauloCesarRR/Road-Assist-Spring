package br.com.fiap.roadassist.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.VehicleModel;

public interface IVehicleRepo extends JpaRepository<VehicleModel, UUID>{
    VehicleModel findByLicensePlateContaining(String plate);
    List<VehicleModel> findByIdDriver(UUID driverId);
}
