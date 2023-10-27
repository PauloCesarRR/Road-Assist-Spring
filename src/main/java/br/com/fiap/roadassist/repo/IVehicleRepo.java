package br.com.fiap.roadassist.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.DriverModel;
import br.com.fiap.roadassist.model.VehicleModel;

public interface IVehicleRepo extends JpaRepository<VehicleModel, Integer>{
    VehicleModel findByLicensePlateContaining(String plate);
    List<VehicleModel> findByDriver(DriverModel driver);
}
