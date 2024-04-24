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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public void delete(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public Event update(String id, Event Event) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public List<Event> search(String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'search'");
  }

}
