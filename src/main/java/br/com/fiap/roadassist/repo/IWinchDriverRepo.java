package br.com.fiap.roadassist.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.WinchDriverModel;


public interface IWinchDriverRepo extends JpaRepository<WinchDriverModel, Integer>{
    WinchDriverModel findByEmail(String email);
}
