package com.backend.services;

import com.backend.domain.People;
import com.backend.domain.RespondStatus;
import com.backend.request.PeopleRequest;
import com.backend.response.PeopleResponse;
import java.util.ArrayList;

/**
 *
 * @author jesus.a.castellanos
 */
public interface PeopleHandlingService 
{
    public RespondStatus addNewPeople(PeopleRequest peopleRequest);
    
    public PeopleResponse listPeople();
    
    public RespondStatus deletePeople(String rut);
    
    public RespondStatus editPeople(PeopleRequest request);
    
}
