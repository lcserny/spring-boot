package com.cserny.test.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by user on 08.03.2016.
 */

@Entity
@NamedQueries({
    @NamedQuery(name = User.USER_FIND_ALL, query = "SELECT u FROM User u"),
    @NamedQuery(name = User.USER_FIND_BY_NAME, query = "SELECT u FROM User u WHERE u.name = ?1")
})
@Table(name = "User")
public class User
{
    public static final String USER_FIND_BY_NAME = "User.findByName";
    public static final String USER_FIND_ALL = "User.findAll";

    @Id
    @GeneratedValue
    private long id;

    @Length(max = 10, message = "name too big")
    @NotEmpty(message = "no name")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "no numbers in name")
    private String name;

    @Length(max = 10, message = "name too big")
    @NotEmpty(message = "no name")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "no numbers in name")
    private String surname;

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

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }
}
