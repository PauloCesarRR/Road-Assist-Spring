package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.WinchModel;

public interface IWinchRepo extends JpaRepository<WinchModel, UUID>{
    WinchModel findByLicensePlateContaining(String plate);
}
