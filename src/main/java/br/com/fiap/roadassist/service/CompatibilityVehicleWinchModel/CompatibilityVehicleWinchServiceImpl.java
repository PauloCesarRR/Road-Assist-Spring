package br.com.fiap.roadassist.service.CompatibilityVehicleWinchModel;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.CompatibilityVehicleWinchModel;
import br.com.fiap.roadassist.repo.ICompatibilityVehicleWinchRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class CompatibilityVehicleWinchServiceImpl implements ICompatibilityVehicleWinchService {

    @Autowired
    private ICompatibilityVehicleWinchRepo repo;

    @Override
    public CompatibilityVehicleWinchModel create(CompatibilityVehicleWinchModel compatibilityVehicleWinch) throws Exception {
        CompatibilityVehicleWinchModel compatibility = repo.findByTypeWinchIdAndTypeVehicleId(compatibilityVehicleWinch.getTypeWinch(), compatibilityVehicleWinch.getTypeVehicle());

        if(compatibility != null){
            return null;
        }

        return repo.save(compatibilityVehicleWinch);
    }


    @Override
    public CompatibilityVehicleWinchModel update(TypeWinchModel typeWinchModel, UUID id) throws Exception {
        TypeWinchModel typeWinch = repo.findById(id).orElse(null);
        if(typeWinch == null) {
            return null;
        }

        Utils.copyNonNullProperties(typeWinchModel, typeWinch);
        return repo.save(typeWinch);
    }


    @Override
    public List<TypeWinchModel> getAll() throws Exception {
        return repo.findAll();
    }


    @Override
    public TypeWinchModel getById(UUID id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(UUID id) throws Exception {
        TypeWinchModel typeWinch = repo.findById(id).orElse(null);
        if(typeWinch == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
