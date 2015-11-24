package com.adarsh.spring.view;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;


/**
 * Modified Spring 3.1's internal Return value handlers, and wires up a decorator
 * to add support for @JsonView
 * 
 *
 */
public class JsonViewSupportFactoryBean implements InitializingBean {

	private static final Logger LOG = Logger.getLogger(JsonViewSupportFactoryBean.class);
    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
  /*  public void afterPropertiesSet() throws Exception {
    	//Handles method return values by delegating to a list of registered HandlerMethodReturnValueHandlers. 
        HandlerMethodReturnValueHandlerComposite returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>();
        // returnValueHandlers.getHandlers()
        // Return a read-only list with the registered handlers.
       handlers.addAll(returnValueHandlers.getHandlers());
    // Here out of all the handlers the RequestResponseBodyMethodProcessor is getting decorated with 
       // the ViewInjectingReturnValueHandler.
        decorateHandlers(handlers);
        adapter.setReturnValueHandlers(handlers);
    }
    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        for (HandlerMethodReturnValueHandler handler : handlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor)
            {
                ViewInjectingReturnValueHandler decorator = new ViewInjectingReturnValueHandler(handler);
                int index = handlers.indexOf(handler);
                handlers.set(index, decorator);
                LOG.info("JsonView decorator support wired up");
                break;
            }
        }        
    }*/


    public void afterPropertiesSet() throws Exception {
        final List<HandlerMethodReturnValueHandler> apiHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
             final List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>(apiHandlers.size());
             handlers.addAll(apiHandlers);
             this.decorateHandlers(handlers);
             requestMappingHandlerAdapter.setReturnValueHandlers(handlers);
    }

    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {

        for (HandlerMethodReturnValueHandler handler : handlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                final ViewInjectingReturnValueHandler decorator = new ViewInjectingReturnValueHandler(handler);
                final int index = handlers.indexOf(handler);
                handlers.set(index, decorator);
                LOG.info("JsonView decorator support wired up");
                break;
            }
        }
    }

}