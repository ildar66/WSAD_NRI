package com.hps.july.web.util;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Vadim Glushkov (mailto: v.glushkov@mail.ru)
 * Date: 15.05.2006
 * Time: 18:38:55
 */
public class RTSMenu {
	public static final Integer INITIATOR = new Integer(1);
	public static final Integer REGION_MANAGER = new Integer(2);
	public static final Integer PERFORMER = new Integer(3);
	public static final Integer TOP_MANAGER = new Integer(4);
	public static final Integer ASSERTOR = new Integer(5);
	public static final Integer TESTER = new Integer(6);
	public static final Integer SETS_RESPONSIBLE = new Integer(7);
	public static final Integer ARENDA_RESPONSIBLE = new Integer(8);
	public static final Integer ARENDA_PERFORMER = new Integer(9);
	public static final Integer MANAGER = new Integer(10);

	public String createRTSMenu(HttpServletRequest request, String login) {

		StringBuffer menu = new StringBuffer();
		Integer personId = getPerson(login);
		boolean isAdmin = request.isUserInRole("administrator") || request.isUserInRole("developer");
/*
		item1_17_5 = addItem(item1, '', 'Заявки на ТС', '');
		item1_17_5_1 = addItem(item1_17_5, '', 'Назначение каналов', '/rts/ShowChannelSettingsListAction.do?navclear=1&itemMenu=item1_17_5_1');
		item1_17_5_2 = addItem(item1_17_5, '', 'Интерфейсы каналов', '/rts/ShowChannelInterfaceListAction.do?navclear=1&itemMenu=item1_17_5_2');
		item1_17_5_3 = addItem(item1_17_5, '', 'Типы каналов', '/rts/ShowChannelTypesListAction.do?navclear=1&itemMenu=item1_17_5_3');
		item1_17_5_4 = addItem(item1_17_5, '', 'Инициаторы', '/rts/ShowInitiatorsListAction.do?navclear=1&itemMenu=item1_17_5_4');
		item1_17_5_5 = addItem(item1_17_5, '', 'Региональные менеджеры', '/rts/ShowRegionManagersListAction.do?navclear=1&itemMenu=item1_17_5_5');
		item1_17_5_6 = addItem(item1_17_5, '', 'Исполнители', '/rts/ShowPerformersListAction.do?navclear=1&itemMenu=item1_17_5_6');
		item1_17_5_7 = addItem(item1_17_5, '', 'Остальные пользователи', '/rts/ShowAllUsersListAction.do?navclear=1&itemMenu=item1_17_5_7');
		item1_17_5_8 = addItem(item1_17_5, '', 'АРМ инициатора', '/rts/RequestsListAction.do?navclear=1&itemMenu=item1_17_5_8');
		item1_17_5_9 = addItem(item1_17_5, '', 'АРМ КМ', '/rts/ConsolidatedRequestsListAction.do?navclear=1&itemMenu=item1_17_5_9');
		item1_17_5_10 = addItem(item1_17_5, '', 'АРМ РМ', '/rts/ElementaryRequestsListAction.do?navclear=1&itemMenu=item1_17_5_10');
		item1_17_5_11 = addItem(item1_17_5, '', 'АРМ исполнителя', '/rts/ShowElementaryRequestsForExecutor.do?navclear=1&itemMenu=item1_17_5_11');
		item1_17_5_12 = addItem(item1_17_5, '', 'АРМ руководителя', '/rts/ShowConsolidatedRequestsForHead.do?navclear=1&itemMenu=item1_17_5_12');
*/

		if(isAdmin || isUserInRole(TOP_MANAGER, personId)) {
			menu.append("item1_17_5_1 = addItem(item1_17_5, '', 'Назначение каналов', '/rts/ShowChannelSettingsListAction.do?navclear=1&itemMenu=item1_17_5_1'); \n");
			menu.append("item1_17_5_2 = addItem(item1_17_5, '', 'Интерфейсы каналов', '/rts/ShowChannelInterfaceListAction.do?navclear=1&itemMenu=item1_17_5_2'); \n");
			menu.append("item1_17_5_3 = addItem(item1_17_5, '', 'Типы каналов', '/rts/ShowChannelTypesListAction.do?navclear=1&itemMenu=item1_17_5_3'); \n");
			menu.append("item1_17_5_4 = addItem(item1_17_5, '', 'Инициаторы', '/rts/ShowInitiatorsListAction.do?navclear=1&itemMenu=item1_17_5_4'); \n");
			menu.append("item1_17_5_5 = addItem(item1_17_5, '', 'Региональные менеджеры', '/rts/ShowRegionManagersListAction.do?navclear=1&itemMenu=item1_17_5_5'); \n");
			menu.append("item1_17_5_6 = addItem(item1_17_5, '', 'Исполнители', '/rts/ShowPerformersListAction.do?navclear=1&itemMenu=item1_17_5_6'); \n");
			menu.append("item1_17_5_7 = addItem(item1_17_5, '', 'Остальные пользователи', '/rts/ShowAllUsersListAction.do?navclear=1&itemMenu=item1_17_5_7'); \n");

			menu.append("item1_17_5_9 = addItem(item1_17_5, '', 'АРМ КМ', '/rts/ConsolidatedRequestsListAction.do?navclear=1&itemMenu=item1_17_5_9'); \n");
		}

		if(isAdmin || isUserInRole(INITIATOR, personId)) {
			menu.append("item1_17_5_8 = addItem(item1_17_5, '', 'АРМ инициатора', '/rts/RequestsListAction.do?navclear=1&itemMenu=item1_17_5_8'); \n");
		}
		if(isAdmin || isUserInRole(REGION_MANAGER, personId)) {
			menu.append("item1_17_5_10 = addItem(item1_17_5, '', 'АРМ РМ', '/rts/ElementaryRequestsListAction.do?navclear=1&itemMenu=item1_17_5_10'); \n");
		}
		if(isAdmin || isUserInRole(PERFORMER, personId)) {
			menu.append("item1_17_5_11 = addItem(item1_17_5, '', 'АРМ исполнителя', '/rts/ShowElementaryRequestsForExecutor.do?navclear=1&itemMenu=item1_17_5_11'); \n");
		}
//		<c:if test="${administrator || developer || rts_manager}">
//			item1_17_5_12 = addItem(item1_17_5, '', 'АРМ руководителя', '/rts/ShowConsolidatedRequestsForHead.do?navclear=1&itemMenu=item1_17_5_12');
//		</c:if>
//		<c:if test="${administrator || developer || rts_assertor}">
//			item1_17_5_13 = addItem(item1_17_5, '', 'АРМ утверждающего', '/rts/ShowConsolidatedRequestsToConfirm.do?navclear=1&itemMenu=item1_17_5_13');
//		</c:if>
//		<c:if test="${administrator || developer || rts_testor}">
//			item1_17_5_14 = addItem(item1_17_5, '', 'АРМ тестирующего', '/rts/ShowConsolidatedRequestsToTest.do?navclear=1&itemMenu=item1_17_5_14');
//		</c:if>
//		<c:if test="${administrator || developer || rts_arendaResponsible}">
//			item1_17_5_15 = addItem(item1_17_5, '', 'АРМ ответственного за аренду', '/rts/ShowConsolidatedRequestsForArendaResponsiblePerson.do?navclear=1&itemMenu=item1_17_5_15');
//		</c:if>

		if(isAdmin || isUserInRole(MANAGER, personId)) {
			menu.append("item1_17_5_12 = addItem(item1_17_5, '', 'АРМ руководителя', '/rts/ShowConsolidatedRequestsForHead.do?navclear=1&itemMenu=item1_17_5_12'); \n");
		} 
		if(isAdmin || isUserInRole(ASSERTOR, personId)) {
			menu.append("item1_17_5_13 = addItem(item1_17_5, '', 'АРМ утверждающего', '/rts/ShowConsolidatedRequestsToConfirm.do?navclear=1&itemMenu=item1_17_5_13'); \n");
		} 
		if(isAdmin || isUserInRole(TESTER, personId)) {
			menu.append("item1_17_5_14 = addItem(item1_17_5, '', 'АРМ тестирующего', '/rts/ShowConsolidatedRequestsToTest.do?navclear=1&itemMenu=item1_17_5_14'); \n");
		} 
		if(isAdmin || isUserInRole(ARENDA_RESPONSIBLE, personId)) {
			menu.append("item1_17_5_15 = addItem(item1_17_5, '', 'АРМ ответственного за аренду', '/rts/ShowConsolidatedRequestsForArendaResponsiblePerson.do?navclear=1&itemMenu=item1_17_5_15'); \n");
		} 
		return menu.toString();
	}

