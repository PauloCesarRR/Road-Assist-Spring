package br.com.fiap.roadassist.service;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.DriverModel;

public interface IDriverService {
    public DriverModel create(DriverModel driverModel) throws Exception;
    public DriverModel update(DriverModel driverModel, UUID id) throws Exception;
    public List<DriverModel> getAll() throws Exception;
    public DriverModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
