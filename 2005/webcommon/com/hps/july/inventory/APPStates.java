package com.hps.july.inventory;

/**
 * Констатны идентификаторов форм модуля "Учёт оборудования"
 * Creation date: (16.01.2002)
 * @author: Administrator
 */
public interface APPStates {
	// Внутренняя расходная накладная
	int IORLIST = 1;
	int EDITIOR = 2;
	int EDITIORST = 3;
	int IORPLIST = 4;
	int EDITIORP = 5;
	int IORPRINT = 6;

	// Внутренний приходный ордер
	int IOLIST = 10;
	int EDITIO = 11;
	int EDITIOST = 12;
	int IODLIST = 13;
	int EDITIOD = 14;
	int DOCLOOKUP = 15;
	int IOPLIST = 16;
	int EDITIOP = 17;
	int IOPRINT = 18;

	// Внешний приходный ордер
	int EOLIST = 20;
	int EDITEO = 21;
	int EDITEOST = 22;
	int EOSLIST = 23;
	int EDITEOS = 24;
	int EOPLIST = 25;
	int EDITEOP = 26;
	int EOPRINT = 27;

	// Требования
	int REQLIST = 30;
	int EDITREQ = 31;
	int EDITREQST = 32;
	int REQPLIST = 33;
	int EDITREQP = 34;

	// Install Acts
	int IALIST = 40;
	int EDITIA = 41;
	int EDITIAS = 42;
	int IAPLIST = 43;
	int EDITIAP = 44;
	int PRINTIA = 45;

	// Install Block Acts
	int IABLIST = 50;
	int EDITIAB = 51;
	int EDITIABS = 52;
	int IABPLIST = 53;
	int EDITIABP = 54;
	int PRINTIAB = 55;

	// Deinstall Acts
	int DIALIST = 60;
	int EDITDIA = 61;
	int EDITDIAS = 62;
	int DIAPLIST = 63;
	int EDITDIAP = 64;
	int PRINTDIA = 65;

	// Deinstall Block Acts
	int DIABLIST = 70;
	int EDITDIAB = 71;
	int EDITDIABS = 72;
	int DIABPLIST = 73;
	int EDITDIABP = 74;
	int PRINTDIAB = 75;

	// Акты рассогласования
	int MISLIST = 80;
	int EDITMIS = 81;

	// Акты инвентаризации на складе
	int IVALIST = 90;
	int EDITIVA = 91;
	int EDITIVAS = 92;
	int IVAPLIST = 93;
	int EDITIVAP = 94;
	int IVAPRINT = 95;

	// Отчёты
	int RPT1PARAMS = 100;
	int RPT1 = 101;
	int RPT2PARAMS = 102;
	int RPT2 = 103;
	int RPT3PARAMS = 104;
	int RPT3 = 105;
	int RPT4PARAMS = 106;
	int RPT4 = 118;
	int RPT4_1 = 107;
	int RPT4_2 = 108;
	int RPT5PARAMS = 109;
	int RPT5 = 110;
	int RPT6PARAMS = 111;
	int RPT6 = 119;
	int RPT6_1 = 112;
	int RPT6_2 = 113;
	int RPT7PARAMS = 114;
	int RPT7 = 115;
	int RPT1RTLOOKUP = 116;
	int RPT1RSTLOOKUP = 117;
	int RPT8 = 120;
	int RPT8PARAMS = 121;
	int RPT9 = 122;
	int RPT9PARAMS = 123;
	int RHIST = 124;
	int RHISTPARAMS = 125;
	int RPTXLS = 126;
	int RPT91 = 127;
	int RPT91PARAMS = 128;
	
	int MASSCALCPARAMS = 150;
	int MASSCALC = 151;
	int MASSRPT = 152;

	int MASSDOCPARAMS	=	160;
	int MASSDOC		=	161;

	int MAIN = 1000;
	int LOGIN = 1001;
	int LOGOUT = 1002;

	// Формы выбора
	int WRKLOOKUP = 200;
	int EQUIPLOOKUP = 201;
	int ORGLOOKUP = 202;
	int STORLOOKUP = 203;
	int COMPLOOKUP = 204;
	int RTPLOOKUP = 205;
	int RSTPLOOKUP = 206;
	int DIVLOOKUP = 207;
	int AGRLOOKUP = 208;
	int RESLOOKUP = 209;
	int CONTRAGLOOKUP = 210;
	int CONTLOOKUP = 211;
	int EQSETLOOKUP = 212;
	int POSLOOKUP = 213;
	int EQPOSLOOKUP = 214;
	int EXPLOOKUP = 215;
	int REQLOOKUP = 216;
	int RENTLOOKUP = 217;
	int RESSETLOOKUP = 218;
	int SERLOOKUP = 219;
	int PARTLOOKUP = 220;
	int IRSLOOKUP = 221;
	int EQUIPPLOOKUP = 222;
	int EQUIPELOOKUP = 223;
	int BSSETLOOKUP = 224;
	int RESLOOKUPSER = 225;

