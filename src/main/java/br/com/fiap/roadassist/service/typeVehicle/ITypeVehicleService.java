package br.com.fiap.roadassist.service.typeVehicle;


import java.util.List;

import br.com.fiap.roadassist.model.TypeVehicleModel;

public interface ITypeVehicleService {
    public TypeVehicleModel create(TypeVehicleModel typeVehicleModel) throws Exception;
    public TypeVehicleModel update(TypeVehicleModel typeVehicleModel, Integer id) throws Exception;
    public List<TypeVehicleModel> getAll() throws Exception;
    public TypeVehicleModel getById(Integer id) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
