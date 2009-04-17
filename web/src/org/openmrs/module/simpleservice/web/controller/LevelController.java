/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.simpleservice.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.simpleservice.AwesomeLevel;
import org.openmrs.module.simpleservice.SimpleService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Gets/sets the level of awesomeness onto the {@link AwesomeLevel} object so that the
 * awesomeLevel.jsp file can read/write it. <br/>
 * <br/>
 * See /metadata/moduleApplicationContext.xml file for the mapping from the url of
 * localhost:8080/openmrs/module/simpleservice/awesomeLevel.htm to this controller
 */
public class LevelController extends SimpleFormController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		
		// This is the object returned and used in the jsp as ${levelFormBackingObject} because it is defined as such in the /metadata/moduleApplicationContext
		AwesomeLevel level = Context.getService(SimpleService.class).getLevel();
		
		// if we don't get a level from the service, it means that one doesn't exist yet.  Create on here for the first page load.
		if (level == null)
			level = new AwesomeLevel();
		
		return level;
	}

	/**
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
     */
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
                                    BindException errors) throws Exception {
	    
    	// this is called when a "post" request type is made to the awesomeLevel.htm url.
    	
    	// the command object attributes are filled in because we did a spring:bind to them
    	AwesomeLevel levelObject = (AwesomeLevel)command;
    	
    	Context.getService(SimpleService.class).saveLevel(levelObject);
    	
	    return super.onSubmit(request, response, command, errors);
    }
	
	
}
