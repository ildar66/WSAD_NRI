package com.hps.july.inventory.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author dimitry
 * Created 12.04.2006
 */
public class MountActDocPositionListBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List docPositions = new ArrayList();
	private MountActDocPositionBean parent;
	
	private Map sortedDocPositions = new HashMap();
	private boolean sortedCache = false;
	
	public MountActDocPositionListBean(MountActDocPositionBean parent) {
		this.parent = parent;
	}
	
	
	
	public MountActDocPositionBean get(int index){
		sortedCache = false;
		
		if (index+1 > docPositions.size()){
			for (int i = docPositions.size(); i < index+1; i++){
				MountActDocPositionBean bean = new MountActDocPositionBean();
				bean.setIndex(i);
				bean.setParent(parent);
				docPositions.add(bean);
			}
		}
		return (MountActDocPositionBean) docPositions.get(index);
	}
	
	public void set(int index, MountActDocPositionBean docPosition){
		sortedCache = false;
		
		if (index+1 > docPositions.size()){
			for (int i = docPositions.size(); i < index+1; i++){
				MountActDocPositionBean bean = new MountActDocPositionBean();
				bean.setIndex(i);
				bean.setParent(parent);
				docPositions.add(bean);
			}
		}
		docPosition.setIndex(index);
		docPositions.set(index, docPosition);
	}
	
	public void add(MountActDocPositionBean docPosition){
		sortedCache = false;
		
		docPosition.setParent(parent);
		docPosition.setIndex(docPositions.size());
		docPositions.add(docPosition);
		
//		System.out.println("add: " + docPosition + ", size=" + docPositions.size());
	}
	
	public void remove(int index){
		sortedCache = false;
		
		for (int i=index; i<docPositions.size(); i++){
			MountActDocPositionBean bean = (MountActDocPositionBean) docPositions.get(i);
			bean.setIndex(i-1);
		}
		
		docPositions.remove(index);
//		System.out.println("remove: " + index + ", size=" + docPositions.size());
	}
	
	private void sortDocPositions(){
		sortedDocPositions.clear();
		
//		System.out.println("docPositions: size=" + docPositions.size() + " values=" + docPositions);
		
		for (int i=0; i<docPositions.size(); i++){
			MountActDocPositionBean docPositionBean = (MountActDocPositionBean) docPositions.get(i);
			Integer categoryId = docPositionBean.getCategoryId();
			
			//if (categoryId == null) categoryId = new Integer(-1);
			
			List sortedDocPositionList = (List) sortedDocPositions.get(categoryId);
			if (sortedDocPositionList == null) sortedDocPositionList = new ArrayList();
			
			sortedDocPositionList.add(docPositionBean);
			sortedDocPositions.put(categoryId, sortedDocPositionList);
		}

//		System.out.println("sortedDocPositions: " + sortedDocPositions);
		
		sortedCache = true;
	}
	
	public Map getCategoryDocPositions(){
		if (!sortedCache) sortDocPositions();
		return sortedDocPositions;		
	}
	
	public Iterator getCategoryDocPositions(int categoryId){
		if (!sortedCache) sortDocPositions();
		List sortedDocPositionList = (List) sortedDocPositions.get(new Integer(categoryId));
		if (sortedDocPositionList == null) return new ArrayList().iterator();
		return sortedDocPositionList.iterator();
	}
	
	public Iterator getDocPositions() {
		return docPositions.iterator();
	}

	public int size() {
		return docPositions.size();
	}

	public MountActDocPositionBean getParent() {
		return parent;
	}
	public void setParent(MountActDocPositionBean parent) {
		this.parent = parent;
	}
}
