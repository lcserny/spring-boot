package com.cserny.test.service;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo on 17.03.2016.
 */
@Component
public class NavigationProvider
{
    private NavigationParser parser;

    public void setParser(NavigationParser parser)
    {
        this.parser = parser;
    }

    public NavigationParser getParser()
    {
        return parser;
    }

    public List<NavigationItem> getNavigationItems()
    {
        return getParser().getNavigationItems();
    }

    public List<NavigationItem> getNavigationItemsFromXml(String xmlFile)
    {
        NavigationParser parser = new NavigationXmlParser(xmlFile);
        setParser(parser);

        return getNavigationItems();
    }
}
