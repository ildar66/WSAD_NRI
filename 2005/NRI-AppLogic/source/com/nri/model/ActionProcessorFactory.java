package com.nri.model;
import java.util.HashMap;
import java.util.Map;

import com.nri.system.AppService;
import com.nri.util.ApplProperties;
import com.nri.system.TraceCapable;
/**
 * Insert the type's description here.
 * Creation date: (2/27/2001 1:45:50 PM)
 * @author: ILS User
 */

public class ActionProcessorFactory {
	private static Map processorCache = null;

	/**
	 * ActionProcessorFactory constructor comment.
	 */
	public ActionProcessorFactory() {
		super();
	}

	/**
	 * Derive the name of the package and class based on the pattern
	 * Creation date: (3/2/2001 4:40:57 PM)
	 * @return String
	 */
	public static String computeActionProcessorClassName(String processorType) {
		String packageName = ApplProperties.PACKAGE_PREFIX + ApplProperties.getModelType().toLowerCase();
		String className = processorType + "ActionProcessorImpl";
		return packageName + "." + className;
	}

	/**
	 * @return adapter to application Model 
	 */
	public static Object getActionProcessor(String name) {
		Object processor = getProcessorCache().get(name);
		if (processor == null) {
			String classname = computeActionProcessorClassName(name);
			Class aClass = null;
			try {
				aClass = Class.forName(classname);
			} catch (ClassNotFoundException e) {
				AppService.log(TraceCapable.ERROR_LEVEL, classname + " not defined...");
			}
			try {
				processor = aClass.newInstance();
				getProcessorCache().put(name, processor);

			} catch (InstantiationException e) {
				AppService.log(TraceCapable.ERROR_LEVEL,e.toString());
			} catch (IllegalAccessException e) {
				AppService.log(TraceCapable.ERROR_LEVEL,e.toString());
			}
		}
		return processor;
	}


	private static Map getProcessorCache() {
		if (processorCache == null)
			processorCache = new HashMap();
		return processorCache;
	}

	public static void resetActionProcessors() {
		processorCache = null;
	}

}