package br.com.fiap.roadassist.service.winch;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.WinchModel;

public interface IWinchService {
    public WinchModel create(WinchModel winch) throws Exception;
    public WinchModel update(WinchModel winch, UUID id) throws Exception;
    public List<WinchModel> getAll() throws Exception;
    public WinchModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
