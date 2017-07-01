/*
 * Created on 16.03.2007
 *
 * ¬озвращает список документов одного(typeRegistryDoc) типа.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.util.*;

/**
 * @author IShaffigulin
 *
 * ¬озвращает список документов одного(typeRegistryDoc) типа.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RegistryBuchCompositionObject_Filter {

	/**
	 * 
	 */
	public RegistryBuchCompositionObject_Filter() {
		super();
	}

	/**
	 * ¬озвращает список документов одного(typeRegistryDoc) типа.
	 * @param iterator
	 * @param typeRegistryDoc
	 * @return
	 */
	public static List apply(ListIterator iterator, Integer typeRegistryDoc) {
		ArrayList answer = new ArrayList();
		while (iterator.hasNext()) {
			RegistryBuchCompositionObject_TO to = (RegistryBuchCompositionObject_TO) iterator.next();
			if (typeRegistryDoc.equals(to.getTypeComposition())) {
				answer.add(to);
			}
		}
		return answer;
	}

}
