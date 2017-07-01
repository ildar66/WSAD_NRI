package com.hps.july.project.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка типовых событий проекта.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
public class ProjectActionTypeListForm extends com.hps.july.web.util.BrowseForm {
/**
 * TypeProjectListForm constructor comment.
 */
public ProjectActionTypeListForm() {
	setFinderMethodName("findAllOrderByCodeAsc");
}
/**
 * Insert the method's description here.
 * Creation date: (25.09.2002 19:26:04)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
}
