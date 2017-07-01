package com.hps.july.persistence;

/**
 * Insert the type's description here.
 * Creation date: (27.06.2002 15:34:45)
 * @author: Oleg Gashnikov
 */
public class PersistenceUtil {
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:20:46)
 * @return java.math.BigDecimal
 * @param val java.math.BigDecimal
 */
public static java.math.BigDecimal dec(java.math.BigDecimal val, int scale ) {
	return (val==null)? val: val.setScale( scale, java.math.BigDecimal.ROUND_HALF_UP );
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 17:30:37)
 * @return java.util.HashMap
 * @param statement java.lang.String
 */
public static java.util.HashMap getAliasesMap(String statement) {
	java.util.HashMap ret = new java.util.HashMap();
	statement = statement.toUpperCase();
	int fromIdx = statement.indexOf(" FROM ");
	fromIdx += 6;
	int whereIdx = statement.indexOf( " WHERE ", fromIdx );
	whereIdx = (whereIdx>0)? whereIdx: statement.length();
	
	String s = statement.substring( fromIdx, whereIdx );
	java.util.StringTokenizer st = new java.util.StringTokenizer( s, "," );
	while( st.hasMoreTokens() ) {
		String pair = st.nextToken();
		java.util.StringTokenizer stt = new java.util.StringTokenizer( pair, " ", false );
		ret.put( stt.nextToken().trim(), stt.nextToken().trim() );
	}
	return ret;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 15:36:19)
 * @return int
 * @param statement java.lang.String
 * @param field java.lang.String
 */
public static int getFieldIndex(String statement, String field) {
	statement = statement.toUpperCase();
	field = field.toUpperCase();
	java.util.StringTokenizer st = new java.util.StringTokenizer( statement, ",", false );
	int idx = 1;
	boolean scippedMode = false;
	while( st.hasMoreTokens() ) {
		String s = st.nextToken();
		if( scippedMode ) {
			if( s.indexOf( "UNION ALL (" ) >= 0 ) {
				scippedMode = false;
				s = s.substring(s.indexOf( "UNION ALL (" ));
				idx = 1;
			} else {
				continue;
			}
		}
		if( s.indexOf( " FROM " ) >= 0 ) {
			if( s.indexOf( "UNION ALL (" ) < 0 ) {
				scippedMode = true;
				s = s.substring(1, s.indexOf( " FROM " ));
				if( s.indexOf( field ) >= 0 ) {
					return idx;
				}
			} else {
				String ss =  s.substring(1, s.indexOf( " FROM " ));
				if( ss.indexOf( field ) >= 0 ) {
					return idx;
				}
				idx = 1;
				s = s.substring(s.indexOf( "UNION ALL (" ));
				if( s.indexOf( field ) >= 0 ) { 
					return idx;
				}
			}
			continue;
		}
		if( s.indexOf( field ) >= 0 ) {
			return idx;
		}
		idx++;
	}
	return -1;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 19:09:59)
 * @param args java.lang.String[]
 */
public static void main(String[] args) {
	//int i = getFieldIndex( "(select T1.x, T2.y, dsf, sfg from q, ert where d2>5 ) union all (select d2, a3, ff from qqq)", 
		//"sfg" ); 
	//i = 1;

	java.util.HashMap map = getAliasesMap( "select adsf,eaf,esaf,sadf from wer q, dfv qq" );
	//map = map;
	}
}
