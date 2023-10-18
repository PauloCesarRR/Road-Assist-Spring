package br.com.fiap.roadassist.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.fiap.roadassist.model.WinchDriverModel;
import br.com.fiap.roadassist.repo.IWinchDriverRepo;
import br.com.fiap.roadassist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;

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
    public WinchDriverModel update(WinchDriverModel winchDriverModel, UUID id) throws Exception {
        var winchDriver = this.repo.findById(id).orElse(null);
        if(winchDriver == null) {
            return null;
        }

        Utils.copyNonNullProperties(winchDriverModel, winchDriver);
        return this.repo.save(winchDriver);
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
