package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPResourceBean_5b81bc6d
 */
public class EJSJDBCPersisterCMPResourceBean_5b81bc6d extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderResourceBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO resources (resource, notes, actualcode, countpolicy, manucode, complectpart, active, complect, boxable, name, model, priceable, resourceclass2, groupid, manufid, disablenfscodes, resourcesubtype, unit, resourceclass) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM resources  WHERE resource = ?";
	private static final String _storeString = "UPDATE resources  SET notes = ?, actualcode = ?, countpolicy = ?, manucode = ?, complectpart = ?, active = ?, complect = ?, boxable = ?, name = ?, model = ?, priceable = ?, resourceclass2 = ?, groupid = ?, manufid = ?, disablenfscodes = ?, resourcesubtype = ?, unit = ?, resourceclass = ? WHERE resource = ?";
	private static final String _loadString = "(((((((((SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8 WHERE T8.resourceclass = \'R\' AND T8.resource = ?)  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, T3.generation, T3.height, T3.length, T3.modification, T3.productline, T3.standard, T3.width, T3.makeyear, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM basestationres  T3, resources  T8 WHERE T8.resource = T3.resource AND T8.resourceclass = \'B\' AND T8.resource = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), T2.anttype, T2.connector, T2.electricangle, T2.freqrange, T2.height, T2.ksvn, T2.length, T2.polarization, T2.weight, T2.width, T2.isomni, T2.entriescount, CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM antennares  T2, resources  T8 WHERE T8.resource = T2.resource AND T8.resourceclass = \'A\' AND T8.resource = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), T4.cablediamid, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM cableres  T4, resources  T8 WHERE T8.resource = T4.resource AND T8.resourceclass = \'K\' AND T8.resource = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T9.freqdevhighk, T9.freqdevhighlog10, T9.freqdevlowk, T9.freqdevlowlog10, T9.mkkrrecomm, T9.protocoldate, T9.protocolnum, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, rrlantennares  T9 WHERE T8.resource = T9.resource AND T8.resourceclass = \'L\' AND T8.resource = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), T7.bandwidth, T7.islinear, T7.numchanals, T7.reppower, T7.endbandwidth, T7.dimensions, T7.weight, T7.usedpower, T7.gainfactor, T7.signaldelay, T7.noisefactor, T7.workband, T7.linkband, T7.voltageid, T7.repitertype, T7.antentriescount, T7.downlinkband, T7.downlinkbandup, T7.isremotecontrol, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, repiterres  T7 WHERE T8.resource = T7.resource AND T8.resourceclass = \'P\' AND T8.resource = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), T5.needcwact, T5.useinarendacontract, T5.useinabonentcontract, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, leaseresources  T5 WHERE T8.resource = T5.resource AND T8.resourceclass = \'X\' AND T8.resource = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), T6.power, T6.workband, T6.linkband, T6.gainfactor, T6.voltageid, T6.usedpower, T6.entriescount, T6.antgatescount, T6.signaldelay, T6.noisefactor, CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM repdonorunitres  T6, resources  T8 WHERE T8.resource = T6.resource AND T8.resourceclass = \'D\' AND T8.resource = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), T10.band, T10.doubletrx, CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM trxres  T10, resources  T8 WHERE T8.resource = T10.resource AND T8.resourceclass = \'E\' AND T8.resource = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), T1.voltage, T1.capacity, T1.accutype, T1.accucount FROM accumres  T1, resources  T8 WHERE T8.resource = T1.resource AND T8.resourceclass = \'C\' AND T8.resource = ?) ";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPResourceBean_5b81bc6d
	 */
	public EJSJDBCPersisterCMPResourceBean_5b81bc6d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postInit
	 */
	public void postInit() {
	}
	/**
	 * _create
	 */
	public void _create(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ResourceBean b = (ResourceBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.notes == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.notes);
			}
			pstmt.setInt(3, b.actualcode);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.countpolicy);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.resource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.manucode);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.complectpart);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.active);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.complect);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.boxable);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.model);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.priceable);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			if (b.resourceclass2 == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.resourceclass2.intValue());
			}
			if (b.groupid == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.groupid.intValue());
			}
			if (b.manufid == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.manufid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.disablenfscodes);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			if (b.subtype_resourcesubtype == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.subtype_resourcesubtype.intValue());
			}
			if (b.unit_unit == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.unit_unit.intValue());
			}
			pstmt.setString(19, "R");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		ResourceBean b = (ResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = (com.hps.july.persistence.ResourceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.resource = _primaryKey.resource;
		b.notes = resultSet.getString(1);
		b.actualcode = resultSet.getInt(2);
		b.countpolicy = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.manucode = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.complectpart = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(6));
		b.active = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(7));
		b.complect = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(8));
		b.boxable = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(9));
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.model = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(11));
		b.priceable = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(12));
		tempint = resultSet.getInt(13);
		b.resourceclass2 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(14);
		b.groupid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		b.manufid = resultSet.wasNull() ? null : new Integer(tempint);
		b.disablenfscodes = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(16));
		tempint = resultSet.getInt(17);
		b.subtype_resourcesubtype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(18);
		b.unit_unit = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ResourceBean b = (ResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = (com.hps.july.persistence.ResourceKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.resource);
			pstmt.setInt(2, _primaryKey.resource);
			pstmt.setInt(3, _primaryKey.resource);
			pstmt.setInt(4, _primaryKey.resource);
			pstmt.setInt(5, _primaryKey.resource);
			pstmt.setInt(6, _primaryKey.resource);
			pstmt.setInt(7, _primaryKey.resource);
			pstmt.setInt(8, _primaryKey.resource);
			pstmt.setInt(9, _primaryKey.resource);
			pstmt.setInt(10, _primaryKey.resource);
			resultSet = pstmt.executeQuery();
			if (!(resultSet.next())) throw new javax.ejb.ObjectNotFoundException();
			hydrate(eb, resultSet, pKey);
		}
		finally {
			if (resultSet != null) resultSet.close();
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * refresh
	 */
	public void refresh(EntityBean eb, boolean forUpdate) throws Exception {
		ResourceBean b = (ResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = new com.hps.july.persistence.ResourceKey();
		_primaryKey.resource = b.resource;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ResourceBean b = (ResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = new com.hps.july.persistence.ResourceKey();
		_primaryKey.resource = b.resource;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(19, _primaryKey.resource);
			if (b.notes == null) {
				pstmt.setNull(1, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(1, b.notes);
			}
			pstmt.setInt(2, b.actualcode);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.countpolicy);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.manucode);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.complectpart);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.active);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.complect);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.boxable);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.model);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.priceable);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.resourceclass2 == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.resourceclass2.intValue());
			}
			if (b.groupid == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.groupid.intValue());
			}
			if (b.manufid == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.manufid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.disablenfscodes);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.subtype_resourcesubtype == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.subtype_resourcesubtype.intValue());
			}
			if (b.unit_unit == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.unit_unit.intValue());
			}
			pstmt.setString(18, "R");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * remove
	 */
	public void remove(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ResourceBean b = (ResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = new com.hps.july.persistence.ResourceKey();
		_primaryKey.resource = b.resource;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.resource);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence.ResourceKey key = new com.hps.july.persistence.ResourceKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.resource = resultSet.getInt(4);
			return key;
		}
