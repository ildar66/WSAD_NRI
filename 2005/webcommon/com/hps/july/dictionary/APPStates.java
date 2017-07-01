package com.hps.july.dictionary;

/**
 * ��������� ��������������� ����
 */
public interface APPStates {
	int TAXLIST 		= 1;
	int EDITTAX 		= 2;
	int UNITLIST 		= 3;
	int EDITUNIT 		= 4;
	int RTPLIST 		= 5; 
	int EDITRTP 		= 6;
	int RSTPLIST 		= 7;
	int EDITRSTP		= 8;
	int RESLIST			= 9;
	int EDITRES			= 10;
	int EDITRES_WN	    = 112;	
	int TAXHLIST		= 11;
	int EDITTAXH		= 12;
	int CRNCLIST		= 13;
	int EDITCRNC		= 14;
	int CRTHLIST		= 15;
	int EDITCRTH		= 16;
	int RATPLIST		= 17;
	int EDITRATP		= 18;
	int CRTLIST			= 19;
	int EDITCRT			= 20;
	int SYSCLIST		= 21;
	int EDITSYSC		= 22;
	int MAIN			= 23;
	int LOGIN			= 24;
	int LOGOUT			= 25;
	int RSTPLOOKUP		= 26;
	int RTPLOOKUP		= 27;
	int CRNCLOOKUP		= 28;
	int RATPLOOKUP		= 29;
	int EDITDBL			= 30;
	int UNITLOOKUP		= 31;
	int RESLOOKUP		= 32;
	int CPFLIST			= 33;
	int EDITCPF			= 34;
	int CPLIST			= 35;
	int EDITCP			= 36;
	int CPCLIST			= 37;
	int EDITCPC			= 38;
	int ORGLISTM		= 39;
	int EDITORGM		= 40;
	int COMPLIST 		= 41;
	int COMPLOOKUP 		= 42;
	int ORGLISTC		= 45;
	int EDITORGC		= 46;
	int BANKLIST		= 47;
	int EDITBANK		= 48;
	int ACCLIST			= 49;
	int EDITACC			= 50;
	int ACCLISTC		= 51;
	int EDITACCC		= 52;
	int BANKLOOKUP		= 53;
	int GRPLIST			= 54;
	int EDITGRP			= 55;
	int GRPLOOKUP		= 56;
	int GRPPLIST		= 57;
	int EDITGRPP		= 58;
	int GRPPLOOKUP		= 59;
	int ORGGLIST		= 60;
	int EDITORGG		= 61;
	int ORGGCLIST		= 62;
	int EDITORGGC		= 63;
	int GRPOLIST		= 64;
	int EDITGRPO		= 65;
	int ORGLOOKUP		= 66;
	int STRGLIST		= 67;
	int EDITSTRG		= 68;
	int DEPLOOKUP		= 69;
	int DGRPLOOKUP		= 70;
	int DIRLOOKUP		= 71;
	int SERVLOOKUP		= 72;
	int CPFCLIST		= 74;
	int EDITCPFC		= 75;
	int ORGMULTI		= 76;
	int AERLIST			= 77;
	int	EDITAERLIST		= 78;
	int CABLIST			= 79;
	int EDITCABLIST		= 80;
	int BSTATLIST		= 81;
	int EDITBSTATLIST	= 82;
	int MAIN_RES		= 83;

	int ANTENA_LIST		= 84;
	int ANTENA_EDIT		= 85;
	int CABLE_LIST		= 86;
	int CABLE_EDIT		= 87;
	int BASESTATION_LIST= 88;
	int BASESTATION_EDIT= 89;

	int CHORTYPE		= 90;
	int CHORTYPE_WN		= 107;

	int ANTENA_RES_EDIT		= 91;
	int ANTENA_RES_EDIT_WN	= 109;
	
	int CABLE_RES_EDIT		= 92;
	int CABLE_RES_EDIT_WN		= 111;
	
	int BASESTATION_RES_EDIT= 93;
	int BASESTATION_RES_EDIT_WN= 108;

	int CARS_LIST			= 94;
	int CAR_EDIT			= 95;

