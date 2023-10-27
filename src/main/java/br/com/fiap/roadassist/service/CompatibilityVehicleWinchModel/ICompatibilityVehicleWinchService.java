package br.com.fiap.roadassist.service.CompatibilityVehicleWinchModel;



import br.com.fiap.roadassist.model.CompatibilityVehicleWinchModel;

import java.util.List;

public interface ICompatibilityVehicleWinchService {
    public CompatibilityVehicleWinchModel create(CompatibilityVehicleWinchModel compatibility) throws Exception;
    public List<CompatibilityVehicleWinchModel> getAll() throws Exception;
    public CompatibilityVehicleWinchModel getById(Integer id) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
