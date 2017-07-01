package com.hps.july.inventory.formbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.*;
import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.cdbc.objects.*;
import org.apache.struts.action.*;
import org.apache.struts.util.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
* Insert the type's description here.
* Creation date: (29.07.2005 17:34:46)
* @author: Shafigullin Ildar
*/
public class ContrEquipListForm extends com.hps.july.web.util.EditForm {
    private java.util.List equipDetList;
	private java.lang.String equipDetSortBy;
	private boolean isContent = false;
	private int storageplace;
	private java.util.ArrayList list = new ArrayList();
	private int act;
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:55:16)
 */
public ContrEquipListForm() {
    setEquipDetSortBy("name");
}
private void checkSize(java.util.ArrayList arList, int index) {
	int asize = arList.size();
	if (asize < (index+1)) {
		for (int i=0; i < index+1 - asize; i++) {
			arList.add(new PosVO());
		}
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 15:01:21)
 * @return int
 */
public int getAct() {
	return act;
}
/**
 * Текущее приложение.
 * Creation date: (29.07.2005 17:34:46)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:17:13)
 * @return java.util.List
 */
public java.util.List getEquipDetList() {
	return equipDetList;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:54:22)
 * @return java.lang.String
 */
public java.lang.String getEquipDetSortBy() {
	return equipDetSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 20:04:57)
 * @return boolean
 */
public boolean getIsContent() {
	return isContent;
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getList(int index) {
	checkSize(list, index);
	return (PosVO)list.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 14:01:56)
 * @return int
 */
public int getListCount() {
	return list.size();
}
/**
 * Текущее состояние приложения.
 * Creation date: (29.07.2005 17:34:46)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.CONTR_EQ_LIST;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 11:34:31)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	
}
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
		list.clear();
		CDBCResultSet res = CDBCBaseStationObject.getEquipResSetFromPosition(getStorageplace(), getEquipDetSortBy());
		Iterator it2 = res.listIterator();

		ListIterator iter = res.listIterator();
    	while (iter.hasNext()) {
			PosVO row = new PosVO();
	    	
        	CDBCRowObject ro = (CDBCRowObject) iter.next();        	
        	Integer sc = (Integer)(ro.getColumn("storagecard").asObject());
        	row.setStoragecard(sc);

			LinkedList params = new LinkedList();
			//System.out.println("----stoargecard: " + sc.intValue());
			String sql = "select id from invcontractitems where group=16 and storagecard=? and idact=?";
			params.add(sc);
			params.add(new Integer(getAct()));
			CDBCResultSet res2 = new CDBCResultSet();
			res2.executeQuery(sql, params.toArray());
	
			Iterator it = res2.listIterator();
			if(it.hasNext()){
				//System.out.println("----loaded:" + act);
				row.setLoaded(Boolean.TRUE);
			}	
        	
        	row.setSn(ro.getColumn("serialnumber").asString());
        	row.setQty(new Double(ro.getColumn("qty").asString()));
        	row.setNote(ro.getColumn("comment").asString());
        	row.setPlace(ro.getColumn("place").asString());
       	 	row.setManucode(ro.getColumn("manucode").asString());
       	 	row.setType((Integer)(ro.getColumn("resource").asObject()));
       	 	row.setTypename(ro.getColumn("model").asString());
       		row.setCategname(ro.getColumn("name").asString());
        	list.add(row);
    	}
		
}
public String processUpdate(javax.servlet.http.HttpServletRequest request,ActionErrors errors) throws Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();

	Connection conn = null;
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	ResultSet rs = null;
	
	try{

	conn = new JdbcConnection().getConnection();
	
	int group = 16;		

	//-----------комплект----------
	ps2 = conn.prepareStatement("SELECT e.equipment FROM equipment e, storageplaces sp"+
				" WHERE e.equipment = sp.storageplace AND sp.type = 'B' AND e.position = ?");
	ps2.setInt(1,getStorageplace());
	rs = ps2.executeQuery();	
	int complectid = 0;	
	if(rs.next()){
	  complectid = rs.getInt(1);	
	}
	
	ps3 = conn.prepareStatement("delete from invcontractitems where idact=? and group=?");
	ps3.setInt(1,act);
	ps3.setInt(2,group);
	ps3.execute();
	
	//-----------------------------
	
		for (int i = 0; i < list.size(); i++) {			
			
    		PosVO vo = (PosVO)list.get(i);
    		
			if(vo.getLoaded().booleanValue()){
				int id = keyGen.getNextKey("tables.invcontractitems");
			
				ps = conn.prepareStatement("insert into invcontractitems values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
								
				int count = 0;
				if(vo.getQty()!=null){
					count = vo.getQty().intValue();
				}
			
	   			ps.setInt(1,id);
	   			ps.setInt(2,act);
	   			ps.setInt(3,group);	   		
	    		ps.setInt(4,vo.getType()!=null?vo.getType().intValue():0);	   		
	    		ps.setNull(5,java.sql.Types.INTEGER);
	    		ps.setInt(6,count);
	    		ps.setString(7,vo.getSn());	    	
		    	ps.setString(8,vo.getNote());
	    		ps.setNull(9,java.sql.Types.INTEGER);
	    		ps.setNull(10,java.sql.Types.DECIMAL);
	    		ps.setNull(11,java.sql.Types.DECIMAL);
	    		ps.setNull(12,java.sql.Types.CHAR);
	    		ps.setNull(13,java.sql.Types.CHAR);
	    		ps.setNull(14,java.sql.Types.DECIMAL);
	    		ps.setNull(15,java.sql.Types.CHAR);
	    		ps.setInt(16,complectid);
	    		ps.setInt(17,storageplace);
	    		ps.setInt(18,vo.getResourcecateg());
				ps.setString(19,"N");
				ps.setInt(20,vo.getStoragecard().intValue());
				ps.setNull(21,java.sql.Types.CHAR);
	    		ps.execute();

			}
		
		}
	}catch(Exception e){
		e.printStackTrace(System.out);
	}finally{
	    try{
		    if(rs!=null) rs.close();
		    if(ps!=null) ps.close();
		    if(ps2!=null) ps2.close();
		    if(ps3!=null) ps3.close();
		    if(conn!=null) conn.close();
	    }catch(Exception exc){
		    exc.printStackTrace(System.out);
	    }
    }
    return null;

}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 15:01:21)
 * @param newAct int
 */
public void setAct(int newAct) {
	act = newAct;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:17:13)
 * @param newEquipDetList java.util.List
 */
public void setEquipDetList(java.util.List newEquipDetList) {
	equipDetList = newEquipDetList;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 18:54:22)
 * @param newEquipDetSortBy java.lang.String
 */
public void setEquipDetSortBy(java.lang.String newEquipDetSortBy) {
	equipDetSortBy = newEquipDetSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 20:04:57)
 * @param newIsContent boolean
 */
public void setIsContent(boolean newIsContent) {
	isContent = newIsContent;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 11:34:31)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
