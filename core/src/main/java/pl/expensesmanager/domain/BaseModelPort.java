package pl.expensesmanager.domain;

import java.io.Serializable;

/**
 * Port to use in domain ports.
 */
interface BaseModelPort {
	
	/**
	 * Method to get id.
	 *
	 * @return id
	 */
	String getId();
	
	/**
	 * Method to set id;
	 *
	 * @param id id
	 */
	void setId(String id);
	
}
