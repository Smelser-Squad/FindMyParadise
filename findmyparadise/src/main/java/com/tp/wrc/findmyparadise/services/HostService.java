package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.models.Host;

import java.util.List;

public interface HostService {

    public List<Host> getAll() throws InvalidHostIDException, NullHostIDException;

    public Host show(Integer hostID) throws InvalidHostIDException, NullHostIDException;

    public Host create(Host newHost) throws InvalidHostIDException, NullHostIDException;

    public Host update(Integer hostID, Host newHost) throws InvalidHostIDException, NullHostIDException;

    public boolean destroy(Integer hostID) throws InvalidHostIDException, NullHostIDException;


}
