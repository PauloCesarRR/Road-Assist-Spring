package br.com.fiap.roadassist.service.driver;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.fiap.roadassist.model.DriverModel;
import br.com.fiap.roadassist.repo.IDriverRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class DriverServiceImpl implements IDriverService {

    @Autowired
    private IDriverRepo repo;

    @Override
    public DriverModel create(DriverModel driverModel) throws Exception {
        DriverModel driver = repo.findByEmail(driverModel.getEmail());

        if(driver != null){
            return null;
        }

        String passwordHashred = BCrypt.withDefaults().hashToString(12,driverModel.getPassword().toCharArray());

        driverModel.setPassword(passwordHashred);

        return repo.save(driverModel);
    }


    @Override
    public DriverModel update(DriverModel driverModel, UUID id) throws Exception {
        DriverModel driver = repo.findById(id).orElse(null);
        if(driver == null) {
            return null;
        }

        Utils.copyNonNullProperties(driverModel, driver);
        return repo.save(driver);
    }


    @Override
    public List<DriverModel> getAll() throws Exception {
        return repo.findAll();
    }


    @Override
    public DriverModel getById(UUID id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(UUID id) throws Exception {
        DriverModel driver = repo.findById(id).orElse(null);
        if(driver == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
