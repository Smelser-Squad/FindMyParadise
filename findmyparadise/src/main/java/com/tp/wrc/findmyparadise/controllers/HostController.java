package com.tp.wrc.findmyparadise.controllers;



import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;

import com.tp.wrc.findmyparadise.models.Host;
import com.tp.wrc.findmyparadise.services.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HostController {

    @Autowired
    HostService service;


    @PostMapping("/host/")
    public ResponseEntity createHost(@RequestBody Host newHost)
    {
        try {
            return ResponseEntity.ok(service.create(newHost));
        }
        catch (NullHostIDException | InvalidHostIDException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/host/{id}")
    public ResponseEntity getHostByID(@PathVariable Integer hostID)
    {
        try {
            return ResponseEntity.ok(service.show(hostID));
        }
        catch (NullHostIDException | InvalidHostIDException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/hosts/")
    public ResponseEntity getHosts()
    {
        try {
            return ResponseEntity.ok(service.getAll());
        }
        catch (NullHostIDException | InvalidHostIDException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/hosts/{id}")
    public ResponseEntity editHostByID(@PathVariable Integer hostID, @RequestBody Host newHost)
    {
        try {
            return ResponseEntity.ok(service.update(hostID, newHost));
        }
        catch (NullHostIDException | InvalidHostIDException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/hosts/{id}")
    public String deleteHostByID(@PathVariable Integer hostID)
    {
        String toReturn = "";

        try {
            if (service.destroy(hostID)) {
                toReturn = "Event " + hostID + " deleted";
            } else {
                toReturn = "Event " + hostID + " not found";
            }
        }
        catch (InvalidHostIDException | NullHostIDException ex)
        {
            ex.getMessage();
        }

        return toReturn;
    }


//    @PostMapping("/host/")
//    public ResponseEntity createHost(@RequestBody Host newHost)
//    {
//
//    }




}
