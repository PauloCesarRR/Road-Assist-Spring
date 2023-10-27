package br.com.fiap.roadassist.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.TypeVehicleModel;

public interface ITypeVehicleRepo extends JpaRepository<TypeVehicleModel, Integer>{
    TypeVehicleModel findByName(String name);
}
