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

import java.util.LinkedHashMap;
import java.util.Map;

import org.openmrs.module.web.extension.AdministrationSectionExt;

/**
 * This class adds links to the administration page under the {@link #getTitle()} header. <br/>
 * <br/>
 * This file is linked to in the extensionPoint in your /metadata/config.xml file with the
 * org.openmrs.admin.list point id.
 */
public class SimpleServiceAdminExt extends AdministrationSectionExt {
	
	/**
	 * @see org.openmrs.module.web.extension.AdministrationSectionExt#getLinks()
	 */
	@Override
	public Map<String, String> getLinks() {
		// a linkedhashmap will keep the order of the links the same as they were entered (whereas a HashMap orders on obj.hashCode()) 
		Map<String, String> links = new LinkedHashMap<String, String>();
		
		// if starting with a slash (/), the link is preceded by the current webapp name: /openmrs/module/simpleservice/awesomeLevel.htm
		// if no slash is given, the link starts from the admin page: /openmrs/admin/...
		// if an absolute link is given, it links directly to that: http://google.com
		// The second string is a messages.properties code for the name to use.  See both /metadata/messages.properties and /metadata/config.xml for the mapping
		links.put("/module/simpleservice/awesomeLevel.htm", "simpleservice.awesomeLevel");
		return links;
	}
	
	/**
	 * @see org.openmrs.module.web.extension.AdministrationSectionExt#getTitle()
	 */
	@Override
	public String getTitle() {
		// The string returned here is displayed above the list of links on the adminstration page. 
		
		// This is a messages.properties code for the name to use.  See both /metadata/messages.properties and /metadata/config.xml for the mapping
		return "simpleservice.title";
	}
	
}
