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

import org.openmrs.module.simpleservice.web.controller.LevelController;

/**
 * The amount of awesome this module contains. <br/>
 * <br/>
 * This object is used in the module to save and display a number entered by the user. <br/>
 * <br/>
 * This object is used because it is returned from the {@link LevelController#formBackingObject}. <br/>
 * <br/>
 * The /module/awesomeLevel.jsp file binds to this object and displays/writes using the getters and
 * setters.
 */
public class AwesomeLevel {
	
	// the primary key of the table
	private Integer awesomeLevelId;
	
	// the value set by the user
	private Integer level;
	
	/**
	 * @param awesomeLevelid the awesomeLevelid to set
	 */
	public void setAwesomeLevelId(Integer awesomeLevelid) {
		this.awesomeLevelId = awesomeLevelid;
	}
	
	/**
	 * @return the awesomeLevelid
	 */
	public Integer getAwesomeLevelId() {
		return awesomeLevelId;
	}
	
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
