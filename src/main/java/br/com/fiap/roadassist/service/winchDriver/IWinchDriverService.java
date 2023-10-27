package br.com.fiap.roadassist.service.winchDriver;


import java.util.List;

import br.com.fiap.roadassist.model.WinchDriverModel;

public interface IWinchDriverService {
    public WinchDriverModel create(WinchDriverModel winchDriverModel) throws Exception;
    public WinchDriverModel update(WinchDriverModel winchDriverModel, Integer id) throws Exception;
    public List<WinchDriverModel> getAll() throws Exception;
    public WinchDriverModel getById(Integer id) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
