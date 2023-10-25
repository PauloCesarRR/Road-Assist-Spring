package br.com.fiap.roadassist.service.callWinch;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.CallModel;

public interface ICallWinchService {
    public CallModel create(CallModel winch) throws Exception;
    public CallModel update(CallModel winch, UUID id) throws Exception;
    public List<CallModel> getAll() throws Exception;
    public CallModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
