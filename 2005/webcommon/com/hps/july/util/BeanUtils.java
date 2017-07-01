package com.hps.july.util;

import java.lang.reflect.*;

/**
 * Утилиты для работы с beans.
 * Creation date: (22.02.2002 16:17:17)
 * @author: Oleg Gashnikov
 */
public class BeanUtils {
/**
 * BeanUtils constructor.
 */
private BeanUtils() {
	super();
}
/**
 * Копирование одноименных свойств двух beans.
 * Creation date: (22.02.2002 16:20:47)
 * @param dest java.lang.Object
 * @param orig java.lang.Object
 */
public static void copyProperties(Object dest, Object orig) throws InvocationTargetException, IllegalAccessException {
	if ( (dest != null) && (orig != null) ) {
		Class origClass = orig.getClass();
		Class destClass = dest.getClass();
		Method methods[] = origClass.getMethods();
		for( int i = 0; i < methods.length; i++ ) {
			String methodName = methods[i].getName();
			if( methodName.indexOf( "get" ) != 0 || methods[i].getParameterTypes().length != 0 )
				continue;
			try {
				Method setter = destClass.getMethod( "set"+methodName.substring( 3 ), 
					new Class[] { methods[i].getReturnType() } );
				if ("java.lang.String".equals(methods[i].getReturnType().getName())) {
					String s = (String)methods[i].invoke( orig, new Object[] {} );
					if ((s != null) && (s.length() == 0))
						s = null;
					setter.invoke( dest, new Object[] {s} );
				} else
					setter.invoke( dest, new Object[] { methods[i].invoke( orig, new Object[] {} ) } );
			} catch( NoSuchMethodException e ) {
				continue;
			}
		}
	}
}
}
