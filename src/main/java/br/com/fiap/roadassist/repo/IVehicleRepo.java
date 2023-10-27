package br.com.fiap.roadassist.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.DriverModel;
import br.com.fiap.roadassist.model.VehicleModel;

public interface IVehicleRepo extends CrudRepository<VehicleModel, Integer>{
    VehicleModel findByLicensePlateContaining(String plate);
    List<VehicleModel> findByDriver(DriverModel driver);
}
