package br.com.fiap.roadassist.service.CompatibilityVehicleWinchModel;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.CompatibilityVehicleWinchModel;
import br.com.fiap.roadassist.repo.ICompatibilityVehicleWinchRepo;

@Component
public class CompatibilityVehicleWinchServiceImpl implements ICompatibilityVehicleWinchService {

    @Autowired
    private ICompatibilityVehicleWinchRepo repo;

    @Override
    public CompatibilityVehicleWinchModel create(CompatibilityVehicleWinchModel compatibilityModel) throws Exception {
        CompatibilityVehicleWinchModel compatibility = repo.findByTypeWinchAndTypeVehicleContaining(compatibilityModel.getTypeWinch(), compatibilityModel.getTypeVehicle());

        if(compatibility != null){
            return null;
        }

        return repo.save(compatibilityModel);
    }


    @Override
    public List<CompatibilityVehicleWinchModel> getAll() throws Exception {
        return repo.findAll();
    }


    @Override
    public CompatibilityVehicleWinchModel getById(UUID id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(UUID id) throws Exception {
        CompatibilityVehicleWinchModel compatibility = repo.findById(id).orElse(null);
        if(compatibility == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
