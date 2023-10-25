package br.com.fiap.roadassist.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.CallModel;

public interface ICallWinchRepo extends JpaRepository<CallModel, UUID>{
    List<CallModel> findByVehicleContaining(UUID idVehicle);
}
