/*
 * Created on 20.02.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.valueobject;

import com.hps.july.cdbc.lib.CDBCRowObject;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PeopleRow {
	private String man="";
	private String firstname="";
	private String lastname="";
	private String middlename="";
	private String passportser="";
	private String passportdate="";
	private String passportwhom="";
	private String isactive="";
	private String tabnum="";
	
	public PeopleRow(CDBCRowObject newRow){
		if (newRow.hasColumn("man")) setMan(newRow.getColumn("man").asString());
		if (newRow.hasColumn("firstname")) setFirstname(newRow.getColumn("firstname").asString());
		if (newRow.hasColumn("lastname")) setLastname(newRow.getColumn("lastname").asString());
		if (newRow.hasColumn("middlename")) setMiddlename(newRow.getColumn("middlename").asString());
		if (newRow.hasColumn("passportser")) setPassportser(newRow.getColumn("passportser").asString());
		if (newRow.hasColumn("passportdate")) setPassportdate(newRow.getColumn("passportdate").asString());
		if (newRow.hasColumn("passportwhom")) setPassportwhom(newRow.getColumn("passportwhom").asString());
		if (newRow.hasColumn("isactive")) setIsactive(newRow.getColumn("isactive").asString());
		if (newRow.hasColumn("tabnum")) setTabnum(newRow.getColumn("tabnum").asString());
	}
	
	public String getMan(){return man;}
	public String getFirstname(){return firstname;}
	public String getLastname(){return lastname;}
	public String getMiddlename(){return middlename;}
	public String getPassportser(){return passportser;}
	public String getPassportdate(){return passportdate;}
	public String getPassportwhom(){return passportwhom;}
	public String getIsactive(){return isactive;}
	public String getTabnum(){return tabnum;}

	public void setMan(String newMan){ man = newMan; }
	public void setFirstname(String newFirstname){ firstname = newFirstname; }
	public void setLastname(String newLastname){ lastname = newLastname; }
	public void setMiddlename(String newMiddlename){ middlename = newMiddlename; }
	public void setPassportser(String newPassportser){ passportser = newPassportser; }
	public void setPassportdate(String newPassportdate){ passportdate = newPassportdate; }
	public void setPassportwhom(String newPassportwhom){ passportwhom = newPassportwhom; }
	public void setIsactive(String newIsactive){ isactive = newIsactive; }
	public void setTabnum(String newTabnum){ tabnum = newTabnum; }
}
