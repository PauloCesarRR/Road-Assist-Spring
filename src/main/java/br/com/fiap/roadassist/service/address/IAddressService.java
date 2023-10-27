package br.com.fiap.roadassist.service.address;


import java.util.List;

import br.com.fiap.roadassist.model.AddressModel;

public interface IAddressService {
    public AddressModel create(AddressModel addressModel) throws Exception;
    public AddressModel update(AddressModel addressModel, Integer id) throws Exception;
    public List<AddressModel> getAll() throws Exception;
    public AddressModel getById(Integer id) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
