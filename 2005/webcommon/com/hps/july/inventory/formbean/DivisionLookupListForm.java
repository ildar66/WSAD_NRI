package com.hps.july.inventory.formbean;

import java.util.ArrayList;
import com.hps.july.persistence.DivisionAccessBean;
import com.hps.july.persistence.CompanyAccessBean;
import com.hps.july.persistence.NamedValueAccessBean;

/**
 * Форма выбора департаментов, отделов и прочих подразделений компании
 * Форма имеет многоуровневую структуру. Т.е. имеется возможности переходить от дирекций к отделам
 * и выбирать нужное.
 * Для организации такого поведения форма сохраняет историю переходов и использует её для возврата
 * к предыдущему уровню компании.
 */
public class DivisionLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
	private int company=1;
	private int countLevel = 1;
	private int[] history;
	private String companyName;
	private boolean isRoot=true;
	private int parent;
	private int division = 0; 
	private int order=1;
public DivisionLookupListForm() {
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
        countLevel = 0;
    } catch (Exception ex) {
        System.out.println("Exception in DivisionLookupListForm.DivisionLookupListForm ex=" + ex.getMessage());
    }
}
public int getCompany() {
	return company;
}
public java.lang.String getCompanyName() {
	return companyName;
}
public int getCountLevel() {
	return countLevel;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(parent), new Integer(company),
		new Boolean(isRoot), new Integer(order)};
}
public int[] getHistory() {
	return history;
}
public int getOrder() {
	return order;
}
public void setCountLevel(int newCountLevel) {
	countLevel = newCountLevel;
	if(countLevel < 0) countLevel = 0;
}
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
public void setOrder(int newOrder) {
	order = newOrder;
}
public void setParent(int newParent) {
	parent = newParent;	
	countLevel++;
	history[countLevel] = parent;
	isRoot=false;
}
public void setUpparent(int newUpparent) {
	parent = newUpparent;
	if(parent == -1) isRoot = true;
}
}
