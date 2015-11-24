package com.adarsh.spring;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 1/27/2015  Time: 9:29 PM
 * This Class provide the implementation for the functionality of..
 */

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.lucas.entity.ui.actionconfig.MappedActionConfigurable;
import java.util.Date;

public class LucasObjectMapper
        extends ObjectMapper
{
    private static final long serialVersionUID = -1280251949989784166L;

    public LucasObjectMapper()
    {
        SimpleModule module = new SimpleModule("JSONModule", new Version(2, 3, 3, null, null, null));
        module.addSerializer(MappedActionConfigurable.class, new ActionConfigJsonSerializer());
        module.addDeserializer(MappedActionConfigurable.class, new ActionConfigJsonDeserializer());
        module.addSerializer(Date.class, new JsonDateSerializer());
        registerModule(module);
    }
}