package com.backend.services;

import com.backend.domain.People;
import com.backend.domain.RespondStatus;
import com.backend.repository.PeopleMapper;
import com.backend.request.PeopleRequest;
import com.backend.response.PeopleResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jesus.a.castellanos
 */
@Service
public class PeopleHandlingServiceImpl implements PeopleHandlingService
{
    
    private final PeopleMapper mapper;
    
    @Autowired
    public PeopleHandlingServiceImpl(PeopleMapper mapper)
    {
        this.mapper = mapper;
    }
    
    @Override
    public RespondStatus addNewPeople(PeopleRequest peopleRequest)
    {
        RespondStatus respond = new RespondStatus();
        try
        {
            People people = new People();
            people.setRut(peopleRequest.getRut());
            people.setAdress(peopleRequest.getAdress());
            people.setName(peopleRequest.getName());
            people.setLastName(peopleRequest.getLastName());
            people.setAge(peopleRequest.getAge());
            mapper.save(people);
            respond.setStatusCode(200);
            respond.setStatusMessage("Correctly inserted");
        }
        catch(DataAccessException e)
        {
            respond.setStatusCode(402);
            respond.setStatusMessage(e.getMessage());
        }
        return respond;
    }
    
    @Override
    public PeopleResponse listPeople()
    {
        PeopleResponse peopleResponse = new PeopleResponse();
        try
        {
            peopleResponse = mapper.findAll();
        }
        catch(DataAccessException e)
        {
            peopleResponse.setPeople(null);
            peopleResponse.setRespondStatus(new RespondStatus(402, e.getMessage()));
        }        
        return peopleResponse;
    }
    
    @Override
    public RespondStatus deletePeople(String rut)
    {        
        System.out.println("llega con el rut: " + rut);
        RespondStatus respond = new RespondStatus();
        respond.setStatusCode(200);
        respond.setStatusMessage("Correcto");
        return respond;
    }
    
    @Override
    public RespondStatus editPeople(PeopleRequest request)
    {
        RespondStatus respond = new RespondStatus();
        respond.setStatusCode(200);
        respond.setStatusMessage("Correcto");
        return respond;
    }
}
