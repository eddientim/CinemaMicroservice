package com.demo.cinemamicroservice.cinemaservice.repositories;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<RoomRepository, String> {

    List<Room> findByMapId(String map);

}
