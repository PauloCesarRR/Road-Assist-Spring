package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.StateModel;

public interface IStateRepo extends JpaRepository<StateModel, UUID>{
    StateModel findByName(String name);
}
