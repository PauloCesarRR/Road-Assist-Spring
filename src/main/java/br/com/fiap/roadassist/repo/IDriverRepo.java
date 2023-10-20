package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.DriverModel;

public interface IDriverRepo extends JpaRepository<DriverModel, UUID>{
    DriverModel findByEmail(String email);
}
