package br.com.fiap.roadassist.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.WinchModel;

public interface IWinchRepo extends JpaRepository<WinchModel, Integer>{
    WinchModel findByLicensePlateContaining(String plate);
}
