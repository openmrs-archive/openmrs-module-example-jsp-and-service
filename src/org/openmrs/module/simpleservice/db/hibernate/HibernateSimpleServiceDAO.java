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
package org.openmrs.module.simpleservice.db.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.simpleservice.AwesomeLevel;
import org.openmrs.module.simpleservice.SimpleService;
import org.openmrs.module.simpleservice.db.SimpleServiceDAO;
import org.openmrs.module.simpleservice.impl.SimpleServiceImpl;

/**
 * The hibernate implementation of the data access object layer.
 * 
 * @see SimpleService
 * @see SimpleServiceImpl
 * @see SimpleServiceDAO
 */
public class HibernateSimpleServiceDAO implements SimpleServiceDAO {
	
	// this object is set by the /metadata/moduleApplicationContext.xml
	private SessionFactory sessionFactory;
	
	/**
	 * This is called by spring because we tell it to in the /metadata/moduleApplicationContext.xml
	 * file
	 * 
	 * @param factory this is hibernate object that lets us interact with the database
	 */
	public void setSessionFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}
	
	/**
	 * @see org.openmrs.module.simpleservice.db.SimpleServiceDAO#getLevel(Integer)
	 */
	public AwesomeLevel getLevel(Integer id) throws DAOException {
		
		// tell hibernate to act on our object
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AwesomeLevel.class);
		
		// always get the first one in the database
		// hibernate acts on the object, so use the AwesomeLevel.java attribute name
		criteria.add(Expression.eq("awesomeLevelId", id));
		
		// there will be only one result, so use .uniqueResult() instead of .list()
		return (AwesomeLevel) criteria.uniqueResult();
	}
	
	/**
	 * @see org.openmrs.module.simpleservice.db.SimpleServiceDAO#saveLevel(org.openmrs.module.simpleservice.AwesomeLevel)
	 */
	public void saveLevel(AwesomeLevel level) throws DAOException {
		sessionFactory.getCurrentSession().save(level);
	}
	
}
