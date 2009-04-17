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

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.simpleservice.web.controller.LevelController;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the interface for the service that will save/load our AwesomeLevel object. <br/>
 * <br/>
 * See the {@link LevelController} for example calls to this service.
 * 
 * @see SimpleServiceImpl
 * @see SimpleServiceDAO
 * @see HibernateSimpleServiceDAO
 */
// This annotation tells spring that we want to _not_ roll back our database transactions (aka, actually save them!)
@Transactional
public interface SimpleService extends OpenmrsService {
	
	/**
	 * Save the given awesome level to the database.
	 * 
	 * @param level the level to save
	 * @throws APIException
	 */
	public void saveLevel(AwesomeLevel level) throws APIException;
	
	/**
	 * Get the current awesome level from the database.
	 * 
	 * @return the currently stored awesome level
	 * @throws APIException
	 */
	public AwesomeLevel getLevel() throws APIException;
	
}
