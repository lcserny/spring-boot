package com.cserny.test.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo on 17.03.2016.
 */
public class NavigationItem
{
    private String label;
    private String action;
    private NavigationItem parentItem;
    private List<NavigationItem> subItems = new ArrayList<>();

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public NavigationItem getParentItem()
    {
        return parentItem;
    }

    public void setParentItem(NavigationItem parentItem)
    {
        this.parentItem = parentItem;
    }

    public List<NavigationItem> getSubItems()
    {
        return subItems;
    }

    public void setSubItems(List<NavigationItem> subItems)
    {
        this.subItems = subItems;
    }

    @Override
    public String toString()
    {
        return label + " - " + action + "\r\n";
    }
}
