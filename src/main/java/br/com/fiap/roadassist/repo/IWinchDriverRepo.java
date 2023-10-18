package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.WinchDriverModel;


public interface IWinchDriverRepo extends JpaRepository<WinchDriverModel, UUID>{
    WinchDriverModel findByEmail(String email);
}
