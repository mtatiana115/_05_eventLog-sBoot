package com.riwi.eventLog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.eventLog.entities.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, String> {
  //creo el método
  public Event findByName(String name);
}
