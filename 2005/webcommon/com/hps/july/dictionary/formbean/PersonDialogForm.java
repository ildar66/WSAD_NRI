package com.hps.july.dictionary.formbean;

import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.dictionary.valueobject.Person_VO;
/**
* Insert the type's description here.
* Creation date: (05.10.2005 12:06:05)
* @author: Shafigullin Ildar
*/
public class PersonDialogForm extends com.hps.july.web.util.EditForm {
    private int id;
    private boolean flagOperation;
    private com.hps.july.dictionary.valueobject.Person_VO person;
/**
 * формирует ФИО в формате(Иванов И. С.).
 * Creation date: (05.10.2005 16:33:43)
 * @param vo com.hps.july.dictionary.valueobject.Person_VO
 */
private void computePersonName(Person_VO vo) {
    if (vo != null) {
        StringBuffer sb = new StringBuffer(vo.getLastname());
        if (vo.getFirstname() != null && !vo.getFirstname().trim().equals("")) {
            sb.append(" " + vo.getFirstname().charAt(0) + ".");
        }
        if (vo.getMiddlename() != null && !vo.getMiddlename().trim().equals("")) {
            sb.append(" " + vo.getMiddlename().charAt(0) + ".");
        }
        vo.setName(sb.toString());
    }
}
/**
 * Текущее приложение.
 * Creation date: (05.10.2005 12:06:05)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 12:35:40)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 15:30:58)
 * @return String
 */
public String getPassportdateStr() {
    if (person != null && person.getPassportdate() != null) {
        StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
        sd.setSqlDate(person.getPassportdate());
        return sd.getString();
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 12:36:47)
 * @return com.hps.july.dictionary.valueobject.Person_VO
 */
public com.hps.july.dictionary.valueobject.Person_VO getPerson() {
	return person;
}
/**
 * Текущее состояние приложения.
 * Creation date: (05.10.2005 12:06:05)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.PERSON_DIALOG;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    setFlagOperation(false);
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    int key = keyGen.getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.ORGANIZATION);
    setId(key);
    person = new Person_VO(new Integer(key));
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 12:36:01)
 * @return boolean
 */
public boolean isFlagOperation() {
	return flagOperation;
}
/**
 * Метод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    person = com.hps.july.arenda.cdbcobjects.CDBC_Person_Object.find(getId());
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    boolean ok = com.hps.july.arenda.cdbcobjects.CDBC_Person_Object.delete(getPerson());
    if (!ok) {
        String errorStr = "Ошибка удаления записи: Person:id" + getPerson().getOrganization();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	computePersonName(getPerson());
    boolean ok = com.hps.july.arenda.cdbcobjects.CDBC_Person_Object.add(getPerson());
    if (!ok) {
        String errorStr = "Ошибка добаления записи: Person:id" + getPerson().getOrganization();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    computePersonName(getPerson());
    boolean ok = com.hps.july.arenda.cdbcobjects.CDBC_Person_Object.edit(getPerson());
    if (!ok) {
        String errorStr = "Ошибка редактирования записи: Person:id" + getPerson().getOrganization();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 12:36:01)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 12:35:40)
 * @param newId int
 */
public void setId(int newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 15:30:58)
 * @param newPassportdateStr String
 */
public void setPassportdateStr(String newPassportdateStr) {
	StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
	sd.setString(newPassportdateStr);
	person.setPassportdate(sd.getSqlDate());
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 12:36:47)
 * @param newPerson com.hps.july.dictionary.valueobject.Person_VO
 */
public void setPerson(com.hps.july.dictionary.valueobject.Person_VO newPerson) {
	person = newPerson;
}
}
