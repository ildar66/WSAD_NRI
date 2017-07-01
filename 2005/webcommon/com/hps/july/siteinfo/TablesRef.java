package com.hps.july.siteinfo;

/**
 * Константы с названиями таблиц БД
 * Creation date: (21.11.2002 20:34:05)
 * @author: Administrator
 */
public interface TablesRef {
    String PIE_QUERY = "tables.pie_query";
    String PIE_QUERY_LOG = "table.pie_query_log";
    String PIE_DOGOVORS_NRI = "tables.pie_dogovors_nri";
    String ORGANIZATION = "tables.organizations";
    String PIE_PAYS_NRI = "tables.pie_paysnri";
    String LEASEDOCPOSITION = "tables.leasedocpositions";
    String DOPINFOLPAYMENTS = "tables.dopinfolpayments";

    String PROTOACTIONS_PK = "table.protoactions";
    String PROTOACTIONS_ORDER = "table.protoactions.order";
    String PROJECTS = "table.projects";
    String PROJECTACTIONS = "table.projectactions";
    String PROJECTSTATES = "table.projectstates";
    String PROJACTIONDOCS = "table.projactiondocs";

    String SUPERREGIONS="tables.superregions";
    String REGIONS="tables.regions";
	String CONTTABLENAME = "tables.containers";

	String COUNTERS = "tables.counters";
	String COUNTERS_INFO = "tables.counters_info";
	
}
