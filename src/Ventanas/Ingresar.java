package Ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Ingresar extends JFrame {
	private String NumeroCuenta;
	//La ruta para la conexion
	String ruta=Conexion.HacerConexion();
	public Ingresar() {
		//Pantalla de Ingresar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,650,500);
		JPanel miPanel= new JPanel();
		miPanel.setLayout(null);
		setContentPane(miPanel);
		JLabel ing1 = new JLabel("<-----Cantidad");
		ing1.setBounds(100,200,200,50);
		ing1.setForeground(Color.WHITE);
		ing1.setFont(new Font("Courier New",Font.ITALIC,14));
		miPanel.add(ing1);
		JButton ingre = new JButton();
		ingre.setBounds(20,206,40,30);
		ingre.addActionListener(new EventoIngresar());
		miPanel.add(ingre);
		JButton boton1=new JButton("Volver");
		boton1.setBounds(250,425,160,50);
		boton1.addActionListener(new Volver());
		miPanel.add(boton1);
		ImageIcon pantallac = new ImageIcon("Imagenes"+File.separator+"pantallac.png");
		JLabel miEtiqueta = new JLabel(pantallac);
		miEtiqueta.setBounds(0, 0, 650,500);
		miPanel.add(miEtiqueta);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
}
	public class EventoIngresar implements ActionListener {
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para ingresar dinero a la Cuenta
			CogerNCuenta();
			Cajero re = new Cajero();
			String cantidad=JOptionPane.showInputDialog("Introduce el dinero que desea retirar");
			//Comprobamos que no meta valores nulos
            while(cantidad==null || cantidad.equals("")) {
            JOptionPane.showMessageDialog(null, "No ha introducido un valor valido");
            cantidad=JOptionPane.showInputDialog("Introduce el dinero que desea retirar");
            }
            int cantidad2=Integer.parseInt(cantidad);
			re.setVisible(true);
			dispose();
			try{
				Conexion.IngresarDinero(cantidad2,NumeroCuenta,ruta);
			}catch(SQLException e1){
				e1.printStackTrace();
			}
	}
}
	public void CogerNCuenta(){
		//Metodo que sirve para coger el NCuenta de la Cuenta
		try {
			NumeroCuenta=Conexion.SacarCuentaCajero(ruta);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public class Volver implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Evento que sirve para volver a la pantalla de Cajero
			Cajero er = new Cajero();
			er.setVisible(true);
			dispose();
	}
}
}