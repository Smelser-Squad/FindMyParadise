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
@CrossOrigin(origins ="http://localhost:8081")
public class HostController {

    @Autowired
    HostService service;


    @PostMapping("/host")
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

    @GetMapping("/host/{hostId}")
    public ResponseEntity getHostByID(@PathVariable Integer hostId)
    {
        try {
            return ResponseEntity.ok(service.show(hostId));
        }
        catch (NullHostIDException | InvalidHostIDException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/hosts")
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


    @PutMapping("/updateHost/{hostId}")
    public ResponseEntity editHostByID(@PathVariable Integer hostId, @RequestBody Host newHost)
    {
        try {
            return ResponseEntity.ok(service.update(newHost));

        }
        catch (NullHostIDException | InvalidHostIDException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @DeleteMapping("/deleteHost/{hostId}")
    public String deleteHostByID(@PathVariable Integer hostId)

    {
        String toReturn = "";

        try {
            if (service.destroy(hostId)) {
                toReturn = "Event " + hostId + " deleted";
            } else {
                toReturn = "Event " + hostId + " not found";
            }
        }
        catch (InvalidHostIDException | NullHostIDException ex)
        {
            ex.getMessage();
        }

        return toReturn;
    }


//    @PostMapping("/host")
//    public ResponseEntity createHost(@RequestBody Host newHost)
//    {
//
//    }




}
