package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.*;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Rules;

import java.util.List;

public interface RulesService {

    List<Rules> index();
    Rules show(Integer id) throws NoListingFoundException;
    Rules create(Rules rule);
    boolean destroy(Integer id) throws NullListingIDException;
    Rules update(Integer id, Rules newRule);
}
