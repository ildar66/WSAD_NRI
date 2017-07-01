package com.hps.july.project.formbean;

/**
 * ‘орма быстрого редактировани€ событи€ проекта.
 * Creation date: (14.11.2003 13:43:14)
 * @author: Dmitry Dneprov
 */
public class ProjectActionFastForm extends ProjectActionForm {
/**
 * ProjectActionFastForm constructor comment.
 */
public ProjectActionFastForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.project.APPStates.PROJECTACTIONFASTEDIT;
}
}
