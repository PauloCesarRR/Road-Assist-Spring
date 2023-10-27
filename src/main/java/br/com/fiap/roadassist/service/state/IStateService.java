package br.com.fiap.roadassist.service.state;


import java.util.List;

import br.com.fiap.roadassist.model.StateModel;

public interface IStateService {
    public StateModel create(StateModel stateModel) throws Exception;
    public StateModel update(StateModel stateModel, Integer id) throws Exception;
    public List<StateModel> getAll() throws Exception;
    public StateModel getById(Integer id) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
