package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.*;
import com.hps.july.basestation.APPStates;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик списка мощьностей канадов БС
 */
public class ShowChanalPowerAction
	extends NavigatedAction
{
private ActionForm fillForm(ActionForm form, HttpServletRequest request)
    throws Exception {

    try {
        ShowChanalPowerForm f = (ShowChanalPowerForm) form;
        
        int basestation = 0;
        basestation = Integer.parseInt(request.getParameter("basestation"));
        //if(basestation == 0) basestation = 7008529;
        
        BaseStationAccessBean bsab = new BaseStationAccessBean();
        bsab.setInitKey_storageplace(basestation);
        bsab.refreshCopyHelper();

        f.setBasestation(basestation);
        f.setAddress(bsab.getPosition().getAddress());
        f.setBasestationName(bsab.getName());
        f.setBasestationNum(bsab.getStorageplace());
        f.setPositionName(bsab.getPosition().getName());
        f.setPositionNum(bsab.getPosition().getStorageplace());

		//определяем массывы для мощностей по диапазонам 900 и 1800
        ChanalPowers[] powers900 = new ChanalPowers[124];
        ChanalPowers[] powers1800 = new ChanalPowers[124];
        for (int i = 0; i < 124; i++) { 
	        //Вставляю пустые
			powers900[i] = new ChanalPowers(i + 1);
			powers1800[i] = new ChanalPowers(i + 1);
        }
		
        //получаем мощность каналов для 900 и 1800
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append("	chanal, polarization, band, power ");
		sql.append(" FROM ");
		sql.append("	chanalpowers ");
		sql.append(" WHERE ");
		sql.append(" equipment = ? ");
		sql.append(" ORDER BY chanal ");
		com.hps.july.cdbc.lib.CDBCResultSet rs = new com.hps.july.cdbc.lib.CDBCResultSet();
		rs.executeQuery(sql.toString(), new Object[] { new Integer(basestation) });
		java.util.Iterator iterator = rs.listIterator();
		while (iterator.hasNext()) {
			com.hps.july.cdbc.lib.CDBCRowObject row = (com.hps.july.cdbc.lib.CDBCRowObject)iterator.next();
			Integer chanal = (Integer)row.getColumn("chanal").asObject();
			String polar = row.getColumn("polarization").asString();
			Integer power = (Integer)row.getColumn("power").asObject();
			Integer band = (Integer)row.getColumn("band").asObject();
			if(band.intValue() == 900) {
				powers900[chanal.intValue() - 1].setChanal(chanal.intValue());
	            if (polar.equals("C"))
	                powers900[chanal.intValue() - 1].setCross(power.intValue());
	            else
	                powers900[chanal.intValue() - 1].setVertical(power.intValue());
			} else {
				powers1800[chanal.intValue() - 1].setChanal(chanal.intValue());
	            if (polar.equals("C"))
	                powers1800[chanal.intValue() - 1].setCross(power.intValue());
	            else
	                powers1800[chanal.intValue() - 1].setVertical(power.intValue());
			}
		}
        f.setChanalPower900(powers900);
        f.setChanalPower1800(powers1800);

		StringBuffer sqlChanalPowerPermit = new StringBuffer("SELECT ");
		sqlChanalPowerPermit.append(" startnumber, endnumber, polarization, band ");
		sqlChanalPowerPermit.append(" FROM ");
		sqlChanalPowerPermit.append(" 	chanalpowerpermit ");
		sqlChanalPowerPermit.append(" WHERE ");
		sqlChanalPowerPermit.append(" 	equipment = ? ");
		sqlChanalPowerPermit.append(" ORDER BY startnumber ");
		rs = new com.hps.july.cdbc.lib.CDBCResultSet();
		rs.executeQuery(sqlChanalPowerPermit.toString(), new Object[] { new Integer(basestation) });
		iterator = rs.listIterator();
		ArrayList r900 = new ArrayList();
		ArrayList r1800 = new ArrayList();		
		while (iterator.hasNext()) {
			com.hps.july.cdbc.lib.CDBCRowObject row = (com.hps.july.cdbc.lib.CDBCRowObject)iterator.next();
			RangeAllow ra = new RangeAllow();
			Integer startNumber = (Integer)row.getColumn("startnumber").asObject();
			Integer endNumber = (Integer)row.getColumn("endnumber").asObject();
			String polar = row.getColumn("polarization").asString();
			Integer band = (Integer)row.getColumn("band").asObject();
			ra.setStartnumber(startNumber);
			ra.setEndnumber(endNumber);
			ra.setPolar(polar);
			ra.setBand(band);
			System.out.println("st=" + startNumber + "; en=" + endNumber + "; band=" + band);
			if(band.intValue() == 900) {
				r900.add(ra);				
			} else {
				r1800.add(ra);				
			}
		}
		f.setR900(r900);
		f.setR1800(r1800);
		
		System.out.println("f.range=" + r900.size() + "; f.range1800=" + r1800.size() );

/*
        //Enumeration enum = bsab.getChanalPowers();
        ChanalPowerAccessBean chanalBean = new ChanalPowerAccessBean();
        Enumeration enum = chanalBean.findChanalPowersByBasestation(new StoragePlaceKey(basestation));
        HashMap map = new HashMap();
        while (enum.hasMoreElements()) {
            ChanalPowerAccessBean power = (ChanalPowerAccessBean)enum.nextElement();
            int chanal = power.getChanal();
            String polar = power.getPolarization();
            int cPower = power.getPower();
            ChanalPowers powers = (ChanalPowers) map.get(new Integer(chanal));
            if (powers == null) {
                powers = new ChanalPowers();
                powers.setChanal(chanal);
                map.put(new Integer(chanal), powers);
            }
            if (polar.equals("C"))
                powers.setCross(cPower);
            else
                powers.setVertical(cPower);
        }
        Object[] tempPowers = map.values().toArray();
        Arrays.sort(tempPowers);
        ChanalPowers[] powers = new ChanalPowers[124];
        for (int i = 0; i < tempPowers.length; i++) { //Вставляю те что есть
            ChanalPowers pow = (ChanalPowers) tempPowers[i];
            int chanal = pow.getChanal();
            try {
                powers[chanal - 1] = pow;
            } catch (Exception ex) {
            }
        }
        for (int i = 0; i < powers.length; i++) { //Вставляю пустые в нужные места
            Object temp = powers[i];
            if (temp == null)
                powers[i] = new ChanalPowers(i + 1);
        }
        f.setChanalPower(powers);
*/        

    } catch (Exception e) {
        System.out.println("Error in ShowChanalPowerAction.fillForm");
        e.printStackTrace(System.out);
        throw e;
    }
    return null;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

	super.perform(mapping, form, request, response);    

	try{
		fillForm(form, request);
		 
		ParamsParser.setState(request, Applications.BASESTATION, APPStates.VIEWCHANALPOWERS);
	    return mapping.findForward("main");
	}catch(Exception e){
		e.printStackTrace(System.out);
		ActionErrors errors = new ActionErrors();
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("chanalpower.error.edit"));		
		saveErrors(request, errors);
		
		ParamsParser.setState(request, Applications.BASESTATION, APPStates.SECT_EDIT);
	    return mapping.findForward("main");
	}
}
}
