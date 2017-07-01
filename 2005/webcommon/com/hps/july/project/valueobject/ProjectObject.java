package com.hps.july.project.valueobject;

import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.math.*;
import java.util.*;

/**
 * Объект-wrapper для проекта.
 * Creation date: (28.04.2003 14:46:59)
 * @author: Dmitry Dneprov
 */
public class ProjectObject {
	private java.lang.String state;
	private java.lang.String contrname;
	private Vector actionVector = new Vector();
	private Vector responsibleVector = new Vector();
	private int divcode;
	private int project;
	private java.lang.Integer posgsmid;
	private java.lang.String posname;
	private int posstorageplace;
	private java.lang.String vctext;
	private java.lang.String posdetails;
	private java.lang.String notes;
	private Integer monthfinish;
	private Integer yearfinish;
	private java.lang.String vcname;
/**
 * ProjectObject constructor comment.
 */
public ProjectObject() {
	super();
	//setPrjobj(newPrjobj);
	setContrname("");
	//setDivcode(argDivcode);
	//try {
	//	int prcode = newPrjobj.getProject();
	//    setState(new ProjectStateAccessBean().findCurrentForProject(
	//	    new Integer(prcode)).getState());
    //} catch (Exception e) {
	    // No state
	    setState("N");
    //}

    /*
    try {
	    OrganizationAccessBean org = new OrganizationAccessBean();
	    org.setInitKey_organization(newPrjobj.getContructerKey().organization);
	    org.refreshCopyHelper();
	    setContrname(org.getShortname());
    } catch (Exception e) {
	    // No contructer
	    setContrname("");
    }
    */
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 22:11:38)
 * @return java.util.Vector
 */
public java.util.Vector getActionVector() {
	return actionVector;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2003 13:57:54)
 * @return java.lang.String
 */
public java.lang.String getContrname() {
	return contrname;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 12:15:03)
 * @return int
 */
public int getDivcode() {
	return divcode;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:15:30)
 * @return int
 */
public Integer getMonthfinish() {
	return monthfinish;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:14:24)
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:14:11)
 * @return java.lang.String
 */
public java.lang.String getPosdetails() {
	return posdetails;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:12:51)
 * @return java.lang.Integer
 */
public java.lang.Integer getPosgsmid() {
	return posgsmid;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:13:06)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:13:36)
 * @return int
 */
public int getPosstorageplace() {
	return posstorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:12:20)
 * @return int
 */
public int getProject() {
	return project;
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 22:11:38)
 * @return java.util.Vector
 */
public java.util.Vector getResponsibleVector() {
	return responsibleVector;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 16:29:21)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2003 14:31:03)
 * @return java.lang.String
 */
public java.lang.String getVcname() {
	return vcname;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:13:50)
 * @return java.lang.String
 */
public java.lang.String getVctext() {
	return vctext;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:15:47)
 * @return int
 */
public Integer getYearfinish() {
	return yearfinish;
}
/**
 * Initialize real actions for the project.
 * Creation date: (13.12.2002 20:36:15)
 */
