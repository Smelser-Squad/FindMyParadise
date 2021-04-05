package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.controllers.requests.AddListingRequest;
import com.tp.wrc.findmyparadise.exceptions.*;
import com.tp.wrc.findmyparadise.models.*;
import com.tp.wrc.findmyparadise.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository repo;

    @Autowired
    HostServiceImpl hostService;

    @Autowired
    RulesServiceImpl rulesService;

    @Autowired
    HealthServiceImpl healthService;

    @Autowired
    AmenityServiceImpl amenityService;



    @Override
    public List<Listing> index() {
        return repo.findAll();
    }

    @Override
    public Listing show(Integer id) throws NoListingFoundException {
        Listing listing = repo.findById(id).orElseThrow(() -> new NoListingFoundException("No listing found"));
        return listing;
    }

//    @Override
//    public Listing create(Listing listing, Integer hostID) throws InvalidHostIDException, NullHostIDException, NullListingNameException, InvalidListingNameException, NullAddressException, InvalidAddressException, NullListingPriceException {
//        if(hostID == null)
//        {
//            throw new NullHostIDException("Cannot have a null host ID!");
//        }
//        if(hostID < 0 )
//        {
//            throw new InvalidHostIDException("Cannot have a host ID that is "+ hostID+"!");
//        }
//        if(listing.getName() == null)
//        {
//            throw new NullListingNameException("Cannot have a null listing name!");
//        }
//        if(listing.getName().trim().length() <= 0)
//        {
//            throw new InvalidListingNameException("You must enter a title that is not whitespace!");
//        }
//        if(listing.getAddress() == null)
//        {
//            throw new NullAddressException("Cannot have a null listing name!");
//        }
//        if(listing.getName().trim().length() <= 0)
//        {
//            throw new InvalidAddressException("You must enter an address that is not whitespace!");
//        }
//        if(listing.getPrice() == null)
//        {
//            throw new NullListingPriceException("Cannot have a null price!");
//        }
//        if(listing.getPrice() <= 0)
//        {
//            throw new InvalidListingNameException("Invalid monetary amount! Must be more than 0!");
//        }
//        Host listHost = hostService.show(hostID);
//        listing.setHost(listHost);
//        return repo.saveAndFlush(listing);
//    }


    @Override
    public Listing create(AddListingRequest listing) throws InvalidHostIDException, NullHostIDException, NullListingNameException, InvalidListingNameException, NullAddressException, InvalidAddressException, NullListingPriceException {
        if(listing.getHostID() == null)
        {
            throw new NullHostIDException("Cannot have a null host ID!");
        }
        if(listing.getHostID() < 0 )
        {
            throw new InvalidHostIDException("Cannot have a host ID that is "+ listing.getHostID()+"!");
        }
        if(listing.getName() == null)
        {
            throw new NullListingNameException("Cannot have a null listing name!");
        }
        if(listing.getName().trim().length() <= 0)
        {
            throw new InvalidListingNameException("You must enter a title that is not whitespace!");
        }
        if(listing.getAddress() == null)
        {
            throw new NullAddressException("Cannot have a null listing name!");
        }
        if(listing.getName().trim().length() <= 0)
        {
            throw new InvalidAddressException("You must enter an address that is not whitespace!");
        }
        if(listing.getPrice() == null)
        {
            throw new NullListingPriceException("Cannot have a null price!");
        }
        if(listing.getPrice() <= 0)
        {
            throw new InvalidListingNameException("Invalid monetary amount! Must be more than 0!");
        }
        Listing newListing = new Listing();
        Host listHost = hostService.show(listing.getHostID());
        List<Rules> rule = new ArrayList<>();
        for(Integer id : listing.getRuleID())
        {
            try {
                rule.add(rulesService.show(id));
            }
            catch (NoListingFoundException e)
            {
                System.out.println("Cannot find that rule!");
            }
        }
        List<Health> health = new ArrayList<>();
        for(Integer id : listing.getHealthID())
        {
            try {
                health.add(healthService.show(id));
            }
            catch (NoListingFoundException e)
            {
                System.out.println("Cannot find that health rule!");
            }
        }
        Set<Amenity> amenity = new HashSet<>();
        for(Integer id : listing.getAmenityID())
        {
            try {
                amenity.add(amenityService.findAmenityById(id));
            }
            catch (NullAmenityIdException | InvalidAmenityIdException e)
            {
                System.out.println("Cannot find that health rule!");
            }
        }

        newListing.setHost(listHost);
        newListing.setRules(rule);
        newListing.setHealthRules(health);
        newListing.setAmenities(amenity);

        newListing.setAddress(listing.getAddress());
        newListing.setName(listing.getName());
        newListing.setPrice(listing.getPrice());
        newListing.setLatitude(listing.getLatitude());
        newListing.setLongitude(listing.getLongitude());
        newListing.setDescription(listing.getDescription());
        newListing.setServiceFee(listing.getServiceFee());
        newListing.setOccupancyFee(listing.getOccupancyFee());
        newListing.setCleaningFee(listing.getCleaningFee());
        newListing.setMaxGuests(listing.getMaxGuests());
        newListing.setBathrooms(listing.getBathrooms());
        newListing.setBedrooms(listing.getBedrooms());
        newListing.setBeds(listing.getBeds());
        newListing.setType(listing.getType());

        newListing.setCheckIn(listing.getCheckIn());
        newListing.setCheckOut(listing.getCheckOut());




        return repo.saveAndFlush(newListing);
    }
    

    @Override
    public boolean destroy(Integer id) throws NullListingIDException {
        if (id == null) {
            throw new NullListingIDException("Listing ID cannot be null");
        }
        Listing listing = repo.findById(id).get();
        if (listing != null) {
            repo.delete(listing);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Listing update(Integer id, Listing newListing) throws NullListingIDException, NoListingFoundException {
        if (id == null) {
            throw new NullListingIDException("Listing ID cannot be null");
        }
        newListing.setListingId(id);
        return repo.save(newListing);
    }

    @Override
    public List<Listing> findByNameIgnoreCase(String listingName) throws NoListingFoundException, InvalidListingNameException, NullListingNameException {
        if(listingName == null)
        {
            throw new NullListingNameException("Cannot find a listing with a null name!");
        }
        if(listingName.trim().length() <= 0)
        {
            throw new InvalidListingNameException("You must enter an listing name that is not whitespace!");
        }
        return repo.findByNameIgnoreCase(listingName);
    }
    
    @Override
    public List<Listing> findByHostID(Integer hostID) throws NullHostIDException, InvalidHostIDException {
        if(hostID == null)
        {
            throw new NullHostIDException("Host ID cannot be null!");
        }
        if( hostID < 0)
        {
            throw new InvalidHostIDException("Invalid host ID!");
        }
        return repo.findByHostHostID(hostID);
    }

    @Override
    public List<Listing> findByPrice(Double price) throws NullListingPriceException{
        if(price == null || price < 0)
        {
            throw new NullListingPriceException("Invalid listing price! Price must be more than 0 or not null!");
        }
        return repo.findByPrice(price);
    }

    @Override
    public List<Listing> findByType(String type) throws NoListingFoundException, InvalidListingTypeException, NullListingTypeException {
        if(type == null)
        {
            throw new InvalidListingTypeException("Cannot find a listing with a null typing!");
        }
        if(type.trim().length() <= 0)
        {
            throw new InvalidListingTypeException("You must enter an typing that is not whitespace!");
        }
        return repo.findByType(type);
    }

}

