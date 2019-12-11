import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*;
import java.util.*;
import javax.swing.table.*;

class MainGUI extends JFrame implements ActionListener { 
  static MainGUI maingui;
  
  // create a frame 
	static JFrame frame; 
 
	// create components
	static JTextField labeltotal; 
	static JTextField labelsearch; 
	static JTextField labelcustom; 
  static JLabel iconsearch;
  static JButton iconedit, iconpurchase;
	static JButton butttonlib, buttoncus;
  static JButton buttoncreate, buttondone;
	static JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonc, buttonadd;
  static JTable maintable;
  static DefaultTableModel model;
  static JScrollPane sp;

  static Boolean edit = false;

	// store operands 
	static String s0 = "";
  static String st; 

  static String[] columnNames = { "Name", "Price", "Category", "SKU", "Description", "Count" }; 

  // create an itemframe 
	static JFrame itemframe; 
 
	// create components
  static JTextField labelname;
  static DefaultListModel listModel;
  static JTextField labelcategory; 
	static JTextField labelprice; 
  static JTextField labelSKU;
  static JTextField labeldesc;

  static JButton buttonexit, buttonsave, buttondelete; 
  
  static Boolean edititem;  

  static Boolean purchase;  
  static JFrame purchaseframe; 
  static JLabel currentsale;
	static JTextField labelpurchasetotal; 
  static JButton buttonexitpurchase, buttonclear; 
  static JTable purchasetable;
  static JScrollPane purchasesp;
  static DefaultTableModel purchasemodel;
  static String[] purchasecolumnNames = { "Name", "Count", "Price", "Delete" };

	// default constructor 
	MainGUI() 
	{ 
    st = "0";
	}

