package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;

/**
 * Insert the type's description here.
 * Creation date: (11.11.2005 15:49:33)
 * @author: Shafigullin Ildar
 */
public abstract class WordForm extends  org.apache.struts.action.ActionForm {
/**
 * Базовый класс(Form) для формирования документов WORD.
 * Creation date: (11.11.2005 15:50:28)
 */
public abstract void init(HttpServletRequest request) throws Exception;
}
