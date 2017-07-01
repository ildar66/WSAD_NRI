package com.hps.july.project.formbean;

import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import com.hps.july.project.valueobject.*;
import com.hps.july.project.*;
import com.hps.july.web.util.*;

/**
 * Форма списка проектов.
 * Creation date: (25.04.2003 10:57:05)
 * @author: Dmitry Dneprov
 */
public class ProjectListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Integer divcode;
	private java.lang.Integer prjtypecode;
	private Boolean allsuperregions;
	private Boolean allregions;
	private Boolean allnetzones;
    private Vector actionTypeVector = null;
    private Vector responsibleVector = null;
	private Boolean allpositions;
	private Boolean allresponsible;
	private Boolean allendtime;
	private Integer[] supregions;
	private Integer[] regions;
	private Integer[] netzones;
	private java.lang.String poscode;
	private java.lang.String posname;
	private java.lang.String respcode;
	private java.lang.String respname;
	private java.lang.Short respmonth;
	private java.lang.Integer respyear;
	private java.lang.String projectstate;
	private java.util.Enumeration divisions;
	private java.util.Enumeration projecttypes;
	private java.util.ArrayList allregionscoll;
	private java.util.ArrayList allnetzonescoll;
	private java.util.ArrayList allsupregionscoll;
	private java.lang.String posnum;
	private int countCol;
	private int respColCount;
	private final static String ALLSUPREGS = "ALLSUPREGS";
	private final static String ALLREGS = "ALLREGS";
	private final static String ALLNETZONES = "ALLNETZONES";
	private int curproject;
	public Vector con_actionTypeVector;
	public Vector con_responsibleVector;
	private java.lang.Boolean providerAll;
	private java.lang.String contructerCode;
	private java.lang.String contructerName;
	private int acceptcode;
	private int scrollcode;
	private boolean autorefresh;
/**
 * ProjectListForm constructor comment.
 */
public ProjectListForm() {
	super();
	curproject = 0;
	divisions = null;
	projecttypes = null;
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(new Date());
	setRespyear(new Integer(cal.get(Calendar.YEAR)));
	setRespmonth(new Short((short)cal.get(Calendar.MONTH)));
	setProjectstate("A");
	setFinderMethodName("5");
	setAutorefresh(false);

	allsuperregions = Boolean.TRUE;
	allregions = Boolean.TRUE;
	allnetzones = Boolean.TRUE;
	allpositions = Boolean.TRUE;
	allresponsible = Boolean.TRUE;
	allendtime = Boolean.TRUE;
	providerAll = Boolean.TRUE;

	poscode = null;
	posname = "";
	posnum = "";

	respcode = null;
	respname = "";

	supregions = new Integer [1];
	regions = new Integer [1]; 
	netzones = new Integer [1];

	divcode = null;
	prjtypecode = null;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 12:47:29)
 * @return java.lang.Integer
 * @param adivsions java.util.HashMap
 */
private Integer firstDivision(HashMap adivisions) throws Exception {
	Integer adivcode = null;
	Iterator it = adivisions.values().iterator();
	if (it.hasNext()) {
		DivisionAccessBean adiv = (DivisionAccessBean)it.next();
		adivcode = new Integer(adiv.getDivision());
	}
	return adivcode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 14:46:02)
 * @return int
 */
public int getAcceptcode() {
	return acceptcode;
}
public java.util.Vector getActionTypeVector() {
	
	return actionTypeVector;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:56:07)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getAllnetzones() {
	return Collections.enumeration(allnetzonescoll);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:56:07)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getAllregions() {
	return Collections.enumeration(allregionscoll);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:56:07)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getAllsupregions() {
	return Collections.enumeration(allsupregionscoll);
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 12:42:42)
 * @return java.lang.String
 */
public java.lang.String getContructerCode() {
	return contructerCode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 12:42:56)
 * @return java.lang.String
 */
