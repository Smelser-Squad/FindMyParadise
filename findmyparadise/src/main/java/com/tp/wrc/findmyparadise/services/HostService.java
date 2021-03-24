package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.models.Host;

import java.util.List;

public interface HostService {

    List<Host> getAll() throws InvalidHostIDException, NullHostIDException;

    Host show(Integer hostID) throws InvalidHostIDException, NullHostIDException;

    Host create(Host newHost) throws InvalidHostIDException, NullHostIDException;

<<<<<<< HEAD
    public Host update(Integer hostID, Host newHost) throws InvalidHostIDException, NullHostIDException;

    public boolean destroy(Integer hostID) throws InvalidHostIDException, NullHostIDException;


}
=======
    Host update(Integer hostID, Host newHost) throws InvalidHostIDException, NullHostIDException;

    boolean destroy(Integer hostID) throws InvalidHostIDException, NullHostIDException;
}
>>>>>>> 8ddd09673c0c32e96326f656b7952ba91bfb9149
