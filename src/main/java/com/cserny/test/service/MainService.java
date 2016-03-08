package com.cserny.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 07.03.2016.
 */

@Service
public class MainService
{
    @Autowired
    protected UserRepository repository;

    public Integer getValue()
    {
        return 5 * 10;
    }

    public String getUserName(String name)
    {
        return repository.getUserByName(name).getName();
    }

    public void createNewUserWithName(String name)
    {
        repository.newUser(name);
    }

    public String getAllEntityNames()
    {
        return repository.getAllUserNames();
    }
}