	private Integer getPerson(String login) {
		java.lang.StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.man as personId FROM operators o, people p WHERE o.man = p.man AND o.loiginid = ?");
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery(sql.toString(), new java.lang.Object[] {
			login
		});
		java.util.Iterator iterator = rs.listIterator();
		if(iterator.hasNext()) {
			CDBCRowObject obj = (CDBCRowObject)iterator.next();
			java.lang.Object resultObj = obj.getColumn("personId").asObject();
			if(resultObj instanceof java.lang.Integer)
				return (Integer)resultObj;
		}
		return null;
	}

	private boolean isUserInRole(Integer roleId, Integer person) {

		java.lang.StringBuffer sql = new StringBuffer();
		boolean isGroup = ((roleId.intValue() == 1) || (roleId.intValue() == 2) || roleId.intValue() == 3);
		if(!isGroup) {
			sql.append(" SELECT ");
			sql.append(" p.man ");
			sql.append(" FROM people p, rts_roles2people rp ");
			sql.append(" WHERE ");
			sql.append(" rp.man = p.man AND p.man = ? AND rp.roleid = ? ");
		} else {
			sql.append(" SELECT ");
			sql.append(" p.man ");
			sql.append(" FROM rts_groups g, rts_groups2people gp, people p ");
			sql.append(" WHERE ");
			sql.append(" gp.man = p.man AND p.man = ? AND g.groupid = gp.groupid AND g.roleid = ? ");
		}
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery(sql.toString(), new java.lang.Object[] {
			person, roleId
		});
		java.util.Iterator iterator = rs.listIterator();
		if(iterator.hasNext()) return true;
		return false;
	}
}
