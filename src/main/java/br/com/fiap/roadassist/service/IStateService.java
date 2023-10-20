package br.com.fiap.roadassist.service;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.StateModel;

public interface IStateService {
    public StateModel create(StateModel stateModel) throws Exception;
    public StateModel update(StateModel stateModel, UUID id) throws Exception;
    public List<StateModel> getAll() throws Exception;
    public StateModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
