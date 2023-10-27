package br.com.fiap.roadassist.service.vehicle;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.VehicleModel;
import br.com.fiap.roadassist.repo.IVehicleRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleRepo repo;

    @Override
    public VehicleModel create(VehicleModel vehicleModel) throws Exception {
        VehicleModel vehicle = repo.findByLicensePlateContaining(vehicleModel.getLicensePlate());

        if(vehicle != null){
            return null;
        }

        return repo.save(vehicleModel);
    }


    @Override
    public VehicleModel update(VehicleModel vehicleModel, Integer id) throws Exception {
        VehicleModel vehicle = repo.findById(id).orElse(null);
        if(vehicle == null) {
            return null;
        }

        Utils.copyNonNullProperties(vehicleModel, vehicle);
        return repo.save(vehicle);
    }


    @Override
    public List<VehicleModel> getAll() throws Exception {
        return (List<VehicleModel>) repo.findAll();
    }


    @Override
    public VehicleModel getById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        VehicleModel vehicle = repo.findById(id).orElse(null);
        if(vehicle == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
