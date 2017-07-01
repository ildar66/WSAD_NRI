package com.hps.july.basestation.actionbean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.basestation.APPStates;
import com.hps.july.basestation.formbean.PositionOnMapForm;
import com.hps.july.constants.Applications;
import com.hps.july.web.util.NavigatedAction;
import com.hps.july.web.util.ParamsParser;
//import com.mapinfo.mapj.MapJ;
//import com.mapinfo.util.DoublePoint;
//import com.mapinfo.util.DoubleRect;

/**
 * Обработчик перехода на показ позиций на карте
 *
 * @deprecated
 */
public class PositionOnmapAction
	extends NavigatedAction
{
/*	
private int findInfoPosition(HashMap positions, MapJ map, int x, int y) {
    try {
	    DoublePoint dp = map.transformScreenToNumeric(new DoublePoint(x,y));
        double x1 = dp.x;
        double x2 = map.transformScreenToNumeric(new DoublePoint(x+20,y)).x;
        if(x1<0 || x2<0){
	        x2=-x2;
	        x1=-x1;
        }
  		double distance = x2-x1;
  		Iterator keys = positions.keySet().iterator();
        while(keys.hasNext()){
	        Object key = keys.next();
	        DoubleRect dr = new DoubleRect((DoublePoint)positions.get(key), distance, distance);
	        if(dr.contains(dp, true))
		        return ((Integer)key).intValue();
        }       
    } catch (Exception ex) {
        System.out.println("Error in MapBySelectedID.findInfoPosition "
	        + ex.getClass().getName() + ": " + ex.getMessage());
    }
    return -1;
}
*/
 
/*    
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    super.perform(mapping, form, request, response);
    System.out.println("PositionOnMapActionIn");

		HttpSession session = request.getSession();
		session.setAttribute("mapState", "0");
		session.setAttribute("mapbyPositionState", "1");

		String positionMenu = request.getParameter("positionMenu");
		if(positionMenu != null && positionMenu.equals("0")) session.setAttribute("positionMenu", "0");
		else session.setAttribute("positionMenu", "1");		
    
	PositionOnMapForm mapForm = (PositionOnMapForm) form;
    
    String whatToDo = mapForm.getWhatToDo();
    if (whatToDo.equals("position")) {// если было выбрано действие показать инф по позиции
        boolean process = true;
        int x = 0, y = 0;
        try {
            x = Integer.parseInt(request.getParameter("mapimage.x"));
            y = Integer.parseInt(request.getParameter("mapimage.y"));
        } catch (NumberFormatException ex) {
            process = false;
        } catch (NullPointerException ex) {
            process = false;
        }
        if (process) {// если определились координаты
            MapJ map = (MapJ) session.getAttribute("mapBySelectedID");
            HashMap positions = (HashMap) session.getAttribute("positionsBySelectedID");
            int storagePlace = findInfoPosition(positions, map, x, y);
            if (storagePlace != -1){// если была найдена такая позиция на карте по координатам
	            ActionForward af = mapping.findForward("viewPosition");
	            String path = af.getPath().substring(0, 27)+"&storageplace="+storagePlace;
	            System.out.println("PositionOnMapAction ForwardPath="+path);
	            af.setPath(path);
                return af; // путь с параметром к EditPosition.do
            } else {// Не попали по станции
	            session.setAttribute("positionMenu", "0");// Чтобы вернуть картинку из кеша
	            ActionErrors errors = new ActionErrors();
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.positionNotFound"));
                saveErrors(request, errors);
                ParamsParser.setState(request, Applications.BASESTATION, APPStates.POSITIONSONMAP);
                return mapping.findForward("main");
            }
        } else {// координаты не определились, это был клик с навигатора	        
	        ParamsParser.setState(request, Applications.BASESTATION, APPStates.POSITIONSONMAP);
            return mapping.findForward("main");
        }
    } else {
        ParamsParser.setState(request, Applications.BASESTATION, APPStates.POSITIONSONMAP);
        return mapping.findForward("main");
    }
}
*/

}
