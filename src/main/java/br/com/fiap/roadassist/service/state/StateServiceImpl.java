package br.com.fiap.roadassist.service.state;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.StateModel;
import br.com.fiap.roadassist.repo.IStateRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class StateServiceImpl implements IStateService {

    @Autowired
    private IStateRepo repo;

    @Override
    public StateModel create(StateModel stateModel) throws Exception {
        StateModel state = repo.findByName(stateModel.getName());

        if(state != null){
            return null;
        }

        return repo.save(stateModel);
    }


    @Override
    public StateModel update(StateModel stateModel, Integer id) throws Exception {
        StateModel state = repo.findById(id).orElse(null);
        if(state == null) {
            return null;
        }

        Utils.copyNonNullProperties(stateModel, state);
        return repo.save(state);
    }


    @Override
    public List<StateModel> getAll() throws Exception {
        return (List<StateModel>) repo.findAll();
    }


    @Override
    public StateModel getById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        StateModel state = repo.findById(id).orElse(null);
        if(state == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
