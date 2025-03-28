package com.hps.july.cdbc.lib;

import java.util.*;
import java.sql.*;
import javax.sql.*;
//import com.hps.july.util.*;
import com.hps.july.jdbcpersistence.lib.*;  
 
/**
 * ���������� ��������� �������.
 * Creation date: (10.03.2004 13:53:20)
 * @author: Dmitry Dneprov
 */
public class CDBCResultSet {
	HashMap headers = new HashMap();
	LinkedList results = new LinkedList();
	private int calculatedColumnsCount;
	private boolean queryExecuted;
/**
 * CDBCResultSet constructor.
 */
public CDBCResultSet() {
	super();
	calculatedColumnsCount = 0;
	queryExecuted = false;
}
/**
 * ��������� ����������� ������� � ���������.
 * Creation date: (10.03.2004 14:40:27)
 * @param colName String
 */
public void addCalculatedColumn(String colName) throws java.lang.IllegalStateException {
	if (queryExecuted)
		throw new java.lang.IllegalStateException("Query already executed");
	int index = headers.size();
	headers.put(colName, new Integer(index));
	calculatedColumnsCount++;
}
/**
 * ��������� ����������� ������� � ������ ������.
 * Creation date: (16.03.2004 11:51:33)
 */
private void addCalculatedColumns(CDBCRowObject ro) throws java.sql.SQLException {
			for (int i = 0; i < calculatedColumnsCount; i++) {
				ro.addColumn(null);
			}
}
/**
 * ���� ����� ��������� ������ � �� � �������� ����������.
 * Creation date: (10.03.2004 14:24:04)
 */
public void executeQuery(String acommand, Object [] aparams)  throws java.lang.IllegalStateException {
	executeQuery(acommand, aparams, 0);
}
/**
 * ���� ����� ��������� ������ � �� � �������� ����������.
 * Creation date: (10.03.2004 14:24:04)
 */
public void executeQuery(String acommand)  throws java.lang.IllegalStateException {
	executeQuery(acommand, null, 0);
}
/**
 * ���� ����� ��������� ������ � �� � �������� ���������� c ������������ �������.
 * Creation date: (10.03.2004 14:24:04)
 */
public void executeQuery(String acommand, Object [] aparams, int amaxRows) throws java.lang.IllegalStateException {
	Connection con = null;
	try {
		JdbcConnection jcon = new JdbcConnection();
		con = jcon.getConnection();
		executeQuery(con, acommand, aparams, amaxRows);
	} catch (Exception ee) {
		ee.printStackTrace(System.out);
	} finally {
			try {
				con.close();
			} catch (Exception e) {
				// Ignore error
			}
	}
}
/**
 * ���� ����� ��������� ������ � �� � �������� ���������� c ������������ �������.
 * Creation date: (10.03.2004 14:24:04)
 */
public void executeQuery(Connection con, String acommand, Object [] aparams, int amaxRows) throws java.lang.IllegalStateException {
	if (queryExecuted)
		throw new java.lang.IllegalStateException("Query already executed");

	//System.out.println(	"CDBC SQL:" + acommand );
	//TimeCounter tc = new TimeCounter("CDBC");
	//tc.start();
	queryExecuted = true;
		
	try {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSetMetaData rmd = null;
		try {
			pst  = con.prepareStatement(acommand);
			// Set query params
			setQueryParams(pst, aparams);
			
			rs = pst.executeQuery();
			rmd = rs.getMetaData();

			makeColumnNames(rmd);
			
			// Extract results
			int colCount = rmd.getColumnCount();
			int resRowsCount = 0;
			//tc.finish("Before firstnext");
			//tc.start();
			while (rs.next()) {
				CDBCRowObject ro = new CDBCRowObject(headers);
				addCalculatedColumns(ro);
				for (int i=1; i <= colCount; i++) 
					ro.addColumn(rs.getObject(i));
				results.addLast(ro);
				resRowsCount++;
				if (amaxRows != 0 && resRowsCount >= amaxRows)
					break;
			}
			//tc.finish("After lastnext");
		} finally {
			try {
				pst.close();
			} catch (Exception e) {
				// Ignore error
			}
		}
    } catch (SQLException e) {
		System.out.println(	"CDBC SQL:" + acommand );
        System.out.println("ERROR SQLCode=" + e.getErrorCode() + ", message=" + e.getMessage());
        e.printStackTrace(System.out);
    } catch (Exception ee) {
        System.out.println("ERROR message=" + ee.getMessage());
        ee.printStackTrace(System.out);
	}
}
    /**
     * ���� ����� ��������� ������ �� ���������� � ��.
     * Creation date: (10.03.2004 14:24:04)
     */
    public boolean executeUpdate(String acommand, Object [] aparams) {
	    boolean result = false;
		Connection con = null;
		try {
			JdbcConnection jcon = new JdbcConnection();
			con = jcon.getConnection();
			result = executeUpdate(con, acommand, aparams);
		} catch (Exception ee) {
			ee.printStackTrace(System.out);
		} finally {
				try {
					con.close();
				} catch (Exception e) {
					// Ignore error
				}
		}
        return result;
    }
    /**
     * ���� ����� ��������� ������ �� ���������� � ��.
     * Creation date: (10.03.2004 14:24:04)
     */
    public boolean executeUpdate(Connection con, String acommand, Object [] aparams) {
        boolean result = false;
        //System.out.println(	"CDBC SQL:" + acommand );
        //TimeCounter tc = new TimeCounter("CDBC");
        //tc.start();

        PreparedStatement pst = null;
        try {
            pst  = con.prepareStatement(acommand);
            // Set query params
            setQueryParams(pst, aparams);
            pst.executeUpdate();
            result = true;
            //tc.finish("After update");
        } catch (SQLException e) {
			System.out.println("CDBC SQL:" + acommand);
            System.out.println("ERROR SQLCode=" + e.getErrorCode() + ", message=" + e.getMessage());
        } catch (Exception ee) {
            System.out.println("ERROR message=" + ee.getMessage());
        } finally {
            try {pst.close();} catch (Exception e) {}
        }
        return result;
    }
/**
 * ���������� ���������� ����� � ����������.
 * Creation date: (10.03.2004 14:42:21)
 * @return int
 */
public int getRowsCount() {
	return results.size();
}
/**
 * ���������� �������� ��� �������� �� ������� �������.
 * Creation date: (16.03.2004 11:51:33)
 */
 public ListIterator listIterator() {
		return results.listIterator();
	}
/**
 * ������� ����� ������� �� ����������.
 * Creation date: (16.03.2004 11:51:33)
 */
private void makeColumnNames(ResultSetMetaData rmd) throws java.sql.SQLException {
			int colCount = rmd.getColumnCount();
			// Make column names
			for (int i = 0; i < colCount; i++) {
                String colName = rmd.getColumnName(i+1);
                if ("(expression)".equalsIgnoreCase(colName)) {
	                // This is returned from Stored Procedure - Change to 'colNNN'
	                String newColName = "col" + (i+1);
					headers.put(newColName, new Integer(i + calculatedColumnsCount));
                } else
					headers.put(colName.toLowerCase(), new Integer(i + calculatedColumnsCount));
			}
}
/**
 * ��������� ���������� �������.
 * Creation date: (10.03.2004 14:58:39)
 * @param apst java.sql.PreparedStatement
 * @param aparams java.sql.Array
 */
private void setQueryParams(PreparedStatement apst, Object [] aparams) throws java.sql.SQLException {
	if (aparams != null) {
		for (int i=0; i< aparams.length; i++) {
			if (aparams [i] != null)
				apst.setObject(i+1, aparams [i]);
			else
				apst.setNull(i+1, java.sql.Types.CHAR);
		}
	}
}
}