public java.lang.String getContructerName() {
	return contructerName;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 10:08:46)
 * @return int
 */
public int getCountCol() {
	return countCol;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2003 14:53:27)
 * @return int
 */
public int getCurproject() {
	return curproject;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:08:31)
 * @return java.lang.Integer
 */
public java.lang.Integer getDivcode() {
	return divcode;
}
/**
 * Return divisions for current user.
 * Creation date: (25.04.2003 11:32:09)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getDivisions() throws Exception {
	return divisions;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditColRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator"); 
	roles.add("planAdmin"); 
	roles.add("planResponsible"); 
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator"); 
	roles.add("planAdmin"); 
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:11:59)
 * @return boolean
 */
public Boolean getEndtimeAll() {
	return allendtime;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 10:57:05)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	StringAndIntegerProperty probj = new StringAndIntegerProperty();
	Integer respint = new Integer(0);
	Integer posint = new Integer(0);
	Integer provint = new Integer(0);
	Integer sortint = new Integer(3);

	probj.setString(getRespcode());
	if (!probj.isEmpty())
		if (probj.isOk())
			respint = probj.getInteger();
			
	probj.setString(getContructerCode());
	if (!probj.isEmpty())
		if (probj.isOk())
			provint = probj.getInteger();
			
	probj.setString(getPoscode());
	if (!probj.isEmpty())
		if (probj.isOk())
			posint = probj.getInteger();
	
	probj.setString(super.getFinderMethodName());
	if (!probj.isEmpty())
		if (probj.isOk())
			sortint = probj.getInteger();
			
	return new Object[] { getDivcode(), getPrjtypecode(), 
		getSuperregionsAll().booleanValue()?Boolean.FALSE:Boolean.TRUE, getSupregions(), 
		getRegionsAll().booleanValue()?Boolean.FALSE:Boolean.TRUE, getRegions(), 
		getNetzonesAll().booleanValue()?Boolean.FALSE:Boolean.TRUE, getNetzones(),
		getPositionsAll().booleanValue()?Boolean.FALSE:Boolean.TRUE, posint,
		getResponsibleAll().booleanValue()?Boolean.FALSE:Boolean.TRUE, respint,
		getProviderAll().booleanValue()?Boolean.FALSE:Boolean.TRUE, provint,
		getEndtimeAll().booleanValue()?Boolean.FALSE:Boolean.TRUE, getRespmonth(), getRespyear(),
		"*".equals(getProjectstate())?Boolean.FALSE:Boolean.TRUE, getProjectstate(),
		con_actionTypeVector, con_responsibleVector,
		sortint};
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByQBE2";
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:13:23)
 * @return int[]
 */
public Integer[] getNetzones() {
	return netzones;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:10:50)
 * @return boolean
 */
public Boolean getNetzonesAll() {
	return allnetzones;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:14:35)
 * @return java.lang.String
 */
public java.lang.String getPoscode() {
	return poscode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:11:13)
 * @return boolean
 */
public Boolean getPositionsAll() {
	return allpositions;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:14:48)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 15:08:10)
 * @return java.lang.String
 */
public java.lang.String getPosnum() {
	return posnum;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:09:21)
 * @return java.lang.Integer
 */
public java.lang.Integer getPrjtypecode() {
	return prjtypecode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:16:45)
 * @return java.lang.String
 */
public java.lang.String getProjectstate() {
	return projectstate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:56:07)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getProjecttypes() {
	return projecttypes;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 12:41:43)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getProviderAll() {
	return providerAll;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:13:09)
 * @return int[]
 */
public Integer[] getRegions() {
	return regions;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:10:31)
 * @return boolean
 */
public Boolean getRegionsAll() {
	return allregions;
}
/**
 * Generates javascript array of regions
 * Creation date: (25.04.2003 11:56:07)
 * @return java.util.Enumeration
 */
