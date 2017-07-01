package applets;
/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.net.*;
import java.util.Iterator;
import java.util.List;
import java.io.*;

public class QueryCollection implements Runnable {
	private Object[][] queries;
	private String[] headers;
	private boolean isDone = false;
	private URL dataURL;

	public QueryCollection(String urlSuffix, URL currentPage) {
		try {
			// Only the URL suffix need be supplied, since
			// the rest of the URL is derived from the current page.
			String protocol = currentPage.getProtocol();
			String host = currentPage.getHost();
			int port = currentPage.getPort();
			dataURL = new URL(protocol, host, port, urlSuffix);
			Thread queryRetriever = new Thread(this);
			queryRetriever.start();
		} catch (MalformedURLException mfe) {
			isDone = true;
		}
	}

	public void run() {
		try {
			retrieveQueries();
		} catch (IOException ioe) {
			queries = null;
			headers = null;
		}
		isDone = true;
	}

	public Object[][] getQueries() {
		return (queries);
	}
	public String[] getHeaders() {
		return (headers);
	}

	public boolean isDone() {
		return (isDone);
	}

	private void retrieveQueries() throws IOException {
		URLConnection connection = dataURL.openConnection();
		// Make sure browser doesn't cache this URL, since
		// I want different queries for each request.
		connection.setUseCaches(false);
		// Use ObjectInputStream so I can read a String[]
		// all at once.
		ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
		try {
			// The return type of readObject is Object, so
			// I need a typecast to the actual type.
			Object[][] queryObject = (Object[][]) in.readObject();
			queries = queryObject;
			headers = new String[]{"1", "2", "3", "4", "5"};//temp
			headers = (String[]) in.readObject();
			//if (queryObject != null && queryObject.length != 0)
				//headers = (String[]) queryObject[queryObject.length - 1];
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	/**
		private void initQueries(List aList) {
			queries = new Object[aList.size()][];
			Iterator iter = aList.iterator();
			int i = 0;
			while (iter.hasNext()) {
				queries[i] = (Object[]) iter.next();
				i++;
			}
		}
	
		private void initHeaders(List aList) {
			headers = new String[aList.size()];
			Iterator iter = aList.iterator();
			int i = 0;
			while (iter.hasNext()) {
				headers[i] = (String) iter.next();
				i++;
			}
		}
	*/
}
