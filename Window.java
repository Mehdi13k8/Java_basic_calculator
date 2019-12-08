import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Window extends JFrame implements ActionListener {
	String first = "";
	String op = "";
	String second = "";
	String al = "";
	JLabel box = new JLabel("0");
	Box bbox = Box.createHorizontalBox();
	String[] devstrings = { "Livre Sterling", "Dollars", "Euro", "Yuan", "CADollars" };
	JComboBox listbox = new JComboBox(devstrings);
	JComboBox listbox2 = new JComboBox(devstrings);
	float stocknb = 0;
	ArrayList<String> linearr = new ArrayList<String>();

	String dollareuro;
	String dollarcadollar;
	String dollarsterling;
	String dollaryuan;
	String sterlingdollar;
	String sterlingeuro;
	String sterlingcadollar;
	String sterlingyuan;
	String yuansterling;
	String yuaneuro;
	String yuancadollar;
	String yuandollar;
	String cadollaryuan;
	String cadollardollar;
	String cadollareuro;
	String cadollarsterling;
	String eurosterling;
	String eurocadollar;
	String euroyuan;// = fill(linearr, 22);
	String eurodollar;// = fill(linearr, 23);

	public Window() {
		String name = "Change";
		String line = "";
		ArrayList<String> linearr = new ArrayList<String>();
		try {
			FileReader file = new FileReader(name);
			BufferedReader buffile = new BufferedReader(file);
			while ((line = buffile.readLine()) != null) {
				linearr.add(line);
			}
			for (String str : linearr) {
				//System.out.println(str);
			}
			buffile.close();
		}
		catch(FileNotFoundException ex) {
		}
		catch(IOException ex) {
		}
		dollareuro = fill(linearr, 0);
		dollarcadollar = fill(linearr, 1);
		dollarsterling = fill(linearr, 2);
		dollaryuan = fill(linearr, 3);
		sterlingdollar = fill(linearr, 5);
		sterlingeuro  = fill(linearr, 6);
		sterlingcadollar = fill(linearr, 7);
		sterlingyuan = fill(linearr, 8);
		yuansterling = fill(linearr, 10);
		yuaneuro = fill(linearr, 11);
		yuancadollar = fill(linearr, 12);
		yuandollar = fill(linearr, 13);
		cadollaryuan = fill(linearr, 15);
		cadollardollar = fill(linearr, 16);
		cadollareuro = fill(linearr, 17);
		cadollarsterling = fill(linearr, 18);
		eurosterling = fill(linearr, 20);
		eurocadollar = fill(linearr, 21);
		euroyuan = fill(linearr, 22);
		eurodollar = fill(linearr, 23);
	}
	public void actionPerformed(ActionEvent e) {
		float nb = 0;
		String string = e.getActionCommand();
		if (second.equals("") && op.equals("") && !string.equals("+") && !string.equals("-") &&
		    !string.equals("*") && !string.equals("/") && !string.equals("Cancel") &&
		    !string.equals("Compute") && !string.equals("Change") && !string.equals("comboBoxChanged")) {
			if (stocknb != 0) {
				stocknb = 0;
				al = "0";
				box.setText(al);
				System.out.println("in");
			}
			first += string;
			if (al.length() == 1 && al.equals("0") || al.length() == 3 && al.equals("0.0"))
				al = string;
			else
				al += string;
			box.setText(al);
		}
		else if (!first.equals("") && op.equals("") && (string.equals("+") || string.equals("-") ||
			string.equals("*") || string.equals("/")) && !string.equals("Cancel") &&
		 !string.equals("Comptute") && !string.equals("Change") && !string.equals("comboBoxChanged")) {
		op += string;
		al += string;
		box.setText(al);
	}
	else if (!first.equals("") && !op.equals("") && second.equals("") && !string.equals("+") && !string.equals("-") && !string.equals("*") && !string.equals("/") && !string.equals("Cancel") &&
		 !string.equals("Comptute") && !string.equals("Change")  && !string.equals("comboBoxChanged")) {
		second += string;
		al += string;
		box.setText(al);
	}
		if (string.equals("Compute") && !first.equals("") && !second.equals("")) {
			if (op.equals("+")) {
			        nb = Float.parseFloat(first) + Float.parseFloat(second);
				stocknb = nb;
				al = Float.toString(nb);
				first = "";
				op = "";
				second = "";
				System.out.println(nb);
			}
			if (op.equals("-")) {
				nb = Float.parseFloat(first) - Float.parseFloat(second);
				stocknb = nb;
				al = Float.toString((int)nb);
				first = "";
				op = "";
				second = "";
				System.out.println(nb);
			}
			if (op.equals("*")) {
				nb = Float.parseFloat(first) * Float.parseFloat(second);
				stocknb = nb;
				al = Float.toString((int)nb);
				first = "";
				op = "";
				second = "";
				System.out.println(nb);
			}
			if (op.equals("/")) {
				nb = Float.parseFloat(first) / Float.parseFloat(second);
				stocknb = nb;
				al = Float.toString((int)nb);
				first = "";
				op = "";
				second = "";
				System.out.println(nb);
			}
			box.setText(al);
			first = "";
			op = "";
			second = "";
			//al = "0";
			//box.setText(al);
		}
		else if (string.equals("Cancel")) {
			al = Integer.toString(0);
			first = "";
			op = "";
			second = "";
			box.setText(al);
		}
		else if (string.equals("Change")) {
			if (stocknb == 0 && first.equals("") && op.equals("") && second.equals("")) {
				stocknb = 0;
				al = "0";
				first = "";
				op = "";
				second = "";
				box.setText(al);
				System.out.println("0");
			        System.out.println(listbox.getSelectedItem());
				System.out.println(listbox2.getSelectedItem());
			}
			else if (stocknb == 0 && !first.equals("") && op.equals("") && second.equals("")) {
				if (listbox.getSelectedItem().equals("Dollars") && listbox2.getSelectedItem().equals("Euro")) {
					nb = Float.parseFloat(first) * Float.parseFloat(dollareuro);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Dollars") && listbox2.getSelectedItem().equals("CADollars")) {
					nb = Float.parseFloat(first) * Float.parseFloat(dollarcadollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Dollars") && listbox2.getSelectedItem().equals("Livre Sterling")) {
					nb = Float.parseFloat(first) * Float.parseFloat(dollarsterling);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Dollars") && listbox2.getSelectedItem().equals("Yuan")) {
					nb = Float.parseFloat(first) * Float.parseFloat(dollaryuan);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Livre Sterling") && listbox2.getSelectedItem().equals("Dollars")) {
					nb = Float.parseFloat(first) * Float.parseFloat(sterlingdollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Livre Sterling") && listbox2.getSelectedItem().equals("Euro")) {
					nb = Float.parseFloat(first) * Float.parseFloat(sterlingeuro);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Livre Sterling") && listbox2.getSelectedItem().equals("Yuan")) {
					nb = Float.parseFloat(first) * Float.parseFloat(sterlingyuan);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Livre Sterling") && listbox2.getSelectedItem().equals("CADollars")) {
					nb = Float.parseFloat(first) * Float.parseFloat(sterlingcadollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Yuan") && listbox2.getSelectedItem().equals("Livre Sterling")) {
					nb = Float.parseFloat(first) * Float.parseFloat(yuansterling);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Yuan") && listbox2.getSelectedItem().equals("Euro")) {
					nb = Float.parseFloat(first) * Float.parseFloat(yuaneuro);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Yuan") && listbox2.getSelectedItem().equals("CADollars")) {
					nb = Float.parseFloat(first) * Float.parseFloat(yuancadollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Yuan") && listbox2.getSelectedItem().equals("Dollars")) {
					nb = Float.parseFloat(first) * Float.parseFloat(yuandollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("CADollars") && listbox2.getSelectedItem().equals("Yuan")) {
					nb = Float.parseFloat(first) * Float.parseFloat(cadollaryuan);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("CADollars") && listbox2.getSelectedItem().equals("Dollars")) {
					nb = Float.parseFloat(first) * Float.parseFloat(cadollardollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("CADollars") && listbox2.getSelectedItem().equals("Euro")) {
					nb = Float.parseFloat(first) * Float.parseFloat(cadollareuro);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("CADollars") && listbox2.getSelectedItem().equals("Livre Sterling")) {
					nb = Float.parseFloat(first) * Float.parseFloat(cadollarsterling);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Euro") && listbox2.getSelectedItem().equals("Livre Sterling")) {
					nb = Float.parseFloat(first) * Float.parseFloat(eurosterling);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Euro") && listbox2.getSelectedItem().equals("CADollars")) {
					nb = Float.parseFloat(first) * Float.parseFloat(eurocadollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Euro") && listbox2.getSelectedItem().equals("Yuan")) {
					nb = Float.parseFloat(first) * Float.parseFloat(euroyuan);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Euro") && listbox2.getSelectedItem().equals("Dollars")) {
					nb = Float.parseFloat(first) * Float.parseFloat(eurodollar);
					System.out.println("nb = ha " + nb);
				}
				stocknb = nb;
				al = Float.toString((int)nb);
				first = "";
				op = "";
				second = "";
				System.out.println("01");
				System.out.println(nb);
				box.setText(al);
			}
			else if (stocknb != 0) {
				System.out.println("else");
				nb = stocknb;
				//stocknb = 0;
				if (listbox.getSelectedItem().equals("Dollars") && listbox2.getSelectedItem().equals("Euro")) {
					nb = nb * Float.parseFloat(dollareuro);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Dollars") && listbox2.getSelectedItem().equals("CADollars")) {
					nb = nb * Float.parseFloat(dollarcadollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Dollars") && listbox2.getSelectedItem().equals("Livre Sterling")) {
					nb = nb * Float.parseFloat(dollarsterling);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Dollars") && listbox2.getSelectedItem().equals("Yuan")) {
					nb = nb * Float.parseFloat(dollaryuan);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Livre Sterling") && listbox2.getSelectedItem().equals("Dollars")) {
					nb = nb * Float.parseFloat(sterlingdollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Livre Sterling") && listbox2.getSelectedItem().equals("Euro")) {
					nb = nb * Float.parseFloat(sterlingeuro);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Livre Sterling") && listbox2.getSelectedItem().equals("Yuan")) {
					nb = nb * Float.parseFloat(sterlingyuan);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Livre Sterling") && listbox2.getSelectedItem().equals("CADollars")) {
					nb = nb * Float.parseFloat(sterlingcadollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Yuan") && listbox2.getSelectedItem().equals("Livre Sterling")) {
					nb = nb * Float.parseFloat(yuansterling);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Yuan") && listbox2.getSelectedItem().equals("Euro")) {
					nb = nb * Float.parseFloat(yuaneuro);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Yuan") && listbox2.getSelectedItem().equals("CADollars")) {
					nb = nb * Float.parseFloat(yuancadollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Yuan") && listbox2.getSelectedItem().equals("Dollars")) {
					nb = nb * Float.parseFloat(yuandollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("CADollars") && listbox2.getSelectedItem().equals("Yuan")) {
					nb = nb * Float.parseFloat(cadollaryuan);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("CADollars") && listbox2.getSelectedItem().equals("Dollars")) {
					nb = nb * Float.parseFloat(cadollardollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("CADollars") && listbox2.getSelectedItem().equals("Euro")) {
					nb = nb * Float.parseFloat(cadollareuro);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("CADollars") && listbox2.getSelectedItem().equals("Livre Sterling")) {
					nb = nb * Float.parseFloat(cadollarsterling);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Euro") && listbox2.getSelectedItem().equals("Livre Sterling")) {
					nb = nb * Float.parseFloat(eurosterling);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Euro") && listbox2.getSelectedItem().equals("CADollars")) {
					nb = nb * Float.parseFloat(eurocadollar);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Euro") && listbox2.getSelectedItem().equals("Yuan")) {
					nb = nb * Float.parseFloat(euroyuan);
					System.out.println("nb = " + nb);
				}
				if (listbox.getSelectedItem().equals("Euro") && listbox2.getSelectedItem().equals("Dollars")) {
					nb = nb * Float.parseFloat(eurodollar);
					System.out.println("nb = ha " + nb);
				}
				
				first = "";
				op = "";
				second = "";
				box.setText(Float.toString((int)nb));
				System.out.println(listbox.getSelectedItem());
				System.out.println(listbox2.getSelectedItem());
			}
		}
	}
	public String fill(ArrayList<String> list, int idx) {
		int block = 0;
		String str = "";
		int idx2 = 0;
		int i = 0;
		int cpy = 0;
		for (String sstr: list) {
			if (block == idx) {
				while (i < sstr.length()) {
					if (sstr.charAt(idx2) == 'f')
						cpy = 0;
					if (cpy == 1)
						str += sstr.charAt(idx2);
					if (sstr.charAt(idx2) == ':')
						cpy = 1;
					idx2++;
					i++;
				}
			}
			block++;
		}
		System.out.println(str);
		return (str);
	}
	public static void main(String[] args) {
		String name = "Change";
		String line = "";
		ArrayList<String> linearr = new ArrayList<String>();
		try {
			FileReader file = new FileReader(name);
			BufferedReader buffile = new BufferedReader(file);
			while ((line = buffile.readLine()) != null) {
				linearr.add(line);
			}
			for (String str : linearr) {
				//System.out.println(str);
			}
			buffile.close();
		}
		catch(FileNotFoundException ex) {
		}
		catch(IOException ex) {
		}

	Window win = new Window();
		

		JFrame frame = new JFrame("Devise Changer");
		JPanel panel = new JPanel();
		frame.getContentPane().add(BorderLayout.PAGE_START, win.box);
		//frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//win.box.setBackground(Color.blue);
		Container x = frame.getContentPane();
		x.setBackground(Color.green);
		//win.setBackground(Color.blue);
		//win.setForeground(Color.red);
		win.box.setOpaque(true);

		frame.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(150, 500));
				
		//Box bbox = Box.createHorizontalBox();
		win.add(win.bbox, BorderLayout.CENTER);

		JTextField field = new JTextField(255);
		field.setEditable(false);
		
		
		win.listbox.setSelectedIndex(0);
		win.listbox.setEditable(false);
		win.listbox.addActionListener(win);
		panel.add(win.listbox);
		win.listbox2.setSelectedIndex(0);
		win.listbox2.setEditable(false);
		win.listbox2.addActionListener(win);
		panel.add(win.listbox2);

		JButton b0;
		b0 = new JButton("0");
		b0.addActionListener(win);
		panel.add(b0);
		
		JButton b1;
		b1 = new JButton("1");
		b1.addActionListener(win);
		panel.add(b1);

		JButton b2;
		b2 = new JButton("2");
		b2.addActionListener(win);
		panel.add(b2);

		JButton b3;
		b3 = new JButton("3");
		b3.addActionListener(win);
		panel.add(b3);

		JButton b4;
		b4 = new JButton("4");
		b4.addActionListener(win);
		panel.add(b4);

		JButton b5;
		b5 = new JButton("5");
		b5.addActionListener(win);
		panel.add(b5);

		JButton b6;
		b6 = new JButton("6");
		b6.addActionListener(win);
		panel.add(b6);

		JButton b7;
		b7 = new JButton("7");
		b7.addActionListener(win);
		panel.add(b7);

		JButton b8;
		b8 = new JButton("8");
		b8.addActionListener(win);
		panel.add(b8);

		JButton b9;
		b9 = new JButton("9");
		b9.addActionListener(win);
		panel.add(b9);

		JButton bP;
		bP = new JButton("+");
		bP.addActionListener(win);
		panel.add(bP);

		JButton bM;
		bM = new JButton("-");
		bM.addActionListener(win);
		panel.add(bM);

		JButton bF;
		bF = new JButton("*");
		bF.addActionListener(win);
		panel.add(bF);

		JButton bD;
		bD = new JButton("/");
		bD.addActionListener(win);
		panel.add(bD);

		JButton bCe;
		bCe = new JButton("Cancel");
		bCe.addActionListener(win);
		panel.add(bCe);

		JButton bCl;
		bCl = new JButton("Compute");
		bCl.addActionListener(win);
		panel.add(bCl);

		JButton bC;
		bC = new JButton("Change");
		bC.addActionListener(win);
		//bC.setIcon(new ImageIcon("exchange.jpg"));
		panel.add(bC);

		//frame.setBackground(Color.red);
		panel.setBackground(Color.red);
		frame.setLocation(50, 50);

		frame.add(panel);
		frame.setSize(150, 350);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					if (!frame.isResizable()) {
						frame.setSize(150, 350);
						frame.setLocation(50, 50);
					}
				}
			});
	}
}