return null;
	}
	/**
	 * getBean
	 */
	public javax.ejb.EJBObject getBean(Object obj) throws Exception {
		javax.ejb.EJBObject bean = null;
		ResultSet rs = (ResultSet) obj;
		java.lang.String discriminator = rs.getString(19).trim();
		if ( discriminator.equals("R") ) {
			bean = super.getBean(obj);
		}
		else {
			String homeName = null;
			if ( discriminator.equals("A") ) {
				homeName = "AntennaResource";
			}
			else
			if ( discriminator.equals("B") ) {
				homeName = "BaseStationResource";
			}
			else
			if ( discriminator.equals("K") ) {
				homeName = "CableResource";
			}
			else
			if ( discriminator.equals("P") ) {
				homeName = "RepiterRes";
			}
			else
			if ( discriminator.equals("L") ) {
				homeName = "RRLAntennaResource";
			}
			else
			if ( discriminator.equals("X") ) {
				homeName = "LeaseResource";
			}
			else
			if ( discriminator.equals("D") ) {
				homeName = "RepiterDonorUnits";
			}
			else
			if ( discriminator.equals("E") ) {
				homeName = "TRXResource";
			}
			else
			if ( discriminator.equals("C") ) {
				homeName = "AccumulatorResource";
			}
			if (homeName != null) {
				bean = ((com.ibm.ejs.container.EJSHome)home).getBean(homeName, getPrimaryKey(rs), rs);
			}
		}
		if (bean == null) {
			try{
				if (rs != null) rs.close();
			}
			catch (SQLException sqlExc) {}
			throw new EJSPersistenceException("Unknown or superclass discriminator value retrieved from database.");
		}
		return bean;
	}
	/**
	 * findResourcesByLeasePayRules
	 */
	public EJSFinder findResourcesByLeasePayRules(java.util.Vector listContracts) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByLeasePayRules(listContracts);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourcesByQBE2
	 */
	public EJSFinder findResourcesByQBE2(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByQBE2(isSubtypekey, subtypeKey, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourcesByQBE
	 */
	public EJSFinder findResourcesByQBE(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByQBE(isSubtypekey, subtypeKey, isModel, model, isName, name, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourceBySubtype
	 */
	public EJSFinder findResourceBySubtype(com.hps.july.persistence.ResourceSubTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("(((((((((SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8 WHERE T8.resourceclass = \'R\' AND T8.resourcesubtype = ?)  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, T3.generation, T3.height, T3.length, T3.modification, T3.productline, T3.standard, T3.width, T3.makeyear, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM basestationres  T3, resources  T8 WHERE T8.resource = T3.resource AND T8.resourceclass = \'B\' AND T8.resourcesubtype = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), T2.anttype, T2.connector, T2.electricangle, T2.freqrange, T2.height, T2.ksvn, T2.length, T2.polarization, T2.weight, T2.width, T2.isomni, T2.entriescount, CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM antennares  T2, resources  T8 WHERE T8.resource = T2.resource AND T8.resourceclass = \'A\' AND T8.resourcesubtype = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), T4.cablediamid, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM cableres  T4, resources  T8 WHERE T8.resource = T4.resource AND T8.resourceclass = \'K\' AND T8.resourcesubtype = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T9.freqdevhighk, T9.freqdevhighlog10, T9.freqdevlowk, T9.freqdevlowlog10, T9.mkkrrecomm, T9.protocoldate, T9.protocolnum, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, rrlantennares  T9 WHERE T8.resource = T9.resource AND T8.resourceclass = \'L\' AND T8.resourcesubtype = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), T7.bandwidth, T7.islinear, T7.numchanals, T7.reppower, T7.endbandwidth, T7.dimensions, T7.weight, T7.usedpower, T7.gainfactor, T7.signaldelay, T7.noisefactor, T7.workband, T7.linkband, T7.voltageid, T7.repitertype, T7.antentriescount, T7.downlinkband, T7.downlinkbandup, T7.isremotecontrol, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, repiterres  T7 WHERE T8.resource = T7.resource AND T8.resourceclass = \'P\' AND T8.resourcesubtype = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), T5.needcwact, T5.useinarendacontract, T5.useinabonentcontract, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, leaseresources  T5 WHERE T8.resource = T5.resource AND T8.resourceclass = \'X\' AND T8.resourcesubtype = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), T6.power, T6.workband, T6.linkband, T6.gainfactor, T6.voltageid, T6.usedpower, T6.entriescount, T6.antgatescount, T6.signaldelay, T6.noisefactor, CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM repdonorunitres  T6, resources  T8 WHERE T8.resource = T6.resource AND T8.resourceclass = \'D\' AND T8.resourcesubtype = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), T10.band, T10.doubletrx, CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM trxres  T10, resources  T8 WHERE T8.resource = T10.resource AND T8.resourceclass = \'E\' AND T8.resourcesubtype = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), T1.voltage, T1.capacity, T1.accutype, T1.accucount FROM accumres  T1, resources  T8 WHERE T8.resource = T1.resource AND T8.resourceclass = \'C\' AND T8.resourcesubtype = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resourcesubtype);
			pstmt.setInt(2, inKey.resourcesubtype);
			pstmt.setInt(3, inKey.resourcesubtype);
			pstmt.setInt(4, inKey.resourcesubtype);
			pstmt.setInt(5, inKey.resourcesubtype);
			pstmt.setInt(6, inKey.resourcesubtype);
			pstmt.setInt(7, inKey.resourcesubtype);
			pstmt.setInt(8, inKey.resourcesubtype);
			pstmt.setInt(9, inKey.resourcesubtype);
			pstmt.setInt(10, inKey.resourcesubtype);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourcesByQBE3
	 */
	public EJSFinder findResourcesByQBE3(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByQBE3(isSubtypekey, subtypeKey, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, connected, owner, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourcesForBrowse
	 */
	public EJSFinder findResourcesForBrowse(java.lang.Boolean isResourcetype, java.lang.Integer resourcetype, java.lang.Boolean isResourcesubtype, java.lang.Integer resourcesubtype, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.String active, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesForBrowse(isResourcetype, resourcetype, isResourcesubtype, resourcesubtype, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, active, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findActiveResourceBySubtype
	 */
	public EJSFinder findActiveResourceBySubtype(java.lang.Integer argSubtype, java.lang.String argActive) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("(((((((((SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8 WHERE T8.resourceclass = \'R\' AND resourcesubtype = ? AND active = ?)  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, T3.generation, T3.height, T3.length, T3.modification, T3.productline, T3.standard, T3.width, T3.makeyear, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM basestationres  T3, resources  T8 WHERE T8.resource = T3.resource AND T8.resourceclass = \'B\' AND resourcesubtype = ? AND active = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), T2.anttype, T2.connector, T2.electricangle, T2.freqrange, T2.height, T2.ksvn, T2.length, T2.polarization, T2.weight, T2.width, T2.isomni, T2.entriescount, CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM antennares  T2, resources  T8 WHERE T8.resource = T2.resource AND T8.resourceclass = \'A\' AND resourcesubtype = ? AND active = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), T4.cablediamid, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM cableres  T4, resources  T8 WHERE T8.resource = T4.resource AND T8.resourceclass = \'K\' AND resourcesubtype = ? AND active = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T9.freqdevhighk, T9.freqdevhighlog10, T9.freqdevlowk, T9.freqdevlowlog10, T9.mkkrrecomm, T9.protocoldate, T9.protocolnum, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, rrlantennares  T9 WHERE T8.resource = T9.resource AND T8.resourceclass = \'L\' AND resourcesubtype = ? AND active = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), T7.bandwidth, T7.islinear, T7.numchanals, T7.reppower, T7.endbandwidth, T7.dimensions, T7.weight, T7.usedpower, T7.gainfactor, T7.signaldelay, T7.noisefactor, T7.workband, T7.linkband, T7.voltageid, T7.repitertype, T7.antentriescount, T7.downlinkband, T7.downlinkbandup, T7.isremotecontrol, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, repiterres  T7 WHERE T8.resource = T7.resource AND T8.resourceclass = \'P\' AND resourcesubtype = ? AND active = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), T5.needcwact, T5.useinarendacontract, T5.useinabonentcontract, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, leaseresources  T5 WHERE T8.resource = T5.resource AND T8.resourceclass = \'X\' AND resourcesubtype = ? AND active = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), T6.power, T6.workband, T6.linkband, T6.gainfactor, T6.voltageid, T6.usedpower, T6.entriescount, T6.antgatescount, T6.signaldelay, T6.noisefactor, CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM repdonorunitres  T6, resources  T8 WHERE T8.resource = T6.resource AND T8.resourceclass = \'D\' AND resourcesubtype = ? AND active = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), T10.band, T10.doubletrx, CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM trxres  T10, resources  T8 WHERE T8.resource = T10.resource AND T8.resourceclass = \'E\' AND resourcesubtype = ? AND active = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), T1.voltage, T1.capacity, T1.accutype, T1.accucount FROM accumres  T1, resources  T8 WHERE T8.resource = T1.resource AND T8.resourceclass = \'C\' AND resourcesubtype = ? AND active = ?) ");
			for (int _EJS_i=0; _EJS_i<20; _EJS_i+=2) {
				pstmt.setObject(_EJS_i+1, argSubtype);
				if (argActive == null) {
				   pstmt.setNull(_EJS_i+2, java.sql.Types.VARCHAR);
				} else {
				   pstmt.setString(_EJS_i+2, argActive);
				}
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourcesByUnit
	 */
	public EJSFinder findResourcesByUnit(com.hps.july.persistence.UnitKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("(((((((((SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8 WHERE T8.resourceclass = \'R\' AND T8.unit = ?)  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, T3.generation, T3.height, T3.length, T3.modification, T3.productline, T3.standard, T3.width, T3.makeyear, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM basestationres  T3, resources  T8 WHERE T8.resource = T3.resource AND T8.resourceclass = \'B\' AND T8.unit = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), T2.anttype, T2.connector, T2.electricangle, T2.freqrange, T2.height, T2.ksvn, T2.length, T2.polarization, T2.weight, T2.width, T2.isomni, T2.entriescount, CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM antennares  T2, resources  T8 WHERE T8.resource = T2.resource AND T8.resourceclass = \'A\' AND T8.unit = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), T4.cablediamid, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM cableres  T4, resources  T8 WHERE T8.resource = T4.resource AND T8.resourceclass = \'K\' AND T8.unit = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T9.freqdevhighk, T9.freqdevhighlog10, T9.freqdevlowk, T9.freqdevlowlog10, T9.mkkrrecomm, T9.protocoldate, T9.protocolnum, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, rrlantennares  T9 WHERE T8.resource = T9.resource AND T8.resourceclass = \'L\' AND T8.unit = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), T7.bandwidth, T7.islinear, T7.numchanals, T7.reppower, T7.endbandwidth, T7.dimensions, T7.weight, T7.usedpower, T7.gainfactor, T7.signaldelay, T7.noisefactor, T7.workband, T7.linkband, T7.voltageid, T7.repitertype, T7.antentriescount, T7.downlinkband, T7.downlinkbandup, T7.isremotecontrol, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, repiterres  T7 WHERE T8.resource = T7.resource AND T8.resourceclass = \'P\' AND T8.unit = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), T5.needcwact, T5.useinarendacontract, T5.useinabonentcontract, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, leaseresources  T5 WHERE T8.resource = T5.resource AND T8.resourceclass = \'X\' AND T8.unit = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), T6.power, T6.workband, T6.linkband, T6.gainfactor, T6.voltageid, T6.usedpower, T6.entriescount, T6.antgatescount, T6.signaldelay, T6.noisefactor, CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM repdonorunitres  T6, resources  T8 WHERE T8.resource = T6.resource AND T8.resourceclass = \'D\' AND T8.unit = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), T10.band, T10.doubletrx, CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM trxres  T10, resources  T8 WHERE T8.resource = T10.resource AND T8.resourceclass = \'E\' AND T8.unit = ?) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), T1.voltage, T1.capacity, T1.accutype, T1.accucount FROM accumres  T1, resources  T8 WHERE T8.resource = T1.resource AND T8.resourceclass = \'C\' AND T8.unit = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.unit);
			pstmt.setInt(2, inKey.unit);
			pstmt.setInt(3, inKey.unit);
			pstmt.setInt(4, inKey.unit);
			pstmt.setInt(5, inKey.unit);
			pstmt.setInt(6, inKey.unit);
			pstmt.setInt(7, inKey.unit);
			pstmt.setInt(8, inKey.unit);
			pstmt.setInt(9, inKey.unit);
			pstmt.setInt(10, inKey.unit);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourcesByLeaseChargeRules
	 */
	public EJSFinder findResourcesByLeaseChargeRules(java.util.Vector listContracts) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByLeaseChargeRules(listContracts);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 */
	public EJSFinder findResourceByReglamentOrderByCodeAsc(java.lang.Integer argReglament) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourceByReglamentOrderByCodeAsc(argReglament);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Resource findByPrimaryKey(com.hps.july.persistence.ResourceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.Resource result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.ResourceKey _primaryKey = (com.hps.july.persistence.ResourceKey)key;
		try {
			try {
				result = (com.hps.july.persistence.Resource)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.resource);
				pstmt.setInt(2, _primaryKey.resource);
				pstmt.setInt(3, _primaryKey.resource);
				pstmt.setInt(4, _primaryKey.resource);
				pstmt.setInt(5, _primaryKey.resource);
				pstmt.setInt(6, _primaryKey.resource);
				pstmt.setInt(7, _primaryKey.resource);
				pstmt.setInt(8, _primaryKey.resource);
				pstmt.setInt(9, _primaryKey.resource);
				pstmt.setInt(10, _primaryKey.resource);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.Resource)tmpFinder.nextElement();
				}
			}
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
		finally {
			if ( tmpFinder != null ) tmpFinder.close();
		}
		if (result == null) {
			throw new javax.ejb.ObjectNotFoundException();
		}
		return result;
	}
	private static final String genericFindSqlString = "(((((((((SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8 WHERE T8.resourceclass = \'R\' AND )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, T3.generation, T3.height, T3.length, T3.modification, T3.productline, T3.standard, T3.width, T3.makeyear, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM basestationres  T3, resources  T8 WHERE T8.resource = T3.resource AND T8.resourceclass = \'B\' AND ) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), T2.anttype, T2.connector, T2.electricangle, T2.freqrange, T2.height, T2.ksvn, T2.length, T2.polarization, T2.weight, T2.width, T2.isomni, T2.entriescount, CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM antennares  T2, resources  T8 WHERE T8.resource = T2.resource AND T8.resourceclass = \'A\' AND ) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), T4.cablediamid, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM cableres  T4, resources  T8 WHERE T8.resource = T4.resource AND T8.resourceclass = \'K\' AND ) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), T9.freqdevhighk, T9.freqdevhighlog10, T9.freqdevlowk, T9.freqdevlowlog10, T9.mkkrrecomm, T9.protocoldate, T9.protocolnum, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, rrlantennares  T9 WHERE T8.resource = T9.resource AND T8.resourceclass = \'L\' AND ) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), T7.bandwidth, T7.islinear, T7.numchanals, T7.reppower, T7.endbandwidth, T7.dimensions, T7.weight, T7.usedpower, T7.gainfactor, T7.signaldelay, T7.noisefactor, T7.workband, T7.linkband, T7.voltageid, T7.repitertype, T7.antentriescount, T7.downlinkband, T7.downlinkbandup, T7.isremotecontrol, CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, repiterres  T7 WHERE T8.resource = T7.resource AND T8.resourceclass = \'P\' AND ) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), T5.needcwact, T5.useinarendacontract, T5.useinabonentcontract, CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM resources  T8, leaseresources  T5 WHERE T8.resource = T5.resource AND T8.resourceclass = \'X\' AND ) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), T6.power, T6.workband, T6.linkband, T6.gainfactor, T6.voltageid, T6.usedpower, T6.entriescount, T6.antgatescount, T6.signaldelay, T6.noisefactor, CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM repdonorunitres  T6, resources  T8 WHERE T8.resource = T6.resource AND T8.resourceclass = \'D\' AND ) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), T10.band, T10.doubletrx, CAST(NULL AS DECIMAL(4, 1)), CAST(NULL AS DECIMAL(6, 0)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER) FROM trxres  T10, resources  T8 WHERE T8.resource = T10.resource AND T8.resourceclass = \'E\' AND ) )  UNION ALL (SELECT T8.notes, T8.actualcode, T8.countpolicy, T8.resource, T8.manucode, T8.complectpart, T8.active, T8.complect, T8.boxable, T8.name, T8.model, T8.priceable, T8.resourceclass2, T8.groupid, T8.manufid, T8.disablenfscodes, T8.resourcesubtype, T8.unit, T8.resourceclass, CAST(NULL AS CHAR(10)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(10)), CAST(NULL AS CHAR(50)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(7, 3)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(20)), CAST(NULL AS DATE), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(1)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS CHAR(20)), CAST(NULL AS DECIMAL(6, 1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS CHAR(1)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS INTEGER), CAST(NULL AS INTEGER), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS DECIMAL(6, 2)), CAST(NULL AS SMALLINT), CAST(NULL AS CHAR(1)), T1.voltage, T1.capacity, T1.accutype, T1.accucount FROM accumres  T1, resources  T8 WHERE T8.resource = T1.resource AND T8.resourceclass = \'C\' AND ) ";
	private static final int[] genericFindInsertPoints = {19521, 17553, 15554, 13640, 11619, 9785, 7809, 5795, 3913, 1970};
	/**
	 * getMergedPreparedStatement
	 */
	public PreparedStatement getMergedPreparedStatement(String searchCondition) throws Exception {
		StringBuffer sb = new StringBuffer(genericFindSqlString);
		for (int i = 0; i < genericFindInsertPoints.length; i++) {
		   sb.insert(genericFindInsertPoints[i], searchCondition);
		}
		return super.getPreparedStatement(sb.toString());
	}
	/**
	 * getMergedWhereCount
	 */
	public int getMergedWhereCount() {
		return genericFindInsertPoints.length;
	}
	/**
	 * getGenericFindSqlString
	 */
	public String getGenericFindSqlString() {
		return genericFindSqlString;
	}
	/**
	 * getGenericFindInsertPoints
	 */
	public int[] getGenericFindInsertPoints() {
		return genericFindInsertPoints;
	}
	private ResourceBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.ResourceBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.ResourceBeanFinderObject temp_finderObject = new com.hps.july.persistence.ResourceBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
