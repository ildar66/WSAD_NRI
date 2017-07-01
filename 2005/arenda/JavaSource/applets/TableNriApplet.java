package applets;
/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Created on 23.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TableNriApplet extends JApplet implements ActionListener {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JTable jTable = null;
	private javax.swing.JScrollPane jScrollPane = null;
	private QueryCollection currentQueries = null;
	private String address = "/arenda/TableNriServlet?table=";
	private URL currentPage = null;
	private JButton startButton;
	private SortFilterModel sorter = null;
	private JComboBox tableNames;
	/**
	 * This is the default constructor
	 */
	public TableNriApplet() {
		super();
		//init();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void init() {
		this.setSize(400, 400);
		/**		
				currentPage = getCodeBase();
				currentQueries = new QueryCollection(address, currentPage);
				while (!currentQueries.isDone()) {
					showStatus("Waiting for data from server...");
					pause(1);
				}
				System.out.println(currentQueries.getQueries().length);
				cells = currentQueries.getQueries();
				this.setContentPane(getJContentPane());
		*/
		jContentPane = new javax.swing.JPanel();
		jContentPane.setLayout(new java.awt.BorderLayout());

		tableNames = new JComboBox();
		//tableNames.addActionListener(this);
		JPanel p = new JPanel();
		p.add(tableNames);
		jContentPane.add(p, BorderLayout.NORTH);
		String[] tables = { "Temp", "roles", "leaseSFstate", "bsprojects", "projectstates", "accounts", "leaseabonentban", "divisions", "people", "kzlregion" };
		for (int i = 0; i < tables.length; i++) {
			tableNames.addItem(tables[i]);
		}

		jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
		//setBackground(Color.white);
		//add(queryArea, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		//Font buttonFont = new Font("SansSerif", Font.BOLD, 16);
		startButton = new JButton("Обновить");
		//startButton.setFont(buttonFont);
		startButton.addActionListener(this);
		//buttonPanel.add(startButton);
		p.add(startButton);
		/**		
				stopButton = new Button("Stop");
				stopButton.setFont(buttonFont);
				stopButton.addActionListener(this);
				buttonPanel.add(stopButton);
				clearButton = new Button("Clear TextArea");
				clearButton.setFont(buttonFont);
				clearButton.addActionListener(this);
				buttonPanel.add(clearButton);
		*/
		jContentPane.add(buttonPanel, BorderLayout.SOUTH);
		this.setContentPane(jContentPane);
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}
	*/
	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private javax.swing.JTable getJTable() {
		if (jTable == null) {
			//jTable = new javax.swing.JTable(cells, columnNames);
			//jTable = new javax.swing.JTable(new InvestmentTableModel(30, 5, 10));

			setUpTableModel();
		}
		return jTable;
	}
	private void setUpTableModel() {
		// set up table model and interpose sorter
		DefaultTableModel model = new DefaultTableModel(cells, columnNames);
		sorter = new SortFilterModel(model);
		// show table
		jTable = new JTable(sorter);
		// set up double click handler for column headers

		jTable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				// check for double click
				if (event.getClickCount() < 2)
					return;

				// find column of click and
				int tableColumn = jTable.columnAtPoint(event.getPoint());

				// translate to jTable model index and sort
				int modelColumn = jTable.convertColumnIndexToModel(tableColumn);
				sorter.sort(modelColumn);
			}
		});

	}

	private void refreshJTable() {
		//jTable = new javax.swing.JTable(cells, new String []{"A","B","C","D","E","F","J","K","L","M"});
		setUpTableModel();
		getJScrollPane().setViewportView(jTable);
		//getJScrollPane().pack();
		//doLayout();
	}
	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			//jScrollPane.getHorizontalScrollBar().setVisible(true);
			//jScrollPane.getHorizontalScrollBar().setAutoscrolls(true);			
			jScrollPane.setViewportView(getJTable());
			//System.out.println(jScrollPane.getVerticalScrollBar().);			
		}
		return jScrollPane;
	}

	private Object[][] cells = { { "Mercury", new Double(2440), new Integer(0), Boolean.FALSE, Color.yellow }, {
			"Venus", new Double(6052), new Integer(0), Boolean.FALSE, Color.yellow }, {
			"Earth", new Double(6378), new Integer(1), Boolean.FALSE, Color.blue }, {
			"Mars", new Double(3397), new Integer(2), Boolean.FALSE, Color.red }, {
			"Jupiter", new Double(71492), new Integer(16), Boolean.TRUE, Color.orange }, {
			"Saturn", new Double(60268), new Integer(18), Boolean.TRUE, Color.orange }, {
			"Uranus", new Double(25559), new Integer(17), Boolean.TRUE, Color.blue }, {
			"Neptune", new Double(24766), new Integer(8), Boolean.TRUE, Color.blue }, {
			"Pluto", new Double(1137), new Integer(1), Boolean.FALSE, Color.black }, {
			"Mercury", new Double(2440), new Integer(0), Boolean.FALSE, Color.yellow }, {
			"Venus", new Double(6052), new Integer(0), Boolean.FALSE, Color.yellow }, {
			"Earth", new Double(6378), new Integer(1), Boolean.FALSE, Color.blue }, {
			"Mars", new Double(3397), new Integer(2), Boolean.FALSE, Color.red }, {
			"Jupiter", new Double(71492), new Integer(16), Boolean.TRUE, Color.orange }, {
			"Saturn", new Double(60268), new Integer(18), Boolean.TRUE, Color.orange }, {
			"Uranus", new Double(25559), new Integer(17), Boolean.TRUE, Color.blue }, {
			"Neptune", new Double(24766), new Integer(8), Boolean.TRUE, Color.blue }, {
			"Pluto", new Double(1137), new Integer(1), Boolean.FALSE, Color.black }, {
			"Mercury", new Double(2440), new Integer(0), Boolean.FALSE, Color.yellow }, {
			"Venus", new Double(6052), new Integer(0), Boolean.FALSE, Color.yellow }, {
			"Earth", new Double(6378), new Integer(1), Boolean.FALSE, Color.blue }, {
			"Mars", new Double(3397), new Integer(2), Boolean.FALSE, Color.red }, {
			"Jupiter", new Double(71492), new Integer(16), Boolean.TRUE, Color.orange }, {
			"Saturn", new Double(60268), new Integer(18), Boolean.TRUE, Color.orange }, {
			"Uranus", new Double(25559), new Integer(17), Boolean.TRUE, Color.blue }, {
			"Neptune", new Double(24766), new Integer(8), Boolean.TRUE, Color.blue }, {
			"Pluto", new Double(1137), new Integer(1), Boolean.FALSE, Color.black }, {
			"Mercury", new Double(2440), new Integer(0), Boolean.FALSE, Color.yellow }, {
			"Venus", new Double(6052), new Integer(0), Boolean.FALSE, Color.yellow }, {
			"Earth", new Double(6378), new Integer(1), Boolean.FALSE, Color.blue }, {
			"Mars", new Double(3397), new Integer(2), Boolean.FALSE, Color.red }, {
			"Jupiter", new Double(71492), new Integer(16), Boolean.TRUE, Color.orange }, {
			"Saturn", new Double(60268), new Integer(18), Boolean.TRUE, Color.orange }, {
			"Uranus", new Double(25559), new Integer(17), Boolean.TRUE, Color.blue }, {
			"Neptune", new Double(24766), new Integer(8), Boolean.TRUE, Color.blue }, {
			"Pluto", new Double(1137), new Integer(1), Boolean.FALSE, Color.black }

	};

	private String[] columnNames = { "String", "Decimal", "Integer", "Boolean", "Color" };
	public void pause(double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException ie) {
		}
	}
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == startButton) {
			//Thread queryDisplayer = new Thread(this);
			//isRunning = true;
			//queryArea.setText("");
			//queryDisplayer.start();
			showStatus("Started display thread...");
			currentPage = getCodeBase();
			String tableName = (String) tableNames.getSelectedItem();

			currentQueries = new QueryCollection(address + tableName, currentPage);
			while (!currentQueries.isDone()) {
				showStatus("Waiting for data from server...");
				pause(1);
			}
			System.out.println(currentQueries.getQueries().length);//temp
			cells = currentQueries.getQueries();
			columnNames = currentQueries.getHeaders();
			//this.setContentPane(getJContentPane());
			//jScrollPane.setViewportView(new javax.swing.JTable(cells, columnNames));
			refreshJTable();
		}
		/**	  else if (event.getSource() == stopButton) {
				isRunning = false;
				showStatus("Stopped display thread...");
			  } else if (event.getSource() == clearButton) {
				queryArea.setText("");
			  }
		*/
	}
}
