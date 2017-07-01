/*
 * Created on 19.12.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.valueobject;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCResourcesObject;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DonorUnitRow {
	private String checked; //???
	private String resource;
	private String model;
	private String power;
	private String workband;
	private String linkband;
	private String gainfactor;
	private String voltageid;
	private String usedpower;
	private String entriescount;
	private String antgatescount;
	private String signaldelay;
	private String noisefactor;
	
	public DonorUnitRow(CDBCRowObject newRow, String isChecked){
		if (newRow.hasColumn("resource")) setResource(newRow.getColumn("resource").asString());
		if (newRow.hasColumn("model")) setModel(newRow.getColumn("model").asString());
		if (newRow.hasColumn("power")) setPower(newRow.getColumn("power").asString());
		if (newRow.hasColumn("workband")) setWorkband(newRow.getColumn("workband").asString());
		if (newRow.hasColumn("linkband")) setLinkband(newRow.getColumn("linkband").asString());
		if (newRow.hasColumn("gainfactor")) setGainfactor(newRow.getColumn("gainfactor").asString());
		if (newRow.hasColumn("voltageid")) setVoltageid(newRow.getColumn("voltageid").asString());
		if (newRow.hasColumn("usedpower")) setUsedpower(newRow.getColumn("usedpower").asString());
		if (newRow.hasColumn("entriescount")) setEntriescount(newRow.getColumn("entriescount").asString());
		if (newRow.hasColumn("antgatescount")) setAntgatescount(newRow.getColumn("antgatescount").asString());
		if (newRow.hasColumn("signaldelay")) setSignaldelay(newRow.getColumn("signaldelay").asString());
		if (newRow.hasColumn("noisefactor")) setNoisefactor(newRow.getColumn("noisefactor").asString());
		setChecked(isChecked);
	}
	
	private Boolean isLinkedDonorUnit(Integer repiterres){
		return new Boolean(CDBCResourcesObject.isLinkedRepeaterDU(repiterres,new Integer(Integer.parseInt(getResource()))));
	}
	
	//public Boolean getChecked(){return checked;}
	public String getChecked(){return checked;}
	public String getResource(){return resource;}
	public String getModel(){return model;}
	public String getPower(){return power;}
	public String getWorkband(){return workband;}
	public String getLinkband(){return linkband;}
	public String getGainfactor(){return gainfactor;}
	public String getVoltageid(){return voltageid;}
	public String getUsedpower(){return usedpower;}
	public String getEntriescount(){return entriescount;}
	public String getAntgatescount(){return antgatescount;}
	public String getSignaldelay(){return signaldelay;}
	public String getNoisefactor(){return noisefactor;}

//	public void setChecked(Boolean newChecked){ checked = newChecked; }
	public void setChecked(String newChecked){ checked = newChecked; }
	public void setResource(String newResource){ resource = newResource; }
	public void setModel(String newModel){ model = newModel; }
	public void setPower(String newPower){ power = newPower; }
	public void setWorkband(String newWorkband){ workband = newWorkband; }
	public void setLinkband(String newLinkband){ linkband = newLinkband; }
	public void setGainfactor(String newGainfactor){ gainfactor = newGainfactor; }
	public void setVoltageid(String newVoltageid){
		 voltageid = CDBCResourcesObject.findVoltagesByCode(newVoltageid); 
	}
	public void setUsedpower(String newUsedpower){ usedpower = newUsedpower; }
	public void setEntriescount(String newEntriescount){ entriescount = newEntriescount; }
	public void setAntgatescount(String newAntgatescount){ antgatescount = newAntgatescount; }
	public void setSignaldelay(String newSignaldelay){ signaldelay = newSignaldelay; }
	public void setNoisefactor(String newNoisefactor){ noisefactor = newNoisefactor; }
}
