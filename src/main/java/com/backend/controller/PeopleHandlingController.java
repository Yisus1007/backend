
package com.backend.controller;

import com.backend.domain.RespondStatus;
import com.backend.request.PeopleRequest;
import com.backend.response.PeopleResponse;
import com.backend.services.PeopleHandlingService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Class containing all rest
 * controller
 * @rest addPeople
 * @rest listPeople
 * @rest modifyPeople
 * @rest deletePeople
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PeopleHandlingController 
{
    @Autowired
    private PeopleHandlingService service;   
    
    /*
    * addPeople
    * add new people to database and return
    * the result insert status
    * @Param: PeopleRequest
    */
    @PostMapping("/new-people")
    public RespondStatus addPeople(@RequestBody PeopleRequest peopleRequest)
    {
        System.out.println("Starting");
        System.out.println("param received: " + peopleRequest.toString());
        RespondStatus respond = service.addNewPeople(peopleRequest);
        System.out.println("Return: " + respond.toString());
        //peopleResponse.setRespondStatus(respond);
        return respond;
    }
    /*
    * listPeople
    * return list of people added
    * an status of process
    */
    @GetMapping("/list-people")
    public PeopleResponse listPeople()
    {
        PeopleResponse peopleResponse = service.listPeople();
        System.out.println("Return with: " + peopleResponse.toString());
        return peopleResponse;
    }
    /*
    * deletePeople
    * Delete a selected person
    * @Param: rut via URL
    */
    @GetMapping("/delete-people")
    public RespondStatus deletePeople(@RequestParam String rut)
    {
        RespondStatus respond = service.deletePeople(rut);
        System.out.println("Return with: " + respond);
        return respond;
    }
    /*
    * deletePeople
    * Edit a people selected in front end
    * @Param: PeopleRequest
    */    
    @PostMapping("/edit-people")
    public RespondStatus editPeople(@RequestBody PeopleRequest peopleRequest)
    {
        RespondStatus respond = service.editPeople(peopleRequest);
        System.out.println("Return with: " + respond);
        return respond;
    }
}
