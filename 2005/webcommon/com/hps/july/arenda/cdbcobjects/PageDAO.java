package com.hps.july.arenda.cdbcobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.sql.DataSource;
import javax.sql.RowSet;
import com.hps.july.jdbcpersistence.lib.TimeCounter;
import com.hps.july.util.*;
/**
 * @author Shafigullin Ildar
 * Базовый класс для DAO-objects.
 */
public abstract class PageDAO {
	/**
	 * 
	 * @param searchCriteria
	 * @param start
	 * @param count
	 * @param orderBy
	 * @return
	 * @throws SQLException
	 * @throws ServiceLocatorException
	 */
	public Page executeSelect(Object searchCriteria, int start, int count, String orderBy) throws SQLException, ServiceLocatorException {
		Connection conn = null;
		Page page = null;
		try {
			conn = getDataSource().getConnection();
			page = executeSelect(conn, searchCriteria, start, count, orderBy);
		} catch (SQLException e) {
			System.out.println("SQLException PageDao.executeSelect: ");
			System.out.println("ERROR: code=" + e.getErrorCode() + ", msg=" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (ServiceLocatorException exc) {
			System.out.println("ServiceLocatorException PageDao.executeSelect: " + exc);
			exc.printStackTrace();
			throw exc;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception exc) {
				System.out.println("PageDao.executeSelect: не могу закрыть соединение!!!");
			}
		}
		return page;
	}
	/**
	 * 
	 * @param con
	 * @param searchCriteria
	 * @param start
	 * @param count
	 * @param orderBy
	 * @return
	 * @throws SQLException
	 */

	public Page executeSelect(Connection con, Object searchCriteria, int start, int count, String orderBy) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Page page = null;
		TimeCounter counter = new TimeCounter("PERF.PageDAO");
		try {
			ps = con.prepareStatement(getSearchSQLString(searchCriteria, orderBy), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			initQueryParams(ps, getQueryParams(searchCriteria));

			//start counter:
			counter.start();

			rs = ps.executeQuery();

			//counter end executeQuery:
			counter.finish("executeQuery");

			//start counter:
			counter.start();

			// determine the number of columns from the mete data        
			int numberOfColumns = rs.getMetaData().getColumnCount();
			ArrayList headers = new ArrayList(numberOfColumns);
			for (int i = 0; i < numberOfColumns; i++) {
				headers.add(rs.getMetaData().getColumnName(i + 1));
			}

			if (start >= 0 && rs.absolute(start + 1)) {
				boolean hasNext = false;
				List items = new LinkedList();
				do {
					items.add(populateRow(rs, numberOfColumns));
				} while ((hasNext = rs.next()) && (--count > 0));
				page = new Page(headers, items, start, hasNext);
			} else {
				//page = Page.EMPTY_PAGE;
				page = new Page(headers, Collections.EMPTY_LIST, 0, false);
			}

		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		}

		//counter end executeQuery:
		counter.finish("populateRow");

		return page;
	}
	/**
	 * 
	 * @return
	 * @throws ServiceLocatorException
	 */

	protected javax.sql.DataSource getDataSource() throws ServiceLocatorException {
		//нужно грузить из настроек (пока так):
		ServiceLocator sl = new ServiceLocator();
		return (DataSource) sl.getDataSource(JNDINames.INFORMIX_DATASOURCE);
	}
	/**
	 * 
	 * @param projCriteria
	 * @param orderBy
	 * @return
	 */
	protected abstract String getSearchSQLString(Object projCriteria, String orderBy);
	/**
	 * 
	 * @param rs
	 * @param numberOfColumns
	 * @return
	 * @throws SQLException
	 */
	protected Object populateRow(ResultSet rs, int numberOfColumns) throws SQLException {
		Object[] values = new Object[numberOfColumns];
		// Read values for current row and save
		// them in the values array
		for (int i = 0; i < numberOfColumns; i++) {
			Object columnValue = rs.getObject(i + 1);
			values[i] = columnValue;
		}
		return values;
	}
	/**
	 * 
	 * @param apst
	 * @param aparams
	 * @throws java.sql.SQLException
	 */

	protected void initQueryParams(PreparedStatement apst, Object[] aparams) throws java.sql.SQLException {
		if (aparams != null) {
			for (int i = 0; i < aparams.length; i++) {
				apst.setObject(i + 1, aparams[i]);
			}
		}
	}
	/**
	 * 
	 * @return
	 */
	protected Object[] getQueryParams(Object objCriteria) {
		return null;
	}
}
