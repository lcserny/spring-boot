package com.cserny.test.service;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo on 17.03.2016.
 */
public class NavigationParser
{
    public List<NavigationItem> parseXml(InputStream inputStream)
    {
        List<NavigationItem> itemList = new ArrayList<>();
        try {
            NavigationHandler handler = new NavigationHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            InputSource source = new InputSource(inputStream);
            reader.parse(source);

            itemList = handler.getItems();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        return itemList;
    }
}
