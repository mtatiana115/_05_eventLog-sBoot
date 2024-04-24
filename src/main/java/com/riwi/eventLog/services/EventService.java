package com.riwi.eventLog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.eventLog.entities.Event;
import com.riwi.eventLog.repositories.EventRepository;
import com.riwi.eventLog.services.service_abstract.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {
  
  @Autowired
  private final EventRepository eventRepository;

  @Override
  public Event save(Event event) {
    return this.eventRepository.save(event);
  }

  @Override
  public List<Event> getAll() {
    return this.eventRepository.findAll();
  }

  @Override
  public Event findById(String id) {
    return this.eventRepository.findById(id).orElseThrow();
  }

  @Override
  public void delete(String id) {
    Event eventFind = this.eventRepository.findById(id).orElseThrow();
    this.eventRepository.delete(eventFind);
  }

  @Override
  public Event update(String id, Event event) {
    this.eventRepository.findById(id).orElseThrow();

    event.setId(id);
    return this.eventRepository.save(event);
  }

  @Override
  public List<Event> search(String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'search'");
  }


}
