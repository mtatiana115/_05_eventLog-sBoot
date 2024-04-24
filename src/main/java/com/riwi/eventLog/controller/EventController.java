package com.riwi.eventLog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
