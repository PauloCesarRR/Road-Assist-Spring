package br.com.fiap.roadassist.service.winchDriver;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.fiap.roadassist.model.WinchDriverModel;
import br.com.fiap.roadassist.repo.IWinchDriverRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class WinchDriverServiceImpl implements IWinchDriverService {

    @Autowired
    private IWinchDriverRepo repo;

    @Override
    public WinchDriverModel create(WinchDriverModel winchDriverModel) throws Exception {
        WinchDriverModel winchDriver = repo.findByEmail(winchDriverModel.getEmail());

        if(winchDriver != null){
            return null;
        }

        String passwordHashred = BCrypt.withDefaults().hashToString(12,winchDriverModel.getPassword().toCharArray());

        winchDriverModel.setPassword(passwordHashred);

        return repo.save(winchDriverModel);
    }


    @Override
    public WinchDriverModel update(WinchDriverModel winchDriverModel, Integer id) throws Exception {
        WinchDriverModel winchDriver = repo.findById(id).orElse(null);
        if(winchDriver == null) {
            return null;
        }

        Utils.copyNonNullProperties(winchDriverModel, winchDriver);
        return repo.save(winchDriver);
    }


    @Override
    public List<WinchDriverModel> getAll() throws Exception {
        return (List<WinchDriverModel>) repo.findAll();
    }


    @Override
    public WinchDriverModel getById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        WinchDriverModel winchDriver = repo.findById(id).orElse(null);
        if(winchDriver == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
