package br.com.fiap.roadassist.service.address;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.AddressModel;

public interface IAddressService {
    public AddressModel create(AddressModel addressModel) throws Exception;
    public AddressModel update(AddressModel addressModel, UUID id) throws Exception;
    public List<AddressModel> getAll() throws Exception;
    public AddressModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
