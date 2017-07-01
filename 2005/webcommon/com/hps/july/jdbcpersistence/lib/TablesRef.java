package com.hps.july.jdbcpersistence.lib;

/**
 *  онстанты имен последовательностей дл€ автогенерации серийных ключей.
 * Creation date: (21.11.2002 20:34:05)
 * @author: Administrator
 */
public interface TablesRef {

	String SECTORS = "tables.sectors";
	String ANTENNES = "tables.antennes";
	String PIE_QUERY = "tables.pie_query";
	String PIE_QUERY_LOG = "tables.pie_query_log";
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

	String SUPERREGIONS = "tables.superregions";
	String REGIONS = "tables.regions";

	String STORAGEPLACES = "tables.storageplaces";
	String BASESTATIONS = STORAGEPLACES;
	String POSITIONS = STORAGEPLACES;
	String SWITCHES = STORAGEPLACES;
	String CONTROLLERS = STORAGEPLACES;

	String CHANALPOWERS = "tables.chanalpowers";
	String IMPORTRECORDS = "tables.importrecords";
	String IMPORTSESSIONS = "tables.importsessions";

	String SITEDOCS = "tables.sitedocs";
	String SITEDOCFILES = "tables.sitedocfiles";
	String SITEDOCTYPES = "tables.sitedoctypes";
	String SITEDOCS_SPLACE = "tables.sitedocs2splace";

	String HOPS = "tables.hops";
	String HOPSLABEL = "tables.hopslabel";
	String ADMIN_REGIONS = "tables.adminRegions";
	String BANKS = "tables.banks";
	String VENDORS = "tables.vendors";
	String VENDORSITES = "tables.vendorsites";
	String ACCOUNTS = "tables.accounts";
}
