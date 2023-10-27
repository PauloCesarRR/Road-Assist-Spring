package br.com.fiap.roadassist.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.TypeWinchModel;

public interface ITypeWinchRepo extends JpaRepository<TypeWinchModel, Integer>{
    TypeWinchModel findByName(String name);
}
