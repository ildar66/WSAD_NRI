package com.hps.july.basestation;

/**
 * Константы идентификаторов состояний модуля "Характеристики оборудования"
 */
public interface APPStates {
	int EDIT=1000;
	int COPY=1001;    
	
	int MAIN = 1;
    int LOGIN = 2;
    int LOGOUT = 3; 

    int BS_LIST = 10;
    int BS_PVIEW = 11;
    int BS_FVIEW = 12;
    int BS_GSM = 13;
    int BS_DIALOG = 14;
    int CNTRLOOKUP = 21;
    int SWCHLOOKUP = 22;
    int POSLOOKUP = 24;
    int BS_EQ_LIST = 25;

    int MAPINFO = 26;
    int POSITIONSONMAP = 27;
    int EDITPOSMAP = 28;
    int ANT_RES_LOOKUP = 29;
    //int ANT_EDIT = 30;
    //int SECT_EDIT = 31;
    int RESTYPE_LOOKUP = 32;
    int RESSUBTYPE_LOOKUP = 33;
    int ANTENNES_CHOICE = 34;
    int EDITEQU = 35; //EquipmentForm
    int EQULIST = 36; //ShowBsEuipmentList
    int EQDETLIST = 37; //ShowEquipdetList

    int IMPORTXLS = 38; //Импорт файла xls
    int VIEWCHANALPOWERS = 39;
    //Просмотр ограничения максимальной мощности по каналам
    int XLSLOADRESULT = 40; //Просмотр результатов загрузки
    int XLSLOADEXTENDEDRESULT = 41; //Расширенный просмотр результатов загрузки
    int XLSLOADJOURNAL = 42; //Просмотр журнала загрузки ограничений мощности	

    int EQSDETLIST = 43; //ShowEquipsdetList
    int LOADRESULTS = 44; //Просмотр журналов загрузки
    int EXPORTFILE = 45;    

    int BS_PEdit = 50;
    int BS_FEdit = 51;
    int ANT_EDIT = 52;
    int ANT_COPY = 521;
    int SECT_EDIT = 53;
    int SECT_COPY = 531;
    int IMPORTXLS_BS = 54; //Импорт файла xls

    int SwitchListForm = 60;
    int SwitchForm = 61;

    int CONTROLLER_LIST = 70;
    int CONTROLLER_EDIT = 71;
    int CONTROLLER_DESC_EDIT = 72;
    int CONTROLLER_DESC_VIEW = 721;
    int CONTROLLER_PARAMS = 73;
    int CONTROLLER_CONNECTED_BS = 74;
    int CONTROLLER_DIALOG = 75;

    int REGLAMENT_WORKS_DIALOG = 76;
 
    int SWCH_EDIT = 80;
    int SWCH_VIEW = 801;
    int SWCH_PARAMS_EDIT = 81;
    int SWCH_CONNECTED_CONTR = 82;

    int ComlineListForm = 90;
    int ComlinePositionListForm = 93;
    int ComlineRForm = 91;
    int COMEQU_LOOKUP = 92;

    int REPEATER_LIST = 100;
    int FROMSECTOR_REPEATER_LIST = 101;
    int REPEATER_EDIT = 102;
    int FROMSECTOR_REPEATER_EDIT = 103;
    int REPEATER_ANTENNA_EDIT = 104;
    int FROMSECTOR_REPEATER_ANTENNA_EDIT = 105;
    int REPEATER_DIALOG = 106;

    int ANTENNA_LOOKUP = 110;
    int REPEATERRES_LOOKUP = 111;
    int ORG_LOOKUP = 112;
    int EQUIPDETLIST_DIALOG_FORM = 113;

    int SwitchControllerForm = 120;

    int BS_LOOKUP = 200;
    int BSSECTOR_LOOKUP = 201;
    int BSANTENNA_LOOKUP = 202;
    int SECTOR_LIST_DIALOG_FORM = 203;
    int SECTOR_DIALOG_FORM = 204;

    int GKRCH_LIST = 300;
    int GKRCH_FORM = 301;
    int GKRCH_FILE = 302;
	int REGIONS_LOOKUP = 303;
	int RRL_LIST = 305;
    int RRL_FORM = 306;
    int RRL_FILE = 307;

    int FREQLICENCE_LIST = 310;
    int FREQLICENCE_FORM = 311;
    int ETAPTYPE_LIST	= 312;
    int ETAPTYPE_FORM	= 313;
    int FREQLICENCE_HIST = 314;
    int COMLINE_LOOKUP = 315;
    int ETAP_FORM = 316;
    int FREQLICENCE_POS_LIST = 317;

    int SITEDOC_FILE = 399;
    int DOCFILES_LIST = 398;

    int REPORT_HAVEPLAN_LOOKUP = 400;
	int REPORT_HAVEPLAN_SHOW = 401;

	int SFO_PROTOCOL = 402;

	int KZL_INDEX_DIALOG_FORM = 500;

	int IMPORTXLSSTEP2 = 600; //Импорт файла xls

}
