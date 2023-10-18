package br.com.fiap.roadassist.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.fiap.roadassist.model.WinchDriverModel;
import br.com.fiap.roadassist.repo.IWinchDriverRepo;

public class WinchDriverServiceImpl implements IWinchDriverService {

    @Autowired
    private IWinchDriverRepo repo;


    @Override
    public WinchDriverModel create(WinchDriverModel winchDriverModel) throws Exception {
        var winchDriver = this.repo.findByEmail(winchDriverModel.getEmail());

        if(winchDriver != null){
            return null;
        }

        String passwordHashred = BCrypt.withDefaults().hashToString(12,winchDriverModel.getPassword().toCharArray());

        winchDriverModel.setPassword(passwordHashred);

        return this.repo.save(winchDriverModel);
    }


    @Override
    public WinchDriverModel update(WinchDriverModel winchDriver, UUID id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public List<WinchDriverModel> getAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }


    @Override
    public WinchDriverModel getById(UUID id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }


    @Override
    public void delete(UUID id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

   
    
}