	int ORGWLIST		= 96;
	int EDITORGW		= 97;
	int REPEATER_LIST   = 98;
	int REPEATER_EDIT   = 99;
	
	int REPEATER_RES_EDIT = 100;
	int REPEATER_RES_EDIT_WN = 110;
	
	int RRLANTRESOURCE_LIST   = 101;
	int RRLANTRESOURCE_EDIT   = 102;
	int RRLANTRESOURCE_PARAM_EDIT = 103;
	int RRLANTRESOURCE_SPEEDPARAM_EDIT = 104;
	
	int INVRESOURCE_LIST   = 105;
	
	int INVRESOURCE_LIST_WN = 106;

	int PERSON_LIST = 113;
	int PERSON_DIALOG = 114;
	int PERSON_LOOKUP_LIST = 115;
	
	int ORGANIZATION_DIALOG = 116;
	int ACCOUNT_DIALOG = 117;
	
	int REGION_LIST = 118;
	int REGION_DIALOG = 119;
	int REGION_LOOKUP_LIST = 120;
	
	int NFSRES2NRIRES = 121;
	
	int BANKS_LIST = 122;
	int BANKS_DIALOG = 123;
	int BANKS_LOOKUP_LIST = 124;
	
	int VENDOR_LIST = 125;
	int VENDOR_DIALOG = 126;
	int VENDOR_LOOKUP_LIST = 127;
	
	int VENDOR_SITE_LIST = 128;
	int VENDOR_SITE_DIALOG = 129;
	int VENDOR_SITE_LOOKUP_LIST = 130;
	
	int ACCOUNTS_LIST = 131;
	int ACCOUNTS_DIALOG = 132;
	int ACCOUNTS_LOOKUP_LIST = 133;
	
	int VENDOR_ADMIN_LIST = 134;
	int VENDOR_ADMIN_DIALOG = 135;
	
	int VENDOR_SITE_ADMIN_LIST = 136;
	int VENDOR_SITE_ADMIN_DIALOG = 137;

	int CONF_POWER_SOURCES_LIST = 142;
	int CONF_POWER_SOURCES_CUR_COMPLECT_LIST = 143;
	int CONF_POWER_SOURCES_STRUCT_CUR_COMPLECT_LIST = 144;
	int NFS_RES_LOOKUP = 145;
	int CONF_POWER_SOURCES_FORM = 146;
	int EDIT_POWER_RESOURCE_FORM = 147;
	int NRI_RES_LOOKUP = 148;
	
	int DONOR_UNIT_LIST = 149;
	int EDIT_DONOR_UNIT = 150;

	int RESOURCEGROUP_LIST = 151;
	int EDIT_RESOURCEGROUP = 152;	
	
	int DONORUNIT_RES_EDIT = 153;
	int DONORUNIT_RES_EDIT_WN = 154;

	int CONF_BASE_STATION_LIST = 160;
	int BASE_STATION_CONF_FORM = 161;
	
	int RESANTENNA_LIST = 162;
	int EDIT_RESANTENNA = 163;	
	
	int RESGROUPCONTENTS_LIST = 164;
	
	int CONF_CONNECTOR_CABLE_COMPAT_LIST = 165;
	int CONF_CONNECTOR_CABLE_COMPAT_LIST_REFRESH = 166;

	//������� �������������
	int USERREQUEST_LIST = 167;
	int EDIT_USERREQUEST = 168;
	
	int PEOPLELOOKUP = 169;
	
	int TRANCEIVER_LIST = 170;
	int EDIT_TRANCEIVER = 171;
	
	int RESCLASS_LIST = 172;
	int EDIT_RESCLASS = 173;
	int EDIT_RESSETCLASS = 174;
	
	int COMMONRES_LIST = 175;
	int EDIT_COMMONRES = 176;
	
	int EDIT_ACCUMBATTERY = 177;
	
	int AFSSCHEME_LIST = 178;
	int EDIT_AFSSCHEME = 179;
	
	int EQUIPMANUF_LIST = 180;
	int EDIT_EQUIPMANUF	= 181;
	int MANUFLOOKUP		= 182;
	
	int RESOURCEREPORT	= 183;
	
	int RESGROUPLOOKUP	= 184;
}