	// main function
	public static void create() 
	{ 
		// create a frame 
		frame = new JFrame("Point Of Sales");

		// create a object of class 
		maingui = new MainGUI(); 

		// create a textfield 
		labeltotal = new JTextField(24); 
		labeltotal.setText("Charge Rp. 0"); 

		labelcustom = new JTextField(24); 
		labelcustom.setText("Rp. 0");

		// set the textfield to non editable 
		labeltotal.setEditable(false); 
		labelcustom.setEditable(false); 

    ImageIcon imageIcon = new ImageIcon("resources/search-button-icon.png");
    Image image = imageIcon.getImage(); 
    Image newimg = image.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
    imageIcon = new ImageIcon(newimg);
    
    iconsearch = new JLabel("");
    iconsearch.setIcon(imageIcon);
    iconsearch.setPreferredSize(new Dimension(18, 18));

    labelsearch = new JTextField(19); 
    labelsearch.setText("Search"); 
    labelsearch.addMouseListener(new MouseAdapter()
    {
        public void mouseClicked(MouseEvent e)
        {
          if(labelsearch.getText().equals("Search"))
          {
            labelsearch.setText("");
          }           
        }
    }
    );

    imageIcon = new ImageIcon("resources/edit-button-icon.jpg");
    image = imageIcon.getImage(); 
    newimg = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    imageIcon = new ImageIcon(newimg);

    iconedit = new JButton("", imageIcon);
    iconedit.setActionCommand("edit");
    iconedit.setPreferredSize(new Dimension(18, 18));
    iconedit.setBorder(BorderFactory.createEmptyBorder());

    //create menubutton
    butttonlib = new JButton("Library"); 
    butttonlib.setPreferredSize(new Dimension(120, 50));

    buttoncus = new JButton("Custom"); 
    buttoncus.setPreferredSize(new Dimension(120, 50));

    // create submenu buttons 
		buttoncreate = new JButton("CREATE NEW ITEM"); 
    buttoncreate.setPreferredSize(new Dimension(240, 50));
    buttondone = new JButton("DONE"); 
    buttondone.setPreferredSize(new Dimension(240, 50));
    
    imageIcon = new ImageIcon("resources/purchase-icon.png");
    image = imageIcon.getImage(); 
    newimg = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    imageIcon = new ImageIcon(newimg);
    
    iconpurchase = new JButton("", imageIcon);
    iconpurchase.setActionCommand("Purchase");
    iconpurchase.setPreferredSize(new Dimension(240, 50));

    // create number buttons 
		button0 = new JButton("0"); 
    button0.setPreferredSize(new Dimension(78, 50));
		button1 = new JButton("1"); 
    button1.setPreferredSize(new Dimension(78, 50));
		button2 = new JButton("2"); 
    button2.setPreferredSize(new Dimension(78, 50));
		button3 = new JButton("3"); 
    button3.setPreferredSize(new Dimension(78, 50));
		button4 = new JButton("4"); 
    button4.setPreferredSize(new Dimension(78, 50));
		button5 = new JButton("5"); 
    button5.setPreferredSize(new Dimension(78, 50));
		button6 = new JButton("6"); 
    button6.setPreferredSize(new Dimension(78, 50));
		button7 = new JButton("7"); 
    button7.setPreferredSize(new Dimension(78, 50));
		button8 = new JButton("8"); 
    button8.setPreferredSize(new Dimension(78, 50));
		button9 = new JButton("9"); 
    button9.setPreferredSize(new Dimension(78, 50));

		// create operator buttons 
		buttonadd = new JButton("+");
    buttonadd.setPreferredSize(new Dimension(78, 50));

		// create C button 
		buttonc = new JButton("C"); 
    buttonc.setPreferredSize(new Dimension(78, 50));

		// create a panel 
		JPanel panel = new JPanel();

    // Initializing the JTable 
    model = new DefaultTableModel(columnNames, 0);
    maintable = new JTable(model); 

    maintable.setTableHeader(null);
    maintable.setShowGrid(false);
    maintable.setDefaultEditor(Object.class, null);
    maintable.getColumnModel().getColumn(2).setMinWidth(0);
    maintable.getColumnModel().getColumn(2).setMaxWidth(0);
    maintable.getColumnModel().getColumn(2).setWidth(0);
    maintable.getColumnModel().getColumn(3).setMinWidth(0);
    maintable.getColumnModel().getColumn(3).setMaxWidth(0);
    maintable.getColumnModel().getColumn(3).setWidth(0);
    maintable.getColumnModel().getColumn(4).setMinWidth(0);
    maintable.getColumnModel().getColumn(4).setMaxWidth(0);
    maintable.getColumnModel().getColumn(4).setWidth(0);
    maintable.getColumnModel().getColumn(5).setMinWidth(0);
    maintable.getColumnModel().getColumn(5).setMaxWidth(0);
    maintable.getColumnModel().getColumn(5).setWidth(0);

    maintable.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent event)
      {
        if (!edit)
        {
          int row = maintable.rowAtPoint(event.getPoint());
          int col = 1;
          int te = 0;
          s0 = maintable.getValueAt(row, col).toString();
          te = (Integer.parseInt(s0) + Integer.parseInt(st));
          st = Integer.toString(te);
          labeltotal.setText("Charge Rp. " + st);

          model.setValueAt(Integer.parseInt(maintable.getValueAt(row, 5).toString()) + 1, row, 5);

          maintable.setModel(model);
        }
        else
        {
          createItemGUI("edit", maintable.rowAtPoint(event.getPoint()));
        }
      }
    }
    );

    // adding it to JScrollPane 
    sp = new JScrollPane(maintable); 
    sp.setPreferredSize(new Dimension(240, 150));
		
    // add action listeners
    iconedit.addActionListener(maingui);	
    iconpurchase.addActionListener(maingui);	
    butttonlib.addActionListener(maingui);	
    buttoncus.addActionListener(maingui);	

		buttoncreate.addActionListener(maingui); 
    buttondone.addActionListener(maingui);

    button9.addActionListener(maingui); 
		button8.addActionListener(maingui); 
		button7.addActionListener(maingui); 
		button6.addActionListener(maingui); 
		button5.addActionListener(maingui); 
		button4.addActionListener(maingui); 
		button3.addActionListener(maingui); 
		button2.addActionListener(maingui); 
		button1.addActionListener(maingui); 
		button0.addActionListener(maingui); 
		buttonc.addActionListener(maingui); 
		buttonadd.addActionListener(maingui); 

		// add elements to panel 
		panel.add(labeltotal);
    panel.add(butttonlib);
    panel.add(buttoncus); 
    panel.add(iconsearch);
    panel.add(labelsearch);
    panel.add(iconedit);

		panel.add(buttoncreate); 
    panel.add(sp);
    panel.add(buttondone);
    panel.add(iconpurchase);

    panel.add(labelcustom);
    panel.add(button1); 
		panel.add(button2); 
		panel.add(button3); 
		panel.add(button4); 
		panel.add(button5); 
		panel.add(button6); 
		panel.add(button7); 
		panel.add(button8); 
		panel.add(button9); 
		panel.add(buttonc); 
		panel.add(button0); 
		panel.add(buttonadd);

		// add panel to frame 
		frame.add(panel); 

		frame.setSize(280, 500); 
    maingui.startLibrary();
		frame.show(); 
  }
  
  public static void createItemGUI(String buffer, int row) 
	{ 
    if(buffer.compareTo("new") == 0)
    {
      edititem = false;
    }
    else
    {
      edititem = true;
    }

    if(!edititem)
    {
      // create an itemframe 
      itemframe = new JFrame("Create New Item");
    }
    else
    {
      itemframe = new JFrame("Edit Item");
    }
		// create a textfield 

    labelname = new JTextField(24);
    labelprice = new JTextField(24); 
    labelcategory = new JTextField(24); 
    labelSKU = new JTextField(24); 
    labeldesc = new JTextField(24); 
    if(edititem)
    {
      labelname.setText(maintable.getValueAt(row, 0).toString());
      labelprice.setText(maintable.getValueAt(row, 1).toString());
      labelcategory.setText(maintable.getValueAt(row, 2).toString());
      labelSKU.setText(maintable.getValueAt(row, 3).toString());
      labeldesc.setText(maintable.getValueAt(row, 4).toString());
    }
    else
    {
      labelname.setText("Item Name");
      labelprice.setText("Price");
      labelcategory.setText("Category");
      labelSKU.setText("SKU");
      labeldesc.setText("Description");  
    }
    
    labelname.addMouseListener(new MouseAdapter()
    {
        public void mouseClicked(MouseEvent e)
        {
          if(labelname.getText().equals("Item Name"))
          {
            labelname.setText("");
          }           
        }
    }
    );
    
    labelcategory.addMouseListener(new MouseAdapter()
    {
        public void mouseClicked(MouseEvent e)
        {
          if(labelcategory.getText().equals("Category"))
          {
            labelcategory.setText("");
          }           
        }
    }
    );

    labelprice.addMouseListener(new MouseAdapter()
    {
        public void mouseClicked(MouseEvent e)
        {
          if(labelprice.getText().equals("Price"))
          {
            labelprice.setText("");
          }           
        }
    }
    );
		
    labelSKU.addMouseListener(new MouseAdapter()
    {
        public void mouseClicked(MouseEvent e)
        {
          if(labelSKU.getText().equals("SKU"))
          {
            labelSKU.setText("");
          }           
        }
    }
    );
    
    labeldesc.addMouseListener(new MouseAdapter()
    {
        public void mouseClicked(MouseEvent e)
        {
          if(labeldesc.getText().equals("Description"))
          {
            labeldesc.setText("");
          }           
        }
    }
    );

    buttonexit = new JButton("X"); 
    buttonexit.setPreferredSize(new Dimension(50, 50));

		buttonsave = new JButton("SAVE"); 
    buttonsave.setPreferredSize(new Dimension(190, 50));

    buttondelete = new JButton("DELETE");
    buttondelete.setPreferredSize(new Dimension(240, 50));
  
    // create a itempanel 
		JPanel itempanel = new JPanel();
		
    // add action listeners
		buttonsave.addActionListener(maingui); 
    buttonexit.addActionListener(maingui);
    buttondelete.addActionListener(maingui);

		// add elements to itempanel 
    itempanel.add(labelname);
    itempanel.add(labelcategory);
    itempanel.add(labelprice);
    itempanel.add(labelSKU);
    itempanel.add(labeldesc);
		itempanel.add(buttonexit);
		itempanel.add(buttonsave);

    if(edititem)
    {
      itempanel.add(buttondelete);
    }
		// add itempanel to itemframe 
		itemframe.add(itempanel); 

		itemframe.setSize(300, 500); 
		itemframe.show(); 
  }
  
  public static void createPurchaseGUI() 
	{
    int total = 0;
    Object[] object = new Object[4];

    purchaseframe = new JFrame("Purchase");
    purchase = true;
    currentsale = new JLabel("CURRENT SALE");
    labelpurchasetotal = new JTextField(24);
		labelpurchasetotal.setEditable(false); 
    labelpurchasetotal.setText("Charge Rp. " + st);

    //Initializing the JTable 
    purchasemodel = new DefaultTableModel(purchasecolumnNames, 0);

    for(int i = 0; i < maintable.getRowCount(); i++)
    {
      if(Integer.parseInt(maintable.getValueAt(i, 5).toString()) > 0)
      {
        object[0] = maintable.getValueAt(i, 0).toString();
        object[1] = ("x" + maintable.getValueAt(i, 5).toString());
        object[2] = Integer.parseInt(maintable.getValueAt(i, 1).toString()) * Integer.parseInt(maintable.getValueAt(i, 5).toString());
        object[3] = "X";
        total = total + Integer.parseInt(maintable.getValueAt(i, 1).toString()) * Integer.parseInt(maintable.getValueAt(i, 5).toString());
        purchasemodel.addRow(object);
      }
    }

    if (total < Integer.parseInt(st))
    {
      object[0] = "Custom";
      object[1] = "";
      object[2] = Integer.parseInt(st) - total;
      object[3] = "X";
      
      purchasemodel.addRow(object);
    }

    purchasetable = new JTable(purchasemodel); 
    purchasetable.getColumnModel().getColumn(3).setMinWidth(11);
    purchasetable.getColumnModel().getColumn(3).setMaxWidth(11);
    purchasetable.getColumnModel().getColumn(3).setWidth(11);
    purchasetable.setTableHeader(null);
    purchasetable.setShowGrid(false);
    purchasetable.setDefaultEditor(Object.class, null);

    purchasetable.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent event)
      {
        int col = purchasetable.columnAtPoint(event.getPoint());
        int row = purchasetable.rowAtPoint(event.getPoint());
        if (col == 3)
        {
          int te = 0;
          s0 = purchasetable.getValueAt(row, 2).toString();
          te = (Integer.parseInt(st) - Integer.parseInt(s0));
          st = Integer.toString(te);
          labelpurchasetotal.setText("Charge Rp. " + st);
          labeltotal.setText("Charge Rp. " + st);
          
          for (int i = 0; i < model.getRowCount(); i++) 
          {
            if(model.getValueAt(i, 0) == purchasetable.getValueAt(row, 0))
            {
              model.setValueAt(0, i, 5);
            }
          }
          int numRows = purchasetable.getSelectedRows().length;
          for(int i = 0; i < numRows ; i++) 
          {
            purchasemodel.removeRow(purchasetable.getSelectedRow());
          }
          purchasetable.setModel(purchasemodel);
        }
      }
    }
    );

    purchasesp = new JScrollPane(purchasetable); 
    purchasesp.setPreferredSize(new Dimension(240, 150));
    
    buttonexitpurchase = new JButton("X"); 
    buttonexitpurchase.setPreferredSize(new Dimension(50, 50));

		buttonclear = new JButton("Clear Sale"); 
    buttonclear.setPreferredSize(new Dimension(190, 50));
  
    // create a purchasepanel 
		JPanel purchasepanel = new JPanel();
		
    // add action listeners
		buttonclear.addActionListener(maingui); 
    buttonexitpurchase.addActionListener(maingui);


		// add elements to purchasepanel 
		purchasepanel.add(currentsale);
		purchasepanel.add(purchasesp);
		purchasepanel.add(labelpurchasetotal);
		purchasepanel.add(buttonexitpurchase);
		purchasepanel.add(buttonclear);

		// add purchasepanel to purchaseframe 
		purchaseframe.add(purchasepanel);
		purchaseframe.setSize(300, 500);
		purchaseframe.show();
	}

  public static void startLibrary()
  {
    butttonlib.setEnabled(false);
    buttoncus.setEnabled(true);
    iconsearch.setVisible(true);
    labelsearch.setVisible(true);
    labelcustom.setVisible(false);
    iconedit.setVisible(true);

    buttoncreate.setVisible(false);

    sp.setVisible(true);

    buttondone.setVisible(false);
    iconpurchase.setVisible(true);

    button9.setVisible(false); 
		button8.setVisible(false); 
		button7.setVisible(false); 
		button6.setVisible(false); 
		button5.setVisible(false); 
		button4.setVisible(false); 
		button3.setVisible(false); 
		button2.setVisible(false); 
		button1.setVisible(false); 
		button0.setVisible(false); 
		buttonc.setVisible(false); 
		buttonadd.setVisible(false); 
  }

  public static void starteditLibrary()
  {
    butttonlib.setEnabled(false);
    buttoncus.setEnabled(false);
    labelcustom.setVisible(false);
    iconedit.setVisible(false);

    buttoncreate.setVisible(true);
    iconpurchase.setVisible(false);

    buttondone.setVisible(true); 
  }

  public static void startCustom()
  {
    s0 = "";
    labelcustom.setText("Rp. 0");
    butttonlib.setEnabled(true);
    buttoncus.setEnabled(false);
    labelsearch.setVisible(false);
    labelcustom.setVisible(true);
    iconsearch.setVisible(false);
    iconedit.setVisible(false);

    buttoncreate.setVisible(false);
    
    sp.setVisible(false);
 
    iconpurchase.setVisible(false);
    
    button9.setVisible(true); 
		button8.setVisible(true); 
		button7.setVisible(true); 
		button6.setVisible(true); 
		button5.setVisible(true); 
		button4.setVisible(true); 
		button3.setVisible(true); 
		button2.setVisible(true); 
		button1.setVisible(true); 
		button0.setVisible(true); 
		buttonc.setVisible(true); 
		buttonadd.setVisible(true); 
  }

	public void actionPerformed(ActionEvent event) 
	{ 
		String s = event.getActionCommand(); 

		// if the value is a number 
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9')) { 
			// if operand is present then add to second no
			s0 = s0 + s; 

			// set the value of text 
			labelcustom.setText("Rp. " + s0); 
		} 
		else if (s.equals("C")) {
      s0 = "";
			// set the value of text 
			labelcustom.setText("Rp. 0"); 
		} 
		else if (s.charAt(0) == '+') { 
			// if there was no operand 
			int te = 0; 
      if(s0 == "")
      {
        s0 = "0";
      }
      te = (Integer.parseInt(s0) + Integer.parseInt(st));

      // convert it to string 
      st = Integer.toString(te);
      s0 = "";  

    	// set the value of text 
			labelcustom.setText("Rp. 0"); 
			labeltotal.setText("Charge Rp. " + st);
		}
    else if (s.equals("Library"))
    {
      startLibrary();
    }
    else if (s.equals("Custom"))
    {
      startCustom();
    }
    else if (s.equals("edit"))
    {
      starteditLibrary();
      edit = true;
    }
    else if (s.equals("Purchase"))
    {
      createPurchaseGUI();
      frame.dispose();
    }
    else if (s.equals("DONE"))
    {
      startLibrary();
      edit = false;
    }
    else if (s.equals("CREATE NEW ITEM"))
    {
      // frame.dispose();
      createItemGUI("new", 0);
    }
    else if (s.equals("SAVE"))
    {
      Object[] row = new Object[6];
      row[0] = (String)labelname.getText();
      row[1] = labelprice.getText();
      row[2] = (String)labelcategory.getText();
      row[3] = (String)labelSKU.getText();
      row[4] = (String)labeldesc.getText();
      row[5] = 0;
      model.addRow(row);
      maintable.setModel(model);
      if(edititem)
      {
        int numRows = maintable.getSelectedRows().length;
        for(int i = 0; i < numRows ; i++) 
        {
          model.removeRow(maintable.getSelectedRow());
        }
      }
      itemframe.dispose();

      // frame.show();
    }
    else if (s.equals("X"))
    {
      if(purchase == true)
      {
        purchaseframe.dispose();
        frame.show();
      }
      else
      {
        itemframe.dispose();
      }
    }
    else if (s.equals("DELETE"))
    {
      int numRows = maintable.getSelectedRows().length;
      for(int i = 0; i < numRows ; i++) 
      {
        model.removeRow(maintable.getSelectedRow());
      }
      itemframe.dispose();

    }
    else if (s.equals("Clear Sale"))
    {
      labelcustom.setText("Rp. 0"); 
      labeltotal.setText("Charge Rp. 0");
      labelpurchasetotal.setText("Charge Rp. 0");
      s0 = ""; 
      st = "0";
      
      for (int i = 0; i < purchasemodel.getRowCount(); i++) 
      {
        purchasemodel.removeRow(i);
      }
      purchasetable.setModel(purchasemodel);
      
      for (int i = 0; i < model.getRowCount(); i++) 
      {
        model.setValueAt(0, i, 5);
      }
    }
  } 
} 