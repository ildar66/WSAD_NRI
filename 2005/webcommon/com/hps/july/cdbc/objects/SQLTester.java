/*
 * Created on 19.03.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SQLTester {
	private StringBuffer sqlb;
	private LinkedList params;
	
	public SQLTester(StringBuffer s, LinkedList p){
		setSQLInfo(s,p);
	}
	
	public void setSQLInfo(StringBuffer s, LinkedList p){
		sqlb = s;
		params = p;
	}
	
	public String printSizes(){
		int qcount = 0;
		char[] chars = sqlb.toString().toCharArray();
		for (int i=0; i< chars.length; i++)
			if (chars[i]=='?') qcount++;
		return "question marks count = "+qcount+" | params count = "+params.size();
	}
	
	public String printSQL(){
		int pos;
		StringBuffer buffer = new StringBuffer(sqlb.toString());
		if (params!=null){
			for (int i=0; i<params.size(); i++){
				String result=buffer.toString();
				pos = result.indexOf("?");
				
				buffer.replace(pos,pos+1,params.get(i).toString());
			}
		}
		return buffer.toString();
	}
}
