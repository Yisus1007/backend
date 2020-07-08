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
    
    /**
     * method to add new people
     * to dataBase an return error if exist
     * or OK if does not exist
     * @param peopleRequest
     * @return insert status (OK or NOK)
    */
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
            respond.setStatusMessage("DataAccessException: " + e.getMessage());
        } 
        catch(Exception e)
        {
            respond.setStatusCode(403);
            respond.setStatusMessage("Exception: " +e.getMessage());
        }
        return respond;
    }
    
    /**
     * Method in charge of extracting 
     * all of register saved on PEOPLE
     * table
     * @return list with all results
    */
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
            peopleResponse.setRespondStatus(new RespondStatus(402, "DataAccessException: " + e.getMessage()));
        }    
        catch(Exception e)
        {
            peopleResponse.setPeople(null);
            peopleResponse.setRespondStatus(new RespondStatus(403, "Exception: " + e.getMessage()));
        }
        return peopleResponse;
    }
    
    /**
     * Method in charge of delete 
     * one register on PEOPLE
     * table
     * @param rut
     * @return delete status (OK or NOK)
    */
    @Override
    public RespondStatus deletePeople(String rut)
    {        
        RespondStatus respond = new RespondStatus();
        try
        {
            respond = mapper.delete(rut);
        }
        catch(DataAccessException e)
        {
            respond.setStatusCode(402);
            respond.setStatusMessage("DataAccessException: " + e.getMessage());
        }
        catch(Exception e)
        {
            respond.setStatusCode(403);
            respond.setStatusMessage("Exception: " + e.getMessage());
        }
        return respond;
    }
    
    /**
     * Method in charge of edit 
     * one register on PEOPLE
     * table
     * @param PeopleRequest
     * @return update status (OK or NOK)
    */
    @Override
    public RespondStatus editPeople(PeopleRequest request)
    {
        RespondStatus response = new RespondStatus();
        try
        {
            People people = new People();
            people.setAdress(request.getAdress());
            people.setAge(request.getAge());
            people.setLastName(request.getLastName());
            people.setRut(request.getRut());
            people.setName(request.getName());
            response = mapper.update(people);
        }
        catch(DataAccessException e)
        {
            response.setStatusCode(402);
            response.setStatusMessage("DataAccessException: " + e.getMessage());            
        }
        catch(Exception e)
        {
            response.setStatusCode(403);
            response.setStatusMessage("Exception: " + e.getMessage());
        }
        return response;
    }
}
