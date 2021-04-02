package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.exceptions.NullListingIDException;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Rules;
import com.tp.wrc.findmyparadise.repositories.RulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RulesServiceImpl implements RulesService {

    @Autowired
    RulesRepository repo;

    public List<Rules> index()
    {
        return repo.findAll();
    }
    public Rules show(Integer id) throws NoListingFoundException
    {
        Rules rule = repo.findById(id).orElseThrow(()-> new NoListingFoundException("Cannot find that rule!"));
        return rule;
    }

    public Rules create(Rules rule)
    {
       return repo.saveAndFlush(rule);
    }

    public boolean destroy(Integer id) throws NullListingIDException
    {
        if (id == null) {
            throw new NullListingIDException("Listing ID cannot be null");
        }
        Rules rule = repo.findById(id).get();
        if (rule != null) {
            repo.delete(rule);
            return true;
        } else {
            return false;
        }
    }

    public Rules update(Integer id, Rules newRule)
    {
        newRule.setRuleId(id);
        return repo.save(newRule);
    }
}
