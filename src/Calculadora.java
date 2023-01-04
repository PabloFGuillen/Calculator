import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculadora {

	private JFrame frame;
	private JTextField RESULT;
	private JTextField OP2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
		    UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}

		ArrayList<String> numeros = new ArrayList<String>();
		numeros.add("");
		ArrayList<String> operaciones = new ArrayList<String>();
		double ans = 0;
		ArrayList<String> historial = new ArrayList<String>();
		historial.add("");
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 485, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton DIVISION = new JButton("/");
		DIVISION.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(numeros.get(numeros.size()-1).equals("")){
					
					
				}else{
					operaciones.add("/");
					numeros.add("");
					RESULT.setText(RESULT.getText().toString() + "/");
				}
				
			}
		});
		DIVISION.setFont(new Font("Verdana", Font.PLAIN, 23));
		DIVISION.setBounds(363, 169, 54, 44);
		frame.getContentPane().add(DIVISION);
		
		JButton RESTA = new JButton("-");
		RESTA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(numeros.get(0) == "") {
					String n = numeros.get(numeros.size()-1) + "-";
					numeros.remove(numeros.size()-1);
					numeros.add(n);
					RESULT.setText(RESULT.getText() + RESTA.getText());
				}
				else {
					if(numeros.get(numeros.size()-1).equals("")){
						
					}
					if(RESULT.getText().charAt(RESULT.getText().toString().length()-1) == '*') {
						String n = numeros.get(numeros.size()-1) + "-";
						numeros.remove(numeros.size()-1);
						numeros.add(n);
						RESULT.setText(RESULT.getText() + RESTA.getText());
				
					}
					else if(RESULT.getText().charAt(RESULT.getText().toString().length()-1) == '/') {
						String n = numeros.get(numeros.size()-1) + "-";
						numeros.remove(numeros.size()-1);
						numeros.add(n);
						RESULT.setText(RESULT.getText() + RESTA.getText());
				
					}
					else if(RESULT.getText().charAt(RESULT.getText().toString().length()-1) == '-') {
				
					}
					else if(RESULT.getText().charAt(RESULT.getText().toString().length()-1) == '+') {
						
					}
					else{
						operaciones.add("-");
						numeros.add("");
						RESULT.setText(RESULT.getText().toString() + "-");
					}
				}
	
			}
		});
		RESTA.setFont(new Font("Verdana", Font.PLAIN, 23));
		RESTA.setBounds(295, 225, 54, 42);
		frame.getContentPane().add(RESTA);
		
		JButton Cuadrado = new JButton("x2");
		Cuadrado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				operaciones.clear();
				RESULT.setText(String.valueOf(Math.pow(Double.parseDouble(numeros.get(numeros.size()-1)),2)));
				numeros.clear();
				numeros.add(RESULT.getText());

			}
		});
		Cuadrado.setBounds(45, 136, 54, 23);
		frame.getContentPane().add(Cuadrado);

		
		JButton MULTIPLICACIÓN = new JButton("*");
		MULTIPLICACIÓN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(numeros.get(numeros.size()-1).equals("")){
					
					
				}else{
					operaciones.add("*");
					numeros.add("");
					RESULT.setText(RESULT.getText().toString() + "*");
				}
				
			}
		});
		MULTIPLICACIÓN.setFont(new Font("Verdana", Font.PLAIN, 23));
		MULTIPLICACIÓN.setBounds(363, 224, 54, 44);
		frame.getContentPane().add(MULTIPLICACIÓN);
		
		JButton SUMA_1_1_1 = new JButton("+");
		SUMA_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(numeros.get(numeros.size()-1).equals("")){
					
					
				}else{
					if(operaciones.size() == 0) {

						operaciones.add("+");
						numeros.add("");
						RESULT.setText(RESULT.getText().toString() + "+");
					
					}
					else if(((operaciones.get(operaciones.size()-1).equals("+") || operaciones.get(operaciones.size()-1).equals("-") || operaciones.get(operaciones.size()-1).equals("/") || operaciones.get(operaciones.size()-1).equals("*")) && numeros.size() < operaciones.size())) {
					
					}
					else {
					
						operaciones.add("+");
						numeros.add("");
						RESULT.setText(RESULT.getText().toString() + "+"); 
					}
		
				}
		
			}
		});
		SUMA_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SUMA_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 23));
		SUMA_1_1_1.setBounds(295, 170, 54, 44);
		frame.getContentPane().add(SUMA_1_1_1);
		
		JButton igual = new JButton("=");
		igual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double n1 = 0;
				double n2 = 0;
				double result = 0;
				if(numeros.size() > 1) {
				for(int i = 0; i < numeros.size(); i++) {
					if(i < 2) {
						if(i == 0) {
							if(numeros.get(i).contains("-")) {
								n1 = Double.parseDouble(numeros.get(i).substring(i));
								
							}
							else {
								n1 = Double.parseDouble(numeros.get(i).toString());
							}
					
						}
						else {
							n2 = Double.parseDouble(numeros.get(i).toString()); 
							if(operaciones.get(i-1).equals("+")) {
								result = n1+n2;
							}
							
							else if(operaciones.get(i-1).equals("-")) {
								result = n1-n2;
							}
							
							else if(operaciones.get(i-1).equals("/")) {
								result = n1/n2;				
							}
							
							else if(operaciones.get(i-1).equals("*")) {
								result = n1*n2;
							}
						}
					}else {
						n1 = Double.parseDouble(numeros.get(i).toString());
						if(operaciones.get(i-1).equals("+")) {
							result = result + n1;
						}
						
						else if(operaciones.get(i-1).equals("-")) {
							result =  result - n1;
						}
						
						else if(operaciones.get(i-1).equals("/")) {
							result =  result / n1;				
						}
						
						else if(operaciones.get(i-1).equals("*")) {
							result =  result * n1;
						}
					}	
				}
				String apoyo = "";
				for(int i = 0; i < numeros.size(); i++) {
					if(i < operaciones.size()) {
						apoyo = apoyo +  numeros.get(i) + operaciones.get(i);
					}
					else {
						apoyo = apoyo + numeros.get(i);
					}
				}
				apoyo = apoyo + " = " + String.valueOf(result);
				historial.remove(historial.size()-1);
				historial.add(apoyo);
				historial.add("");
				operaciones.clear();
				numeros.clear();
				numeros.add(String.valueOf(result));
				
				RESULT.setText(String.valueOf(String.format("%.2f", result)));
				}
			}
		});
		igual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		igual.setBounds(295, 341, 122, 44);
		frame.getContentPane().add(igual);
		
		JButton punto = new JButton(".");
		punto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + ".";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +punto.getText());
			}
		});
		punto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		punto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		punto.setBounds(131, 341, 54, 44);
		frame.getContentPane().add(punto);
		
		JButton cero = new JButton("0");
		cero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
					String n = numeros.get(numeros.size()-1) + "0";
					numeros.remove(numeros.size()-1);
					numeros.add(n);
					RESULT.setText(RESULT.getText() +cero.getText());
					
				}
		});
		cero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cero.setBounds(45, 341, 54, 44);
		frame.getContentPane().add(cero);
		
		JButton uno = new JButton("1");
		uno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + "1";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +uno.getText());
			}
		});
		uno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		uno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uno.setBounds(45, 280, 54, 44);
		frame.getContentPane().add(uno);
		
		JButton dos = new JButton("2");
		dos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + "2";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +dos.getText());
			}
		});
		dos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dos.setBounds(131, 280, 54, 44);
		frame.getContentPane().add(dos);
		
		JButton tres = new JButton("3");
		tres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + "3";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +tres.getText());
			}
		});
		tres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tres.setBounds(215, 280, 54, 44);
		frame.getContentPane().add(tres);
		
		JButton cuatro = new JButton("4");
		cuatro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + "4";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +cuatro.getText());
			}
		});
		cuatro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cuatro.setBounds(45, 225, 54, 44);
		frame.getContentPane().add(cuatro);
		
		JButton cinco = new JButton("5");
		cinco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + "5";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +cinco.getText());
			}
		});
		cinco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cinco.setBounds(131, 225, 54, 44);
		frame.getContentPane().add(cinco);
		
		JButton seis = new JButton("6");
		seis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + "6";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +seis.getText());
		
			}
		});
		seis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		seis.setBounds(215, 225, 54, 44);
		frame.getContentPane().add(seis);
		
		JButton siete = new JButton("7");
		siete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + "7";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +siete.getText());
			}
		});
		siete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		siete.setBounds(45, 170, 54, 44);
		frame.getContentPane().add(siete);
		
		JButton ocho = new JButton("8");
		ocho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + "8";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +ocho.getText());
			}
		});
		ocho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ocho.setBounds(131, 170, 54, 44);
		frame.getContentPane().add(ocho);
		
		JButton nueve = new JButton("9");
		nueve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = numeros.get(numeros.size()-1) + "9";
				numeros.remove(numeros.size()-1);
				numeros.add(n);
				RESULT.setText(RESULT.getText() +nueve.getText());
			}
		});
		nueve.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nueve.setBounds(215, 170, 54, 44);
		frame.getContentPane().add(nueve);
		
		JButton OFF = new JButton("OFF");
		OFF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		OFF.setBounds(215, 136, 54, 23);
		frame.getContentPane().add(OFF);
		
		JButton ce = new JButton("CE");
		ce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] cadena = new char[RESULT.getText().toString().length()];
				cadena = RESULT.getText().toString().toCharArray();
				char[] apoyo = new char[cadena.length -1];
				for(int i = 0; i < apoyo.length; i++) {
					apoyo[i] = cadena[i];
				}
				RESULT.setText(String.valueOf(apoyo));
				if(cadena[cadena.length-1] == '+' || cadena[cadena.length-1] == '-' || cadena[cadena.length-1] == '*' || cadena[cadena.length-1] == '/') {
					operaciones.remove(operaciones.size()-1);
					numeros.remove(numeros.size()-1);
				}else {
					char[] cadena2 = numeros.get(numeros.size()-1).toCharArray();
					char[] apoyo2 = new char[cadena2.length-1];
					for(int i = 0; i < apoyo2.length; i++) {
						apoyo2[i] = cadena2[i];
					}
					numeros.remove(numeros.size()-1);
					numeros.add(apoyo2.toString());
				}
				}
		});
		ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ce.setFont(new Font("Verdana", Font.PLAIN, 11));
		ce.setBounds(295, 135, 54, 23);
		frame.getContentPane().add(ce);
		
		RESULT = new JTextField();
		RESULT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == 'a') {
					e.setKeyChar('\n');
					RESULT.setText("");
				}
				else {
					e.setKeyChar('\n');
					RESULT.setText("");
				}
			}
		});
		RESULT.setHorizontalAlignment(SwingConstants.RIGHT);
		RESULT.setBounds(45, 83, 372, 42);
		frame.getContentPane().add(RESULT);
		RESULT.setColumns(10);
		
		JButton c = new JButton("C");
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numeros.clear();
				numeros.add("");
				operaciones.clear();
				RESULT.setText("");
			}
		});
		c.setFont(new Font("Verdana", Font.PLAIN, 11));
		c.setBounds(363, 135, 54, 23);
		frame.getContentPane().add(c);
		
		JButton cambioV = new JButton("+/-");
		cambioV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(numeros.get(numeros.size()-1).equals("") == false && numeros.size() >= 1) {
						Double string = Double.parseDouble(numeros.get(numeros.size()-1));
						string = string * -1;
						numeros.remove(numeros.size()-1);
						numeros.add(String.valueOf(string));
						if(operaciones.size() > 0) {
							char[] cadena = new char[RESULT.getText().toString().length()];
							String indice = RESULT.getText();
							int indxe = indice.lastIndexOf(operaciones.get(operaciones.size()-1));
							cadena = RESULT.getText().toCharArray();
							
							for(int i = 0; i < cadena.length; i++) {
								if(i == indxe && cadena[i] == '+') {
									cadena[i] = '-';
								}
								
								else if(i == indxe && cadena[i] == '-') {
									cadena[i] = '+';					
								}
								
								else if(i == indxe && cadena[i] == '*') {
									
								}
								
								else if(i == indxe && cadena[i] == '/'){
										
								}
							}
							RESULT.setText(String.copyValueOf(cadena));
						}
				}if(operaciones.size() == 0){
					char[] cadena = new char[RESULT.getText().toString().length()];
					cadena = RESULT.getText().toCharArray();
					if(cadena[0] == '-') {
						char[] apoyo =  new char[RESULT.getText().toString().length()-1];
						for(int i = 1; i < cadena.length; i++) {
							apoyo[i-1] = cadena[i];
						}
						RESULT.setText(String.copyValueOf(apoyo));
					}
					else {
						char[] apoyo =  new char[RESULT.getText().toString().length()+1];
						cadena = RESULT.getText().toCharArray();
						apoyo[0] = '-';
						for(int i = 0; i < cadena.length; i++) {
							apoyo[i+1] = cadena[i];
						}
						RESULT.setText(String.copyValueOf(apoyo));
					}
				}
			}
		});
		cambioV.setFont(new Font("Verdana", Font.PLAIN, 13));
		cambioV.setBounds(295, 278, 54, 44);
		frame.getContentPane().add(cambioV);
		
		JButton raiz = new JButton("\t√");
		raiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double raz = Math.sqrt(Double.parseDouble(numeros.get(numeros.size()-1)));
				numeros.remove(numeros.size()-1);
				numeros.add(String.valueOf(raz));
				char[] cadena = RESULT.getText().toCharArray();
				if(operaciones.size() > 0) {
					int ultimo = 0;
					for(int i = 0; i < cadena.length; i++) {
						if(cadena[i] == '+' || cadena[i] == '-' || cadena[i] == '*' || cadena[i] == '/') {
							ultimo = i;
						}
					}
					if(raz >= 0) {
						RESULT.setText(RESULT.getText().substring(0, ultimo+1) + String.valueOf(String.format("%.2f", raz)));
					}
					else {
						RESULT.setText("Math Error");
						try {
							TimeUnit.SECONDS.sleep(5);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						RESULT.setText("");
						numeros.clear();
						numeros.add("");
					}
				}
				else 
				{
					if(raz >= 0)
					{
						RESULT.setText(String.valueOf(String.format("%.2f", raz)));
					}else {
						RESULT.setText("Math Error");
						numeros.clear();
						numeros.add("");
					}
				}
			}
		});
		raiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		raiz.setBounds(131, 136, 54, 23);
		frame.getContentPane().add(raiz);
		
		JButton porcentaje = new JButton("%");
		porcentaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double porcentaje = (Double.parseDouble(numeros.get(numeros.size()-1)) / 100);
				numeros.remove(numeros.size()-1);
				numeros.add(String.valueOf(porcentaje));
				char[] cadena = RESULT.getText().toCharArray();
				if(operaciones.size() > 0) {
					int ultimo = 0;
					for(int i = 0; i < cadena.length; i++) {
						if(cadena[i] == '+' || cadena[i] == '-' || cadena[i] == '*' || cadena[i] == '/') {
							ultimo = i;
						}
					}
					RESULT.setText(RESULT.getText().substring(0, ultimo+1) + String.valueOf(String.format("%.2f", porcentaje)));
				}
				else {
					
					RESULT.setText(String.valueOf(porcentaje));
				}
			}
		});
		porcentaje.setFont(new Font("Verdana", Font.PLAIN, 13));
		porcentaje.setBounds(363, 279, 54, 44);
		frame.getContentPane().add(porcentaje);
		
		JButton Historial = new JButton("H");
		Historial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				H.main(historial, frame);
				
			}
		});
		Historial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Historial.setBounds(215, 341, 54, 44);
		frame.getContentPane().add(Historial);
	}
}
