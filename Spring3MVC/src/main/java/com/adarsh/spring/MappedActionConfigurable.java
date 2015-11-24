package com.adarsh.spring;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 1/27/2015  Time: 9:30 PM
 * This Class provide the implementation for the functionality of..
 */

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lucas.entity.support.ActionConfigJsonDeserializer;
import com.lucas.entity.user.Permission;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@JsonDeserialize(using=ActionConfigJsonDeserializer.class, as=PermissionMappedActionConfig.class)
public abstract interface MappedActionConfigurable<T, S>
        extends ActionConfigurable
{
    public abstract Map<T, S> getActionConfig()
            throws JsonParseException, JsonMappingException, IOException;

    public abstract void buildActionConfigurable(List<Permission> paramList);
}