package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.CallModel;

public interface ICallWinchRepo extends JpaRepository<CallModel, UUID>{
    CallModel findByVehicleContaining(UUID idVehicle);
}
