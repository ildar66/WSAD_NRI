/*
 * Created on 17.01.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.util.LinkedList;
import java.util.ListIterator;


/**
 * ����� ��� ���������� ������ ������� SQL-��������
 * Creation date: (19.01.2007 12:19:35)
 * @author: Alexander Ermolov
 */
public class SQLClauseBuilder {
	LinkedList clauses;
	LinkedList params;
	String glueoption;
	boolean brackets;
	public SQLClauseBuilder(){
		super();
		clauses = new LinkedList();
		params = new LinkedList();
		brackets = false;
		glueoption = "AND";
	}
	/**
	 * �������� ������� � �������� ��������� �������
	 */
	
	private String processWildcards(String param){
		param=param.replace('*','%');
		return param;
	}
	public void addClause(String clause){
		clauses.add(clause);
	}
	public void addParametrizedClause(String clause, Object param){
		if (param instanceof String){
			String value = (String) param; 
			if (value.length()>0)
				value=processWildcards(value);
			clauses.add(clause);
			params.add(value);
		}
		else if (param instanceof Integer){
			Integer value = (Integer)param; 
			if (value.intValue() != 0){ 
				clauses.add(clause);
				params.add(value);
			}
		}
	}
	/**
	 * �������� �������/��������� ������� � ������ �������� ��������������� 
	 * ����������
	 */
	public void addParametrizedClause(String clause, LinkedList otherparams){
		if (!otherparams.isEmpty()){
			clauses.add(clause);
			params.addAll(otherparams);
		}
	}
	/**
	 * ������ ������ ����������� �������
	 */
	public void setGlueOption(String option){
		glueoption = option;
	}
	/**
	 * ��������� ��������� � ������
	 */
	public void setBrackets(boolean newBrackets){
		brackets = newBrackets;
	}
	/**
	 * ���������� ������ ������ �������
	 */
	public String glueClauses(){
		String result = "";
		if (clauses.size()>0){
			ListIterator it = clauses.listIterator();
			while (it.hasNext()){
				result += it.next()+ " " + glueoption + " ";
			}
			result = result.substring(0,result.length()-(glueoption+" ").length());
			if (brackets) result = "("+result+")";
		}
		return result;
	}
	/**
	 * ������/�������� ������ �������/����������
	 */
	public boolean isEmpty(){
		//return (params.size()==0);
		return (clauses.size()==0);
	}
	/**
	 * ���������� ������ �������� ���������� � ���� ������� ��������
	 */
	public Object[] getParamsAsArray(){
		return params.toArray();
	}
	/**
	 * ���������� ������ �������� ���������� � ���� ���������� ������
	 */
	public LinkedList getParams(){
		return params;
	}
	public String toString(){
		String res = glueClauses();
		StringBuffer resb;
		int i;
		ListIterator it = params.listIterator();
		while (it.hasNext()){
			String param = String.valueOf(it.next());
			i = res.indexOf("?");
			resb = new StringBuffer(res);
			resb.replace(i,i+1,param);
			res = resb.toString();
		}
		return res;
	}
}