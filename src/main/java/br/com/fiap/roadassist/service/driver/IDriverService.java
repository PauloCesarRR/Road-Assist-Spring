package br.com.fiap.roadassist.service.driver;


import java.util.List;

import br.com.fiap.roadassist.model.DriverModel;

public interface IDriverService {
    public DriverModel create(DriverModel driverModel) throws Exception;
    public DriverModel update(DriverModel driverModel, Integer id) throws Exception;
    public List<DriverModel> getAll() throws Exception;
    public DriverModel getById(Integer id) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
