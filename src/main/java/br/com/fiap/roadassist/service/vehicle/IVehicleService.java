package br.com.fiap.roadassist.service.vehicle;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.VehicleModel;

public interface IVehicleService {
    public VehicleModel create(VehicleModel vehicle) throws Exception;
    public VehicleModel update(VehicleModel vehicle, UUID id) throws Exception;
    public List<VehicleModel> getAll() throws Exception;
    public VehicleModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
