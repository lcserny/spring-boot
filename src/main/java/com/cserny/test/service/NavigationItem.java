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
    private boolean hasParent;
    private List<NavigationItem> subItems;

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

    public boolean isHasParent()
    {
        return hasParent;
    }

    public void setHasParent(boolean hasParent)
    {
        this.hasParent = hasParent;
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
        return label + " - " + action;
    }
}
