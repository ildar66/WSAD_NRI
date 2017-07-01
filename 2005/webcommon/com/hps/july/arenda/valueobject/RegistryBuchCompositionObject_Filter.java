/*
 * Created on 16.03.2007
 *
 * ���������� ������ ���������� ������(typeRegistryDoc) ����.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.util.*;

/**
 * @author IShaffigulin
 *
 * ���������� ������ ���������� ������(typeRegistryDoc) ����.
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
	 * ���������� ������ ���������� ������(typeRegistryDoc) ����.
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
