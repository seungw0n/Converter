package AsciiConverter;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends Frame implements ActionListener {
	
	JTextField input;
	final JTextField output;
	final JTextField outputB;
	JLabel l;
	JButton b;
	
	public Main() {
		JFrame f = new JFrame("Converter");
		
		input = new JTextField();
		input.setBounds(10,10,280,20);
		
		output = new JTextField();
		output.setBounds(10,80,280,20);
		
		outputB = new JTextField();
		outputB.setBounds(10,100,280,20);
		
		l = new JLabel();
		l.setBounds(10,140,280,20);
		l.setText("Copyright by Seung Won Joeng - McGill CS");
	
		b = new JButton("Convert to ASCII");
		b.setBounds(80,40,150,30);
		b.addActionListener(this);
		
		
		f.add(b); f.add(input); f.add(output); f.add(outputB);
		f.add(l);
		f.setSize(300,200);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			String val = input.getText();
			//Something process
			int[] arr = strToAscii(val);
			String resultOne = strToAscii(arr);
			String resultTwo = decimalToBinary(arr);
			
			
			output.setText(resultOne);
			outputB.setText(resultTwo);
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public int[] strToAscii(String str) {
		
		int[] arr = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int tmp = (int)c;
			arr[i] = tmp;
		}
		
		return arr;
	}
	
	public String strToAscii(int[] arr) {
		String result = "";
		for(int i : arr) {
			result += Integer.toString(i);
			result += " ";
		}
		
		return result;
	}
	
	public String decimalToBinary(int[] arr) {
		String result = "";
		
		for(int i : arr) {
			result += Integer.toBinaryString(i);
			result += " ";
		}
		
//		int count = 0;
//		
//		for(int i = 0; i < result.length(); i++) {
//			count++;
//			if(count == 5) {
//				count = 0;
//				result = new StringBuilder(result).insert(i, " ").toString();
//			}
//		}
		
		return result;
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
