package br.com.fiap.roadassist.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.WinchDriverModel;


public interface IWinchDriverRepo extends CrudRepository<WinchDriverModel, Integer>{
    WinchDriverModel findByEmail(String email);
}
