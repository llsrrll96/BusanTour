package com.tour.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour.app.domain.Room;

public interface TourRoomJpaRepository extends JpaRepository<Room,Long>{

}
