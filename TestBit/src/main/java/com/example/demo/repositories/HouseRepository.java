package com.example.demo.repositories;

import com.example.demo.entities.House;
import com.example.demo.models.AddressProjectionInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HouseRepository extends JpaRepository<House,Integer> {

    @Query(value = "select c.name as city, s.name as street, h.number as house, count(a.id) as apartmentCount " +
            "from houses h " +
            "left join streets s on h.street_id = s.id " +
            "left join cities c on s.city_id = c.id " +
            "left join apartments a on h.id = a.houses_id " +
            "where c.id = :id " +
            "group by h.id, c.name, s.name, h.number", nativeQuery = true)
    List<AddressProjectionInterface> findAddressByCityID(@Param(value = "id") int id);

    @Query(value = "select c.name as city, s.name as street, h.number as house, count(a.id) as apartmentCount " +
            "from houses h " +
            "left join streets s on h.street_id = s.id " +
            "left join cities c on s.city_id = c.id " +
            "left join apartments a on h.id = a.houses_id " +
            "where s.id = :id " +
            "group by h.id, c.name, s.name, h.number", nativeQuery = true)
    List<AddressProjectionInterface> findAddressByStreetID(@Param(value = "id") int id);

}