	// Акты инвентаризации на позиции
	int INVLIST = 301;
	int EDITINV = 302;
	int EDITINVS = 303;
	int INVPLIST = 304;
	int EDITINVP = 305;
	int INVPRINT = 306;
	int EDITEOM = 307;

	int IRSLIST = 310;
	int EDITIRS = 311;
	int IRASLIST = 312;
	int EDITIRAS = 313;
	
	int CONTRLIST = 314;
	int EDITCONTR = 315;
	int CONTRLOADXLS = 316;
	int CONTR_EQ_LIST = 317;
	
	// Внешняя расходная накладная
	int EORLIST = 320;
	int EDITEOR = 321;
	int EDITEORST = 322;
	int EORPLIST = 323;
	int EDITEORP = 324;
	int EORPRINT = 325;

	int CHELIST = 330;
	int EDITCHE = 331;
	int EDITCHEST = 332;
	int CHEPLIST = 333;
	int EDITCHEP = 334;

	int CHPLIST = 340;
	int EDITCHP = 341;
	int EDITCHPST = 342;
	int CHPPLIST = 343;
	int EDITCHPP = 344;

	int CHSLIST = 350;
	int EDITCHS = 351;
	int EDITCHSST = 352;
	int CHSPLIST = 353;
	int EDITCHSP = 354;

	// Акты монтажа на позиции
	int ASPLIST = 360;
	int EDITASP = 361;
	int ASPPLIST = 362;
	int EDITASPP = 363;
	int EDITASPST = 364;
	int EDITASPPU = 365;
	int ASPLOADXLS = 366;

	// Акты демонтажа на позиции
	int DIPLIST = 370;
	int EDITDIP = 371;
	int DIPPLIST = 372;
	int EDITDIPP = 373;
	int EDITDIPST = 374;

	int ASSBLIST = 380;
	int EDITASSB = 381;
	int ASSBPLIST = 382;
	int EDITASSBP = 383;
	int EDITASSBST = 384;

	int DASSBLIST = 390;
	int EDITDASSB = 391;
	int DASSBPLIST = 392;
	int EDITDASSBP = 393;
	int EDITDASSBST = 394;

	int POLIST = 420;
	int EDITPO = 421;
	int POPLIST = 422;
	int EDITPOP = 423;
	int EDITPOST = 424;

	int FLTLIST = 430;
	int EDITFLT = 431;
	int EDITFLTST = 432;

	// Акты монтажа и демонтажа блоков

	int ASSLIST = 400;
	int EDITASS = 401;
	int ASSPLIST = 402;
	int EDITASSP = 403;
	int DASSLIST = 404;
	int EDITDASS = 405;
	int DASSPLIST = 406;
	int EDITDASSP = 407;
	int EDITASSST = 408;
	int EDITDASSST = 409;
	int STCLOOKUP = 410;

	int AFSLIST = 411;
	int EDITAFS = 412;
	int AFSPOSLIST = 413;
	int EDITAFSPOSG = 414;
	int EDITAFSPOSA = 415;
	int EDITAFSPOS = 416;
	int AFSSTATE = 417;

	int CRDSLOOKUP = 500;
	int CRDPLOOKUP = 501;
	int CRDLOOKUP = 502;
	int CRDRLOOKUP = 503;

	int BARLIST = 600;
	int EDITBAR = 601;
	int BARPARAMS = 602;
	int BARPRINT = 603;
	int SERPARAMS = 604;
	int SERPRINT = 605;
	int BARLOOKUP = 606;

	int INVACTLOADEXCEL = 701;
	int INVLOADEXCEL = 702;
	int EOLOADEXCEL = 703;
	int IOLOADEXCEL = 704;
	int IORLOADEXCEL = 705;
	int INVLOADINV = 706;

	int INVFILLFDB = 801;
	int IVAFILLFDB = 802;

	int DISM_FFDB = 803;

	int MOUNTEDIT2 = 804;
	int MOUNTEDIT3 = 805;
	int AFSEDIT21 = 806;
	int AFSEDIT22 = 807;
	int AFSINDOOR = 808;
	int EDITAFSDPOS = 809;
	int MOUNT_ACT2 = 810;

	// Акты инвентаризации у сотрудника/подрядчика
	int WRKINVLIST = 900;
	int WRKINVFORM = 901;
	int WRKINVPOS = 902;
	int WRKINVFILLDB = 903;

	int DOCSBYCOMPROJLIST = 904;
	
	int MOUNT_ACT2_FORM = 905;
	
	// конфигурация оборудования
	// int CONF_EQ_LIST = 910;
	int CONF_EQ_FORM = 920;
	int CONF_EQ_FORM_STANDS_TITLE = 930;
	int CONF_EQ_FORM_STANDS_CONTENT = 935;
	int CONF_EQ_FORM_ANTENNS_TITLE = 940;
	int CONF_EQ_FORM_ANTENNS_CONTENT = 945;
	
	int CONFIG_EQUIPMENT_FORM = 950;
}
