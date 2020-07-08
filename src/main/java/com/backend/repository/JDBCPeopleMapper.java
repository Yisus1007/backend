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
        System.out.println("Entro al save con: " + people.toString());
        try
        {
            template.update(insertQuery, 
                            people.getRut(),
                            people.getName(),
                            people.getLastName(),
                            people.getAge(),
                            people.getAdress());
            System.out.println("hizo el insert");
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
            respondStatus.setStatusMessage("Registros devueltos: " + listPeople.size());
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
}
