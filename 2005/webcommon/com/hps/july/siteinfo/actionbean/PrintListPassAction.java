package com.hps.july.siteinfo.actionbean;

import java.sql.*;
import java.io.*;
import java.util.*;
import com.hps.july.siteinfo.formbean.BuildListPassForm;
import com.hps.july.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Формирует список прохода в Word
 * Форм бина нет, переходит на listPassWord.jsp
 * @author: Maxim Gerasimov
 */
public class PrintListPassAction extends org.apache.struts.action.Action {
private ArrayList findOrgCars(Integer storageplace)
	throws Exception
{
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT c.car car, TRIM(c.car_model) car_model, TRIM(c.car_number) car_number, TRIM(o.shortname) orgname ");
	sb.append("FROM cars c, organizations o ");
	sb.append("WHERE c.organization IN (SELECT UNIQUE wr.organization FROM workresponsibility wr WHERE wr.storageplace=? AND wr.resptype='O') AND c.isour = 'N' AND c.organization = o.organization ");
	sb.append("ORDER BY orgname, car_model, car_number ");

	ArrayList result = new ArrayList();
	JdbcConnection jcon = new JdbcConnection();
	Connection con = jcon.getConnection();
	try {
		PreparedStatement ps = con.prepareStatement(sb.toString());
		ps.setInt(1,(storageplace==null?0:storageplace.intValue()));

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			CarValueObject cv = new CarValueObject();
			cv.setCar(rs.getInt("car"));
			cv.setCarmodel(rs.getString("car_model"));
			cv.setCarnumber(rs.getString("car_number"));
			cv.setOrgname(rs.getString("orgname"));
			result.add(cv);
		}

	    try {
		    rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	    try {
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	} catch(Exception e) {
		// @TODO: handle exceptions
		e.printStackTrace(System.out);
		throw e;
	} finally {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	return result;
}
private ArrayList findOrgResponsible(Integer storageplace)
	throws java.lang.Exception
{
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT w.worker worker, TRIM(p.lastname) lastname, TRIM(p.firstname) firstname, TRIM(p.middlename) middlename, TRIM(p.passportser) passportser, p.passportdate passportdate, TRIM(p.passportwhom) passportwhom, TRIM (o.shortname) orgname ");
	sb.append("FROM workers w, people p, organizations o ");
	sb.append("WHERE w.man = p.man AND w.isour = 'N' AND w.organization IN (SELECT organization FROM workresponsibility WHERE storageplace = ? AND resptype = 'O') AND w.organization = o.organization ");
	sb.append("ORDER BY orgname, lastname, firstname, middlename ");
	
	ArrayList result = new ArrayList();
	JdbcConnection jcon = new JdbcConnection();
	Connection con = jcon.getConnection();
	try {
		PreparedStatement ps = con.prepareStatement(sb.toString());
		ps.setInt(1,(storageplace==null?0:storageplace.intValue()));
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			WorkerValueObject wv = new WorkerValueObject();
			wv.setWorker(rs.getInt("worker"));
			wv.setLastname(rs.getString("lastname"));
			wv.setFirstname(rs.getString("firstname"));
			wv.setMiddlename(rs.getString("middlename"));
			wv.setPassportser(rs.getString("passportser"));
			wv.setPassportdate(rs.getDate("passportdate"));
			wv.setPassportwhom(rs.getString("passportwhom"));
			wv.setOrgname(rs.getString("orgname"));
			result.add(wv);
		}
	    try {
		    rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	    try {
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	} catch(Exception e) {
		// @TODO: handle exceptions
		e.printStackTrace(System.out);
		throw e;
	} finally {
	    try {
		    con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	return result;
}
private ArrayList findOurCars(Integer storageplace)
	throws Exception
{
	StringBuffer sb = new StringBuffer();
	// @TODO: prepare SQL string
	sb.append("SELECT c.car car, TRIM(c.car_model) car_model, TRIM(c.car_number) car_number, d.shortname orgname ");
	sb.append("FROM cars c, divisions d ");
	sb.append("WHERE c.isour = 'Y' AND c.division IN ");
	sb.append("(SELECT UNIQUE division FROM workers w, workresponsibility wr WHERE w.worker=wr.worker AND wr.storageplace=? AND wr.resptype='W') ");
	sb.append("AND d.division = c.division ");
	sb.append("ORDER BY car_model, car_number ");
	
	ArrayList result = new ArrayList();
	JdbcConnection jcon = new JdbcConnection();
	Connection con = jcon.getConnection();
	try {
		PreparedStatement ps = con.prepareStatement(sb.toString());
		ps.setInt(1,(storageplace==null?0:storageplace.intValue()));

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			CarValueObject cv = new CarValueObject();
			cv.setCar(rs.getInt("car"));
			cv.setCarmodel(rs.getString("car_model"));
			cv.setCarnumber(rs.getString("car_number"));
			cv.setOrgname(jcon.getString(rs, "orgname"));
			result.add(cv);
		}

	    try {
		    rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	    try {
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	} catch(Exception e) {
		// @TODO: handle exceptions
		e.printStackTrace(System.out);
		throw e;
	} finally {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	return result;

	/*
	try {
		ArrayList cars = new ArrayList();
		HashSet set = new HashSet();
		for(int i = 0; i < organizations.length; i++) {
System.out.println("PALP - ORG:"+organizations[i]);
			CarAccessBean car = new CarAccessBean();
			Enumeration enum = car.findByOrganizationIsour(organizations[i], isour);
			
System.out.println("PALP - ORG.enum:"+enum.hasMoreElements());
			while(enum.hasMoreElements()){
				CarAccessBean temp = (CarAccessBean)enum.nextElement();
				Integer key = new Integer(temp.getCar());
				if(!set.contains(key)){
System.out.println("PALP - ORG.enum.car:ADDED:"+key);
					set.add(key);
					cars.add(temp);
				} else {
System.out.println("PALP - ORG.enum.car:REJECT:"+key);
				}
			}
		}

		return cars;
	}catch(Exception e){
		System.out.println("Error in PrintListPassAction.findCars");
		e.printStackTrace(System.out);
		throw e;
	}
	*/
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 21:08:29)
 * @return ArrayList of com.hps.july.siteinfo.actionbean.WorkerValueBean
 * (used in listPassWord.jsp under name workerBeeline)
 * @param storageplace java.lang.Integer
 * @param isOur java.lang.String
 * @exception java.lang.Exception The exception description.
 */
private ArrayList findOurResponsible(Integer storageplace)
	throws java.lang.Exception
{
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT w.worker worker, TRIM(p.lastname) lastname, TRIM(p.firstname) firstname, TRIM(p.middlename) middlename, TRIM(p.passportser) passportser, p.passportdate passportdate, TRIM(p.passportwhom) passportwhom, d.shortname orgname ");
	sb.append("FROM workers w, people p, divisions d ");
	sb.append("WHERE p.man = w.man AND w.isservicestuff = 'Y' AND w.division IN ");
	sb.append("(SELECT UNIQUE division FROM workers w, workresponsibility wr WHERE w.worker=wr.worker AND wr.storageplace=? AND wr.resptype='W') ");
	sb.append("AND d.division = w.division ");
	sb.append("ORDER BY lastname, firstname, middlename ");
	
	ArrayList result = new ArrayList();
	JdbcConnection jcon = new JdbcConnection();
	Connection con = jcon.getConnection();
	try {
		PreparedStatement ps = con.prepareStatement(sb.toString());
		ps.setInt(1,(storageplace==null?0:storageplace.intValue()));
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			WorkerValueObject wv = new WorkerValueObject();
			wv.setWorker(rs.getInt("worker"));
			wv.setLastname(rs.getString("lastname"));
			wv.setFirstname(rs.getString("firstname"));
			wv.setMiddlename(rs.getString("middlename"));
			wv.setPassportser(rs.getString("passportser"));
			wv.setPassportdate(rs.getDate("passportdate"));
			wv.setPassportwhom(rs.getString("passportwhom"));
			wv.setOrgname(jcon.getString(rs, "orgname"));
			result.add(wv);
		}
	    try {
		    rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	    try {
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	} catch(Exception e) {
		// @TODO: handle exceptions
		e.printStackTrace(System.out);
		throw e;
	} finally {
	    try {
		    con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	return result;
	
/*
		
	try{
		PositionResponsibleWorkersAccessBean pr	= new PositionResponsibleWorkersAccessBean();
		Enumeration enum = pr.findByPositionResptype(storageplace, "W");

		ArrayList ar = new ArrayList();
		HashSet set = new HashSet();
		HashSet rset = new HashSet();
		while(enum.hasMoreElements()){
			PositionResponsibleWorkersAccessBean responsible =
				(PositionResponsibleWorkersAccessBean)enum.nextElement();
			WorkerAccessBean rworker = responsible.getWorker();
			WorkerKey rkey = responsible.getWorkerKey();
			if(rworker != null) {
				if( rkey != null && !rset.contains(rkey) ) {
System.out.println("OUR_WORKER:rworker:"+rworker.getWorker());
					DivisionAccessBean div = rworker.getDivision();
System.out.println("    OUR_WORKER:division:"+div.getDivision());
					Enumeration endiv = rworker.findWorkersByDivision(new DivisionKey(div.getDivision()));
System.out.println("    OUR_WORKER:has workers:"+endiv);
					while(endiv.hasMoreElements()) {
						WorkerAccessBean w = (WorkerAccessBean)endiv.nextElement();
						WorkerKey key = new WorkerKey(w.getWorker());
						if(key != null && !set.contains(key)) {
							if(w.getIsservicestuff() != null && w.getIsservicestuff().booleanValue()) {
								set.add(key);
								ar.add(w);
System.out.println("        OUR_WORKER:ADDED:"+key.worker);
							} else {
System.out.println("        OUR_WORKER:REJECT:"+key.worker+" Service:"+w.getIsservicestuff());
							}
						}
					}
					rset.add(rkey);
				} else {
System.out.println("OUR_WORKER:rworker:"+rworker.getWorker()+" processed");
				}
			} else {
System.out.println("OUR_WORKER:rworker = null");
			}
			
		}

		return ar;
	} catch(Exception e) {
		System.out.println("Error in PrintListPassAction.findResponsible");
		e.printStackTrace(System.out);
		throw e;
	}
*/
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException {

	try{
		BuildListPassForm f = (BuildListPassForm)form;
		Integer storageplace = new Integer(f.getStorageplace());
		if(storageplace.intValue() == 0)
			throw new Exception("===storageplace = 0===");

		if(f.isWorkerBeeline()){
			request.setAttribute("workerBeeline", findOurResponsible(storageplace));
		}

		if(f.isCarBeeline()){			
			request.setAttribute("carBeeline", findOurCars(storageplace));
		}

		if(f.isWorkerNoBeeline()){
			request.setAttribute("workerNoBeeline", findOrgResponsible(storageplace));
		}
		
		if(f.isCarNoBeeline()){			
			request.setAttribute("carNoBeeline", findOrgCars(storageplace));
		}

		PositionAccessBean position = new PositionAccessBean();
		position.setInitKey_storageplace(storageplace.intValue());
		position.refreshCopyHelper();
		request.setAttribute("position", position);
		
		return mapping.findForward("listPass");
	} catch(Exception e) {
		System.out.println("Error in PrintListPassAction");
		e.printStackTrace(System.out);
		return mapping.findForward("error");
	}
}
}
