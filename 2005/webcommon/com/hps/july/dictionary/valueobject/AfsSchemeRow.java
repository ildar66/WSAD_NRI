/*
 * Created on 05.04.2007
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
public class AfsSchemeRow {
	private String schemeid;
	private String numscheme;
	private String sectcount900;
	private String sectcount1800;
	private String antX2;
	private String antX4;
	private String antV1;
	private String antV2;
	private String dbc1;
	private String dbc2;
	private String df1;
	private String df2;
	private String tma;
	private String jo;
	private String ji;
	private String con;
	private String notes;
	
	public AfsSchemeRow(CDBCRowObject row){
		if (row.hasColumn("schemeid")) setSchemeid(row.getColumn("schemeid").asString());
		if (row.hasColumn("numscheme")) setNumscheme(row.getColumn("numscheme").asString());
		if (row.hasColumn("sectcount900")) setSectcount900(row.getColumn("sectcount900").asString());
		if (row.hasColumn("sectcount1800")) setSectcount1800(row.getColumn("sectcount1800").asString());
		if (row.hasColumn("antx2")) setAntX2(row.getColumn("antx2").asString());
		if (row.hasColumn("antx4")) setAntX4(row.getColumn("antx4").asString());
		if (row.hasColumn("antv1")) setAntV1(row.getColumn("antv1").asString());
		if (row.hasColumn("antv2")) setAntV2(row.getColumn("antv2").asString());
		if (row.hasColumn("dbc1")) setDbc1(row.getColumn("dbc1").asString());
		if (row.hasColumn("dbc2")) setDbc2(row.getColumn("dbc2").asString());
		if (row.hasColumn("df1")) setDf1(row.getColumn("df1").asString());
		if (row.hasColumn("df2")) setDf2(row.getColumn("df2").asString());
		if (row.hasColumn("tma")) setTma(row.getColumn("tma").asString());
		if (row.hasColumn("jo")) setJo(row.getColumn("jo").asString());
		if (row.hasColumn("ji")) setJi(row.getColumn("ji").asString());
		if (row.hasColumn("con")) setCon(row.getColumn("con").asString());
		if (row.hasColumn("notes")) setNotes(row.getColumn("notes").asString());		
	}
	public String getSchemeid(){return schemeid;}
	public String getNumscheme(){return numscheme;}
	public String getSectcount900(){return sectcount900;}
	public String getSectcount1800(){return sectcount1800;}
	public String getAntX2(){return antX2;}
	public String getAntX4(){return antX4;}
	public String getAntV1(){return antV1;}
	public String getAntV2(){return antV2;}
	public String getDbc1(){return dbc1;}
	public String getDbc2(){return dbc2;}
	public String getDf1(){return df1;}
	public String getDf2(){return df2;}
	public String getTma(){return tma;}
	public String getJo(){return jo;}
	public String getJi(){return ji;}
	public String getCon(){return con;}
	public String getNotes(){return notes;}
		
	public void setSchemeid(String newSchemeid){schemeid = newSchemeid;}
	public void setNumscheme(String newNumscheme){numscheme = newNumscheme;}
	public void setSectcount900(String newSectcount900){sectcount900 = newSectcount900;}
	public void setSectcount1800(String newSectcount1800){sectcount1800 = newSectcount1800;}
	public void setAntX2(String newAntx2){antX2 = newAntx2;}
	public void setAntX4(String newAntx4){antX4 = newAntx4;}
	public void setAntV1(String newAntv1){antV1 = newAntv1;}
	public void setAntV2(String newAntv2){antV2 = newAntv2;}
	public void setDbc1(String newDbc1){dbc1 = newDbc1;}
	public void setDbc2(String newDbc2){dbc2 = newDbc2;}
	public void setDf1(String newDf1){df1 = newDf1;}
	public void setDf2(String newDf2){df2 = newDf2;}
	public void setTma(String newTma){tma = newTma;}
	public void setJo(String newJo){jo = newJo;}
	public void setJi(String newJi){ji = newJi;}
	public void setCon(String newCon){con = newCon;}
	public void setNotes(String newNotes){notes = newNotes;}
}

