package br.com.fiap.roadassist.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.DriverModel;

public interface IDriverRepo extends JpaRepository<DriverModel, Integer>{
    DriverModel findByEmail(String email);
}
