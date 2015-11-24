package com.adarsh.spring;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 1/27/2015  Time: 9:24 PM
 * This Class provide the implementation for the functionality of..
 */

public enum Level
{
    INFO("INFO"),  WARN("WARN"),  ERROR("ERROR");

    private String type;

    private Level(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
