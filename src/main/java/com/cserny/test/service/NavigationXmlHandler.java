package com.cserny.test.service;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by leonardo on 17.03.2016.
 */
public class NavigationXmlHandler extends DefaultHandler
{
    private List<NavigationItem> navigationItems = new ArrayList<>();
    private Stack<String> elementStack = new Stack<>();
    private Stack<NavigationItem> objectStack = new Stack<>();

    public List<NavigationItem> getNavigationItems()
    {
        return navigationItems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        elementStack.push(qName);

        if (qName.equalsIgnoreCase(NavigationXmlParser.NODE_ITEM)) {
            NavigationItem item = new NavigationItem();
            NavigationItem prevItem = null;
            if (!objectStack.empty()) {
                prevItem = currentObject();
            }
            if (prevItem != null && prevItem.getSubItems() != null) {
                item.setChild(true);
                prevItem.getSubItems().add(item);
            }
            objectStack.push(item);
        }

        if (qName.equalsIgnoreCase(NavigationXmlParser.NODE_ITEMS)) {
            NavigationItem item = objectStack.peek();
            item.setSubItems(new ArrayList<>());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String value = new String(ch, start, length).trim();
        if (currentElement().equalsIgnoreCase(NavigationXmlParser.NODE_LABEL)) {
            NavigationItem item = objectStack.peek();
            item.setLabel(value);
        }

        if (currentElement().equalsIgnoreCase(NavigationXmlParser.NODE_ACTION)) {
            NavigationItem item = objectStack.peek();
            item.setAction(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        elementStack.pop();

        if (qName.equalsIgnoreCase(NavigationXmlParser.NODE_ITEM)) {
            NavigationItem item = objectStack.pop();
            if (!item.isChild()) {
                navigationItems.add(item);
            }
        }
    }

    private String currentElement()
    {
        return elementStack.peek();
    }

    private NavigationItem currentObject()
    {
        return objectStack.peek();
    }
}
