package com.demo.cinemamicroservice.cinemaservice.services;

import com.demo.cinemamicroservice.cinemaservice.models.Room;
import com.demo.cinemamicroservice.cinemaservice.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService extends BaseService<Room, RoomRepository> {

}
