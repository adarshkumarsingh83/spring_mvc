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
package com.adarsh.spring.mvc.controller;

import com.adarsh.spring.mvc.exception.ApplicationGenericException;
import com.adarsh.spring.mvc.view.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@ControllerAdvice
public class ApplicationGlobalExceptionController {

    private final Logger logger= LoggerFactory.getLogger(ApplicationGlobalExceptionController.class);

	@ExceptionHandler(ApplicationGenericException.class)
	public
    @ResponseBody ResponseView<ApplicationGenericException> handleCustomException(ApplicationGenericException ex) {
        logger.info("Inside ApplicationException Handler");
        final ResponseView<ApplicationGenericException> exceptionResponseView=new  ResponseView<ApplicationGenericException>();
		exceptionResponseView.setData(ex);
        exceptionResponseView.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        exceptionResponseView.setResponseMessage(ex.getErrorMessage());
		return exceptionResponseView;
	}

	@ExceptionHandler(Exception.class)
	public  @ResponseBody ResponseView<Exception>  handleAllException(Exception ex) {
        logger.info("Inside GenericException Handler");
        final ResponseView<Exception> exceptionResponseView=new  ResponseView<Exception>();
        exceptionResponseView.setData(ex);
        exceptionResponseView.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        exceptionResponseView.setResponseMessage(ex.getLocalizedMessage());
        return exceptionResponseView;
	}
}