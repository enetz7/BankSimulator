package Ventanas;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import Ventanas.Ajustes.EventoCambiarPin;
import Ventanas.CrearCuenta1.CrearCuenta;
import Ventanas.CrearCuenta1.VolverAtras;

import java.awt.Color;
import java.awt.Font;
public class CambiarPin extends JFrame {
	private JLabel pin1,pin2,pinuevo,titulo,mal,mal2,mal3;
	private JPasswordField textArea1,textArea2,textArea3;
	private JButton boton1,boton2,boton3;
	private String NumeroCuenta;
	//La ruta para la conexion
	String ruta=Conexion.HacerConexion();
	boolean esta=false;
	boolean esta2=false;
	boolean esta3=false;
	public CambiarPin(){
		//Pantalla de CambiarPIN
		setTitle("Cambiar Pin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,650,500);
		JPanel miPanel= new JPanel();
		miPanel.setLayout(null);
		setContentPane(miPanel);
		titulo= new JLabel("Cambiar PIN");
		titulo.setBounds(170,-140,380,380);
		titulo.setFont(new Font("Courier New", Font.ITALIC,40));
		miPanel.add(titulo);
		pin1=new JLabel("PIN actual: ");
		pin1.setBounds(80,60,200,200);
		miPanel.add(pin1);
		pin2=new JLabel("PIN nuevo: ");
		pin2.setBounds(80,100,200,200);
		miPanel.add(pin2);
		pinuevo=new JLabel("Repito el PIN: ");
		pinuevo.setBounds(80,140,200,200);
		miPanel.add(pinuevo);
		mal=new JLabel("Datos erroneos");
		mal.setBounds(400,120,200,200);
		mal.setFont(new Font("Courier New", Font.ITALIC,20));
		mal.setForeground(Color.RED);
		mal.setVisible(false);
		miPanel.add(mal);
		mal2=new JLabel("El PIN debe tener 4 caracteres");
		mal2.setBounds(200,140,250,250);
		mal2.setFont(new Font("Courier New", Font.ITALIC,13));
		mal2.setForeground(Color.RED);
		mal2.setVisible(false);
		miPanel.add(mal2);
		mal3=new JLabel("El PIN tiene que ser diferente");
		mal3.setBounds(200,10,250,250);
		mal3.setFont(new Font("Courier New", Font.ITALIC,13));
		mal3.setForeground(Color.RED);
		mal3.setVisible(false);
		miPanel.add(mal3);
		textArea1= new JPasswordField();
		textArea1.setBounds(200,150,200,20);
		miPanel.add(textArea1);
		textArea2= new JPasswordField();
		textArea2.setBounds(200,190,200,20);
		miPanel.add(textArea2);
		textArea3= new JPasswordField();
		textArea3.setBounds(200,230,200,20);
		miPanel.add(textArea3);
		boton1=new JButton("Aceptar");
		boton1.setBounds(470,300,130,20);
		boton1.addActionListener(new Ingresar());
		miPanel.add(boton1);
		boton3=new JButton("Cancelar");
		boton3.setBounds(330,300,130,20);
		boton3.addActionListener(new Limpiar());
		miPanel.add(boton3);
		boton2=new JButton("Volver");
		boton2.setBounds(35,400,160,50);
		boton2.addActionListener(new VolverAtras());
		miPanel.add(boton2);
		ImageIcon fondo= new ImageIcon("Imagenes"+File.separator+"Login.jpg");
		JLabel miEtiqueta= new JLabel(fondo);
		miEtiqueta.setBounds(0, 0,650,500);
		miPanel.add(miEtiqueta);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	}
	public class VolverAtras implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Evento que sirve para volver a la pantalla de Ajustes
			Ajustes vent=new Ajustes();
			vent.setVisible(true);
			dispose();
		}
	}
	public class Limpiar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Evento que sirve para limpiar los textArea
			textArea1.setText("");
			textArea2.setText("");
			textArea3.setText("");
		}
	}
	public class Ingresar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Evento que sirve para Cambiar el Pin
			Cajero ca = new Cajero();
			String resultado="";
		CogerNCuenta();
		try {
			resultado=Conexion.CogerPin(NumeroCuenta,ruta);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String pinNuevo=textArea3.getText();
		//Comprobaciones antes de cambiar el PIN
		//Comprobamos la longitud que sea 4
		if((textArea2.getText().length()!=4) && (textArea3.getText().length()!=4)){
			mal2.setVisible(true);
			esta=true;
		}else {
			esta2=true;
			//Comprobamos que sea diferente el PIN
		}if((textArea1.getText().equals(textArea2.getText()) && (textArea1.getText().equals(textArea3.getText())))){
			mal3.setVisible(true);
			esta=true;
		}else {
			esta3=true;
			//Comprobamos que meta 2 veces el PIN bien
		}if((!textArea2.getText().equals(textArea3.getText()))){
			mal.setVisible(true);
			esta=true;
		}else{
			esta3=true;
		}//Si esta todo bien cambiamos el PIN
			if(((textArea2.getText().equals(textArea3.getText())) && (esta2==true) && (esta3==true) && (textArea1.getText().equals(resultado)))){
				mal.setVisible(false);
				mal2.setVisible(false);
				esta=true;
				try {
					Conexion.CambiarPin(NumeroCuenta,ruta,pinNuevo);
					JOptionPane.showMessageDialog(null,"Tu nuevo PIN es: "+textArea3.getText());
					ca.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(esta==false) {
				mal.setVisible(true);
			}
	}
}
	public void CogerNCuenta(){
		//Metodo que coje el numero de cuenta
		try {
			NumeroCuenta=Conexion.SacarCuentaCajero(ruta);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
