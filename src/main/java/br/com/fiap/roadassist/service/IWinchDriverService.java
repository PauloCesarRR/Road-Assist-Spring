package br.com.fiap.roadassist.service;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.WinchDriverModel;
import jakarta.servlet.http.HttpServletRequest;

public interface IWinchDriverService {
    public WinchDriverModel create(WinchDriverModel winchDriverModel) throws Exception;
    public WinchDriverModel update(WinchDriverModel winchDriverModel, UUID id) throws Exception;
    public List<WinchDriverModel> getAll() throws Exception;
    public WinchDriverModel getById(UUID id) throws Exception;
    public void delete(UUID id) throws Exception;
}
