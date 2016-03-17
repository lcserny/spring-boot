package com.cserny.test.service;

import java.util.List;

/**
 * Created by leonardo on 17.03.2016.
 */
public class NavigationItem
{
    private int id;
    private int parentId;
    private String label;
    private String action;
    private List<NavigationItem> subItems;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

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

    public int getParentId()
    {
        return parentId;
    }

    public void setParentId(int parentId)
    {
        this.parentId = parentId;
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
        return id + " - " + label + " - " + action + " - " + parentId;
    }
}
