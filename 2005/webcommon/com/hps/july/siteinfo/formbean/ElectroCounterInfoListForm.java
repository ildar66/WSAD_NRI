package com.hps.july.siteinfo.formbean;

/**
 * Класс, реализующий форму отображения списка моделей электросчетчиков
 * Creation date: (18.08.2004 14:38:07)
 * @author: Vadim Glushkov
 */
public class ElectroCounterInfoListForm extends com.hps.july.web.util.BrowseForm {

	private java.lang.String name = null;
	private java.lang.String code = null;
	/**
	 * ElectroCounterInfoListForm constructor comment.
	 */
	public ElectroCounterInfoListForm() {
		super();
		this.code = new String("");
		this.name = new String("");
		setLastVisited(true);
	}
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCElectroCounterObject";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2004 14:41:14)
	 * @return java.lang.String
	 */
	public java.lang.String getCode() {
		return code;
	}
	/**
	 * Возвращает список ролей, которым разрешено редактирование.
	 * Creation date: (27.06.2002 16:47:06)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("electroCounterEditor");
		roles.add("administrator");
		return roles;
	}
	/**
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (18.08.2004 14:38:07)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object [] {
			this.code, this.name
		};
	}
	/**
	 * Возвращает имя метода поиска.
	 * Creation date: (22.01.2002 11:20:35)
	 * @return java.lang.String
	 */
	public java.lang.String getFinderMethodName() {
		return "listElectroCountersInfo";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2004 14:40:52)
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2004 14:41:14)
	 * @param newCode java.lang.String
	 */
	public void setCode(java.lang.String newCode) {
		code = newCode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2004 14:40:52)
	 * @param newName java.lang.String
	 */
	public void setName(java.lang.String newName) {
		name = newName;
	}
}
