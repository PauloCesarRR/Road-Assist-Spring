package br.com.fiap.roadassist.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.CallModel;

public interface ICallWinchRepo extends JpaRepository<CallModel, Integer>{
    List<CallModel> findByVehicleContaining(Integer idVehicle);
}
