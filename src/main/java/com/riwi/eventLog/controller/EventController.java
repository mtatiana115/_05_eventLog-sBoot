package com.riwi.eventLog.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public ResponseEntity<List<Event>>getAll(@RequestParam(defaultValue = "1") int page,
  @RequestParam(defaultValue = "3") int size){
    return ResponseEntity.ok(this.iEventService.getAllByPages(page -1 , size).toList());
  }

  @PostMapping
  public ResponseEntity<Event> insert(@RequestBody Event objEvent){
    
    if (validateDate(objEvent.getDate()) && validateCapacity(objEvent.getCapacity())) {
      return ResponseEntity.ok(this.iEventService.save(objEvent));
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Event> get (@PathVariable String id){
    return ResponseEntity.ok(this.iEventService.findById(id));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Event> update(@PathVariable String id, @RequestBody Event event){

    if (validateDate(event.getDate()) && validateCapacity(event.getCapacity())) {
      return ResponseEntity.ok(this.iEventService.update(id, event));
    } else {
      return ResponseEntity.badRequest().build();
    }
    
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id){
    this.iEventService.delete(id);
    return ResponseEntity.noContent().build();
  }

  public boolean validateDate(LocalDate date){
    LocalDate today = LocalDate.now();
    if (date.isBefore(today)) {
      return false;
      
    } else {
      return true;
    }
  }

  public boolean validateCapacity(int capacity){
    if (capacity>0) return true;
    return false;
  }

  @GetMapping("/search")
  public List<Event> findByName(@RequestParam String name) {
      return iEventService.search(name);
  }
  
}
