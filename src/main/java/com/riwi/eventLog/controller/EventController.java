package com.riwi.eventLog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.eventLog.entities.Event;
import com.riwi.eventLog.services.service_abstract.IEventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor
public class EventController {

  //Inyectar la interfaz del servicio
  @Autowired
  private final IEventService iEventService;

  @GetMapping
  public ResponseEntity<List<Event>>getAll(){
    return ResponseEntity.ok(this.iEventService.getAll());
  }

  @PostMapping
  public ResponseEntity<Event> insert(@RequestBody Event objEvent){
    return ResponseEntity.ok(this.iEventService.save(objEvent));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Event> get (@PathVariable String id){
    return ResponseEntity.ok(this.iEventService.findById(id));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Event> update(@PathVariable String id, @RequestBody Event event){
    return ResponseEntity.ok(this.iEventService.update(id, event));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id){
    this.iEventService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
