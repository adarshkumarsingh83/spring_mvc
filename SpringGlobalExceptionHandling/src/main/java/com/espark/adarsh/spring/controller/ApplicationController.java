/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.espark.adarsh.spring.controller;

import com.espark.adarsh.spring.exception.ApplicationGenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Controller
public class ApplicationController {

    private final Logger logger= LoggerFactory.getLogger(ApplicationController.class);

    @RequestMapping(value = "/{type:.+}", method = RequestMethod.GET)
    public ModelAndView applicationControllerRequestProcessor(@PathVariable("type") String type)
            throws Exception {
        logger.info("inside applicationControllerRequestProcessor()");
        if ("ae1".equals(type)) {
            throw new ApplicationGenericException("AE_001", "THIS IS APPLICATION EXCEPTION 001");
        } else if ("ae2".equals(type)) {
            throw new ApplicationGenericException("AE_002", "THIS IS APPLICATION EXCEPTION 002");
        } else if ("ae3".equals(type)) {
            throw new ApplicationGenericException("AE003", "THIS IS APPLICATION EXCEPTION 003");
        } else if ("ae4".equals(type)) {
            throw new ApplicationGenericException("AE_004", "THIS IS APPLICATION EXCEPTION 004");
        } else if ("io".equals(type)) {
            throw new IOException("IO-EXCEPTION");
        } else if ("run".equals(type)) {
            throw new RuntimeException("RUNTIME-EXCEPTION");
        } else if ("e".equals(type)) {
            throw new Exception("EXCEPTION");
        } else {
            return new ModelAndView("index").addObject("msg", type);
        }
    }
}