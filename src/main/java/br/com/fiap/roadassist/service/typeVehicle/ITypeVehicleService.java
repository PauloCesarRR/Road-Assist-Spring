package br.com.fiap.roadassist.service.typeVehicle;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.TypeVehicleModel;

public interface ITypeVehicleService {
    public TypeVehicleModel create(TypeVehicleModel typeVehicleModel) throws Exception;
    public TypeVehicleModel update(TypeVehicleModel typeVehicleModel, UUID id) throws Exception;
    public List<TypeVehicleModel> getAll() throws Exception;
    public TypeVehicleModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
