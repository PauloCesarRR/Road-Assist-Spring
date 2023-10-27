package br.com.fiap.roadassist.repo;



import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.AddressModel;

public interface IAddressRepo extends CrudRepository<AddressModel, Integer>{

}
