package com.hps.july.security.formbean;

import java.util.ArrayList;
import com.hps.july.persistence.DivisionAccessBean;
import com.hps.july.persistence.CompanyAccessBean;
import com.hps.july.persistence.NamedValueAccessBean;
/**
 * Форма списка отделов.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
 /**Для выбора подраздеоений
 */
public class DivisionListForm extends com.hps.july.web.util.BrowseForm {

	private int company=1;
private int countLevel = 1;
private int[] history;
	private String companyName;
	private boolean isRoot=true;
	private int parent;
private int division = 0; 
	private int order=1;
/**
 * TypeProjectListForm constructor comment.
 */
public DivisionListForm() {
    try {
        setFinderMethodName("findByParentCompany");
        NamedValueAccessBean ab = new NamedValueAccessBean();
        ab.setInitKey_id("OUR_COMPANY");
        ab.refreshCopyHelper();
        company = ab.getIntvalue();
        CompanyAccessBean cab = new CompanyAccessBean();
        cab.setInitKey_company(company);
        cab.refreshCopyHelper();
        companyName = cab.getName();

        history = new int[5];
        history[0] = -1;
    } catch (Exception ex) {
        System.out.println("Exception in DivisionListForm.DivisionListForm ex=" + ex.getMessage());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2002 19:35:20)
 * @return int
 */
public int getCompany() {
	return company;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2002 19:35:40)
 * @return java.lang.String
 */
public java.lang.String getCompanyName() {
	return companyName;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 11:28:36)
 * @return int
 */
public int getCountLevel() {
	return countLevel;
}
/**
 * Insert the method's description here.
 * Creation date: (25.09.2002 19:26:04)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	
	//if(countLevel==1)
		//isRoot=true;
	//if(parent==-1){
		//isRoot=true;
	//}
	return new Object[] { new Integer(parent), new Integer(company),
		new Boolean(isRoot), new Integer(order)};
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 10:14:36)
 * @return int[]
 */
public int[] getHistory() {
	return history;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 11:22:40)
 * @return int
 */
public int getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 11:28:36)
 * @param newCountLevel int
 */
public void setCountLevel(int newCountLevel) {
	countLevel = newCountLevel;
	if(countLevel < 0) countLevel = 0;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 15:23:10)
 * @param newDivision int
 */
public void setDivision(int newDivision) { //?isRoot=true&parent=-1
    division = newDivision;
    try {
        if (division != 0 && division > 0) {
            DivisionAccessBean ab = new DivisionAccessBean();
            ArrayList ar = new ArrayList();
            while (ab != null) {
                ab.setInitKey_division(division);
                ab.refreshCopyHelper();
                ab = ab.getParent();
                if (ab != null) {
                    if (ar.size() == 0) {
                        parent = ab.getDivision(); // Этот родитель будет текущим для данного подразделения
                        ar.add(0, new Integer(parent));
                    } else
                        ar.add(0, new Integer(ab.getDivision()));
                }
            }
            int size = ar.size();//Количество предыдущих элементов
            if (size > 0) {
	            countLevel = size;
	            isRoot = false;
	            for(int i=0; i< size; i++)
		            history[i+1] = ((Integer)ar.get(i)).intValue();
            } else {
	            countLevel = 0;
                isRoot = true;
                parent = -1;
            }
        } else {
	        countLevel = 0;
            isRoot = true;
            parent = -1;
        }
    } catch (Exception ex) {
        System.out.println(ex.getClass().getName()+" in DivisionListForm.setDivision. Message is:"+ex.getMessage());
        countLevel = 0;
        isRoot = true;
        parent = -1;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 11:22:40)
 * @param newOrder int
 */
public void setOrder(int newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (02.10.2002 17:43:13)
 * @param newParent int
 */
public void setParent(int newParent) {
	parent = newParent;	
	countLevel++;
	history[countLevel] = parent;
	isRoot=false;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 11:27:05)
 * @param newUpparent int
 */
public void setUpparent(int newUpparent) {
	parent = newUpparent;
	if(parent == -1) isRoot = true;
}
}