public void initActionVector(Vector actionTypeVector, PreparedStatement st, PreparedStatement divst) {
	
	//TimeCounter tmcnt = new TimeCounter("PROJECT:");
	//tmcnt.start();
    ProjectActionAccessBean action = null;
    Enumeration enum = actionTypeVector.elements();
    
    actionVector=new Vector();
    while (enum.hasMoreElements()) {
	    ProjectActionHeaderObject obj = (ProjectActionHeaderObject)enum.nextElement();
	    if (obj.getObjtype() == ProjectActionHeaderObject.OBJPRJACTION) {

	        try {
				// Find ProjectAction
			    st.setInt(1, getProject());
			    st.setInt(2, obj.getProjectactiontype());
			    st.setInt(3, getDivcode());

			    ResultSet rs = st.executeQuery();
			    if (rs.next()) {
			        ProjectActionObject ob = new ProjectActionObject(rs.getInt("projectactionid"), getDivcode());

			        ob.setHeadername(obj.getColname());
			        
			        if ("Y".equals(rs.getString("completed")))
			        	ob.setCompleted(Boolean.TRUE);
			        else
			        	ob.setCompleted(Boolean.FALSE);
			        	
			        if ("Y".equals(rs.getString("agreement")))
			        	ob.setAgreement(Boolean.TRUE);
			        else
			        	ob.setAgreement(Boolean.FALSE);
			        	
			        if ("Y".equals(rs.getString("hasproblems")))
			        	ob.setHasproblems(true);
			        else
			        	ob.setHasproblems(false);

			        ob.setFactdate(rs.getDate("factdate"));
			        	
			        ob.setPlandate(rs.getDate("plandate"));

			        byte[] comm = rs.getBytes("comment");
			        if (rs.wasNull() || (comm==null))
			        	ob.setComment(null);
			        else
			        	ob.setComment(new String(comm, "Cp1251").trim());
			        	
			        byte[] notes = rs.getBytes("notes");
			        if (rs.wasNull() || (notes==null))
			        	ob.setNotes(null);
			        else
			        	ob.setNotes(new String(notes, "Cp1251").trim());
			        	
			        if ("Y".equals(rs.getString("isnewplandate")))
			        	ob.setIsNewplandate(Boolean.TRUE);
			        else
			        	ob.setIsNewplandate(Boolean.FALSE);
			        	
			        ob.setSuggplandate(rs.getDate("suggplandate"));
			        ob.setProjectactiontype(obj.getProjectactiontype());
			        	
			        actionVector.add(ob);
			    } else {
				    // Create dummy object
			        ProjectActionObject ob = new ProjectActionObject(0, getDivcode());

			        ob.setHeadername(null);
			        ob.setCompleted(Boolean.FALSE);
			        ob.setAgreement(Boolean.FALSE);
			        ob.setHasproblems(false);
			        ob.setFactdate(null);
			        ob.setPlandate(null);
			        ob.setComment(null);
			        ob.setIsNewplandate(Boolean.FALSE);
			        ob.setSuggplandate(null);
			        ob.setProjectactiontype(obj.getProjectactiontype());
			        	
			        actionVector.add(ob);
			    }

			    rs.close();
	        } catch (Exception e) {
		        actionVector.add(null);
		        e.printStackTrace(System.out);
	        }
	    } else {
		    // instance of ProjectDivColumnsAccessBean
            ProjectActionObject ob = new ProjectActionObject(obj.getDivcolid(), getDivcode(), getProject());
	        try {
				// Find ProjectAction
			    divst.setInt(1, getProject());
			    divst.setInt(2, obj.getDivcolid());

			    ResultSet rs = divst.executeQuery();
			    if (rs.next()) {
			        ob.setUsercolval(rs.getString("colvalue"));
			        if (rs.wasNull())
			        	ob.setUsercolval("");
			    }
			    rs.close();
	        } catch (Exception e) {
		        e.printStackTrace(System.out);
	        }
            actionVector.add(ob);
	    }
    }
    //tmcnt.finish("ActionVector");
}
/**
 * Initialize real actions for the project.
 * Creation date: (13.12.2002 20:36:15)
 */
public void initResponsibleVector(Vector responsibleTypeVector, PreparedStatement st) {


	//TimeCounter tmcnt = new TimeCounter("PROJECT:");
	//tmcnt.start();
    try {
	
	    PositionResponsibleWorkersAccessBean resp = null;
	    Enumeration enum = responsibleTypeVector.elements();
	    
	    responsibleVector=new Vector();
		Integer pos = new Integer(getPosstorageplace());
	    while (enum.hasMoreElements()) {
	        try {
		        Integer rtype = new Integer(((ResponsibilityTypeAccessBean)enum.nextElement()).getResponsibilityType());

		        st.setInt(1, pos.intValue());
		        st.setInt(2, rtype.intValue());

		        ResultSet rs = st.executeQuery();
		        if (rs.next()) 
					responsibleVector.add(rs.getString("lastname").trim());
		        else
		            responsibleVector.add(null);

		        rs.close();
		        
	        } catch (Exception e) {
		        responsibleVector.add(null);
		        e.printStackTrace(System.out);
	        }
	    }
	    
    } catch (Exception e) {
	    e.printStackTrace(System.out);
    }
    //tmcnt.finish("InitResponsibleVector");
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2003 13:57:54)
 * @param newContrname java.lang.String
 */
public void setContrname(java.lang.String newContrname) {
	contrname = newContrname;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 12:15:03)
 * @param newDivcode int
 */
public void setDivcode(int newDivcode) {
	divcode = newDivcode;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:15:30)
 * @param newMonthfinish int
 */
public void setMonthfinish(Integer newMonthfinish) {
	monthfinish = newMonthfinish;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:14:24)
 * @param newNotes java.lang.String
 */
public void setNotes(java.lang.String newNotes) {
	notes = newNotes;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:14:11)
 * @param newPosdetails java.lang.String
 */
public void setPosdetails(java.lang.String newPosdetails) {
	posdetails = newPosdetails;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:12:51)
 * @param newPosgsmid java.lang.Integer
 */
public void setPosgsmid(java.lang.Integer newPosgsmid) {
	posgsmid = newPosgsmid;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:13:06)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:13:36)
 * @param newPosstorageplace int
 */
public void setPosstorageplace(int newPosstorageplace) {
	posstorageplace = newPosstorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:12:20)
 * @param newProject int
 */
public void setProject(int newProject) {
	project = newProject;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 16:29:21)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2003 14:31:03)
 * @param newVcname java.lang.String
 */
public void setVcname(java.lang.String newVcname) {
	vcname = newVcname;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:13:50)
 * @param newVctext java.lang.String
 */
public void setVctext(java.lang.String newVctext) {
	vctext = newVctext;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2003 12:15:47)
 * @param newYearfinish int
 */
public void setYearfinish(Integer newYearfinish) {
	yearfinish = newYearfinish;
}
}
