package br.com.fiap.roadassist.service;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.WinchDriverModel;

public interface IWinchDriverService {
    public WinchDriverModel create(WinchDriverModel winchDriver) throws Exception;
    public WinchDriverModel update(WinchDriverModel winchDriver, UUID id) throws Exception;
    public List<WinchDriverModel> getAll() throws Exception;
    public WinchDriverModel getById(UUID id) throws Exception;
    public void delete(UUID id) throws Exception;
}
