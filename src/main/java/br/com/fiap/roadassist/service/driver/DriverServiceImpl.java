package br.com.fiap.roadassist.service.driver;

import java.util.List;


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
    public DriverModel update(DriverModel driverModel, Integer id) throws Exception {
        DriverModel driver = repo.findById(id).orElse(null);
        if(driver == null) {
            return null;
        }

        Utils.copyNonNullProperties(driverModel, driver);
        return repo.save(driver);
    }


    @Override
    public List<DriverModel> getAll() throws Exception {
        return (List<DriverModel>) repo.findAll();
    }


    @Override
    public DriverModel getById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        DriverModel driver = repo.findById(id).orElse(null);
        if(driver == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
