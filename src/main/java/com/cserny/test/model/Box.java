package com.cserny.test.model;

/**
 * Created by user on 14.03.2016.
 */
public class Box<T>
{
    private T var;

    public T getVar()
    {
        return var;
    }

    public void setVar(T var)
    {
        this.var = var;
    }
}
