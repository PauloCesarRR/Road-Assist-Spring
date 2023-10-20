package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.TypeWinchModel;

public interface ITypeWinchRepo extends JpaRepository<TypeWinchModel, UUID>{
    TypeWinchModel findByName(String name);
}
