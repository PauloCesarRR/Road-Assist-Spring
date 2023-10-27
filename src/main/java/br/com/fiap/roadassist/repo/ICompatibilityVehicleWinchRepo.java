package br.com.fiap.roadassist.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.CompatibilityVehicleWinchModel;
import br.com.fiap.roadassist.model.TypeVehicleModel;
import br.com.fiap.roadassist.model.TypeWinchModel;

public interface ICompatibilityVehicleWinchRepo extends JpaRepository<CompatibilityVehicleWinchModel,Integer>{
    CompatibilityVehicleWinchModel findByTypeWinchAndTypeVehicleContaining(TypeWinchModel typeWinchId, TypeVehicleModel typeVehicle);
}
