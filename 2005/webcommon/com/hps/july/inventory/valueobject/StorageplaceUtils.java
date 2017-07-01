package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс.
 * Содержит методы для получения наименований позиции или склада
 * а так же методы ля определения типа хранилища
 */
public class StorageplaceUtils {
	public static final int TYPE_UNKNOWN = 0;
	public static final int TYPE_POSITION = 1;
	public static final int TYPE_STORAGE = 2;
	public static final int TYPE_EQUIPMENT = 3;
	public static final int TYPE_EXPEDITOR = 4;
	public static final int TYPE_ORGANIZATION = 5;
public static String getPositionName(PositionAccessBean p) {
	try {
		String name = "";
		if(p.getGsmid() != null) {
			name += "D"+p.getGsmid()+" ";
		}
		if(p.getDampsid() != null) {
			name += "A"+p.getDampsid()+" ";
		}
		name += p.getName();
		return name;
	} catch(Exception e) {
		return "";
	}
}
public static String getStorageplaceName(StoragePlaceAccessBean sp) {
	String name = "";
	try {
		sp.refreshCopyHelper();

		com.hps.july.cdbc.objects.CDBCDocuments d = new com.hps.july.cdbc.objects.CDBCDocuments();
		name = d.getFullStorageName(new Integer(sp.getStorageplace()));
/*
		if(sp.getEJBRef() instanceof Storage) {
			name = sp.getName();
		} else
		if(sp.getEJBRef() instanceof Position) {
			PositionAccessBean p = new PositionAccessBean(sp.getEJBRef());
			p.refreshCopyHelper();
			name = getPositionName(p);
		} else
		if(sp.getEJBRef() instanceof EquipmentSet) {
			EquipmentSetAccessBean e = new EquipmentSetAccessBean(sp.getEJBRef());
			e.refreshCopyHelper();
			PositionAccessBean p = e.getPosition();
			name = getPositionName(p);
//			name += "/" + com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(e);
		} else
		if(sp.getEJBRef() instanceof Expedition) {
			ExpeditionAccessBean exp = new ExpeditionAccessBean(sp.getEJBRef());
			exp.refreshCopyHelper();
			if(exp.getExpeditor() != null) {
				name = exp.getExpeditor().getMan().getFullName();
			} else
			if(exp.getOrganization() != null) {
				name = exp.getOrganization().getName();
			} 
		}
*/
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return name;
}
public static String getStorageplaceNameLite(StoragePlaceAccessBean sp) {
	String name = "";
	try {
		sp.refreshCopyHelper();
		com.hps.july.cdbc.objects.CDBCDocuments d = new com.hps.july.cdbc.objects.CDBCDocuments();
		name = d.getFullStorageName(new Integer(sp.getStorageplace()));
/*
		if(sp.getEJBRef() instanceof Storage) {
			name = sp.getName();
		} else
		if(sp.getEJBRef() instanceof Position) {
			PositionAccessBean p = new PositionAccessBean(sp.getEJBRef());
			p.refreshCopyHelper();
			name = getPositionName(p);
		} else
		if(sp.getEJBRef() instanceof EquipmentSet) {
			EquipmentSetAccessBean e = new EquipmentSetAccessBean(sp.getEJBRef());
			e.refreshCopyHelper();
			PositionAccessBean p = e.getPosition();
			name = getPositionName(p);
//			name += "/" + com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(e);
		} else
		if(sp.getEJBRef() instanceof Expedition) {
			ExpeditionAccessBean exp = new ExpeditionAccessBean(sp.getEJBRef());
			exp.refreshCopyHelper();
			if(exp.getExpeditor() != null) {
				name = exp.getExpeditor().getMan().getFullName();
			} else
			if(exp.getOrganization() != null) {
				name = exp.getOrganization().getName();
			} 
		}
*/
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return name;
}
public static int getStorageplaceType(StoragePlaceAccessBean sp) {
	int type = TYPE_UNKNOWN;
	try {
		sp.refreshCopyHelper();
		javax.ejb.EJBObject o = sp.getEJBRef();
System.out.println("SPType:"+o.getClass().getName());
		if(type == TYPE_UNKNOWN) {
			try {
				Storage s = (Storage)javax.rmi.PortableRemoteObject.narrow(o,Storage.class);
				type = TYPE_STORAGE;
			} catch(Exception e) { }
		}
		if(type == TYPE_UNKNOWN) {
			try {
				Position p = (Position)javax.rmi.PortableRemoteObject.narrow(o,Position.class);
				type = TYPE_POSITION;
			} catch(Exception e) { }
		}
		if(type == TYPE_UNKNOWN) {
			try {
				EquipmentSet es = (EquipmentSet)javax.rmi.PortableRemoteObject.narrow(o,EquipmentSet.class);
				type = TYPE_EQUIPMENT;
			} catch(Exception e) { }
		}
		if(type == TYPE_UNKNOWN) {
			try {
				ExpeditionAccessBean exp = new ExpeditionAccessBean();
				exp.setInitKey_storageplace(sp.getStorageplace());
				exp.refreshCopyHelper();
				if(exp.getExpeditor() != null) {
					type = TYPE_EXPEDITOR;
				} else if(exp.getOrganization() != null) {
					type = TYPE_ORGANIZATION;
				} else {
					type = TYPE_UNKNOWN;
				}
			} catch(Exception e) { }
		}
	} catch(Exception e) {
	}
System.out.println("SPTypeCode:"+type);
	return type;
}
}
