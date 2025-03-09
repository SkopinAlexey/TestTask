package com.example.demo.repositories;

import com.example.demo.entities.Street;
import com.example.demo.models.StreetProjectionInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street,Integer> {

    @Query(value = "select s.name as name, count(h.id) as number " +
            "from cities c " +
            "join streets s on s.city_id = c.id " +
            "left join houses h on h.street_id = s.id " +
            "where c.id = :id " +
            "group by s.id", nativeQuery = true)
    List<StreetProjectionInterface> findStreetHouseNumberByID(@Param(value = "id") int id);

    boolean existsById(int id);
    boolean existsByIdAndCityId(int id, int cityId);
}
