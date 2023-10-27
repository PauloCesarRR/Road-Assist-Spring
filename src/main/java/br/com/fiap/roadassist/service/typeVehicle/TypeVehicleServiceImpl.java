package br.com.fiap.roadassist.service.typeVehicle;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.TypeVehicleModel;
import br.com.fiap.roadassist.repo.ITypeVehicleRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class TypeVehicleServiceImpl implements ITypeVehicleService {

    @Autowired
    private ITypeVehicleRepo repo;

    @Override
    public TypeVehicleModel create(TypeVehicleModel typeVehicleModel) throws Exception {
        TypeVehicleModel typeVehicle = repo.findByName(typeVehicleModel.getName());

        if(typeVehicle != null){
            return null;
        }

        return repo.save(typeVehicleModel);
    }


    @Override
    public TypeVehicleModel update(TypeVehicleModel typeVehicleModel, Integer id) throws Exception {
        TypeVehicleModel typeVehicle = repo.findById(id).orElse(null);
        if(typeVehicle == null) {
            return null;
        }

        Utils.copyNonNullProperties(typeVehicleModel, typeVehicle);
        return repo.save(typeVehicle);
    }


    @Override
    public List<TypeVehicleModel> getAll() throws Exception {
        return repo.findAll();
    }


    @Override
    public TypeVehicleModel getById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        TypeVehicleModel typeVehicle = repo.findById(id).orElse(null);
        if(typeVehicle == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
