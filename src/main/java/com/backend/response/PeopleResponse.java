package com.backend.response;

import com.backend.domain.People;
import com.backend.domain.RespondStatus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesus.a.castellanos
 * Response to the front-end with 
 * the necessary data to show
 */
public class PeopleResponse 
{
   
    private List<People> people;
    private RespondStatus respondStatus;

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public RespondStatus getRespondStatus() {
        return respondStatus;
    }

    public void setRespondStatus(RespondStatus respondStatus) {
        this.respondStatus = respondStatus;
    }
    
    
        
    @Override
    public String toString()
    {
        return "{ \n people: [" + this.people.toString() + "], \n respondStatus: [" + this.respondStatus.toString() + "]\n}";
    }
    
}
