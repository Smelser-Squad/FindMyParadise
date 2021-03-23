package com.tp.wrc.findmyparadise.controllers;


import com.tp.wrc.findmyparadise.models.Host;
import com.tp.wrc.findmyparadise.services.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class HostController {

    @Autowired
    HostService service;

//    @PostMapping("/host/")
//    public ResponseEntity createHost(@RequestBody Host newHost)
//    {
//
//    }



}
