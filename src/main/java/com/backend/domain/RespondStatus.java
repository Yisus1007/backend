package com.backend.domain;

/**
 *
 * @author jesus.a.castellanos
 * class operate with return with
 * status codes an status messages
 */
public class RespondStatus 
{
    private Integer statusCode;
    private String statusMessage;
    
    public RespondStatus(Integer statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
    public RespondStatus()
    {
        
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    
    @Override
    public String toString()
    {
        return "{ \n statusCode: [" + this.statusCode + "]\n statusMessage: [" + this.statusMessage + "]\n}";
    }


    
    
}
