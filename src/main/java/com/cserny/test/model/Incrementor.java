package com.cserny.test.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by user on 11.03.2016.
 */

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Incrementor
{
    protected int value = 5 * 5;

    public int getValue()
    {
        value += 5;
        return value;
    }
}
