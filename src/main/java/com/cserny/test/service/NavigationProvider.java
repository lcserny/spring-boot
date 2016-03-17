package com.cserny.test.service;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    public static final String LABEL = "label";
    public static final String ACTION = "action";
    public static final String ITEM = "item";
    public static final String ITEMS = "items";

    public List<NavigationItem> getNavigationItems()
    {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:admin.xml");
        File xmlFile = null;
        try {
            xmlFile = resource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NavigationParser parser = new NavigationParser();
        List<NavigationItem> itemList = new ArrayList<>();
        try {
            itemList = parser.parseXml(new FileInputStream(xmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (NavigationItem item : itemList) {
            System.out.println(item);
        }

        return itemList;
    }
}
