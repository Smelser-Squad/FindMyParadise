package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.InvalidHostEmailException;
import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.InvalidHostNameException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.models.Host;
import com.tp.wrc.findmyparadise.repositories.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    @Autowired
    HostRepository hRepo;

    @Override
    public List<Host> getAll() throws InvalidHostIDException, NullHostIDException {
        return hRepo.findAll();
    }

    @Override
    public Host show(Integer hostID) throws InvalidHostIDException, NullHostIDException {
        if(hostID==null){
            throw new NullHostIDException("Null host id entered");
        }
        Host newHost = null;
        Optional<Host> opt = hRepo.findById(hostID);
        if (opt.isPresent()) {
            newHost = opt.get();

            return newHost;
        } else {
            throw new InvalidHostIDException("a host with that ID doesn't exist");
        }
    }

    @Override
    public Host create(Host newHost) throws InvalidHostIDException, NullHostIDException, InvalidHostEmailException, InvalidHostNameException {

        if(
                !(newHost.getEmail().contains("@")) ||
                !(newHost.getEmail().contains(".com")) &&
                !(newHost.getEmail().contains(".net")) &&
                !(newHost.getEmail().contains(".gov")) &&
                !(newHost.getEmail().contains(".biz")) &&
                !(newHost.getEmail().contains(".org"))
        ){
            throw new InvalidHostEmailException("invalid email entered");
        }
            //using regular expression to make sure host's name doesn't contain numbers or symbols.
            //this specific regex uses the unicode property for letters to allow for names with umlauts and
            //other special characters
        if(!newHost.getHostName().matches("^\\pL+[\\pL\\pZ\\pP]{0,}")){
            throw new InvalidHostNameException("invalid name entered");
        }
        return hRepo.saveAndFlush(newHost);
    }

    @Override
    public Host update(Host newHost) throws InvalidHostIDException, NullHostIDException {
        if(newHost.getHostID()==null)
            throw new NullHostIDException("Host ID was null");

        Host hostToUpdate = hRepo.findById(newHost.getHostID()).get();

        if (hostToUpdate != null) {

            hostToUpdate.setHostName(newHost.getHostName());
            hostToUpdate.setTotalReviews(newHost.getTotalReviews());
            hostToUpdate.setSuperHost(newHost.isSuperHost());
            hostToUpdate.setVerified(newHost.isVerified());
            hostToUpdate.setResponseTime(newHost.getResponseTime());
            hostToUpdate.setResponseRate(newHost.getResponseRate());
            hostToUpdate.setJoinDate(newHost.getJoinDate());
            hostToUpdate.setEmail(newHost.getEmail());
            hostToUpdate.setImageSrc(newHost.getImageSrc());

            return hRepo.saveAndFlush(hostToUpdate);
        } else {
            throw new NullHostIDException("a host with that ID doesn't exist");
        }
    }

    @Override
    public boolean destroy(Integer hostID) throws InvalidHostIDException, NullHostIDException {
        if(hostID==null){
            throw new NullHostIDException("Null host id entered");
        }
        Host newHost = hRepo.findById(hostID).get();

        if (newHost != null) {
            hRepo.delete(newHost);
            return true;
        } else {
            throw new InvalidHostIDException("a host with that ID doesn't exist");
        }
    }
    
}

