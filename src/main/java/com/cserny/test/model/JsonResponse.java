package com.cserny.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by user on 07.03.2016.
 */
@JsonIgnoreProperties
public class JsonResponse
{
    protected String name;
    protected Date date;

    public JsonResponse(String name, Date date)
    {
        this.name = name;
        this.date = date;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
}
