package br.com.fiap.roadassist.service.CompatibilityVehicleWinchModel;

import java.util.UUID;

import br.com.fiap.roadassist.model.CompatibilityVehicleWinchModel;

import java.util.List;

public interface ICompatibilityVehicleWinchService {
    public CompatibilityVehicleWinchModel create(CompatibilityVehicleWinchModel compatibility) throws Exception;
    public CompatibilityVehicleWinchModel update(CompatibilityVehicleWinchModel compatibility, UUID id) throws Exception;
    public List<CompatibilityVehicleWinchModel> getAll() throws Exception;
    public CompatibilityVehicleWinchModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
