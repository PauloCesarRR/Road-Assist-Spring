package br.com.fiap.roadassist.service.callWinch;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.CallModel;
import br.com.fiap.roadassist.repo.ICallWinchRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class CallWinchServiceImpl implements ICallWinchService {

    @Autowired
    private ICallWinchRepo repo;

    @Override
    public CallModel create(CallModel callModel) throws Exception {
        return repo.save(callModel);
    }


    @Override
    public CallModel update(CallModel CallModel, Integer id) throws Exception {
        CallModel winch = repo.findById(id).orElse(null);
        if(winch == null) {
            return null;
        }

        Utils.copyNonNullProperties(CallModel, winch);
        return repo.save(winch);
    }


    @Override
    public List<CallModel> getAll() throws Exception {
        return repo.findAll();
    }


    @Override
    public CallModel getById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        CallModel call = repo.findById(id).orElse(null);
        if(call == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
