package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import java.util.*;
import com.hps.july.basestation.valueobject.*;
/**
* JDBC - Объект для работы с "Перечень ответственных за позиции сотрудников и  организаций-подрядчиков".
* Creation date: (05.08.2005 11:28:08)
* @author: Shafigullin Ildar
*/
public class CDBC_WorkResponsibility_Object {
    private static final String find_SQL =
        "SELECT worker, idresponsibility, storageplace, resptype, organization, operator FROM WorkResponsibility ";
    private final static java.lang.String add_SQL =
        "INSERT INTO WorkResponsibility (worker, idresponsibility, storageplace, resptype, organization, operator) "
            + "VALUES (?,?,?,?,?,?) ";
    private final static java.lang.String edit_SQL =
        "UPDATE WorkResponsibility SET worker=?, organization=?, operator=? "
            + "WHERE idresponsibility= ? AND storageplace=? AND resptype=? ";
    private static final String findIdResponsibility_SQL =
        "SELECT intvalue FROM namedvalues WHERE id = 'RESPONSIBLE_EXPLBSS' ";
            
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 12:14:11)
 */
public static boolean add(WorkResponsibility_VO vo) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params =
        {
            vo.getWorker(),
            vo.getIdresponsibility(),
            vo.getStorageplace(),
            vo.getResptype(),
            vo.getOrganization(),
            vo.getOperator()};
    return res.executeUpdate(add_SQL, params);
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 12:14:11)
 */
public static boolean edit(WorkResponsibility_VO vo) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params =
        {
            vo.getWorker(),
            vo.getOrganization(),
            vo.getOperator(),
            vo.getIdresponsibility(),
            vo.getStorageplace(),
            vo.getResptype()};
    return res.executeUpdate(edit_SQL, params);
}
/**
 * Creation date: (23.07.2005 13:57:38)
 */
public static WorkResponsibility_VO find(Integer idresponsibility, Integer storageplace, String resptype) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { idresponsibility, storageplace, resptype };
    String sql = find_SQL + "WHERE idresponsibility = ? AND storageplace = ? AND resptype = ? ";
    res.executeQuery(sql, params);
    ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    WorkResponsibility_VO vo = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        Integer idResponsibility = (Integer) ro.getColumn("idresponsibility").asObject();
        Integer storagePlace = (Integer) ro.getColumn("storageplace").asObject();
        String respType = ro.getColumn("resptype").asString();
        vo = new WorkResponsibility_VO(idResponsibility, storagePlace, respType);
        vo.setOperator((Integer)ro.getColumn("operator").asObject());
        vo.setOrganization((Integer)ro.getColumn("organization").asObject());
        vo.setWorker((Integer)ro.getColumn("worker").asObject());
    }
    return vo;
}
/**
 * Creation date: (23.07.2005 13:57:38)
 */
public static WorkResponsibility_VO find(Integer storageplace, String resptype) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = {storageplace, resptype };
    String sql = find_SQL + "WHERE idresponsibility = (SELECT intvalue FROM namedvalues WHERE id = 'RESPONSIBLE_EXPLBSS') AND storageplace = ? AND resptype = ? ";
    res.executeQuery(sql, params);
    ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    WorkResponsibility_VO vo = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        Integer idResponsibility = (Integer) ro.getColumn("idresponsibility").asObject();
        Integer storagePlace = (Integer) ro.getColumn("storageplace").asObject();
        String respType = ro.getColumn("resptype").asString();
        vo = new WorkResponsibility_VO(idResponsibility, storagePlace, respType);
        vo.setOperator((Integer)ro.getColumn("operator").asObject());
        vo.setOrganization((Integer)ro.getColumn("organization").asObject());
        vo.setWorker((Integer)ro.getColumn("worker").asObject());
    }
    return vo;
}
/**
 * Creation date: (23.07.2005 13:57:38)
 */
public static Integer findIdResponsibility() {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = null;
    String sql = findIdResponsibility_SQL;
    res.executeQuery(sql, params);
    ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    Integer idResponsibility = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        idResponsibility = (Integer) ro.getColumn("intvalue").asObject();
    }
    return idResponsibility;
}
}
