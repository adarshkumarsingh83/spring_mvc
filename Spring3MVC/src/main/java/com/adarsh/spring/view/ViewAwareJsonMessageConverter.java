package com.adarsh.spring.view;

import com.adarsh.spring.rest.ApiResponse;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

/**
 * Adds support for Jackson's JsonView on methods
 * annotated with a {@link ResponseView} annotation
 *
 */
public class ViewAwareJsonMessageConverter extends
        MappingJackson2HttpMessageConverter {

    public ViewAwareJsonMessageConverter()
    {
        super();
        ObjectMapper defaultMapper = new ObjectMapper();
        defaultMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        setObjectMapper(defaultMapper);
    }
    
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
    	/* The RequestResponseBodyMethodProcessor has been decorated with the ViewInjectingReturnValueHandler
    	 * Now if the controller method is annotated with the @ResponseView then the decorator would return
    	 * the instance of the PojoView which is kind of DataView and the PojoView will always return true for 
    	 * hasView() so the below condition will always pass.
    	 */
        if (object instanceof DataView && ((DataView) object).hasView())
        {
            writeView((DataView) object, outputMessage);
        } else {
            super.writeInternal(object, outputMessage);
        }
    }
    protected void writeView(DataView view, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        ObjectWriter writer = getWriterForView(view.getView());
        JsonGenerator jsonGenerator = 
                writer.getFactory().createGenerator(outputMessage.getBody(), encoding);
        try {
        	ApiResponse<?> apiResponse =  (ApiResponse<?>)view.getData();
            writer.writeValue(jsonGenerator, apiResponse);
        }
        catch (IOException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }

    private ObjectWriter getWriterForView(Class<?> view) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        return mapper.writer().withView(view);
    }
    
}
