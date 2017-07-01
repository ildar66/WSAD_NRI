/*
 * Created on 28.02.2007
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
public class TranceiverVO {
	Integer resource;
	Integer band;
	Boolean doubletrx;
	
	public TranceiverVO(CDBCRowObject row){
		if (row.hasColumn("resource")) 
			setResource(new Integer(Integer.parseInt(row.getColumn("resource").asString())));
		if (row.hasColumn("band"));
			setBand(new Integer(Integer.parseInt(row.getColumn("band").asString())));
		if (row.hasColumn("doubletrx")){
			String dtrx = row.getColumn("doubletrx").asString();
			switch (dtrx.charAt(0)){
				case 'Y': doubletrx = new Boolean(true); break;
				case 'N': doubletrx = new Boolean(false); break;
			}
		}
	}
	
	public Integer getResource(){ return resource; }
	public Integer getBand(){ return band; }
	public Boolean getDoubletrx(){ return doubletrx; }
	
	public void setResource(Integer newResource){ resource = newResource; }
	public void setBand(Integer newBand){ band = newBand; }
	public void setDoubletrx(Boolean newDoubletrx){ doubletrx = newDoubletrx; }
}
