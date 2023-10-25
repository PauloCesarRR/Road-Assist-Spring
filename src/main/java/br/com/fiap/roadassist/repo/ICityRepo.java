package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.roadassist.model.CityModel;

public interface ICityRepo extends JpaRepository<CityModel, UUID>{
    @Query(value = "SELECT C FROM tbl_city C WHERE C.name_city = ?1 AND C.state_id =?2", nativeQuery = true)
    CityModel findByNameAndState(String name, UUID stateId);
}
