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
package org.openmrs.module.simpleservice.impl;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.simpleservice.AwesomeLevel;
import org.openmrs.module.simpleservice.SimpleService;
import org.openmrs.module.simpleservice.db.SimpleServiceDAO;

/**
 * This is the actual implementation of the {@link SimpleService}. This calls the dao and saves the
 * object to the database
 */
public class SimpleServiceImpl extends BaseOpenmrsService implements SimpleService {
	
	// this dao object is set by the /metadata/moduleApplicationContext.xml
	SimpleServiceDAO dao = null;
	
	/**
	 * This is called by spring because we tell it to in the
	 * /metadata/moduleApplicationContext.xml file
	 * 
	 * @param dao the dao that will save things to the database
	 */
	public void setAwesomeDao(SimpleServiceDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * @see org.openmrs.module.simpleservice.SimpleService#getLevel()
	 */
	public AwesomeLevel getLevel() throws APIException {
		return dao.getLevel(1);
	}
	
	/**
	 * @see org.openmrs.module.simpleservice.SimpleService#saveLevel(org.openmrs.module.simpleservice.AwesomeLevel)
	 */
	public void saveLevel(AwesomeLevel level) throws APIException {
		dao.saveLevel(level);
	}
	
}
