package br.com.fiap.roadassist.service.callWinch;


import java.util.List;

import br.com.fiap.roadassist.model.CallModel;

public interface ICallWinchService {
    public CallModel create(CallModel winch) throws Exception;
    public CallModel update(CallModel winch, Integer id) throws Exception;
    public List<CallModel> getAll() throws Exception;
    public CallModel getById(Integer id) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
