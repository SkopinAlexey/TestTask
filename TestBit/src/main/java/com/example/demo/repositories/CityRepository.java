package com.example.demo.repositories;

import com.example.demo.entities.City;
import com.example.demo.models.CityProjectionInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
    @Query(value = "SELECT c.name as city, count(h.id) as number " +
            "FROM cities c " +
            "LEFT JOIN streets s ON s.city_id = c.id " +
            "LEFT JOIN houses h ON h.street_id = s.id " +
            "GROUP BY c.id, c.name", nativeQuery = true)
    List<CityProjectionInterface> findCityHouseNumber();

    boolean existsById(Integer id);
}