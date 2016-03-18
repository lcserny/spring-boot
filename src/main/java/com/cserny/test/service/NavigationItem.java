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
    private boolean child;
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

    public boolean isChild()
    {
        return child;
    }

    public void setChild(boolean child)
    {
        this.child = child;
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
