package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.WinchDriverModel;
import java.util.List;


public interface IWinchDriverRepo extends JpaRepository<WinchDriverModel, UUID>{
    List<WinchDriverModel> findByEmail(String email);
}
