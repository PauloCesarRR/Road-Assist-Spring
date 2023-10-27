package br.com.fiap.roadassist.service.city;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.CityModel;
import br.com.fiap.roadassist.repo.ICityRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class CityServiceImpl implements ICityService {

    @Autowired
    private ICityRepo repo;

    @Override
    public CityModel create(CityModel cityModel) throws Exception {
        CityModel city = repo.findByNameAndStateContaining(cityModel.getName(), cityModel.getState());

        if(city != null){
            return null;
        }

        return repo.save(cityModel);
    }


    @Override
    public CityModel update(CityModel cityModel, Integer id) throws Exception {
        CityModel city = repo.findById(id).orElse(null);
        if(city == null) {
            return null;
        }

        Utils.copyNonNullProperties(cityModel, city);
        return repo.save(city);
    }


    @Override
    public List<CityModel> getAll() throws Exception {
        return (List<CityModel>) repo.findAll();
    }


    @Override
    public CityModel getById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        CityModel city = repo.findById(id).orElse(null);
        if(city == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
