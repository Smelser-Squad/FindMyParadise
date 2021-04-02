package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "house_rules")
public class Rules implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rule_id")
    private Integer ruleId;

    @Column(name = "rule_value")
    private String ruleValue;


    @ManyToMany(mappedBy = "rules", cascade = CascadeType.ALL)
    private Set<Listing> listings;


    public Rules()
    {

    }

    public Rules(Integer ruleId, Set<Listing> listings, String ruleValue) {
        this.ruleId = ruleId;
        this.listings = listings;
        this.ruleValue = ruleValue;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }


    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    public Set<Listing> getListings() {
        return listings;
    }

    public void setListings(Set<Listing> listings) {
        this.listings = listings;
    }
}
