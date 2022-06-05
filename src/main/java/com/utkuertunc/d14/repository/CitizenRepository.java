package com.utkuertunc.d14.repository;

import com.utkuertunc.d14.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    @Query(value = "SELECT citizen_id, name, is_citizen FROM citizen", nativeQuery = true)
    List<String> findAllByCitizenship();

    @Query(value = "SELECT c.citizen_id, c.name, COUNT(citizen_id) AS 'count_of_children' FROM children " +
            "INNER JOIN citizen c on children.parent_id = c.citizen_id GROUP BY c.citizen_id, c.name", nativeQuery = true)
    List<String> findAllByCountOfChildren();

    @Query(value = "SELECT citizen_id, name FROM citizen", nativeQuery = true)
    List<String> findAllByName();

    @Query(value = "SELECT citizen_id, name, has_driving_license FROM citizen", nativeQuery = true)
    List<String> findAllByDrivingLicense();

    @Query(value = "SELECT * FROM citizen WHERE citizen_id = :citizenId", nativeQuery = true)
    Citizen findByCitizenId(@Param(value = "citizenId") Long citizenId);
}
