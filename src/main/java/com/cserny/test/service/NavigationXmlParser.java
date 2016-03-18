package com.cserny.test.service;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo on 17.03.2016.
 */
public class NavigationXmlParser implements NavigationParser
{
    public static final String XML_PATH = "classpath:%s";

    private String xmlFile;

    public NavigationXmlParser(String xmlFile)
    {
        this.xmlFile = xmlFile;
    }

    public List<NavigationItem> getNavigationItems()
    {
        List<NavigationItem> itemList = new ArrayList<>();
        try {
            NavigationXmlHandler handler = new NavigationXmlHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            InputSource source = new InputSource(new FileInputStream(getXmlFile()));
            reader.parse(source);

            itemList = handler.getNavigationItems();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        return itemList;
    }

    private File getXmlFile() throws IOException
    {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource(String.format(XML_PATH, xmlFile));
        File xmlFile = null;
        xmlFile = resource.getFile();
        return xmlFile;
    }
}
