/*
 * Created on 18.07.2007
 *
 * Application Model interface for Security manipulation services.
 */
package com.nri.model;

import java.util.ArrayList;

import com.nri.domain.Company;
import com.nri.domain.MsUser;
import com.nri.domain.People;
import com.nri.domain.Role;
import com.nri.domain.WorkPosition;
import com.nri.exception.MappingException;
import com.nri.exception.ModelException;
import com.nri.exception.NoSuchCompanyException;
import com.nri.exception.NoSuchMsUserException;
import com.nri.exception.NoSuchPeopleException;
import com.nri.exception.NoSuchRoleException;
import com.nri.exception.NoSuchWorkPositionException;

/**
 * @author IShaffigulin
 *
 * Application Model interface for Security manipulation services.
 */
public interface SecurityActionProcessor {
	/**
	 * Retrieve the People object with supplied People Id.
	 * @param manId the Integer People Id
	 * @return the located People, or null if no such People exists
	 */
	public People findPeopleByKey(Integer manId) throws NoSuchPeopleException;

	/** 
	 * Removes an People from the system.
	 * @param manId People to be removed.
	 */
	public void removePeople(Integer manId) throws NoSuchPeopleException;

	/**
	 * Add a new persistent People to the system.
	 * @param People to add to the persistent store.
	 */
	public void addPeople(People newPeople) throws MappingException;

	/**
	 * Update a persistent People to the system.
	 * @param People to update to the persistent store.
	 * @return the updated People 
	 */
	public void updatePeople(People aPeople) throws NoSuchPeopleException, MappingException, ModelException;

	/**
	 * Locate all Peoples.
	 * @returns a List of all Peoples
	 */
	public ArrayList findAllPeoples() throws ModelException;

	/**
	 * Locate all Peoples like by name.
	 * @returns a List of all Peoples like by name
	 */
	public ArrayList findPeoplesByName(String name) throws ModelException;

	/**
	 * Locate Role by is Id.
	 * @returns the requested Role
	 * @param roleId the String identifying the Role to be returned.
	 */
	public Role findRoleByKey(String roleId) throws NoSuchRoleException;

	/** 
	 * Delete a Role from system
	 * @param roleId the id of the Role to be removed.
	 */
	public void removeRole(String roleId) throws NoSuchRoleException;

	/**
	 * Insert a new Role into the NRI system
	 * @param newRole the Role to be added.
	 */
	public void addRole(Role newRole) throws MappingException;

	/**
	 * Update a persistent Role to the system.
	 * @param Role to update to the persistent store.
	 * @return the updated Role 
	 */
	public void updateRole(Role aRole) throws NoSuchRoleException, MappingException, ModelException;

	/**
	 * Locate all Roles.
	 * @returns a List of all Roles
	 */
	public ArrayList findAllRoles() throws ModelException;

	/**
	 * Locate all Roles like by name.
	 * @returns a List of all Roles like by name
	 */
	public ArrayList findRolesByName(String name) throws ModelException;

	/**
	 * Locate all Roles like by name.
	 * @returns a List of all Roles like by name
	 */
	public ArrayList findRolesByName(String name, String orderBy) throws ModelException;

	/**
	 * Locate WorkPosition by is Id.
	 * @returns the requested WorkPosition
	 * @param aId the Integer identifying the WorkPosition to be returned.
	 */
	public WorkPosition findWorkPositionByKey(Integer aId) throws NoSuchWorkPositionException;
		
	/** 
	 * Delete a WorkPosition from system
	 * @param aId the id of the WorkPosition to be removed.
	 */
	public void removeWorkPosition(Integer aId) throws NoSuchWorkPositionException;

	/**
	 * Insert a new WorkPosition into the NRI system
	 * @param newWorkPosition the WorkPosition to be added.
	 */
	public void addWorkPosition(WorkPosition newWorkPosition) throws MappingException;

	/**
	 * Update a persistent WorkPosition to the system.
	 * @param WorkPosition to update to the persistent store.
	 * @return the updated WorkPosition 
	 */
	public void updateWorkPosition(WorkPosition aWorkPosition) throws NoSuchWorkPositionException, MappingException, ModelException;

	/**
	 * Locate all WorkPositions like by name.
	 * @returns a List of all WorkPositions like by name
	 */
	public ArrayList findWorkPositions(String name, Boolean isActive, String orderBy) throws ModelException;
	
	/**
	 * This is a testing method designed to allow you to clear the caches for the
	 * In-Memory Simulated Data Access Objects when neecessary.
	 */
	public void clearInMemoryCaches();
	
	/**
	 * Locate MsUser by is Id.
	 * @returns the requested MsUser
	 * @param aId the Integer identifying the MsUser to be returned.
	 */
	public MsUser findMsUserByKey(Integer aId) throws NoSuchMsUserException;
		
	/** 
	 * Delete a MsUser from system
	 * @param aId the id of the MsUser to be removed.
	 */
	public void removeMsUser(Integer aId) throws NoSuchMsUserException;

	/**
	 * Insert a new MsUser into the NRI system
	 * @param newMsUser the MsUser to be added.
	 */
	public void addMsUser(MsUser newMsUser) throws MappingException;

	/**
	 * Update a persistent MsUser to the system.
	 * @param MsUser to update to the persistent store.
	 * @return the updated MsUser 
	 */
	public void updateMsUser(MsUser aMsUser) throws NoSuchMsUserException, MappingException, ModelException;

	/**
	 * Locate all MsUsers like by name.
	 * @returns a List of all MsUsers like by name
	 */
	public ArrayList findMsUsers(String name, String orderBy) throws ModelException;
	
	/**
	 * Locate Company by is Id.
	 * @returns the requested Company
	 * @param aId the Integer identifying the Company to be returned.
	 */
	public Company findCompanyByKey(Integer aId) throws NoSuchCompanyException;
		
	/** 
	 * Delete a Company from system
	 * @param aId the id of the Company to be removed.
	 */
	public void removeCompany(Integer aId) throws NoSuchCompanyException;

	/**
	 * Insert a new Company into the NRI system
	 * @param newCompany the Company to be added.
	 */
	public void addCompany(Company newCompany) throws MappingException;

	/**
	 * Update a persistent Company to the system.
	 * @param Company to update to the persistent store.
	 * @return the updated Company 
	 */
	public void updateCompany(Company aCompany) throws NoSuchCompanyException, MappingException, ModelException;

	/**
	 * Locate all Companys like by name.
	 * @returns a List of all Companys like by name
	 */
	public ArrayList findCompanies(String name, String orderBy) throws ModelException;
	
	/**
	 * Locate all Roles.
	 * @returns a List of all Roles
	 */
	public ArrayList findAllCompanies() throws ModelException;	
}