public String getRegionsarray() {

	// Init Regions
	try {
		//Enumeration en = null;
		//en = new RegionAccessBean().findByQBE(Boolean.FALSE, null, Boolean.FALSE, "", new Integer(1));
		
		javax.servlet.ServletContext application = getServlet().getServletContext();
		ArrayList ar = (ArrayList)application.getAttribute(ALLREGS);
		Iterator it = ar.iterator();

		String body = "";
		int cnt = 0;

		while (it.hasNext()) {
			
			try {
				com.hps.july.project.valueobject.RegionObject reg = (com.hps.july.project.valueobject.RegionObject)it.next();
				body = body + "regs [" + cnt + "] = new Array(" + reg.getRegionid() + ", ";
				body = body + reg.getSupregid() + ", ";
				body = body + "\"" + reg.getRegname() + "\"); \r\n";
				cnt++;
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		String start = "var arrayLength = " + cnt + "; \r\n" +
			"var regs = new Array(); \r\n";
		
		return start + body;
		
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return "";
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:15:10)
 * @return java.lang.String
 */
public java.lang.String getRespcode() {
	return respcode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 11:28:38)
 * @return int
 */
public int getRespColCount() {
	return respColCount;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:16:09)
 * @return java.lang.Short
 */
public java.lang.Short getRespmonth() {
	return respmonth;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:15:27)
 * @return java.lang.String
 */
public java.lang.String getRespname() {
	return respname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:11:33)
 * @return boolean
 */
public Boolean getResponsibleAll() {
	return allresponsible;
}
public java.util.Vector getResponsibleVector() {
	
	return responsibleVector;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:16:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getRespyear() {
	return respyear;
}
/**
 * Insert the method's description here.
 * Creation date: (06.01.2004 12:18:22)
 * @return int
 */
public int getScrollcode() {
	return scrollcode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:10:15)
 * @return boolean
 */
public Boolean getSuperregionsAll() {
	return allsuperregions;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:12:55)
 * @return int[]
 */
public Integer[] getSupregions() {
	return supregions;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 12:38:43)
 * @return java.util.Enumeration
 */
public Enumeration getYears() {
	Vector years = new Vector();
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(new Date());
	int startyear = cal.get(Calendar.YEAR) - 2;
	for (int i=startyear; i < (startyear+5); i++) {
		YearObject ayear = new YearObject();
		ayear.setYear(i);
		years.add(ayear);
	}	
	return years.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 17:45:29)
 */
public Vector initActionTypeVector(javax.servlet.http.HttpServletRequest request) throws Exception {
	
	TimeCounter tmcnt = new TimeCounter("PROJECT:");
	tmcnt.start();
	
    countCol = 0;
    actionTypeVector = new Vector();

    // Init user columns vector before first column
    Enumeration enb = new ProjectDivColumnsAccessBean().findByColDivisionActtypeOrderByAfterColAsc(new Integer(0), getDivcode(), getPrjtypecode());
    while (enb.hasMoreElements()) {
	    countCol++;
	    ProjectDivColumnsAccessBean pab = (ProjectDivColumnsAccessBean)enb.nextElement();
	    ProjectActionHeaderObject pho = new ProjectActionHeaderObject(pab.getDivcolid(), pab.getDivisionKey().division, 
		    pab.getColname());
	    actionTypeVector.add(pho);
    }
    
	String prjParamsStr = Util_Alex.getCookie(makeName("prjparams"), request);
        
			
    java.sql.Date date = null;
    ProtoActionAccessBean protoAction = new ProtoActionAccessBean();
    Enumeration enp = protoAction.findByProjecttypeOrderByOrderAsc(
            getPrjtypecode() == null ? new Integer(0) : getPrjtypecode());
    while (enp.hasMoreElements()) {
	    protoAction = (ProtoActionAccessBean)enp.nextElement();
	    ProjectActionTypeAccessBean pab = protoAction.getProjectActionType();
	    String result = null;
	    if ( (pab.getResult() != null) && (pab.getResult().trim().length() > 0) )
	    	result = pab.getResult();
	    ProjectActionHeaderObject pho = new ProjectActionHeaderObject(pab.getProjectactiontype(), 
		    pab.getAction2division().getDivision(), pab.getName(), result, pab.getResponsibilitytypeKey().responsibilityType);
		String name = makeName("proto" + pho.getProjectactiontype());
		if(!Util_Alex.hasParam(name, prjParamsStr)) {
	        countCol++;
	        actionTypeVector.add(pho); //actionType
		}
	    // Init user columns vector after specified column
	    Enumeration ena = new ProjectDivColumnsAccessBean().findByColDivisionActtypeOrderByAfterColAsc(new Integer(protoAction.getProjectaction()), 
		    getDivcode(), getPrjtypecode());
	    while (ena.hasMoreElements()) {
		    countCol++;
		    ProjectDivColumnsAccessBean pabd = (ProjectDivColumnsAccessBean)ena.nextElement();
		    ProjectActionHeaderObject phod = new ProjectActionHeaderObject(pabd.getDivcolid(), pabd.getDivisionKey().division, 
			    pabd.getColname());
		    actionTypeVector.add(phod);
	    }
    }
    
    tmcnt.finish("InitActionTypeVector");
    
    return actionTypeVector;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:48:33)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) {

	//TimeCounter tmcnt = new TimeCounter("PROJECT:");
	javax.servlet.ServletContext application = getServlet().getServletContext();
	
	// Init project types
	try {
		projecttypes = new ProjectTypeAccessBean().findAllOrderByCodeAsc();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	// Init divisions
	try {
		String uname = request.getRemoteUser();
		//String uname = "dima";

		HashMap adivisions = new HashMap();
		
		if (request.isUserInRole("administrator")) {
			
			// permit all divisions to administrator

			// Add divisions from projectactiontypes
			Enumeration en1 = new DivisionAccessBean().findAllByProjectActionTypeOrderByNameAsc();
			while (en1.hasMoreElements()) {
				DivisionAccessBean adiv = (DivisionAccessBean)en1.nextElement();
				adivisions.put(new Integer(adiv.getDivision()), adiv);
			}
			
			// Add divisions from usercomments
			//    waiting for specific finder....
			Enumeration en3 = new DivisionAccessBean().findAllByProjectCommsByNameAsc();
			while (en3.hasMoreElements()) {
				DivisionAccessBean adiv = (DivisionAccessBean)en3.nextElement();
				adivisions.put(new Integer(adiv.getDivision()), adiv);
			}

			// Add divisions from usercolumns
			Enumeration en2 = new DivisionAccessBean().findAllByProjectColumnsOrderByNameAsc();
			while (en2.hasMoreElements()) {
				DivisionAccessBean adiv = (DivisionAccessBean)en2.nextElement();
				adivisions.put(new Integer(adiv.getDivision()), adiv);
			}

		} else {
			// Determine divisions by operator
			OperatorAccessBean oper = new OperatorAccessBean().findByLogin(uname);
			WorkerAccessBeanTable workers = new WorkerAccessBeanTable();
			workers.setWorkerAccessBean((Enumeration)new WorkerAccessBean().findWorkersByMan(oper.getManKey()));
			for (int i=0; i<workers.numberOfRows(); i++) {
				DivisionAccessBean div = workers.getWorkerAccessBean(i).getDivision();
				div.refreshCopyHelper();
				adivisions.put(new Integer(div.getDivision()), div);
			}
		}

		// Select default value for combo-box	
		if (!adivisions.isEmpty()) {
			if (divcode == null) {
				divcode = firstDivision(adivisions);
			} else {
				// Check if currently selected division exists in new collection
				if (adivisions.get(divcode) == null) {
					divcode = firstDivision(adivisions);
				}
			}
		}
		divisions = Collections.enumeration(adivisions.values());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	
	// Init Superregions
	//tmcnt.start();
	try {
		ArrayList allappsupregs = (ArrayList)application.getAttribute(ALLSUPREGS);
		if (allappsupregs == null) {
			allappsupregs = new ArrayList();
			Enumeration en = new SuperRegionAccessBean().findAllOrderByCodeAsc();
			
			// Convert to ArrayList
			while (en.hasMoreElements()) {
				SuperRegionAccessBean rab = (SuperRegionAccessBean)en.nextElement();
				SuperregionObject rob = 
					new SuperregionObject(rab.getSupregid(), rab.getSupregname());
				allappsupregs.add(rob);
			}

			application.setAttribute(ALLSUPREGS, allappsupregs);
		} else {
			System.out.println("PROJECT: allsupregions FROM application");
		}

		// Clone superregions
		allsupregionscoll = (ArrayList)allappsupregs.clone();
		
		// Check if have selected elements
		if (supregions.length == 0) {
			supregions = new Integer[1];
			supregions [0] = new Integer(((SuperregionObject)allsupregionscoll.get(0)).getSupregid());
		} else if (getSuperregionsAll().booleanValue()) {
			supregions = new Integer[allsupregionscoll.size()];
			for (int i=0; i < allsupregionscoll.size(); i++)
				supregions [i] = new Integer(((SuperregionObject)allsupregionscoll.get(i)).getSupregid());
		}

		// Sort selected first
		for (int i=0; i < allsupregionscoll.size(); i++)
			for (int j=i+1; j < allsupregionscoll.size(); j++) {
				// Complex comparator (selected - less than non-selected, than by alphabet)
				SuperregionObject sreg1 = (SuperregionObject)allsupregionscoll.get(i);
				SuperregionObject sreg2 = (SuperregionObject)allsupregionscoll.get(j);

				boolean sreg1sel = false;
				boolean sreg2sel = false;

				int k;
				int m;
				
				m = sreg1.getSupregid();
				for (k=0; k < supregions.length; k++) {
					if (supregions [k].intValue() == m) {
						sreg1sel = true;
						break;
					}
				}
				
				m = sreg2.getSupregid();
				for (k=0; k < supregions.length; k++) {
					if (supregions [k].intValue() == m) {
						sreg2sel = true;
						break;
					}
				}

				// Calculate comparator
				boolean flt = false;
				if (sreg1sel && !sreg2sel)
					flt = true;
				else if ( !(sreg1sel ^ sreg2sel)) {
					// Check abc order
					if (sreg1.getSupregname().compareToIgnoreCase(sreg2.getSupregname()) <= 0)
						flt = true;
				}

				// Apply comparator
				if (!flt) {
					allsupregionscoll.set(i, sreg2);
					allsupregionscoll.set(j, sreg1);
				}

			}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	//tmcnt.finish("Init superregions");

	//tmcnt.start();
	// Init Regions
	try {
		ArrayList allappregions = (ArrayList)application.getAttribute(ALLREGS);
		allappregions = (ArrayList)application.getAttribute(ALLREGS);
		if (allappregions == null) {
			allappregions = new ArrayList(); 
			Enumeration en = new RegionAccessBean().findByQBE(Boolean.FALSE, null, Boolean.FALSE, "", new Integer(1));
			//tmcnt.finish("Regions finder");

			//tmcnt.start();
			// Convert to ArrayList
			while (en.hasMoreElements()) {
				RegionAccessBean rab = (RegionAccessBean)en.nextElement();
				com.hps.july.project.valueobject.RegionObject rob = 
					new com.hps.july.project.valueobject.RegionObject(rab.getRegionid(), 
						rab.getSuperregionKey().supregid, rab.getRegname());
				allappregions.add(rob);
			}
				
			application.setAttribute(ALLREGS, allappregions);
		} else {
			System.out.println("PROJECT: allregionscoll FROM application");
		}

		allregionscoll = new ArrayList();
		Iterator it = allappregions.iterator();
		while (it.hasNext()) {
			com.hps.july.project.valueobject.RegionObject reg = 
				(com.hps.july.project.valueobject.RegionObject)it.next();
			// Check if region belongs to selected superregions
			int j = reg.getSupregid();
			for (int k=0; k < supregions.length; k++)
				if (j == supregions [k].intValue()) {
					allregionscoll.add(reg);
					break;
				}
		}
		
		//tmcnt.finish("Regions cycle");

		//tmcnt.start();
		// Check if have selected elements
		if (regions.length == 0) {
			regions = new Integer[1];
			regions [0] = new Integer(((com.hps.july.project.valueobject.RegionObject)allregionscoll.get(0)).getRegionid());
		} else if (getRegionsAll().booleanValue()) {
			regions = new Integer[allregionscoll.size()];
			for (int i=0; i < allregionscoll.size(); i++)
				regions [i] = new Integer(((com.hps.july.project.valueobject.RegionObject)allregionscoll.get(i)).getRegionid());
		}

		// Sort selected first
		for (int i=0; i < allregionscoll.size(); i++)
			for (int j=i+1; j < allregionscoll.size(); j++) {
				// Complex comparator (selected - less than non-selected, than by alphabet)
				com.hps.july.project.valueobject.RegionObject reg1 = (com.hps.july.project.valueobject.RegionObject)allregionscoll.get(i);
				com.hps.july.project.valueobject.RegionObject reg2 = (com.hps.july.project.valueobject.RegionObject)allregionscoll.get(j);

				boolean reg1sel = false;
				boolean reg2sel = false;

				int k;
				int m;
				
				m = reg1.getRegionid();
				for (k=0; k < regions.length; k++) {
					if (regions [k].intValue() == m) {
						reg1sel = true;
						break;
					}
				}
				
				m = reg2.getRegionid();
				for (k=0; k < regions.length; k++) {
					if (regions [k].intValue() == m) {
						reg2sel = true;
						break;
					}
				}

				// Calculate comparator
				boolean flt = false;
				if (reg1sel && !reg2sel)
					flt = true;
				else if ( !(reg1sel ^ reg2sel)) {
					// Check abc order
					if (reg1.getRegname().compareToIgnoreCase(reg2.getRegname()) <= 0)
						flt = true;
				}

				// Apply comparator
				if (!flt) {
					allregionscoll.set(i, reg2);
					allregionscoll.set(j, reg1);
				}

			}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	//tmcnt.finish("Regions sort");

	//tmcnt.start();
	// Init Netzones
	try {
		ArrayList allappnetzones = (ArrayList)application.getAttribute(ALLNETZONES);
		if (allappnetzones == null) {
			allappnetzones = new ArrayList();
			Enumeration en = new NetZoneAccessBean().findAllOrderByNameAsc();
			// Convert to ArrayList
			while (en.hasMoreElements()) {
				NetZoneAccessBean rab = (NetZoneAccessBean)en.nextElement();
				NetzoneObject rob = 
					new NetzoneObject(rab.getNetzone(), rab.getName());
				allappnetzones.add(rob);
			}

			application.setAttribute(ALLNETZONES, allappnetzones);
		} else {
			System.out.println("PROJECT: allnetzonescoll FROM application");
		}

		allnetzonescoll = (ArrayList)allappnetzones.clone();
		
		// Check if have selected elements
		if (netzones.length == 0) {
			netzones = new Integer[1];
			netzones [0] = new Integer(((NetzoneObject)allnetzonescoll.get(0)).getNetzone());
		} else if (getNetzonesAll().booleanValue()) {
			netzones = new Integer[allnetzonescoll.size()];
			for (int i=0; i < allnetzonescoll.size(); i++)
				netzones [i] = new Integer(((NetzoneObject)allnetzonescoll.get(i)).getNetzone());
		}

		// Sort selected first
		for (int i=0; i < allnetzonescoll.size(); i++)
			for (int j=i+1; j < allnetzonescoll.size(); j++) {
				// Complex comparator (selected - less than non-selected, than by alphabet)
				NetzoneObject netz1 = (NetzoneObject)allnetzonescoll.get(i);
				NetzoneObject netz2 = (NetzoneObject)allnetzonescoll.get(j);

				boolean netz1sel = false;
				boolean netz2sel = false;

				int k;
				int m;
				
				m = netz1.getNetzone();
				for (k=0; k < netzones.length; k++) {
					if (netzones [k].intValue() == m) {
						netz1sel = true;
						break;
					}
				}
				
				m = netz2.getNetzone();
				for (k=0; k < netzones.length; k++) {
					if (netzones [k].intValue() == m) {
						netz2sel = true;
						break;
					}
				}

				// Calculate comparator
				boolean flt = false;
				if (netz1sel && !netz2sel)
					flt = true;
				else if ( !(netz1sel ^ netz2sel)) {
					// Check abc order
					if (netz1.getName().compareToIgnoreCase(netz2.getName()) <= 0)
						flt = true;
				}

				// Apply comparator
				if (!flt) {
					allnetzonescoll.set(i, netz2);
					allnetzonescoll.set(j, netz1);
				}

			}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	//tmcnt.finish("Init netzones");

	if (divcode == null) {
		divcode = new Integer(0);
	}
	
	if (prjtypecode == null) {

		// Initialize to empty element
		prjtypecode = new Integer(0);
		
		/* Initialize to first element in list - commented out, but can be restored
		try {
			java.util.ArrayList prtypes = new java.util.ArrayList();
			if (projecttypes.hasMoreElements()) {
				ProjectTypeAccessBean first = (ProjectTypeAccessBean)projecttypes.nextElement();
				prjtypecode = new Integer(first.getProjecttype());
				prtypes.add(first);
				while (projecttypes.hasMoreElements()) {
					ProjectTypeAccessBean next = (ProjectTypeAccessBean)projecttypes.nextElement();
					prtypes.add(next);
				}
				projecttypes = Collections.enumeration(prtypes);
			}
			else
				prjtypecode = new Integer(0);
		} catch (Exception e) {
			prjtypecode = new Integer(0);
			e.printStackTrace(System.out);
		}
		*/
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 17:45:29)
 */
public Vector initResponsibleVector(javax.servlet.http.HttpServletRequest request) throws Exception {
	String prjParamsStr = Util_Alex.getCookie(makeName("prjparams"), request);
    respColCount = 0;
    responsibleVector = new Vector();
    Enumeration en = new ResponsibilityTypeAccessBean().findAllOrderByCodeAsc();
    while (en.hasMoreElements()) {
	    ResponsibilityTypeAccessBean resp = (ResponsibilityTypeAccessBean)en.nextElement();
		String name = makeName("resp" + resp.getResponsibilityType());
		if(!Util_Alex.hasParam(name, prjParamsStr)) {
			respColCount++;
			responsibleVector.add(resp);
		}
	    
    }
    return responsibleVector;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2004 11:31:54)
 * @return boolean
 */
public boolean isAutorefresh() {
	return autorefresh;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2003 16:46:16)
 * @return java.lang.String
 * @param nameBase java.lang.String
 */
public String makeName(String nameBase) {
	try {
		return nameBase + "_" + getPrjtypecode() + "_" + getDivcode();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 14:46:02)
 * @param newAcceptcode int
 */
public void setAcceptcode(int newAcceptcode) {
	acceptcode = newAcceptcode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2004 11:31:54)
 * @param newAutorefresh boolean
 */
public void setAutorefresh(boolean newAutorefresh) {
	autorefresh = newAutorefresh;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 12:42:42)
 * @param newContructerCode java.lang.String
 */
public void setContructerCode(java.lang.String newContructerCode) {
	contructerCode = newContructerCode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 12:42:56)
 * @param newContructerName java.lang.String
 */
public void setContructerName(java.lang.String newContructerName) {
	contructerName = newContructerName;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 10:08:46)
 * @param newCountCol int
 */
public void setCountCol(int newCountCol) {
	countCol = newCountCol;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2003 14:53:27)
 * @param newCurproject int
 */
public void setCurproject(int newCurproject) {
	curproject = newCurproject;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:08:31)
 * @param newDivcode java.lang.Integer
 */
public void setDivcode(java.lang.Integer newDivcode) {
	divcode = newDivcode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:11:59)
 * @param newAllendtime boolean
 */
public void setEndtimeAll(Boolean newAllendtime) {
	allendtime = newAllendtime;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @param newFinderMethodName java.lang.String
 */
public void setFinderMethodName(java.lang.String newFinderMethodName) {

	if (newFinderMethodName.length() < 3)
		super.setFinderMethodName(newFinderMethodName);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:13:23)
 * @param newNetzones int[]
 */
public void setNetzones(Integer[] newNetzones) {
	netzones = newNetzones;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:10:15)
 * @param newAllsuperregions boolean
 */
public void setNetzonesAll(Boolean newAllnetzones) {
	allnetzones = newAllnetzones;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:14:35)
 * @param newPoscode java.lang.String
 */
public void setPoscode(java.lang.String newPoscode) {
	poscode = newPoscode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:11:13)
 * @param newAllpositions boolean
 */
public void setPositionsAll(Boolean newAllpositions) {
	allpositions = newAllpositions;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:14:48)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 15:08:10)
 * @param newPosnum java.lang.String
 */
public void setPosnum(java.lang.String newPosnum) {
	posnum = newPosnum;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:09:21)
 * @param newPrjtypecode java.lang.Integer
 */
public void setPrjtypecode(java.lang.Integer newPrjtypecode) {
	prjtypecode = newPrjtypecode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:16:45)
 * @param newProjectstate java.lang.String
 */
public void setProjectstate(java.lang.String newProjectstate) {
	projectstate = newProjectstate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 12:41:43)
 * @param newProviderAll java.lang.Boolean
 */
public void setProviderAll(java.lang.Boolean newProviderAll) {
	providerAll = newProviderAll;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:13:09)
 * @param newRegions int[]
 */
public void setRegions(Integer[] newRegions) {
	regions = newRegions;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:10:31)
 * @param newAllregions boolean
 */
public void setRegionsAll(Boolean newAllregions) {
	allregions = newAllregions;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:15:10)
 * @param newRespcode java.lang.String
 */
public void setRespcode(java.lang.String newRespcode) {
	respcode = newRespcode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 11:28:38)
 * @param newRespColCount int
 */
public void setRespColCount(int newRespColCount) {
	respColCount = newRespColCount;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:16:09)
 * @param newRespmonth java.lang.Short
 */
public void setRespmonth(java.lang.Short newRespmonth) {
	respmonth = newRespmonth;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:15:27)
 * @param newRespname java.lang.String
 */
public void setRespname(java.lang.String newRespname) {
	respname = newRespname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:11:33)
 * @param newAllresponsible boolean
 */
public void setResponsibleAll(Boolean newAllresponsible) {
	allresponsible = newAllresponsible;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:16:25)
 * @param newRespyear java.lang.Integer
 */
public void setRespyear(java.lang.Integer newRespyear) {
	respyear = newRespyear;
}
/**
 * Insert the method's description here.
 * Creation date: (06.01.2004 12:18:22)
 * @param newScrollcode int
 */
public void setScrollcode(int newScrollcode) {
	scrollcode = newScrollcode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:10:15)
 * @param newAllsuperregions boolean
 */
public void setSuperregionsAll(Boolean newAllsuperregions) {
	allsuperregions = newAllsuperregions;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:12:55)
 * @param newSupregions int[]
 */
public void setSupregions(Integer[] newSupregions) {
	supregions = newSupregions;
}
}
