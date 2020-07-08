/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.repository;

import com.backend.domain.People;
import com.backend.domain.RespondStatus;
import com.backend.response.PeopleResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jesus.a.castellanos
 */
@Repository("repository")
public class JDBCPeopleMapper implements PeopleMapper 
{
    static final String insertQuery = "insert into PEOPLE (rut,first_name,last_name,age,adress) values(?,?,?,?,?)";
    static final String findAllQuery = "SELECT ID,RUT,FIRST_NAME,LAST_NAME,AGE,ADRESS FROM PEOPLE";
    static final String deleteQuery = "DELETE FROM PEOPLE WHERE RUT = ?";
    static final String updateQuery = "UPDATE PEOPLE SET FIRST_NAME = ?, LAST_NAME = ?, AGE = ?, ADRESS = ? WHERE RUT = ?";
    private final JdbcTemplate template;
    
    @Autowired
    public JDBCPeopleMapper(JdbcTemplate template)
    {
        this.template = template;
    }
    
    @Override
    @Transactional
    public void save(People people) throws DataAccessException
    {
        try
        {
            template.update(insertQuery, 
                            people.getRut(),
                            people.getName(),
                            people.getLastName(),
                            people.getAge(),
                            people.getAdress());
        }
        catch(DataAccessException e)
        {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }
    
    @Override
    public PeopleResponse findAll() throws DataAccessException
    {
        PeopleResponse response = new PeopleResponse();
        RespondStatus respondStatus = new RespondStatus();
        
        try
        {
            List<People> listPeople = template.query(findAllQuery,(rs, rowNum)->
                            new People(rs.getInt("ID"),
                                       rs.getString("RUT"),
                                       rs.getString("FIRST_NAME"),
                                       rs.getString("LAST_NAME"),
                                       rs.getInt("AGE"),
                                       rs.getString("ADRESS")
                            )
            );
            respondStatus.setStatusCode(200);
            respondStatus.setStatusMessage("Return with: " + listPeople.size() + " register");
            response.setPeople(listPeople);
            response.setRespondStatus(respondStatus);
        }
        catch(DataAccessException e)
        {
            respondStatus.setStatusCode(403);
            respondStatus.setStatusMessage(e.getMessage());
            response.setPeople(null);
            response.setRespondStatus(respondStatus);
        }
        return response;                
    }
    
    @Override
    public RespondStatus delete(String rut) throws DataAccessException
    {
        RespondStatus respondStatus = new RespondStatus();
        try
        {
            template.update(deleteQuery,rut);
            respondStatus.setStatusCode(200);
            respondStatus.setStatusMessage("Deleted register");
        }
        catch(DataAccessException e)
        {
            respondStatus.setStatusCode(402);
            respondStatus.setStatusMessage(e.getMessage());
        }
        return respondStatus;
    }
    
    @Override
    public RespondStatus update(People people) throws DataAccessException
    {
        RespondStatus respondStatus = new RespondStatus();
        try
        {
            template.update(updateQuery,people.getName(),
                                        people.getLastName(),
                                        people.getAge(),
                                        people.getAdress(),
                                        people.getRut());
            respondStatus.setStatusCode(200);
            respondStatus.setStatusMessage("Updated register");
        }
        catch(DataAccessException e)
        {
            respondStatus.setStatusCode(403);
            respondStatus.setStatusMessage(e.getMessage());
        }
        return respondStatus;
        
    }
}
