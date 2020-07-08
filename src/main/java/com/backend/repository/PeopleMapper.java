
package com.backend.repository;

import com.backend.domain.People;
import com.backend.domain.RespondStatus;
import com.backend.response.PeopleResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jesus.a.castellanos
 */
public interface PeopleMapper 
{
    public void save(People people) throws DataAccessException;
    
    public PeopleResponse findAll() throws DataAccessException;
    
    public RespondStatus delete(String rut) throws DataAccessException;
    
    public RespondStatus update(People people) throws DataAccessException;
}
