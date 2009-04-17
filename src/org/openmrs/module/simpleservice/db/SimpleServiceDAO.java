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
package org.openmrs.module.simpleservice.db;

import org.openmrs.api.APIException;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.simpleservice.AwesomeLevel;
import org.openmrs.module.simpleservice.SimpleService;
import org.openmrs.module.simpleservice.db.hibernate.HibernateSimpleServiceDAO;
import org.openmrs.module.simpleservice.impl.SimpleServiceImpl;

/**
 * This is the data-access-object interface. All implementations that do the actual saving must
 * implement this interface. HibernateSimpleServiceDAO is the only implementation right now and it is set
 * on the service by the /metadata/moduleApplicationContext.xml file.<br/>
 * <br/>
 * 
 * @see SimpleService
 * @see SimpleServiceImpl
 * @see HibernateSimpleServiceDAO
 */
public interface SimpleServiceDAO {
	
	/**
	 * Save the given awesome level to the database.
	 * 
	 * @param level the level to save
	 * @throws APIException
	 */
	public void saveLevel(AwesomeLevel level) throws DAOException;
	
	/**
	 * Get the current awesome level from the database.
	 * 
	 * @param id the level id to fetch 
	 * @return the currently stored awesome level
	 * @throws APIException
	 */
	public AwesomeLevel getLevel(Integer id) throws DAOException;
	
}
