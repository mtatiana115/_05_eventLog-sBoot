package com.riwi.eventLog.services.service_abstract;

import java.util.List;

import com.riwi.eventLog.entities.Event;

public interface IEventService {

  public Event save(Event event);

  public List<Event> getAll();

  public Event findById(String id);

  public void delete(String id);

  public Event update(String id, Event Event);

  public List<Event> search(String name);
}