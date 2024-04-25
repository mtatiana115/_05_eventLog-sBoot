package com.riwi.eventLog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.eventLog.entities.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, String> {
  //creo el método
  public List<Event> findByName(String name);
}
