package com.cserny.test.entity;

import javax.persistence.*;

/**
 * Created by user on 08.03.2016.
 */

@Entity
@NamedQuery(name = User.USER_FIND_BY_NAME, query = "SELECT u FROM User u WHERE u.name = ?1")
@Table(name = "User")
public class User
{
    public static final String USER_FIND_BY_NAME = "User.findByName";

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
