package br.com.fiap.roadassist.service.address;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.AddressModel;
import br.com.fiap.roadassist.repo.IAddressRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressRepo repo;

    @Override
    public AddressModel create(AddressModel addressModel) throws Exception {

        return repo.save(addressModel);
    }


    @Override
    public AddressModel update(AddressModel addressModel, Integer id) throws Exception {
        AddressModel address = repo.findById(id).orElse(null);
        if(address == null) {
            return null;
        }

        Utils.copyNonNullProperties(addressModel, address);
        return repo.save(address);
    }


    @Override
    public List<AddressModel> getAll() throws Exception {
        return repo.findAll();
    }


    @Override
    public AddressModel getById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        AddressModel address = repo.findById(id).orElse(null);
        if(address == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
