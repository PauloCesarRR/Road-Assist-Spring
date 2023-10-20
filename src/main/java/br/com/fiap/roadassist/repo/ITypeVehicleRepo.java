package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.TypeVehicleModel;

public interface ITypeVehicleRepo extends JpaRepository<TypeVehicleModel, UUID>{
    TypeVehicleModel findByName(String name);
}
