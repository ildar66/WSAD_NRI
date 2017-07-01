package com.hps.july.web.util;

import com.hps.july.jdbcpersistence.lib.TimeCounter;
import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.reflect.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.security.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.cdbc.lib.*;


/**
 * Action, от которого надо наследовать action в browse. Хождение по страницам.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class BrowseAction extends NavigatedAction {
	private static int pageLength;
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект,
 * устарело - необходимо использовать одноименный метод в BrowseForm.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	return o;
}
/**
 * Возвращает имя bean для броуза - устарело, надо использовать такой же метод в BrowseForm.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return null;
}
/**
 * Возвращает кол-во строк перекрытия при листании страниц.
 * Creation date: (10.06.2003 13:39:08)
 * @return int
 */
public int getOverlapRows() {
	return 3;
}
/**
 * Определяет кол-во строк на странице.
 * Creation date: (22.01.2002 17:12:04)
 * @return int
 */
public int getRowsOnPage() {
	int result = 30;

	if (pageLength == 0) {
		try {
			com.hps.july.persistence.NamedValueAccessBean ab = new com.hps.july.persistence.NamedValueAccessBean();
			ab.setInitKey_id("PAGELENGTH");
			ab.refreshCopyHelper();
			pageLength = ab.getIntvalue();
			result = pageLength;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	} else {
		result = pageLength;
	}
	return result;
}
    /**
     * Основной метод обработки запроса.
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an <code>ActionForward</code> instance describing where and how
     * control should be forwarded, or <code>null</code> if the response has
     * already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet exception occurs
     */
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
//	TimeCounter tc = new TimeCounter("BROWSE.ACTION");
//	tc.start();
    // Check if process action requested instead of browse
    String s = request.getParameter(Constants.PROCESS_PROPERTY);
    if ("1".equals(s)) {
        return mapping.findForward("process");
    }

    // Call browse initialization
    ActionForward result = ((BrowseForm)form).initBrowse(mapping, request, response);
    if (result != null)
    	return result;
    
	// Call navigated perform
	super.perform(mapping, form, request, response);

//	tc.finish(">>>>	BROWSE: #1");
    
    //get form
    BrowseForm browseForm = (BrowseForm) form;
    ActionErrors errors = new ActionErrors();
    Object collection = null;
	boolean isCollection = false;
	boolean isCDBC = false;
    //
    try {

        browseForm.validateValues(errors); //

        // Determine browse bean name
        String brName = browseForm.getBrowseBeanName();
        if (brName == null)
        	brName = getBrowseBeanName();
        	
		Class cl = Class.forName(brName);
		Constructor cons = cl.getConstructor(new Class[] {});
		Object bean = cons.newInstance(new Object[] {});
		Object[] filterParams = browseForm.getFilterParams();
		Class filterParamTypes[] = new Class[filterParams.length];
		for (int i = 0; i < filterParams.length; i++) {
			if (filterParams[i] == null)
            	System.out.println(">>>>>> BROWSE ERROR: filterParams [" + i + "]=null");
			filterParamTypes[i] = filterParams[i].getClass();
		}
		Method finder =
			cl.getDeclaredMethod(browseForm.getFinderMethodName(), filterParamTypes);
		collection = finder.invoke(bean, filterParams);

		isCDBC = collection instanceof CDBCResultSet;
		isCollection = collection instanceof Collection;
		if (!isCDBC && !isCollection) {
			collection = new AccessBeanTable((Enumeration)collection);
		}
//		tc.finish(">>>>	BROWSE: #2");

		int rowsOnPage = getRowsOnPage();
		int stdRowsOnPage = 30;
		int overlapRows = getOverlapRows();
        //calculate new page
        int pages = 0;
        if (isCDBC && (collection != null)) {
	        // Special case - unlimited page
	        if (rowsOnPage == -1) {
		        rowsOnPage = ((CDBCResultSet)collection).getRowsCount();
		        if (rowsOnPage < stdRowsOnPage)
		        	rowsOnPage = stdRowsOnPage;
	        }
	        pages = ((CDBCResultSet)collection).getRowsCount() / (rowsOnPage - overlapRows) + 1;
        	request.setAttribute("numberOfLines", new Integer(((CDBCResultSet)collection).getRowsCount()).toString());
        } else if (isCollection && (collection != null)) {
	        // Special case - unlimited page
	        if (rowsOnPage == -1) {
		        rowsOnPage = ((Collection)collection).size();
		        if (rowsOnPage < stdRowsOnPage)
		        	rowsOnPage = stdRowsOnPage;
	        }
	        pages = ((Collection)collection).size() / (rowsOnPage - overlapRows) + 1;
        	request.setAttribute("numberOfLines", new Integer(((Collection)collection).size()).toString());
        } else if (collection != null) {
	        // Special case - unlimited page
	        if (rowsOnPage == -1) {
		        rowsOnPage = ((AccessBeanTable)collection).numberOfRows();
		        if (rowsOnPage < stdRowsOnPage)
		        	rowsOnPage = stdRowsOnPage;
	        }
	        pages = ((AccessBeanTable)collection).numberOfRows() / (rowsOnPage - overlapRows) + 1;
        	request.setAttribute("numberOfLines", new Integer(((AccessBeanTable)collection).numberOfRows()).toString());
        } else
        	request.setAttribute("numberOfLines", "0");
        
//		tc.finish(">>>>	BROWSE: #2.1");
		
        String action = browseForm.getBrowseAction();
        int page = browseForm.getCurrentPage();
        
        if (Constants.BROWSE_ACTION_BOTTOM.equals(action)) {
            page = 10000;
            browseForm.setBrowseAction("");
        } else
            if (Constants.BROWSE_ACTION_NEXT.equals(action)) {
                page++;
                browseForm.setBrowseAction("");
            } else
                if (Constants.BROWSE_ACTION_PREV.equals(action)) {
                    page--;
                    browseForm.setBrowseAction("");
                } else
                    if (Constants.BROWSE_ACTION_TOP.equals(action)) {
                        page = 1;
                        browseForm.setBrowseAction("");
                    }
        page = (page >= 1) ? page : 1;

        //building display list
        ArrayList displayList = new ArrayList(rowsOnPage);
        int nRecords = 1;
		int startRecord = (page-1) * (rowsOnPage - overlapRows);
		if (startRecord < 0)
			startRecord = 0;
		int endRecord = startRecord + rowsOnPage - 1;
		int curRecord = -1;
		int i = -1;
		int goodRecords = 0;

		if (collection != null) {
			ListIterator cdbcit = null;
			Iterator colIter = null;
			Enumeration colEnum = null;
			if (isCDBC)
				cdbcit = ((CDBCResultSet)collection).listIterator();
			else if (isCollection)
				colIter = ((Collection)collection).iterator();
			else
				colEnum = ((AccessBeanTable)collection).rows();

//			tc.finish(">>>>	BROWSE: #2.2");
			
			//System.out.println(">>>> BROWSE: StartRecord=" + startRecord + ", EndRecord=" + endRecord);	
        	while (true) {
	        	if (isCDBC) {
	        		if (!cdbcit.hasNext())
	        			break;
	        	} else if (isCollection) {
	        		if (!colIter.hasNext())
	        			break;
	        	} else {
	        		if (!colEnum.hasMoreElements())
	        			break;
	        	}
	        	curRecord++;
	        	int curPage = curRecord / (rowsOnPage - overlapRows) + 1;
				if (page == (curPage-1))
					curPage = page;

	        	// Calculate display index
	        	i = rowsOnPage - curPage * (rowsOnPage-overlapRows) + curRecord - overlapRows;

	        	//System.out.println(">>>> BROWSE: CurRecord=" + curRecord + ", curPage=" + curPage + ", i=" + i);
	        		
	        	Object arec = null;
	        	if (isCDBC)
	        		arec = cdbcit.next();
	        	else if (isCollection)
	        		arec = colIter.next();
	        	else
	        		arec = colEnum.nextElement();
	        		
	        	if ((curRecord >= startRecord) && (curRecord <= endRecord)) {
		        	Object brec = ((BrowseForm)form).constructRowModelBean(arec);
		        	if (brec == null)
		        		brec = constructRowModelBean(arec);
		        	try {
	        			displayList.set(i, brec);
		        	} catch (java.lang.IndexOutOfBoundsException ee) {
		        		displayList.add(i, brec); // Store current element
		        	}
	        		goodRecords++;
	        	} else {
		        	try {
		        		displayList.set(i, arec); // Store current element
		        	} catch (java.lang.IndexOutOfBoundsException ee) {
		        		displayList.add(i, arec); // Store current element
		        	}
	        	}
	        	// Check end of page
	        	if (curRecord == endRecord)
	        		break;

        	}

//			tc.finish(">>>>	BROWSE: #2.3");
        	//System.out.println(">>>> BROWSE: GoodRecords=" + goodRecords);
        	boolean needConstruct = false;
        	
			// Check if we are after end page
			if ((goodRecords == 0) && (curRecord < startRecord)) {
				goodRecords = i+1;
				//page = (curRecord + overlapRows) / rowsOnPage + 1;
		        page = curRecord / (rowsOnPage - overlapRows) + 1;
		        needConstruct = true;
			}
			// Check end page
			for (int j = (rowsOnPage-1); j >= goodRecords; j--) {
				try {
					displayList.remove(j);
			    } catch (java.lang.IndexOutOfBoundsException ee) {
				    // Nothing to remove
			    }
			}

			// Construct unconstructed objects
			if (needConstruct) {
        		//System.out.println(">>>> BROWSE: Constructing last page objects");
				for (int k = 0; k < displayList.size(); k++) {
					Object arec = displayList.get(k);
		        	Object brec = ((BrowseForm)form).constructRowModelBean(arec);
		        	if (brec == null)
		        		brec = constructRowModelBean(arec);
	        		displayList.set(k, brec);
				}
			}

			//pages = page;
			
		} else {
			collection = new Vector().elements();
		}
		
//		tc.finish(">>>>	BROWSE: #3");
    	
        browseForm.setCurrentPage(page);
        if (displayList.size() == 0)
        	displayList.add(null);
        request.setAttribute("browseList", displayList);
        request.setAttribute("numberOfPages", new Integer(pages));
        if (!errors.empty()) 
        	saveErrors(request, errors);
    } catch (Exception e) {
        browseForm.setCurrentPage(0);
        Vector displayList = new Vector();
        displayList.add(null);
        request.setAttribute("browseList", displayList);
        request.setAttribute("numberOfPages", new Integer(0));
        if (!errors.empty()) {
            System.out.println("Error while check form:");
        } else {
            System.out.println("Error while constructing list:");
            e.printStackTrace(System.out);
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
        }
        saveErrors(request, errors);
        //throw new ServletException( "While constructing list: ", e );
    }
    // Memory collection Debug
    //System.gc();
    return mapping.findForward( "main" );
}
}
