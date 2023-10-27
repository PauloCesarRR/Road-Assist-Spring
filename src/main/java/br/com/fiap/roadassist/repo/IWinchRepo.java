package br.com.fiap.roadassist.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.WinchModel;

public interface IWinchRepo extends CrudRepository<WinchModel, Integer>{
    WinchModel findByLicensePlateContaining(String plate);
}
