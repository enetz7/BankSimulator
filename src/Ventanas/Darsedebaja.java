package Ventanas;

import java.awt.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Ventanas.Aval.EventoAtrasAval;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class Darsedebaja extends JFrame {
	
	private String dni;
	private String pin;
	//La ruta para la conexion
	String ruta=Conexion.HacerConexion();
	private JPanel contentPane;
	private JTextField textodni;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JLabel dni1;
	private JLabel pin1;

	public Darsedebaja() {
		//Pantala de Darse de baja
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textodni = new JTextField();
		textodni.setBounds(217, 47, 141, 28);
		contentPane.add(textodni);
		textodni.setColumns(10);
		
		dni1 = new JLabel("Introduzca su dni");
		dni1.setBounds(52, 47, 155, 28);
		contentPane.add(dni1);

		
		pin1 = new JLabel("Introduzca su pin");
		pin1.setBounds(52, 125, 155, 28);
		contentPane.add(pin1);
		
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(new EventoDarsedebaja());
		Aceptar.setBounds(307, 218, 89, 36);
		contentPane.add(Aceptar);

		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 125, 141, 28);
		contentPane.add(passwordField);
		
		JButton Atras = new JButton("Volver");
		Atras.addActionListener(new EventoAtrasDarsedebaja());
		Atras.setBounds(160,218,99,33);
		contentPane.add(Atras);
		
		ImageIcon pantallac = new ImageIcon("Imagenes"+File.separator+"635632-600-338.jpg");
		JLabel miEtiqueta = new JLabel(pantallac);
		miEtiqueta.setBounds(0, 0, 450,320);
		contentPane.add(miEtiqueta);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	}
	public class EventoDarsedebaja implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para Darse de baja
			Pasillo pe = new Pasillo();
			boolean esta=false;
			try {
				String dni = textodni.getText();
				String pin = passwordField.getText();
				//Comprobar si no meten datos
				if(dni==null || dni.equals("") || pin==null || pin.equals("")) {
					JOptionPane.showMessageDialog(null,"Por favor, meta valores");
					dni="";
					pin="";
				}
				else {
				esta=Conexion.Darsedebaja(dni,ruta,pin);
				if(esta==true) {
				//Comprobamos si esta correcto los datos
				JOptionPane.showMessageDialog(null,"Gracias, su cuenta ha sido dada de baja");
				pe.setVisible(true);
				dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Los datos no son correctos.");
				}
			}} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
}
	public class EventoAtrasDarsedebaja implements ActionListener{
		public void actionPerformed (ActionEvent e){
			//Evento que sirve para volver a la pantalla de Ventanilla
			Ventanilla ventana_darsedebaja = new Ventanilla();
			ventana_darsedebaja.setVisible(true);
			dispose();
		}
	}
	
}
