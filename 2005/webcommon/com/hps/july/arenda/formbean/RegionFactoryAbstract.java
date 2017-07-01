/*
 * Created on 12.04.2007
 *
 * Factory for Region
 */
package com.hps.july.arenda.formbean;

/**
 * @author IShaffigulin
 *
 * Factory for Region
 */
public abstract class RegionFactoryAbstract {
	//public final static int REGION_KAZAHSTAN = 91;//OLD
	public final static int REGION_ALMAATA = 91; //������
	public final static int REGION_ASTANINSK = 95; //95		�����������
	public final static int REGION_ACTUBINSK = 96; //96		�����������         
	public final static int REGION_ATYRAUSK = 97; //97		����������      
	public final static int REGION_EAST_KAZAHSTAN = 98; //98		��������-�������������       
	public final static int REGION_JAMBYRSKY = 99; //99		����������     
	public final static int REGION_WEST_KAZAHSTAN = 100; //100		�������-�������������
	public final static int REGION_KARAGANDA = 101; //101		��������������  
	public final static int REGION_KOSTANAY = 102; //102		������������
	public final static int REGION_KYZYLORDA = 103; //103		��������������     
	public final static int REGION_MANGISTAY = 104; //104		�������������  
	public final static int REGION_PAVLODAR = 105; //105		������������                  
	public final static int REGION_NORD_KAZAHSTAN = 106; //106		������-�������������      
	public final static int REGION_SOUTH_KAZAHSTAN = 107; //107		����-�������������                   

	/**
	 * 
	 * @param regionID
	 * @return
	 */
	public static RegionFactoryAbstract getFactory(int regionID) {
		if (regionID == REGION_ALMAATA) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_ASTANINSK) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_ACTUBINSK) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_ATYRAUSK) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_EAST_KAZAHSTAN) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_JAMBYRSKY) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_WEST_KAZAHSTAN) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_KARAGANDA) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_KOSTANAY) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_KYZYLORDA) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_MANGISTAY) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_PAVLODAR) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_NORD_KAZAHSTAN) {
			return new RegionFactoryKazahstan();
		} else if (regionID == REGION_SOUTH_KAZAHSTAN) {
			return new RegionFactoryKazahstan();
		} else {
			return new RegionFactoryDefault();
		}
	}

	public abstract WeArandaFormView getWeArandaFormView();
	public abstract VendorFormView getVendorFormView();
}
