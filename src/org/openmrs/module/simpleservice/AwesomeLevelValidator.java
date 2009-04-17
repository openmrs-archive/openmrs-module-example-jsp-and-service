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
package org.openmrs.module.simpleservice;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * This validates the {@link AwesomeLevel} object.<br/>
 * <br/>
 * This class is mapped to the spring form controller for the AwesomeLevel.htm page. See
 * /metadata/moduleApplicationContext.xml for the mapping between url, controller, and this
 * validator
 */
public class AwesomeLevelValidator implements Validator {
	
	/**
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return AwesomeLevel.class.isAssignableFrom(clazz);
	}
	
	/**
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 *      org.springframework.validation.Errors)
	 */
	public void validate(Object target, Errors errors) {
		// This first line makes sure the "level" attribute on the "target" object is filled in by the user
		
		// The last string is a messages.properties key code for translating into the user's current language.  
		// See both /metadata/messages.properties and /metadata/config.xml for the mapping
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "level", "simpleservice.levelCannotBeEmpty");
		
		// a custom validation on the given object
		AwesomeLevel levelObject = (AwesomeLevel) target;
		if (levelObject.getLevel() != null && levelObject.getLevel() < 5)
			errors.rejectValue("level", "simpleservice.levelCantBeThatLow");
		
	}
	
}
