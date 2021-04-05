package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.exceptions.NullListingIDException;
import com.tp.wrc.findmyparadise.models.Health;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Rules;
import com.tp.wrc.findmyparadise.repositories.HealthRepository;
import com.tp.wrc.findmyparadise.repositories.RulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthServiceImpl implements HealthService{

    @Autowired
    HealthRepository repo;

    public List<Health> index()
    {
        return repo.findAll();
    }
    public Health show(Integer id) throws NoListingFoundException
    {
        Health health = repo.findById(id).orElseThrow(()-> new NoListingFoundException("Cannot find that health!"));
        return health;
    }
    public Health create(Health health)
    {
        return repo.saveAndFlush(health);
    }

    public boolean destroy(Integer id) throws NullListingIDException
    {
        if (id == null) {
            throw new NullListingIDException("Listing ID cannot be null");
        }
        Health health = repo.findById(id).get();
        if (health != null) {
            repo.delete(health);
            return true;
        } else {
            return false;
        }
    }

    public Health update(Integer id, Health newHealth)
    {
        newHealth.setHealthId(id);
        return repo.save(newHealth);
    }
}
