package br.com.fiap.roadassist.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.CallModel;

public interface ICallWinchRepo extends CrudRepository<CallModel, Integer>{
    List<CallModel> findByVehicleContaining(Integer idVehicle);
}
